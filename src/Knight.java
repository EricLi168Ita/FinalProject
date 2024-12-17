/**
 * It extends Character, inheriting name and health, and adds an armorRating attribute.
 * Knights can also protect peasants by increasing their health.
 */
public class Knight extends Character {
    private int armorRating;

    /**
     * Constructs a Knight with a given name, health, and armor rating.
     */
    public Knight(String name, int health, int armorRating) {
        super(name, health);
        this.armorRating = armorRating;
    }

    // Getter for armorRating
    public int getArmorRating() {
        return armorRating;
    }

    // Setter for armorRating
    public void setArmorRating(int armorRating) {
        this.armorRating = armorRating;
    }

    /**
     * Allows the knight to protect a peasant by improving the peasant's health.
     * When protected, the peasant gains additional health.
     */
    public void protectPeasant(Peasant peasant) {
        System.out.println(getName() + " (Knight) protects " + peasant.getName() + " (Peasant).");
        int newHealth = peasant.getHealth() + 10; // increase peasant's health by 10
        peasant.setHealth(newHealth);
        System.out.println(peasant.getName() + " now has " + peasant.getHealth() + " health after being protected.");
    }

    /**
     * Provides a string representation of the knight, including its armor rating.
     */
    @Override
    public String toString() {
        return "Knight{name='" + getName() + "', health=" + getHealth() + ", armorRating=" + armorRating + "}";
    }
}
