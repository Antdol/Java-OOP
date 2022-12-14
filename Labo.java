class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    private int poids;
    private int age;
    private String couleur;
    private int esperanceVie;
    private boolean clonee;

    public Souris(int unPoids, String uneCouleur, int unAge, int uneEsperance) {
        poids = unPoids;
        couleur = uneCouleur;
        age = unAge;
        esperanceVie = uneEsperance;
        clonee = false;
        System.out.println("Une nouvelle souris !");
    }

    public Souris(int unPoids, String uneCouleur, int unAge) {
        poids = unPoids;
        couleur = uneCouleur;
        age = unAge;
        esperanceVie = ESPERANCE_VIE_DEFAUT;
        clonee = false;
        System.out.println("Une nouvelle souris !");
    }

    public Souris(int unPoids, String uneCouleur) {
        poids = unPoids;
        couleur = uneCouleur;
        age = 0;
        esperanceVie = ESPERANCE_VIE_DEFAUT;
        clonee = false;
        System.out.println("Une nouvelle souris !");
    }

    public Souris(Souris s) {
        poids = s.poids;
        couleur = s.couleur;
        age = s.age;
        esperanceVie = s.esperanceVie * 4 / 5;
        clonee = true;
        System.out.println("Clonage d'une souris !");
    }

    public String toString() {
        String s = "Une souris " + couleur;
        if (clonee) {
            s += ", clonee,";
        } 
        s += " de " + age + " mois et pesant " + poids + " grammes";
        return s;
    }

    public void vieillir() {
        ++age;
        if (clonee) {
            if (age > esperanceVie / 2) {
                couleur = "verte";
            }
        }
    }

    public void evolue() {
        while (age < esperanceVie) {
            vieillir();
        }
    }
}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
