package tprev;

public class ImprimanteBasique implements Imprimable {
    @Override
    public void imprimer(String document) {
        System.out.println("Impression : " + document);
    }
}