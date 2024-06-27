package players;

import game.RPG_Game;

public class King extends Hero{
    String reset = "\u001B[0m";
    String redText = "\u001B[31m";

    String blackBg = "\u001B[40m";
    public King(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.SAITAMA);
    }
    public void attack(Boss boss){

    }
    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int saitamaChance = RPG_Game.random.nextInt(100);
        if (saitamaChance < 10){
            System.out.println(redText + blackBg + " INCREDIBLE KING SUMMONED SAITAMA " + reset);
            boss.setHealth(boss.getHealth() - boss.getHealth());
        }
        else{
            System.out.println("king failed to summon saitama");
        }
    }
}
