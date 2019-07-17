import java.io.IOException;
import java.util.Scanner;

public class main {
    static boolean challengerBoucle = false;
    static boolean defenseurBoucle = false;
    static boolean duelBoucle = false;

    static int longueurCombinaison;
    static int nbEssaies;

    static boolean menuBoucle;
    static boolean modeDev;

    public static void main(String[] args) throws IOException {

        Scanner sc                  = new Scanner(System.in);
        boolean menuBoucle          = true;

        System.out.println("Bienvenue dans le module de recherche d'une combinaison à X chiffres.");

        while (menuBoucle) {

            System.out.println("Veuillez sélectionner un mode de jeu :\n1 - Challenger  2 - Défenseur  3 - Duel");

            int reponseMode = sc.nextInt();

            if (reponseMode == 1) {
                challengerBoucle    =  true;
            }
            else if (reponseMode == 2) {
                defenseurBoucle     = true;
            }
            else if (reponseMode == 3) {
                duelBoucle          = true;
            }

            while (challengerBoucle) {
                ModesDeJeu.modeChallenger();
            }
            while (defenseurBoucle) {
                ModesDeJeu.modeDefenseur();
            }
            while (duelBoucle) {
                ModesDeJeu.modeDuel();
            }
        }
    }
}
