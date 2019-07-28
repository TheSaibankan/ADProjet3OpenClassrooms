import java.util.Random;
import java.util.Scanner;

public class IA {
    private Random random = new Random();
    private Scanner sc = new Scanner(System.in);


    String createCombinationChallenger() {
        String combinationChallenger = "";

        //ajout des valeurs dans le string
        int digitCombi1 = random.nextInt(10);
        int digitCombi2 = random.nextInt(10);
        int digitCombi3 = random.nextInt(10);
        int digitCombi4 = random.nextInt(10);
        int digitCombi5 = random.nextInt(10);

        if (Main.combinationLength == 3) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 + digitCombi3;
        }
        else if (Main.combinationLength == 4) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 +
                    digitCombi3 + digitCombi4;
        }
        else if (Main.combinationLength == 5) {
            combinationChallenger = String.valueOf(digitCombi1) + digitCombi2 +
                    digitCombi3 + digitCombi4 + digitCombi5;
        }
        return combinationChallenger;
    }
    void launchChallenger(String combinationChallenger) {

        if (Main.devMode) {
            System.out.println("La combinaison est la suivante : " + combinationChallenger);
        }

        for (int pI = 0; pI < Main.nbTries; pI++) {
            StringBuilder resultUserCombinaison = new StringBuilder();
            System.out.println("Veuillez rentrer " + Main.combinationLength + " chiffres :" );

            if (pI == 0) sc.nextLine(); // pourquoi première lecture est sautée ?

            String userCombination = sc.nextLine();
            if (userCombination.length() != Main.combinationLength) {
                System.out.println("Attention ! Vous avez saisi "+userCombination.length()+" chiffre(s) "+
                        "au lieu de "+Main.combinationLength+".");

                if (pI == 0) continue;
                else pI--;
            }
            for(int indice = 0; indice < Main.combinationLength; indice++) {

                if (userCombination.charAt(indice) == combinationChallenger.charAt(indice)) {
                    resultUserCombinaison.append("=");
                }
                else if (userCombination.charAt(indice) < combinationChallenger.charAt(indice)) {
                    resultUserCombinaison.append("+");
                }
                else if (userCombination.charAt(indice) > combinationChallenger.charAt(indice)) {
                    resultUserCombinaison.append("-");
                }
            }
            System.out.println(resultUserCombinaison);
        }
    }
}

