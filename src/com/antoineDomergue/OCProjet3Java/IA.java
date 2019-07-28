package com.antoineDomergue.OCProjet3Java;

import java.util.Random;

class IA {
    private static Random random = new Random();

    static String createCombinationChallenger() {

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
}

