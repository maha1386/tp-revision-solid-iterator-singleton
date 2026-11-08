package tprev;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Panier implements Iterable<Produit> {

    private final Produit[] articles = new Produit[10];

    private int taille = 0;

    public void ajouter(Produit p) {

        if (taille == articles.length) {
            throw new IllegalStateException("Panier plein");
        }

        articles[taille++] = p;
    }

    @Override
    public Iterator<Produit> iterator() {

        return new Iterator<Produit>() {

            private int position = 0;
            private int dernierRetourne = -1;

            @Override
            public boolean hasNext() {

                return position < taille;
            }

            @Override
            public Produit next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                dernierRetourne = position;

                return articles[position++];
            }

            // Bonus : suppression du dernier élément retourné
            @Override
            public void remove() {

                if (dernierRetourne == -1) {
                    throw new IllegalStateException();
                }

                for (int i = dernierRetourne; i < taille - 1; i++) {
                    articles[i] = articles[i + 1];
                }

                articles[--taille] = null;

                if (position > dernierRetourne) {
                    position--;
                }

                dernierRetourne = -1;
            }
        };
    }
    public Iterable<Produit> disponibles() {
        return () -> new FiltreDisponibles(iterator());
    }
}
