package tprev;

import java.io.FileWriter;
import java.io.IOException;

public class DepotFichier implements DepotCommandes {
    @Override
    public void enregistrer(String email, double total) {
        try (FileWriter fw = new FileWriter("commandes.txt", true)) {
            fw.write(email + ";" + total + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la sauvegarde", e);
        }
    }
}
