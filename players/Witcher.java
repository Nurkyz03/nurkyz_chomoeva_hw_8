package players;

public class Witcher extends Hero {
    private boolean revived = false;

    public Witcher(int health, int damage, String name) {
        super(health, damage, name, SuperAbilityEnum.REVIVE);
    }

    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (!revived) {
            for (Hero hero : heroes) {
                if (!hero.equals(this) && hero.getHealth() <= 0) {
                    System.out.println(this.getName() + " revived " + hero.getName() + " and dies.");
                    hero.setHealth(this.getHealth());
                    this.setHealth(0);
                    revived = true;
                    break;
                }
            }
        }
    }
}