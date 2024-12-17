/**
 * The Merchant class represents a character who deals in trade
 * It extends Character and adds a gold attribute.
 * Merchants can sell armor to knights, increasing the knight's armor rating and earning gold.
 */
public class Merchant extends Character {
    private int gold;

    /**
     * Merchant with a given name, health, and initial amount of gold.
     */
    public Merchant(String name, int health, int gold) {
        super(name, health);
        this.gold = gold;
    }

    // Getter for gold
    public int getGold() {
        return gold;
    }

    // Setter for gold
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * Sells armor to a Knight, increasing the knight's armor rating.
     * The merchant earns 50 gold from each sale.
     */
    public void sellArmorToKnight(Knight knight, int armorIncrease) {
        System.out.println(getName() + " (Merchant) sells an armor piece to " + knight.getName() + " (Knight).");
        knight.setArmorRating(knight.getArmorRating() + armorIncrease);
        this.gold += 50; 
        System.out.println(knight.getName() + "'s armor rating is now " + knight.getArmorRating() + ".");
        System.out.println(getName() + " now has " + this.gold + " gold.");
    }

    /**
     * Provides a string representation of the merchant, including the amount of gold they have.
     */
    @Override
    public String toString() {
        return "Merchant{name='" + getName() + "', health=" + getHealth() + ", gold=" + gold + "}";
    }
}
