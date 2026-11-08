package tprev;

public class Main {

    public static void main(String[] args) {

        // 1. Création du panier
        Panier panier = new Panier();

        panier.ajouter(new Produit("Clavier", 45.0, true));
        panier.ajouter(new Produit("Souris", 20.0, true));
        panier.ajouter(new Produit("Ecran", 150.0, false));
        panier.ajouter(new Produit("Casque", 60.0, true));

        // 2. Récupération du Singleton une seule fois
        Journal journal = JournalApplication.getInstance();

        // 3. Création du service avec injection
        CommandeService service = new CommandeService(
                new DepotFichier(),
                new NotificateurConsole(),
                journal
        );

        // 4. Traitement des produits disponibles
        double total = service.traiter(
                panier.disponibles(),
                new RemisePremium(),
                "client@gmail.com"
        );

        System.out.println("Total final : " + total);

        // 5. Afficher les messages du journal
        System.out.println("Journal : ");

        for (String message : journal.getMessages()) {

            System.out.println(message);
        }
    }
}