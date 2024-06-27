package players;

import game.RPG_Game;

public class Hacker extends Hero {
    private int stealAmount;

    public Hacker(int health, int damage, String name, int stealAmount) {
        super(health, damage, name, SuperAbilityEnum.STEAL);
        this.stealAmount = stealAmount;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (RPG_Game.getRound() % 2 == 1) {

            Hero randomHero = getRandomHero(heroes);
            if (randomHero != null) {
                boss.setHealth(boss.getHealth() - stealAmount);
                randomHero.setHealth(randomHero.getHealth() + stealAmount);
                System.out.println(getName() + " transferred " + stealAmount + " health from boss to " + randomHero.getName());
            }
        }
    }

    private Hero getRandomHero(Hero[] heroes) {
        int randomHeroIndex = RPG_Game.random.nextInt(heroes.length);
        return heroes[randomHeroIndex];
    }
}
