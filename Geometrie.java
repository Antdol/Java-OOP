import java.util.*;
public class Geometrie {
  
  public static void main(String[] args) {

    System.out.println("Construisons un triangle ABC :\n");
    Triangle abc = new Triangle();
    abc.setPointA();
    abc.setPointB();
    abc.setPointC();
    System.out.println("Le périmètre du triangle ABC est " + abc.perimetre());
    if (abc.estIsocele()) {
      System.out.println("Le triangle ABC est isocèle");
    } else {
      System.out.println("Le triangle ABC n'est pas isocèle");
    }

  }
}

class Triangle {
  private static Scanner clavier = new Scanner(System.in);

  private double [] pointA = new double[2];
  private double [] pointB = new double[2];
  private double [] pointC = new double[2];

  public boolean estIsocele() {
    double ab = distanceAB();
    double bc = distanceBC();
    double ac = distanceAC();

    if (ab == bc || ab == ac || ac == bc) {
      return true;
    } else {
      return false;
    }
  }

  private double distanceAB() {
    return Math.sqrt(Math.pow(pointA[0] - pointB[0], 2) + Math.pow(pointA[1] - pointB[1], 2));
  }

  private double distanceBC() {
    return Math.sqrt(Math.pow(pointB[0] - pointC[0], 2) + Math.pow(pointB[1] - pointC[1], 2));
  }

  private double distanceAC() {
    return Math.sqrt(Math.pow(pointA[0] - pointC[0], 2) + Math.pow(pointA[1] - pointC[1], 2));
  }

  public double perimetre() {
    return distanceAB() + distanceBC() + distanceAC();
  }

  public void setPointA() {
    System.out.println("Construisons le point A :");
    System.out.print("  Entrez sa coordonnée x : ");
    pointA[0] = clavier.nextDouble();
    System.out.print("  Entrez sa coordonnée y : ");
    pointA[1] = clavier.nextDouble();
  }

  public void setPointB() {
    System.out.println("Construisons le point B :");
    System.out.print("  Entrez sa coordonnée x : ");
    pointB[0] = clavier.nextDouble();
    System.out.print("  Entrez sa coordonnée y : ");
    pointB[1] = clavier.nextDouble();
  }

  public void setPointC() {
    System.out.println("Construisons le point C :");
    System.out.print("  Entrez sa coordonnée x : ");
    pointC[0] = clavier.nextDouble();
    System.out.print("  Entrez sa coordonnée y : ");
    pointC[1] = clavier.nextDouble();
  }
}
