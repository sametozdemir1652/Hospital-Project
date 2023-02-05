package hastane;

public class Hastane {

    Doktor doktor = new Doktor();

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    Hasta hasta = new Hasta();

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

}
