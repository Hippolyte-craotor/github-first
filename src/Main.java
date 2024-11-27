import java.io.IOException; //Pour gérer les execptions liéés aux entrees/sorties
import java.io.OutputStream; //Pour envoyer des données via le socket
import java.io.PrintWriter; //Pour ecrire des données en sortie
import java.net.Socket; //Pour creer une connexion client serveur
import java.util.Scanner; //Pour lire l'entreé utilisateur

public class Main {
    public static <socket> void main(String[] args) {//Point d'entrée l'application


        try {
            // Création d'un socket pour se connecter au serveur
            Socket MyClientSocket = new Socket("localhost", 5000);
            System.out.println("Connexion établie avec le serveur.");

            // Préparation pour envoyer des messages
            OutputStream os = MyClientSocket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);

            // Scanner pour lire l'entrée utilisateur
            Scanner sc = new Scanner(System.in);

            String message;
            System.out.println("Tapez vos messages (tapez 'bye' pour quitter) :");

            // Boucle pour envoyer des messages tant que l'utilisateur ne tape pas "bye"
            while (true) {
                System.out.print("Vous : ");
                message = sc.nextLine();
                pw.println(message); // Envoi du message au serveur

                if (message.equalsIgnoreCase("bye")) {
                    System.out.println("Déconnexion...");
                    break;
                }
            }

            // Fermeture des ressources
            pw.close();
            MyClientSocket.close();
        } catch (IOException exception) {
            System.err.println("Erreur : " + exception.getMessage());
        }

    }
}