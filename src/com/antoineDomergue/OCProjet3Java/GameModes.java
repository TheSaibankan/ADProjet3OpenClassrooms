package com.antoineDomergue.OCProjet3Java;

import java.io.IOException;

class GameModes {

    static int pI;
    static int pIDef = 0;
    static int indiceDef;

    static String combinationChallenger = "";
    static String combinationDefender = "";
    static String combinationDefenderSecondTurn = "";
    static String resultatIACombinaison = "";
    static String tempValue = "";
    static String userCombination = "";

    static void challengerMode() throws IOException {
        ChallengerMode.challengerModeLaunch();
    }
    static void defenderMode() throws IOException {
        DefenderMode.defenderModeLaunch();
    }
    static void duelMode() throws IOException {
        DuelMode.duelModeLaunch();
    }
}