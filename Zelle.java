/* Klasse für ein Sudoku-Feld, die beschreibt, 
ob das Feld schon besetzt ist, bzw. welche Möglichkeiten es fürs Feld noch gibt.*/

class Zelle {
	boolean besetzt;
	int wert;
	int[] auswahl;

	/* ein leeres Feld erzeugen */
	public Zelle() {
		this.besetzt = false;
		this.wert = 0;
		this.auswahl = new int[9];
		for (int i = 0; i < 9; i++) {
			this.auswahl[i] = i + 1;
		}
	}

	/* ein besetztes Feld erzeugen */
	public Zelle(int n) {
		this.besetzt = true;
		this.wert = n;
		this.auswahl = new int[9];
		for (int i = 0; i < 9; i++) {
			this.auswahl[i] = 0;

		}
	}

	/*
	 * Eine Zahl n als Möglichkeit in einer Zelle löschen, falls es nur noch eine
	 * Möglichkeit bleibt, dann aktualisiere den Wert der Zelle
	 */
	public void moeglichkeitLoesche(int n) {
		this.auswahl[n - 1] = 0;
		int[] r = this.anzahlMoeglichkeit();
		if (r[0] == 1)
			this.besetze(r[1]);
	}

	/* Eine unbesetzte Zelle einem Wert zuweisen bzw. besetzen. */
	public void besetze(int wert) {
		this.besetzt = true;
		this.wert = wert;
		this.auswahl = new int[9];
		for (int i = 0; i < 9; i++) {
			this.auswahl[i] = 0;
		}
	}

	/* Die Liste der moeglichen Werte in einer Zelle visualisieren. */
	public void visualisiereAuswahl() {
		for (int i = 0; i < 9; i++) {
			System.out.print(auswahl[i] + " ");
		}
		System.out.println();
	}

	/* Die Anzahl der Moeglichkeiten in einem Kästchen zurückgeben */
	public int[] anzahlMoeglichkeit() {
		int c = 0;
		int wert = -1;
		int[] result = new int[2];
		for (int i = 0; i < 9; i++) {
			if (!this.besetzt) {
				if (this.auswahl[i] > 0) {
					c++;
					wert = this.auswahl[i];
				}
			}
		}
		result[0] = c;
		result[1] = wert;
		return result;
	}

	public String toString() {
		if (besetzt) {
			return (this.wert + " ");
		} else {
			return ("_ ");
		}
	}

}
