class main {

	public static void main(String[] args) {
		String s1 = "..3.2.6..9..3.5..1..18.64....81.29..7.......8..67.82....26.95..8..2.3..9..5.1.3..";
		// String s2 =
		// "....2....9..3.5..1..18.64....81.29..7.......8..67.82....26.95..8..2.3..9..5.1.3..";
		SudokuNeu sudoku1 = new SudokuNeu(s1);
		// SudokuNeu sudoku2 = new SudokuNeu(s2);
		System.out.println(sudoku1);
		int wege = 0;
		while (sudoku1.anzahlBesetztenZellen() < 81) {
			if (wege > 10) {
				System.out.println("Das Spiel ist komplizierter als gedacht.");
				break;
			}
			sudoku1.aktualisiere();
			wege++;
		}
		if (wege <= 10) {
			System.out.println(sudoku1);
			System.out.println("Das Spiel wird gelöst in " + wege + " Vorwärtsschritte.");
		}

	}

}
