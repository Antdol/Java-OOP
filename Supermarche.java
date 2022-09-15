import java.util.*;
import java.text.SimpleDateFormat;

class Caisse {
  // une caisse a un numéro et un montant total encaissé (en Frs suisses)
  private int numero;
  private double montantTotal;

  public Caisse(int num, double montantInit) {
    if (num > 0) {
      numero = num;
      montantTotal = montantInit;
    } else {
      System.out.println("Il faut un numero de caisse positif");
    }
  }

  public void scanner(Caddie caddie) {
    // variables pour stocker le contenu du caddie
    ArrayList<Article> contenu = caddie.getContenu();
    ArrayList<Integer> quantite = caddie.getNombre();
    double montant = 0.0;
    
    // afficher l'entete du ticket de caisse
    System.out.println("=========================================");
    Date dateCourante = new Date();
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yy");
    System.out.println(formatDate.format(dateCourante));
    System.out.println("Caisse numero " + numero + "\n");

    //afficher la liste des achats
    while (contenu.size() != 0) {
      Article article = contenu.get(0);
      int nombre = quantite.get(0);
      System.out.print(article.getNom() + " : " + article.getPrix() + " x " + nombre + " = ");
      double prixSolde = article.getPrix() * nombre / 2;
      double prixNonSolde = article.getPrix() * nombre;                     
      if (article.getEnSolde()) {
        System.out.println(prixSolde + " Frs (1/2 prix)");
        montant += prixSolde;
      } else {
        System.out.println(prixNonSolde + " Frs");
        montant += prixNonSolde;
      }
      
      contenu.remove(0);
      quantite.remove(0);
    }

    // afficher le montant total et le bas du ticket
    System.out.println("\nMontant total a payer : " + montant + " Frs");
    System.out.println("=========================================");

    // mettre à jour la caisse
    montantTotal += montant;
  }

  public void totalCaisse() {
    System.out.println("La caisse numero " + numero + " a encaisse " + montantTotal + " Frs aujourd'hui");
  }
}

class Caddie {

  // le caddie contient un tableau dynamique d'articles
  private ArrayList<Article> contenu;
  // et un tableau dynamique qui stock le nombre de chaque articles
  private ArrayList<Integer> nombre;

  // initialise un caddie vide
  public Caddie() {
    contenu = new ArrayList<Article>();
    nombre = new ArrayList<Integer>();
  }

  // ajoute un article dans le caddie n fois
  public void remplir(Article unArticle, int quantite) {
    if (quantite > 0) {
      contenu.add(unArticle);
      nombre.add(quantite);
    } else {
      System.out.println("Il faut un nombre positif d'article pour remplir le caddie.");
    }
  }

  // donne la liste des articles dans le caddie
  public ArrayList<Article> getContenu() {
    return contenu;
  }

  // donne le nombre de chaque article dans la liste
  public ArrayList<Integer> getNombre() {
    return nombre;
  }
}

class Article {
  // Un article a un nom, un prix et peut etre en solde
  private String nom;
  private double prix;
  private boolean enSolde;

  // initialise un article
  public Article(String unNom, double unPrix, boolean solde) {
    nom = unNom;
    if (unPrix > 0.0) prix = unPrix;
    enSolde = solde;
  }

  // donne le nom de l'article
  public String getNom() {
    return nom;
  }

  // donne le prix de l'article
  public double getPrix() {
    return prix;
  }

  // donne si l'article est en solde
  public boolean getEnSolde() {
    return enSolde;
  }
}

public class Supermarche {
  public static void main(String[] args) {
    // Les articles vendus dans le supermarché
    Article choufleur = new Article("Chou-fleur extra", 3.50, false);
    Article roman = new Article("Les malheurs de Sophie", 16.50, true);
    Article camembert = new Article("Cremeux 100%MG", 5.80, false);
    Article cdrom = new Article("C++ en trois jours", 48.50, false);
    Article boisson = new Article("Petit-lait", 2.50, true);
    Article petitspois = new Article("Pois surgeles", 4.35, false);
    Article poisson = new Article("Sardines", 6.50, false);
    Article biscuits = new Article("Cookies de grand-mere", 3.20, false);
    Article poires = new Article("Poires Williams", 4.80, false);
    Article cafe = new Article("100% Arabica", 6.90, true);
    Article pain = new Article("Pain d'epautre", 6.90, false);
    // Les caddies du supermarché
    Caddie caddie1 = new Caddie();
    Caddie caddie2 = new Caddie();
    Caddie caddie3 = new Caddie();
    // Les caisses du supermarché
    // le premier argument est le numero de la caisse
    // le second argument est le montant initial de la caisse.
    Caisse caisse1 = new Caisse(1, 0.0);
    Caisse caisse2 = new Caisse(2, 0.0);
    // les clients font leurs achats
    // le second argument de la méthode remplir
    // correspond à une quantité
    // remplissage du 1er caddie
    caddie1.remplir(choufleur, 2);
    caddie1.remplir(cdrom, 1);
    caddie1.remplir(biscuits, 4);
    caddie1.remplir(boisson, 6);
    caddie1.remplir(poisson, 2);
    // remplissage du 2eme caddie
    caddie2.remplir(roman, 1);
    caddie2.remplir(camembert, 1);
    caddie2.remplir(petitspois, 2);
    caddie2.remplir(poires, 2);
    // remplissage du 3eme caddie
    caddie3.remplir(cafe, 2);
    caddie3.remplir(pain, 1);
    caddie3.remplir(camembert, 2);
    // Les clients passent à la caisse
    caisse1.scanner(caddie1);
    caisse1.scanner(caddie2);
    caisse2.scanner(caddie3);
    caisse1.totalCaisse();
    caisse2.totalCaisse();
  }
}
  