import java.util.Random;
import java.util.Scanner;

public class main {
    static boolean challengerBoucle = false;
    static boolean defenseurBoucle = false;
    static boolean duelBoucle = false;

    public static void main(String[] args) {
        Random random               = new Random();
        Scanner sc                  = new Scanner(System.in);

        boolean modeDev;
        boolean menuBoucle          = true;

        System.out.println("Bienvenue dans le module de recherche d'une combinaison à X chiffres.");

        while (menuBoucle) {

            System.out.println("Veuillez sélectionner un mode de jeu :\n1 - Challenger  2 - Défenseur  3 - Duel");

            int reponseMode = sc.nextInt();

            if (reponseMode == 1) {
                //menuBoucle          = false;
                challengerBoucle    =  true;
            }
            else if (reponseMode == 2) {
                //menuBoucle          = false;
                defenseurBoucle     = true;
            }
            else if (reponseMode == 3) {
                //menuBoucle          = false;
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
