import java.util.Scanner;
class TourDeMagie {
  public static void main(String[] args) {
    Magicien m = new Magicien();
    Assistant a = new Assistant();
    Spectateur s = new Spectateur();
    Papier p = new Papier();

    m.demanderSpectateur();
    int age = s.demanderAge();
    int argent = s.demanderArgent();
    p.setAge(age);
    p.setArgent(argent);
    int resultat = a.calcul(p.getAge(), p.getArgent());
    m.deviner(resultat);
  }
}

class Magicien {
  public void demanderSpectateur() {
    System.out.println("[Magicien] demande au spectateur d'écrire son age" + 
                      "et la somme d'argent qu'il a dans sa poche sur un papier.");
  }
  public void deviner(int resultatAssistant) {
    int age = (resultatAssistant + 115) / 100;
    int argent = (resultatAssistant + 115) % 100;
    System.out.println("Je vois que vous avez " + age + " ans et " + argent + " francs suisses en poche !");
  }
}

class Assistant {
  public int calcul(int age, int argent) {
    System.out.println("[Assistant] calcule dans sa tête.");
    int resultat = (2 * age + 5) * 50 + argent - 365;
    System.out.println("[Assistant] J'annonce : " + resultat);
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
    System.out.println("[Spectateur] écrit son âge sur le papier");
    this.age = age;
  }
  public void setArgent(int argent) {
    System.out.println("[Spectateur] écrit la somme qu'il a dans la poche sur le papier");
    this.argent = argent;
  }
  public int getAge() {
    System.out.println("[Assistant] lit l'age");
    return age;
  }
  public int getArgent() {
    System.out.println("[Assistant] lit la somme d'argent");
    return argent;
  }
}

