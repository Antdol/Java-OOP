class TestCercle {

    public static void main(String[] args) {

        Cercle c1 = new Cercle();
        Cercle c2 = new Cercle();
        Cercle c3 = new Cercle();

        c1.setCentre(0, 5);
        c1.setRayon(10);

        c2.setCentre(8, 2);
        c2.setRayon(5);

        c3.setCentre(5, 5);
        c3.setRayon(20);

        System.out.println("c1 : " + c1.surface() + " " + c1.estInterieur(-5, 10));
        System.out.println("c2 : " + c2.surface() + " " + c2.estInterieur(14, 2));
        System.out.println("c3 : " + c3.surface() + " " + c3.estInterieur(25, 5));
    }
}

class Cercle {
    private double rayon;
    private double x;
    private double y;

    public void setCentre(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setRayon(double r) {
        rayon = r;
    }
    
    public double surface() {
        return Math.PI * rayon * rayon;
    }

    public boolean estInterieur(double x, double y) {
        double distanceAuCentre = Math.sqrt(Math.pow(this.x - x, 2) * Math.pow(this.y - y, 2));
        if (distanceAuCentre <= rayon) {
            return true;
        } else {
            return false;
        }
    }
}