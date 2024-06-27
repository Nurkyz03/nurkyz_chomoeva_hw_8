package players;

import game.RPG_Game;

public class Samurai extends Hero{
    public Samurai(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.SURIKEN);
    }
    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int typeOfSuriken = RPG_Game.random.nextInt(8) + 2;
        if (typeOfSuriken <= 5){
            System.out.println("Samurai threw an suriken with vaccine");
            boss.setHealth(boss.getHealth() + 50);
        }
        if (typeOfSuriken >= 5){
            System.out.println("Samurai threw an poison suriken");
            boss.setHealth(boss.getHealth() - 50);
        }
    }
}