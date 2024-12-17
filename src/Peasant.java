/**
The Peasant class represents a common worker in the kingdom.
 It extends Character and adds a grainCount attribute.
Peasants can trade grain with merchants, increasing the merchant's gold while reducing their own grain.
 */
public class Peasant extends Character {
    private int grainCount;

    /**
    Peasant with a given name, health, and grain count.
     */
    public Peasant(String name, int health, int grainCount) {
        super(name, health);
        this.grainCount = grainCount;
    }

    // Getter for grainCount
    public int getGrainCount() {
        return grainCount;
    }

    // Setter for grainCount
    public void setGrainCount(int grainCount) {
        this.grainCount = grainCount;
    }

    /**
     * Trades a certain amount of grain with a Merchant.
     * The merchant gains double the grain amount in gold, and the peasant loses that amount of grain.
     */
    public void tradeWithMerchant(Merchant merchant, int grainOffered) {
        System.out.println(getName() + " (Peasant) attempts to trade " + grainOffered + " grain with " + merchant.getName() + " (Merchant).");
        if (grainOffered <= this.grainCount) {
            this.grainCount -= grainOffered;
            merchant.setGold(merchant.getGold() + grainOffered * 2); // The merchant profits: double gold per grain
            System.out.println(getName() + " now has " + this.grainCount + " grain left.");
            System.out.println(merchant.getName() + " now has " + merchant.getGold() + " gold.");
        } else {
            System.out.println("Not enough grain to trade.");
        }
    }

    /**
     * Provides a string representation of the peasant, including how much grain they have.
     */
    @Override
    public String toString() {
        return "Peasant{name='" + getName() + "', health=" + getHealth() + ", grainCount=" + grainCount + "}";
    }
}
