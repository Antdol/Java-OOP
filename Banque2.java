class Compte {
  private String type;
  private double solde;
  private double taux;

  public Compte(double unSolde) {
    type = "Compte prive";
    taux = 0.01;
    if (unSolde >= 0) {
      solde = unSolde;
    }
  }

  public Compte(String unType, double unSolde, double unTaux) {
    if (unType.equals("Compte prive") || unType.equals("Compte d'epargne")) {
      type = unType;
    }
    if (unTaux > 0.0 && unTaux < 1) {
      taux = unTaux;
    }
    if (unSolde >= 0.0) {
      solde = unSolde;
    }
    
  }
}

class Client {
  private String nom;
  private String ville;
  private boolean masculin;
  private Compte prive;
  private Compte epargne;

  public Client(String unNom, String uneVille, boolean estUnHomme) {
    nom = unNom;
    ville = uneVille;
    masculin = estUnHomme;
  }
}

class Banque2 {
  public static void main(String[] args) {

  }
}