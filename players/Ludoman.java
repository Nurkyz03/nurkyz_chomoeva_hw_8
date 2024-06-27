package players;

import java.util.Random;

public class Ludoman extends Hero {
    private Random random;

    public Ludoman(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.THROW_DICE);
        this.random = new Random();
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;

        System.out.println(getName() + " rolls the dice: " + dice1 + " and " + dice2);

        if (dice1 == dice2) {
            int damage = dice1 * dice2;
            System.out.println("They match! Gambler deals damage to the boss: " + damage);
            boss.setHealth(boss.getHealth() - damage);
        } else {
            int randomIndex = random.nextInt(heroes.length);
            Hero target = heroes[randomIndex];
            int damage = dice1 + dice2;
            System.out.println("They don't match! Gambler deals damage to " + target.getName() + ": " + damage);
            target.setHealth(target.getHealth() - damage);
        }
    }
}