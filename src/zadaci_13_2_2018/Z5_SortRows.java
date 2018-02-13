package zadaci_13_2_2018;

import java.util.Scanner;

public class Z5_SortRows {
	/**
	 * 5. Implementirati sljedeæu metodu da sortira redove u 2D nizu.
	 * 
	 * public static double[ ][ ] sortRows(double[ ][ ] array)
	 * 
	 * Napisati testni program koji pita korisnika da unese 3x3 matricu (ili da
	 * pita korisnika koliku matricu želi unijeti) te mu ispisuje na konzoli
	 * matricu sa sortiranim redovima - od najmanjeg broja do najveæeg.
	 */
	public static void main(String[] args) {
		double[][] matrix = new double[3][3];

		Scanner input = new Scanner(System.in);
		System.out.println("Unesite elemente matrice: ");
		// petlja za unos vrijednosti elemenata matrice
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = input.nextDouble();
			}
		}
		input.close();
		System.out.println(sortRows(matrix));
	}

	/**
	 * meotda sortira redove u 2D nizu u rastucem redosljedu
	 */
	public static double[][] sortRows(double[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				double currentMin = mat[i][j];
				int currentMinIndex = j;
				// trazi najmanji element u redu matrice m
				for (int k = j + 1; k < mat[i].length; k++) {
					if (currentMin > mat[i][k]) {
						currentMin = mat[i][k];
						currentMinIndex = k;
					}
				}
				/*
				 * ako je index najmanjeg el u nizu razlicit od trenutnog j,
				 * onda zamijeni m[i][j] sa majmanjim el u redu matrice
				 * m[i][currentMinIndex]
				 */
				if (currentMinIndex != j) {
					mat[i][currentMinIndex] = mat[i][j];
					mat[i][j] = currentMin;
				}
			}
		}
		return mat;
	}
}
