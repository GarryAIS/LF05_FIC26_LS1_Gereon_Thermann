import java.util.Scanner;

class Fahrkartenautomat {

	public static void main(String[] args) {

		Scanner tastatur = new Scanner(System.in);
		double zuZahlenderBetrag;

		begruessung();
		zuZahlenderBetrag = fahrkartenbestellungErfassen(tastatur);
		zuZahlenderBetrag = fahrkartenBezahlen(tastatur, zuZahlenderBetrag);
		fahrkartenAusgeben();
		rueckgeldAusgabe(zuZahlenderBetrag);

		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");

		tastatur.close();
	}

	static void begruessung() {
		System.out.println("Herzlich Willkommen!\n");
	}

	static double fahrkartenbestellungErfassen(Scanner tastatur) {
		var zuZahlenderBetrag = 0.0;
		var anzahlDerTickets = 1;
		var auswahl = true;

		while (auswahl) {

			System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus:");
			System.out.println("Kurzstrecke AB [2,00 EUR] (1)");
			System.out.println("Einzelfahrschein AB [3,00 EUR] (2)");
			System.out.println("Tageskarte AB [8,80 EUR] (3)");
			System.out.println("4-Fahrten-Karte AB [9,40 EUR]");
			System.out.println("Bezahlen (9)\n");
			System.out.print("Ihre Wahl: ");

			switch (tastatur.nextInt()) {
				case 1:
					zuZahlenderBetrag = menge(anzahlDerTickets, tastatur, zuZahlenderBetrag, 2.0);
					break;

				case 2:
					zuZahlenderBetrag = menge(anzahlDerTickets, tastatur, zuZahlenderBetrag, 3.0);
					break;

				case 3:
					zuZahlenderBetrag = menge(anzahlDerTickets, tastatur, zuZahlenderBetrag, 8.8);
					break;

				case 4:
					zuZahlenderBetrag = menge(anzahlDerTickets, tastatur, zuZahlenderBetrag, 9.4);
					break;

				case 9:
					auswahl = false;
					break;
			}
		}
		return zuZahlenderBetrag;
	}

	static double menge(int anzahlDerTickets, Scanner tastatur, double zuZahlenderBetrag, double ticketPreis) {
		System.out.print("Anzahl der Tickets (maximal 10): ");
		anzahlDerTickets = tastatur.nextInt();
		while (anzahlDerTickets < 0 || anzahlDerTickets > 10) {
			System.out.println(">> Wählen sie bitte eine Anzahl zwischen 1 und 10 <<");
			anzahlDerTickets = tastatur.nextInt();
		}
		zuZahlenderBetrag = zuZahlenderBetrag + ticketPreis * anzahlDerTickets;
		return zuZahlenderBetrag;
	}

	static double fahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag) {
		var eingezahlterGesamtbetrag = 0.0;
		do {
			System.out.printf("Noch zu zahlen: %.2f Euro \n", zuZahlenderBetrag);
			do {
				System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
				eingezahlterGesamtbetrag = tastatur.nextDouble();
			} while (eingezahlterGesamtbetrag > 20 || eingezahlterGesamtbetrag < 0.05);
			zuZahlenderBetrag = zuZahlenderBetrag - eingezahlterGesamtbetrag;
		} while (zuZahlenderBetrag > 0.0);
		return zuZahlenderBetrag;
	}

	static void fahrkartenAusgeben() {
		System.out.println("\n Fahrschein wird ausgegeben");
		for (int i = 0; i < 21; i++) {
			System.out.print("=");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static void rueckgeldAusgabe(double zuZahlenderBetrag) {
		var rueckgabebetrag = -zuZahlenderBetrag;
		double[] rueckgeld = { 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05 };
		if (rueckgabebetrag > 0.0) {
			System.out.printf("Der Rückgabebetrag in Höhe von %.2f Euro \n", rueckgabebetrag);
			System.out.println("Wird in folgenden Münzen/Scheinen ausgezahlt:");

			for (int i = 0; i < rueckgeld.length; i++) {
				while (rueckgabebetrag >= rueckgeld[i] - 0.001) {
					System.out.printf("%.2f Euro \n", rueckgeld[i]);
					rueckgabebetrag = rueckgabebetrag - rueckgeld[i];
				}
			}
		}
	}
}