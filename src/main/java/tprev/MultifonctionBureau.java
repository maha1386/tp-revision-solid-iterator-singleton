package tprev;

public class MultifonctionBureau implements Imprimable, Numerisable, Faxable {
    @Override
    public void imprimer(String document) {
        System.out.println("Impression : " + document);
    }
    @Override
    public void numeriser(String document) {
        System.out.println("Numerisation : " + document);
    }
    @Override
    public void faxer(String document) {
        System.out.println("Fax : " + document);
    }
}