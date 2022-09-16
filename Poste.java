import java.util.ArrayList;

class Boite {
	private ArrayList<Envoi> envois;

	public Boite(int taille) {
		envois = new ArrayList<Envoi>();
	}

	public void ajouterCourrier(Envoi envoi) {
		envois.add(envoi);
	}

	public double affranchir() {
		double montantTotal = 0.0;
		for (Envoi e : envois) {
			montantTotal += e.affranchir();
		}
		return montantTotal;
	}

	public void afficher() {
		for (Envoi e : envois) {
			e.afficher();
		}
	}

	public int courriersInvalides() {
		int compteur = 0;
		for (Envoi e : envois) {
			if (!e.getValide()) {
				++compteur;
			}
		}
		return compteur;
	}
}

class Envoi {
	private double poids;
	private boolean express;
	private String adresseDestination;
	private boolean valide;

	public Envoi(double poids, boolean express, String adresse) {
		this.poids = poids;
		this.express = express;
		adresseDestination = adresse;
		if (adresseDestination.length() == 0) {
			valide = false;
		} else {
			valide = true;
		}
	}

	public double getPoids() {
		return poids;
	}

	public boolean getMode() {
		return express;
	}

	public String getAdresse() {
		return adresseDestination;
	}

	public boolean getValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public void afficher() {
		if (!valide) {
			System.out.println("(Courrier invalide)");
		}
		System.out.println("    Poids : " + poids);
		System.out.print("    Express : ");
		if (express) {
			System.out.println("oui");
		} else {
			System.out.println("non");
		}
		System.out.println("    Destination : " + adresseDestination);
	}

	public double affranchir() {
		return 0.0;
	}
}

class Lettre extends Envoi {
	private String format;

	public Lettre(double poids, boolean express, String adresse, String format) {
		super(poids, express, adresse);
		this.format = format;
	}

	public double affranchir() {
		double montant = 0.0;
		if (!getValide()) {
			return montant;
		} else {
			if (format.equals("A4")) {
				montant = 2.50 + 1.0 * getPoids() / 1000;
			} else if (format.equals("A3")) {
				montant = 3.50 + 1.0 * getPoids() / 1000;
			}
		}

		if (getMode()) {
			return montant * 2.0;
		} else {
			return montant;
		}
	}

	public void afficher() {
		System.out.println("Lettre");
		super.afficher();
		System.out.println("    Prix : " + affranchir() + " CHF");
		System.out.println("    Format : " + format);
	}
}

class Publicite extends Envoi {
	public Publicite(double poids, boolean express, String adresse) {
		super(poids, express, adresse);
	}

	public double affranchir() {
		double montant = 0.0;
		if (!getValide()) {
			return montant;
		} else {
			montant = 5.0 * getPoids() / 1000.0;
		}

		if (getMode()) {
			return montant * 2.0;
		} else {
			return montant;
		}
	}

	public void afficher() {
		System.out.println("Publicite");
		super.afficher();
		System.out.println("    Prix : " + affranchir() + " CHF");
	}
}

class Colis extends Envoi {
	private double volume;

	public Colis(double poids, boolean express, String adresse, double volume) {
		super(poids, express, adresse);
		this.volume = volume;
	}

	public double affranchir() {
		double montant = 0.0;
		if (!getValide() || volume > 50) {
			setValide(false);
			return montant;
		} else {
			montant = 0.25 * volume + getPoids() / 1000.0 * 1.0;
		}
		
		if (getMode()) {
			return montant * 2.0;
		} else {
			return montant;
		}
	}

	public void afficher() {
		System.out.println("Colis");
		super.afficher();
		System.out.println("    Prix : " + affranchir() + " CHF");
		System.out.println("    Volume : " + volume);
	}
}


// PROGRAMME PRINCIPAL (A NE PAS MODIFIER)
class Poste {

	public static void  main(String args[]) {
		// Creation d'une boite-aux-lettres
		// 30  est la capacit'e maximale de la
		// boite aux lettres
		// (pas necessaire si vous dêcidez d'utiliser
		// un ArrayList).
		Boite boite = new Boite(30);

		//Creation de divers courriers/colis..
		Lettre lettre1 = new Lettre(200, true, "Chemin des Acacias 28, 1009 Pully", "A3");
		Lettre lettre2 = new Lettre(800, false, "", "A4"); // invalide

		Publicite pub1 = new Publicite(1500, true, "Les Moilles  13A, 1913 Saillon");
		Publicite pub2 = new Publicite(3000, false, ""); // invalide

		Colis colis1 = new Colis(5000, true, "Grand rue 18, 1950 Sion", 30);
		Colis colis2 = new Colis(3000, true, "Chemin des fleurs 48, 2800 Delemont", 70); //Colis invalide !

		boite.ajouterCourrier(lettre1);
		boite.ajouterCourrier(lettre2);
		boite.ajouterCourrier(pub1);
		boite.ajouterCourrier(pub2);
		boite.ajouterCourrier(colis1);
		boite.ajouterCourrier(colis2);


		System.out.println("Le montant total d'affranchissement est de " +
						   boite.affranchir());
		boite.afficher();
		
		System.out.println("La boite contient " + boite.courriersInvalides()
						   + " courriers invalides");
	}
}
