package game;

import players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();
    private static int round = 0;

    public static void startGame(){
        Boss thanos = new Boss(1500, 50, "Thanos");

        Berserk captainAmerica = new Berserk(300, 15, "Captain America");
        Warrior ironMan = new Warrior(270, 20, "Iron man");
        Mag thor = new Mag(320, 30, "Thor", 5);
        Medic drStrange = new Medic(220, 10, "DR Strange", 10);
        Medic wong = new Medic(230, 5, "Wong", 5);
        Witcher blackPanter = new Witcher(260, 0 ,"Black Panter");
        Hacker hulk = new Hacker (150, 10 , "Hulk",10);
        Bomber groot = new Bomber(200, 0 , "Groot", 100);
        Samurai starLord = new Samurai(200, 0 , "Star Lord");
        King nickFury = new King(170, 0 , "Nick Fury");
        Ludoman rocketRacoon = new Ludoman(200, 0 , "Rocket Racoon");
        Hero[] avengers = {captainAmerica, ironMan, thor, drStrange, wong, blackPanter, hulk, groot, starLord, nickFury, rocketRacoon};

        System.out.println("------------- Start game Assemble  -------------");
        printStatistics(thanos, avengers);

        while (!isGameOver(thanos, avengers)){
            round(thanos, avengers);
        }
    }

    private static boolean isGameOver(Boss thanos, Hero[] heroes){
        if (thanos.getHealth() <= 0){
            System.out.println("\n\uD83C\uDFC1 GAME OVER!!!");
            System.out.println("\n\uD83D\uDC4F Avengers won!!!");
            return true;
        }
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                return false;
            }
        }
        System.out.println("\n\uD83C\uDFC1 GAME OVER!!!");
        System.out.println("\n\uD83D\uDE22Thanos won!!!");
        return true;
    }

    private static void round(Boss thanos, Hero[] avengers){
        round++;
        thanos.chooseDefence();
        System.out.println("------------- ROUND " + round + " -------------");
        thanos.attackBoss(avengers);
        for (int i = 0; i < avengers.length; i++) {
            if (avengers[i].getHealth() > 0 && thanos.getHealth() > 0
                    && avengers[i].getSuperAbilityEnum() != thanos.getDefence()){
                avengers[i].attackHero(thanos);
                avengers[i].applySuperAbility(thanos, avengers);
            }
        }
        printStatistics(thanos, avengers);
    }

    private static void printStatistics(Boss boss, Hero[] heroes){
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }
    public static int getRound() {
        return round;
    }

    public static void setRound(int round) {
        RPG_Game.round = round;
    }
}
