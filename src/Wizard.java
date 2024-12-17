/**
 * The Wizard class represents a character who can cast healing spells.
 * It extends Character and adds a mana attribute.
 * Wizards can use mana to heal other characters, increasing their health.
 */
public class Wizard extends Character {
    private int mana;

    /**
     * Wizard with a given name, health, and mana
     */
    public Wizard(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    // Getter for mana
    public int getMana() {
        return mana;
    }

    // Setter for mana
    public void setMana(int mana) {
        this.mana = mana;
    }

   
    public void castHealingSpell(Character c) {
        if (mana >= 10) {
            System.out.println(getName() + " (Wizard) casts a healing spell on " + c.getName() + ".");
            c.setHealth(c.getHealth() + 20);
            mana -= 10;
            System.out.println(c.getName() + "'s health is now " + c.getHealth() + ". " + getName() + " now has " + mana + " mana left.");
        } else {
            System.out.println(getName() + " does not have enough mana to cast a spell.");
        }
    }

    /**
     * Provides a string representation of the wizard, including current mana.
     */
    @Override
    public String toString() {
        return "Wizard{name='" + getName() + "', health=" + getHealth() + ", mana=" + mana + "}";
    }
}
