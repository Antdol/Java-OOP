import java.util.Scanner;
class TourDeMagie {
  public static void main(String[] args) {

  }
}

class Magicien {
  public void demanderSpectateur() {
    System.out.println("Magicien : Ecrivez votre age et la somme que vous avez en poche sur un papier.");
  }
}

class Assistant {
  public int calcul(int age, int argent) {
    int resultat = (2 * age + 5) * 50 + argent - 365;
    return resultat;
  }
}

class Spectateur {
  private static Scanner clavier = new Scanner(System.in);
  public int demanderAge() {
    int age;
    do {
      System.out.print("Quel âge ai-je ? ");
      age = clavier.nextInt();
    } while (age <= 0);
    
    return age;
  }

  public int demanderArgent() {
    int argent;
    do {
      System.out.print("Combien d'argent ai-je dans ma poche (<100) ? ");
      argent = clavier.nextInt();
    } while (argent < 0 || argent > 99);
    return argent;
  }
}

class Papier {
  private int age;
  private int argent;
  public void setAge(int age) {
    this.age = age;
  }
  public void setArgent(int argent) {
    this.argent = argent;
  }
  public int getAge() {
    return age;
  }
  public int getArgent() {
    return argent;
  }
}

