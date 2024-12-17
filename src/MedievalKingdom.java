import java.util.ArrayList;
import java.util.Scanner;

public class MedievalKingdom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> characters = new ArrayList<>();

        //Give attributes to each child classes
        Knight knight = new Knight("Sir Arthur", 100, 50);
        Peasant peasant = new Peasant("Old John", 50, 30);
        Merchant merchant = new Merchant("Gilda", 60, 100);
        Wizard wizard = new Wizard("Merlin", 80, 50);

        characters.add(knight);
        characters.add(peasant);
        characters.add(merchant);
        characters.add(wizard);

        System.out.println("Welcome to the Medieval Kingdom Simulation!");
        System.out.println("Are you a Customer or a Manager? (type 'customer' or 'manager')");
        String role = scanner.nextLine().trim().toLowerCase();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menu ---");
            if (role.equals("manager")) {
                //managing characters, adding new ones, etc.
                System.out.println("1. View All Characters");
                System.out.println("2. Add a New Character");
                System.out.println("3. Remove a Character");
                System.out.println("4. Perform Interactions");
                System.out.println("5. Exit");
            } else {
                // Customer options: Interact with existing characters
                System.out.println("1. View All Characters");
                System.out.println("2. Ask Knight to Protect Peasant");
                System.out.println("3. Ask Merchant to Sell Armor to Knight");
                System.out.println("4. Ask Peasant to Trade with Merchant");
                System.out.println("5. Ask Wizard to Heal a Character");
                System.out.println("6. Exit");
            }

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    // View all characters
                    System.out.println("Listing all characters:");
                    for (Character c : characters) {
                        System.out.println(c.toString());
                    }
                    break;
                case "2":
                    if (role.equals("manager")) {
                        // Add new character
                        System.out.println("What type of character would you like to add? (knight/peasant/merchant/wizard)");
                        String type = scanner.nextLine().trim().toLowerCase();
                        System.out.println("Enter name:");
                        String newName = scanner.nextLine();
                        System.out.println("Enter health:");
                        int newHealth = Integer.parseInt(scanner.nextLine());

                        switch (type) {
                            case "knight":
                                System.out.println("Enter armor rating:");
                                int armor = Integer.parseInt(scanner.nextLine());
                                Knight newKnight = new Knight(newName, newHealth, armor);
                                characters.add(newKnight);
                                break;
                            case "peasant":
                                System.out.println("Enter grain count:");
                                int grain = Integer.parseInt(scanner.nextLine());
                                Peasant newPeasant = new Peasant(newName, newHealth, grain);
                                characters.add(newPeasant);
                                break;
                            case "merchant":
                                System.out.println("Enter gold amount:");
                                int gold = Integer.parseInt(scanner.nextLine());
                                Merchant newMerchant = new Merchant(newName, newHealth, gold);
                                characters.add(newMerchant);
                                break;
                            case "wizard":
                                System.out.println("Enter mana amount:");
                                int mana = Integer.parseInt(scanner.nextLine());
                                Wizard newWizard = new Wizard(newName, newHealth, mana);
                                characters.add(newWizard);
                                break;
                            default:
                                System.out.println("Unknown type. No character added.");
                        }
                    } else {
                        // Customer option #2: Knight protects Peasant
                        Knight k = null;
                        Peasant p = null;
                        for (Character c : characters) {
                            if (c instanceof Knight) k = (Knight) c;
                            if (c instanceof Peasant) p = (Peasant) c;
                        }
                        if (k != null && p != null) {
                            k.protectPeasant(p);
                        } else {
                            System.out.println("Knight or Peasant not found.");
                        }
                    }
                    break;
                case "3":
                    if (role.equals("manager")) {
                        // Remove a character
                        System.out.println("Enter the name of the character to remove:");
                        String removeName = scanner.nextLine();
                        Character toRemove = null;
                        for (Character c : characters) {
                            if (c.getName().equalsIgnoreCase(removeName)) {
                                toRemove = c;
                                break;
                            }
                        }
                        if (toRemove != null) {
                            characters.remove(toRemove);
                            System.out.println("Character removed: " + toRemove.getName());
                        } else {
                            System.out.println("No character found with that name.");
                        }
                    } else {
                        // Customer option #3: Merchant sells armor to Knight
                        Merchant mer = null;
                        Knight k2 = null;
                        for (Character c : characters) {
                            if (c instanceof Merchant) mer = (Merchant) c;
                            if (c instanceof Knight) k2 = (Knight) c;
                        }
                        if (mer != null && k2 != null) {
                            mer.sellArmorToKnight(k2, 10);
                        } else {
                            System.out.println("Merchant or Knight not found.");
                        }
                    }
                    break;
                case "4":
                    if (role.equals("manager")) {
                        // Manager Interaction Menu
                        System.out.println("Choose an interaction:");
                        System.out.println("a. Knight protects Peasant");
                        System.out.println("b. Merchant sells armor to Knight");
                        System.out.println("c. Peasant trades with Merchant");
                        System.out.println("d. Wizard heals a Character");
                        String interChoice = scanner.nextLine().trim().toLowerCase();

                        Knight k = null;
                        Peasant p = null;
                        Merchant m = null;
                        Wizard w = null;
                        for (Character c : characters) {
                            if (c instanceof Knight && k == null) k = (Knight) c;
                            if (c instanceof Peasant && p == null) p = (Peasant) c;
                            if (c instanceof Merchant && m == null) m = (Merchant) c;
                            if (c instanceof Wizard && w == null) w = (Wizard) c;
                        }

                        switch (interChoice) {
                            case "a":
                                if (k != null && p != null) {
                                    k.protectPeasant(p);
                                } else {
                                    System.out.println("Knight or Peasant not available.");
                                }
                                break;
                            case "b":
                                if (m != null && k != null) {
                                    m.sellArmorToKnight(k, 10);
                                } else {
                                    System.out.println("Merchant or Knight not available.");
                                }
                                break;
                            case "c":
                                if (p != null && m != null) {
                                    System.out.println("How much grain to trade?");
                                    int grainOffered = Integer.parseInt(scanner.nextLine());
                                    p.tradeWithMerchant(m, grainOffered);
                                } else {
                                    System.out.println("Peasant or Merchant not available.");
                                }
                                break;
                            case "d":
                                if (w != null) {
                                    System.out.println("Who should the Wizard heal?");
                                    String healName = scanner.nextLine();
                                    Character toHeal = null;
                                    for (Character c : characters) {
                                        if (c.getName().equalsIgnoreCase(healName)) {
                                            toHeal = c;
                                            break;
                                        }
                                    }
                                    if (toHeal != null) {
                                        w.castHealingSpell(toHeal);
                                    } else {
                                        System.out.println("No character found by that name to heal.");
                                    }
                                } else {
                                    System.out.println("Wizard not available.");
                                }
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }

                    } else {
                        // Customer option #4: Peasant trades with Merchant
                        Peasant p2 = null;
                        Merchant mer2 = null;
                        for (Character c : characters) {
                            if (c instanceof Peasant) p2 = (Peasant) c;
                            if (c instanceof Merchant) mer2 = (Merchant) c;
                        }
                        if (p2 != null && mer2 != null) {
                            System.out.println("How much grain would you like the Peasant to trade?");
                            int grainOffered = Integer.parseInt(scanner.nextLine());
                            p2.tradeWithMerchant(mer2, grainOffered);
                        } else {
                            System.out.println("Peasant or Merchant not found.");
                        }
                    }
                    break;
                case "5":
                    if (role.equals("manager")) {
                        // Exit
                        exit = true;
                    } else {
                        // Customer option #5: Wizard heals a character
                        Wizard w = null;
                        for (Character c : characters) {
                            if (c instanceof Wizard) {
                                w = (Wizard)c;
                                break;
                            }
                        }
                        if (w != null) {
                            System.out.println("Which character should the Wizard heal?");
                            String healName = scanner.nextLine();
                            Character toHeal = null;
                            for (Character c : characters) {
                                if (c.getName().equalsIgnoreCase(healName)) {
                                    toHeal = c;
                                    break;
                                }
                            }
                            if (toHeal != null) {
                                w.castHealingSpell(toHeal);
                            } else {
                                System.out.println("No character found by that name to heal.");
                            }
                        } else {
                            System.out.println("Wizard not found.");
                        }
                    }
                    break;
                case "6":
                    if (!role.equals("manager")) {
                        // Customer Exit
                        exit = true;
                    } else {
                        System.out.println("Invalid choice for Manager.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the Medieval Kingdom Simulation. Goodbye!");
        scanner.close();
    }
}
