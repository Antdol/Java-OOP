class FiguresGeometriques {
  public static void main(String[] args) {
  // A COMPLETER
    RectangleColore r = new RectangleColore(4.3, 12.5, 4);
    System.out.println(r.getLargeur());
  }
}
class Rectangle extends Figure {
  private double largeur;
  private double longueur;

  public Rectangle(double largeur, double longueur, double x, double y) {
    super(x, y);
    this.largeur = largeur;
    this.longueur = longueur;
  }
  public double surface() {
    return largeur * longueur;
  }
  public double getLongueur() {
    return longueur;
  }
  public double getLargeur() {
    return largeur;
  }
  public void setLargeur(double l) {
    largeur = l;
  }
  public void setLongueur(double l) {
    longueur = l;
  }
}
class Cercle extends Figure {
  private double rayon;
  public Cercle(double x, double y, double r) {
    super(x, y);
    rayon = r;
  }
}

class RectangleColore extends Rectangle {
  private int couleur;

  public RectangleColore(double x, double y, double largeur, double longueur, int couleur) {
    super(x, y, largeur, longueur);
    this.couleur = couleur;
  }
}

class Figure {
  // Coordonnees du centre
  private double x;
  private double y;

  public Figure(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void affiche() {
    System.out.println("centre = (" + x + ", " + y + ")");
  }
}