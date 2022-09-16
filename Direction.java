import java.util.Calendar;

class EPFLien {
  private String nom;
  private int annee;
  private boolean etudiant;

  public EPFLien(String nom, int annee, boolean etudiant) {
    this.nom = nom;
    this.annee = annee;
    this.etudiant = etudiant;
  }

  public boolean estEtudiant() {
    return etudiant;
  }

  public int getAnnee() {
    return annee;
  }

  public void afficher() {
    System.out.println("  Nom : " + nom);
    System.out.println("  Annee : " + annee);
  }
}

class Etudiant extends EPFLien {
  private String section;

  public Etudiant(String nom, int annee, boolean etudiant, String section) {
    super(nom, annee, etudiant);
    this.section = section;
  }

  public void afficher() {
    super.afficher();
    System.out.println("  Section : " + section);
  }
}

class EtudiantRegulier extends Etudiant {
  private double moyenne;

  public EtudiantRegulier(String nom, int annee, boolean etudiant, String section, double moyenne) {
    super(nom, annee, etudiant, section);
    this.moyenne = moyenne;
  }

  public void afficher() {
    System.out.println("Etudiant regulier:");
    super.afficher();
    System.out.printf("  Moyenne : %.1f\n", moyenne);
  }
}

class EtudiantEchange extends Etudiant {
  private String uniOrigine;

  public EtudiantEchange(String nom, int annee, boolean etudiant, String section, String uniOrigine) {
    super(nom, annee, etudiant, section);
    this.uniOrigine = uniOrigine;
  }

  public void afficher() {
    System.out.println("Etudiant d'echange:");
    super.afficher();
    System.out.println("  Uni d'origine : " + uniOrigine);
  }
}

class Personnel extends EPFLien {
  private String labo;
  private int salaire;

  public Personnel(String nom, int annee, boolean etudiant, String labo, int salaire) {
    super(nom, annee, etudiant);
    this.labo = labo;
    this.salaire = salaire;
  }

  public void afficher() {
    super.afficher();
    System.out.println("  Labo : " + labo);
    System.out.println("  Salaire : " + salaire);
  }
}
class Secretaire extends Personnel {
  
  public Secretaire(String nom, int annee, boolean etudiant, String labo, int salaire) {
    super(nom, annee, etudiant, labo, salaire);
  }

  public void afficher() {
    System.out.println("Secretaire:");
    super.afficher();
  }
}

class Enseignant extends Personnel {
  private String section;

  public Enseignant(String nom, int annee, boolean etudiant, String labo, int salaire, String section) {
    super(nom, annee, etudiant, labo, salaire);
    this.section = section;
  }

  public void afficher() {
    System.out.println("Enseignant:");
    super.afficher();
    System.out.println("  Section : " + section);
  }
}

public class Direction {
  public static void main(String[] args) {

    EPFLien [] epfliens = new EPFLien[5];

    epfliens[0] = new EtudiantRegulier("Gaston Peutimide", 2013, true, "SSC", 6.0);
    epfliens[1] = new EtudiantRegulier("Yvan Rattrapeur", 2011, true, "SSC", 2.5);
    epfliens[2] = new EtudiantEchange("Bjorn Borgue", 2012, true, "Informatique", "KTH");
    epfliens[3] = new Enseignant("Mathieu Matheu", 1998, false, "LMEP", 10000, "Physique");
    epfliens[4] = new Secretaire("Sophie Scribona", 2005, false, "LMT", 5000);
    
    etudiantsEtDureeMoyenne(epfliens);
    afficherEPFLiens(epfliens);

  }

  private static void afficherEPFLiens(EPFLien [] tab) {
    System.out.println("Liste des EPFLiens:");
    for (EPFLien e : tab) {
      e.afficher();
    }
  }

  private static void etudiantsEtDureeMoyenne(EPFLien[] tab) {
    int compteEtudiant = 0;
    double somme = 0;
    final int ANNEE_COURANTE = Calendar.getInstance().get(Calendar.YEAR);
    for (EPFLien e : tab) {
      if (e.estEtudiant()) {
        ++compteEtudiant;
      }
      somme += ANNEE_COURANTE - e.getAnnee();
    }
    double moyenne = somme / tab.length;
    System.out.println("Parmi les " + tab.length + " EPFLiens, " + compteEtudiant + " sont etudiants.");
    System.out.println("Ils sont a l'EPFL depuis en moyenne " + moyenne + " ans.");
  }
}