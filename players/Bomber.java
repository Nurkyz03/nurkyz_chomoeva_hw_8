package players;

public class Bomber extends Hero {
    private int bombDamage;

    public Bomber (int health, int damage, String name, int bombDamage) {
        super(health, damage, name, SuperAbilityEnum.BOMB);
        this.bombDamage = bombDamage;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (getHealth() <= 0) {
            System.out.println(this.getName() + " explodes!");
            boss.setHealth(boss.getHealth() - bombDamage);
            System.out.println("Boss takes " + bombDamage + " additional damage from the explosion!");
        }

    }
}
