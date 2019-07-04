import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Random random               = new Random();
        Scanner sc                  = new Scanner(System.in);

        boolean modeDev             = false;
        boolean gameBoucle          = true;
        boolean menuBoucle          = true;
        boolean challengerBoucle    = false;
        boolean defenseurBoucle     = false;
        boolean duelBoucle          = false;
        
        int nbEssaies               = 5;
        int longueurCombinaison     = 4;



        System.out.println("Bienvenue dans le module de recherche d'une combinaison à X chiffres.");

        while (gameBoucle){

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
                else menuBoucle = true;

                while (challengerBoucle) {

                    System.out.println("Vous avez sélectionné le mode Challenger !");
                    System.out.println("Par défaut, la combinaison contient 4 chiffres. " +
                            "Voulez-vous modifier la difficulté ?\n 1 - Oui  2 - Non");

                    int reponseDiff = sc.nextInt();

                    if (reponseDiff == 1) {
                        System.out.println("Choisissez la difficulté : 1 - Facile  2 - Normal  " +
                                "3 - Difficile");

                        int choixDiff = sc.nextInt();

                        if (choixDiff == 1){
                            System.out.println("Vous avez choisi le mode facile.");
                            longueurCombinaison = 3;
                        }
                        else if (choixDiff == 2) {
                            System.out.println("Vous avez choisi le mode normal.");
                            longueurCombinaison = 4;
                        }
                        else if (choixDiff == 3) {
                            System.out.println("Vous avez choisi le mode difficile.");
                            longueurCombinaison = 5;
                        }
                        else {
                            System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
                            continue;
                        }

                    }
                    else if (reponseDiff == 2) longueurCombinaison = 4;
                    else {
                        System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
                        continue;
                    }

                    System.out.println("Voulez-vous activer le mode développeur ? 1 - Oui  2 - Non");
                    int reponseDev = sc.nextInt();
                    if (reponseDev == 1) modeDev = true;
                    else if (reponseDev == 2) modeDev = false;
                    else {
                        System.out.println("Une erreur est survenue. Redémarrage du module Challenger...");
                        continue;
                    }

                    String combinaisonChallenger = "";

                    //ajout des valeurs dans le string
                    int chiffreCombi1 = random.nextInt(10);
                    int chiffreCombi2 = random.nextInt(10);
                    int chiffreCombi3 = random.nextInt(10);
                    int chiffreCombi4 = random.nextInt(10);
                    int chiffreCombi5 = random.nextInt(10);

                    if (longueurCombinaison == 3) {
                        combinaisonChallenger = String.valueOf(chiffreCombi1) + chiffreCombi2 + chiffreCombi3;
                    }
                    else if (longueurCombinaison == 4) {
                        combinaisonChallenger = String.valueOf(chiffreCombi1) + chiffreCombi2 +
                                chiffreCombi3 + chiffreCombi4;
                    }
                    else if (longueurCombinaison == 5) {
                        combinaisonChallenger = String.valueOf(chiffreCombi1) + chiffreCombi2 +
                                chiffreCombi3 + chiffreCombi4 + chiffreCombi5;
                    }


                    //affichage de la solution en mode dev
                    if (modeDev) {
                        System.out.println("La combinaison est la suivante : " + combinaisonChallenger);
                    }

                    for (int pI = 0; pI < nbEssaies; pI++) {
                        String resultatUserCombinaison = "";
                        System.out.println("Veuillez rentrer " + longueurCombinaison + " chiffres :" );
                        if (pI == 0) {
                            sc.nextLine(); // pourquoi première lecture est sautée ?
                        }
                        String userCombinaison = sc.nextLine();


                        for(int indice = 0; indice < longueurCombinaison; indice++) {

                            if (userCombinaison.charAt(indice) == combinaisonChallenger.charAt(indice)) {
                                resultatUserCombinaison += "=";
                            }
                            else if (userCombinaison.charAt(indice) < combinaisonChallenger.charAt(indice)) {
                                resultatUserCombinaison += "+";
                            }
                            else if (userCombinaison.charAt(indice) > combinaisonChallenger.charAt(indice)) {
                                resultatUserCombinaison += "-";
                            }
                        }
                        System.out.println(resultatUserCombinaison);

                        if (resultatUserCombinaison.equals("===") || resultatUserCombinaison.equals("====") ||
                                resultatUserCombinaison.equals("=====")) {
                            System.out.println("Félicitation ! Vous avez trouvé la combinaison !\n" +
                                        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");

                            int userInputEndGame = sc.nextInt();

                            if (userInputEndGame == 1) {
                                pI = 99;
                                challengerBoucle = true;
                            }
                            else if (userInputEndGame == 2) {
                                pI = 99;
                                challengerBoucle = false;
                                menuBoucle = true;
                            }
                            else if (userInputEndGame == 3) {
                                System.exit(0);
                            }
                            else {
                                System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
                                challengerBoucle = false;
                                menuBoucle = true;
                            }
                        }
                    }
                }

                while (defenseurBoucle) {

                    int chiffreUserDef1;
                    int chiffreUserDef2;
                    int chiffreUserDef3;
                    int chiffreUserDef4;
                    int chiffreUserDef5;


                    int longueurCombinaisonDef;

                    String combinaisonDefenseur = "";
                    String combinaisonDefenseur2 = "";
                    String resultatIACombinaison = "";
                    String valeurTemp = "";


                    System.out.println("Vous avez sélectionné le mode Défenseur !");
                    System.out.println("Veuillez rentrer une combinaison de 3, 4 ou 5 chiffes :");

                    sc.nextLine();
                    String userCombinaisonDefenseur = sc.nextLine();

                    if (userCombinaisonDefenseur.length() == 3) {
                        longueurCombinaisonDef = 3;

                        chiffreUserDef1 = Character.getNumericValue(userCombinaisonDefenseur.charAt(0));
                        chiffreUserDef2 = Character.getNumericValue(userCombinaisonDefenseur.charAt(1));
                        chiffreUserDef3 = Character.getNumericValue(userCombinaisonDefenseur.charAt(2));
                    }
                    else if (userCombinaisonDefenseur.length() == 4) {
                        longueurCombinaisonDef = 4;

                        chiffreUserDef1 = Character.getNumericValue(userCombinaisonDefenseur.charAt(0));
                        chiffreUserDef2 = Character.getNumericValue(userCombinaisonDefenseur.charAt(1));
                        chiffreUserDef3 = Character.getNumericValue(userCombinaisonDefenseur.charAt(2));
                        chiffreUserDef4 = Character.getNumericValue(userCombinaisonDefenseur.charAt(3));
                    }
                    else if (userCombinaisonDefenseur.length() == 5) {
                        longueurCombinaisonDef = 5;

                        chiffreUserDef1 = Character.getNumericValue(userCombinaisonDefenseur.charAt(0));
                        chiffreUserDef2 = Character.getNumericValue(userCombinaisonDefenseur.charAt(1));
                        chiffreUserDef3 = Character.getNumericValue(userCombinaisonDefenseur.charAt(2));
                        chiffreUserDef4 = Character.getNumericValue(userCombinaisonDefenseur.charAt(3));
                        chiffreUserDef5 = Character.getNumericValue(userCombinaisonDefenseur.charAt(4));
                    }
                    else {
                        System.out.println("Une erreur est survenue. Votre combinaison est de " +
                                userCombinaisonDefenseur.length()+". Redémarrage du module Défenseur...");
                        continue;
                    }

                    for (int pIDef = 0; pIDef < nbEssaies; pIDef++) {
                        if (pIDef == 0) {
                            int chiffreCombiDef1 = random.nextInt(10);
                            int chiffreCombiDef2 = random.nextInt(10);
                            int chiffreCombiDef3 = random.nextInt(10);
                            int chiffreCombiDef4 = random.nextInt(10);
                            int chiffreCombiDef5 = random.nextInt(10);

                            if (longueurCombinaisonDef == 3) {
                                combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 + chiffreCombiDef3;
                            }
                            else if (longueurCombinaisonDef == 4) {
                                combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                                        chiffreCombiDef3 + chiffreCombiDef4;
                            }
                            else if (longueurCombinaisonDef == 5) {
                                combinaisonDefenseur = String.valueOf(chiffreCombiDef1) + chiffreCombiDef2 +
                                        chiffreCombiDef3 + chiffreCombiDef4 + chiffreCombiDef5;
                            }
                        }

                        for (int indiceDef = 0; indiceDef < longueurCombinaisonDef; indiceDef++) {
                            if (pIDef == 1) {

                                if (userCombinaisonDefenseur.charAt(indiceDef) == combinaisonDefenseur.charAt
                                (indiceDef)) {

                                    combinaisonDefenseur2 += combinaisonDefenseur.charAt(indiceDef);
                                    valeurTemp = combinaisonDefenseur2;
                                    resultatIACombinaison += "=";

                                }

                                else if (userCombinaisonDefenseur.charAt(indiceDef) < combinaisonDefenseur.charAt
                                (indiceDef)) {

                                    int min = Character.getNumericValue(combinaisonDefenseur.charAt(indiceDef));

                                    combinaisonDefenseur2 += Character.forDigit
                                            ((random.nextInt(9-min+1)+min),10);

                                    resultatIACombinaison += "+";
                                }

                                else if (userCombinaisonDefenseur.charAt(indiceDef) > combinaisonDefenseur.charAt
                                (indiceDef)) {
                                    resultatIACombinaison += "-";

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}





//for (int pI = 0; pI < nbEssaies; pI++) {
//        for (int indiceDef = 0; indiceDef < longueurCombinaisonDef; indiceDef++) {
//        if (userCombinaisonDefenseur.charAt(indiceDef) == combinaisonDefenseur.charAt
//        (indiceDef)) {
//        resultatIACombinaison += "=";
//        }
//
//        else if (userCombinaisonDefenseur.charAt(indiceDef) < combinaisonDefenseur.charAt
//        (indiceDef)) {
//        resultatIACombinaison += "+";
//
//        int valeurRécup = Character.getNumericValue(combinaisonDefenseur.charAt(indiceDef));
//        int nouvelleValeur = valeurRécup + random.nextInt(10 - valeurRécup);
//        char nouvelleValeurChar = Character.forDigit(nouvelleValeur, 10);
//
//        char[] ch = combinaisonDefenseur.toCharArray();
//        ch[indiceDef] = nouvelleValeurChar;
//        combinaisonDefenseur = ch.toString();
//
//        }
//        else if (userCombinaisonDefenseur.charAt(indiceDef) > combinaisonDefenseur.charAt
//        (indiceDef)) {
//        resultatIACombinaison += "-";
//        int valeurRécup2 = Character.getNumericValue(combinaisonDefenseur.charAt(indiceDef));
//        int nouvelleValeur2 = random.nextInt(valeurRécup2);
//        char nouvelleValeurChar = Character.forDigit(nouvelleValeur2, 10);
//
//        char[] ch2 = combinaisonDefenseur.toCharArray();
//        ch2[indiceDef] = nouvelleValeurChar;
//        combinaisonDefenseur = ch2.toString();
//        }
//        }
//
//        System.out.println(combinaisonDefenseur);
//        System.out.println(resultatIACombinaison);
//
//        if (resultatIACombinaison.equals("===") || resultatIACombinaison.equals("====") ||
//        resultatIACombinaison.equals("=====")) {
//        System.out.println("Félicitation ! Vous avez trouvé la combinaison !\n" +
//        "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
//
//        int userInputEndGame = sc.nextInt();
//
//        if (userInputEndGame == 1) {
//        pI = 99;
//        challengerBoucle = true;
//        }
//        else if (userInputEndGame == 2) {
//        pI = 99;
//        challengerBoucle = false;
//        menuBoucle = true;
//        }
//        else if (userInputEndGame == 3) {
//        System.exit(0);
//        }
//        else {
//        System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
//        challengerBoucle = false;
//        menuBoucle = true;
//        }
//        }
//        }

////affichage du menu de fin si victoire
//                            if (userCombinaison == combinaisonChallenger) {
//                                    System.out.println("Félicitation ! Vous avez trouvé la combinaison !\n" +
//                                    "Vous pouvez recommencer (1), retourner au menu (2), ou fermer le programme (3).");
//
//                                    int userInputEndGame = sc.nextInt();
//
//                                    if (userInputEndGame == 1) {
//                                    challengerBoucle = true;
//                                    }
//                                    else if (userInputEndGame == 2) {
//                                    challengerBoucle = false;
//                                    menuBoucle = true;
//                                    }
//                                    else if (userInputEndGame == 3) {
//                                    System.exit(0);
//                                    }
//                                    else {
//                                    System.out.println("Vous n'avez pas saisi une commande valide. Retour au menu...");
//                                    challengerBoucle = false;
//                                    menuBoucle = true;
//                                    }
//
//                                    }

//else if (userCombinaison.length() != longueurCombinaison && userCombinaison != "") {
//        pI--;
//        System.out.println("Vous n'avez pas rentré une " +
//        "combinaison à "+ longueurCombinaison + " chiffres.");
//        }