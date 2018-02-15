package zadaci_14_2_2018;

public class Z2_RandomCards {
	/**
	 * 2. Napisati program koji simulira nasumièno izvlaèenje karte iz špila od
	 * 52 karte. Program treba ispisati koja karta je izvuèena (A, 2, 3, 4, 5,
	 * 6, 7, 8, 9, 10, J, Q ili K) te znak u kojem je data karta (Srce, Pik,
	 * Djetelina, Kocka). Primjer: Karta koju ste izvukli je 10 u znaku kocke.
	 * 
	 */
	public static void main(String[] args) {
		// an array of cards numbers
		String[] num = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"J", "Q", "K" };
		// an arrey of cards suits
		String[] suits = { " clubs", " diamonds", " hearts", "spades " };

		System.out.println("Your card is : "
				+ num[(int) (Math.random() * num.length)] + " "
				+ suits[(int) (Math.random() * suits.length)]);
	}
}
