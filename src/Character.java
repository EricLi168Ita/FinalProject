/**
 * The Character class is the base class for all characters in the medieval kingdom.
 * It defines common attributes and behaviors that all specialized characters (Knight, Peasant, Merchant, Wizard)
 * Common attributes: name, health
 * Common methods: getters and setters for name and health, and a toString method.
 */
public class Character {
    private String name;
    private int health;

    /**
     * Constructs a character with the given name and health.
     */
    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name 
    public void setName(String name) {
        this.name = name;
    }

    // Getter for health
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

  
    @Override
    public String toString() {
        return "Character{name='" + name + "', health=" + health + "}";
    }
}
