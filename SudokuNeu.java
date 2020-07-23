class SudokuNeu {

	String s;
	Zelle[][] Feld;

	// angenommen, die Werte passen immer, es sei denn die Länge passt nicht.
	public SudokuNeu(String s) {
		if (s.length() != 81) {
			System.out.println("Sudoku Werte nicht passend!!!");
		} else {
			this.s = s;
			this.Feld = new Zelle[9][9];
			int feld = 0;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (s.substring(feld, feld + 1).equals(".")) {
						this.Feld[i][j] = new Zelle();
					} else {
						this.Feld[i][j] = new Zelle(Integer.parseInt(s.substring(feld, feld + 1)));
					}
					feld++;
					if (feld > 80) {
						break;
					}
				}
			}
		}
	}

	public String toString() {

		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0) {
				System.out.println("-------------------------------");
			}
			for (int j = 0; j < 9; j++) {
				if (j % 3 == 0) {
					System.out.print("| ");
				}
				System.out.print(this.Feld[i][j] + " ");
			}
			System.out.println();
		}
		return "";
	}

	/* Die Anzahl der besetzten Zellen zurückgeben */
	public int anzahlBesetztenZellen() {
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (this.Feld[i][j].besetzt)
					sum++;
			}
		}
		return sum;
	}

	/* Überprüfe ob eine bestimmte Zahl in einer bestimmten Zeile erlaubt ist. */
	public boolean checkZeile(int zeile, int zahl) {
		for (int j = 0; j < 9; j++) {
			if (this.Feld[zeile][j].wert == zahl) {
				return false;
			}
		}
		return true;
	}

	/* Überprüfe ob eine bestimmte Zahl in einer bestimmten Spalte erlaubt ist. */
	public boolean checkSpalte(int spalte, int zahl) {
		for (int i = 0; i < 9; i++) {
			if (this.Feld[i][spalte].wert == zahl) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Überprüfe ob eine bestimmte Zahl in einem bestimmten Kästchen 3x3 erlaubt
	 * ist.
	 */
	public boolean checkBox(int spalte, int zeile, int zahl) {
		spalte = (spalte / 3) * 3;
		zeile = (zeile / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (this.Feld[zeile + i][spalte + j].wert == zahl) {
					return false;
				}
			}
		}
		return true;
	}

	public void aktualisiere() {
		for (int i = 0; i < 9; i++) {
			for (int zahl = 1; zahl < 10; zahl++) {
				if (!checkZeile(i, zahl)) {
					for (int j = 0; j < 9; j++) {
						this.Feld[i][j].moeglichkeitLoesche(zahl);
					}
				}
			}
		}
		for (int j = 0; j < 9; j++) {
			for (int zahl = 1; zahl < 10; zahl++) {
				if (!checkSpalte(j, zahl)) {
					for (int i = 0; i < 9; i++) {
						this.Feld[i][j].moeglichkeitLoesche(zahl);
					}
				}
			}
		}
		for (int zahl = 1; zahl < 10; zahl++) {
			for (int i = 0; i < 9; i = i + 3) {
				for (int j = 0; j < 9; j = j + 3) {
					if (!this.checkBox(i, j, zahl)) {

						for (int ibox = 0; ibox < 3; ibox++) {
							for (int jbox = 0; jbox < 3; jbox++) {
								this.Feld[j + ibox][i + jbox].moeglichkeitLoesche(zahl);
							}
						}
					}
				}
			}
		}
	}

}
