package players;

public class Mag extends Hero{
    private int boostAmount;

    public Mag(int health, int damage, String name,int boostAmount) {
        super(health, damage, name, SuperAbilityEnum.BOOST);
        this.boostAmount = boostAmount;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            int currentDamage = hero.getDamage();
            hero.setDamage(currentDamage + boostAmount);
        }

        System.out.println(this.getName() + " increased the attack of all heroes by " + boostAmount + "!");
    }

}
