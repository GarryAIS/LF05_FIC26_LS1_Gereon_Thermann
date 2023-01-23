import java.util.Scanner;

class Fahrkartenautomat {
	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);

		double zuZahlenderBetrag;
		int anzahlDerTickets;
		double eingezahlterGesamtbetrag;
		double eingeworfeneMuenze;
		double rueckgabebetrag;
		double preisProTicket;

		static void moneyBack() {
			while (rueckgabebetrag >= 20.0) { // 20-Euro-Scheine
				System.out.println("20 Euro");
				rueckgabebetrag = rueckgabebetrag - 20.0;
			}
		}
		// 1

		System.out.print("Ticketpreis (Euro): ");
		preisProTicket = tastatur.nextDouble();
		if (preisProTicket < 0 || preisProTicket > 10) {
			System.out.println("Fehlerhafte Eingabe Wert wird auf 1 gesetzt");
			preisProTicket = 1;
		}
		System.out.print("Anzahl der Tickets (maximal 10): ");
		anzahlDerTickets = tastatur.nextInt();
		if (anzahlDerTickets < 0 || anzahlDerTickets > 10) {
			anzahlDerTickets = 1;
			System.out.println("Fehlerhafte Eingabe Wert wird auf 1 gesetzt");
		}

		// do {
		// System.out.print("Ticketpreis (Euro): ");
		// zuZahlenderBetrag = tastatur.nextDouble();
		// } while (zuZahlenderBetrag < 0 || zuZahlenderBetrag > 10);

		// do {
		// System.out.print("Anzahl der Tickets : ");
		// anzahlDerTickets = tastatur.nextInt();
		// } while (anzahlDerTickets < 0 || anzahlDerTickets > 10);

		// 2
		eingezahlterGesamtbetrag = 0.0;
		do {
			zuZahlenderBetrag = preisProTicket * anzahlDerTickets - eingezahlterGesamtbetrag;
			System.out.printf("Noch zu zahlen: %.2f Euro \n", zuZahlenderBetrag);
			do {
				System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
				eingeworfeneMuenze = tastatur.nextDouble();
			} while (eingeworfeneMuenze > 20 || eingeworfeneMuenze < 0.05);

			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		} while (eingezahlterGesamtbetrag <= zuZahlenderBetrag);

		// 3
		System.out.println("\n Fahrschein wird ausgegeben");
		for (int i = 0; i < 21; i++) {
			System.out.print("=");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");

		// 4
		int genauigkeit = 2;
		rueckgabebetrag = eingezahlterGesamtbetrag - preisProTicket * anzahlDerTickets;
		if (rueckgabebetrag > 0.0) {
			System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro \n", rueckgabebetrag);
			System.out.println("Wird in folgenden Münzen/Scheinen ausgezahlt:");

			while (rueckgabebetrag >= 20.0) { // 20-Euro-Scheine
				System.out.println("20 Euro");
				rueckgabebetrag = rueckgabebetrag - 20.0;
			}
			while (rueckgabebetrag >= 10.0) { // 10-Euro-Scheine
				System.out.println("10 Euro");
				rueckgabebetrag = rueckgabebetrag - 10.0;
			}
			while (rueckgabebetrag >= 5.0) { // 5-Euro-Scheine
				System.out.println("5 Euro");
				rueckgabebetrag = rueckgabebetrag - 5.0;
			}
			while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
				System.out.println("2 Euro");
				rueckgabebetrag = rueckgabebetrag - 2.0;
			}
			while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
				System.out.println("1 Euro");
				rueckgabebetrag = rueckgabebetrag - 1.0;
			}
			while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
				System.out.println("50 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.5;
			}
			while (rueckgabebetrag > 0.19) { // 20-Cent-Münzen
				System.out.println("20 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.2;
			}
			while (rueckgabebetrag > 0.09) { // 10-Cent-Münzen
				System.out.println("10 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.1;
			}
			while (rueckgabebetrag > 0.049) { // 5-Cent-Münzen
				System.out.println("5 Cent");
				rueckgabebetrag = rueckgabebetrag - 0.05;
			}
		}

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

		tastatur.close();
	}

	private static void moneyBack() {
	}
}