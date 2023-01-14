import java.util.*;

/**
 * The runner class for this project.
 * It allows the user to interact with the inventory.
 *
 * @author John Robert R.
 * @author Lucas Ueta
 */
public class Runner {
    /**
     * Receives commands from user.
     *
     * @return - String array (size 2) with the arguments inputted by the user.
     */
    private static String[] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase(Locale.ROOT);
        int spaceIndex = input.indexOf(' ');
        if (spaceIndex == -1)
            return new String[] { input, "" };

        return new String[] { input.substring(0, spaceIndex), input.substring(spaceIndex + 1) };
    }

    /**
     * Prints a message informing the user of the valid commands.
     */
    private static void help() {
        System.out.println("'open' - view full inventory\n" +
                           "'view <item name>' - view item and its available actions\n" +
                           "'exit' - end the program");
    }

    /**
     * Prints out the item's valid actions.
     * It then listens out for the user's command to carry it out.
     *
     * @param item - the item the user has inquired about
     */
    private static void interactWithItem(Item item) {
        System.out.println("--- ACTIONS ---");
        System.out.println(item.getActions());
        String firstArgument = getUserInput()[0];
        if (firstArgument.equals("exit"))
            return;

        if (!item.act(firstArgument))
            System.out.println("Invalid action.");
    }

    /**
     * Prints out the items information and allows user to interact with the item.
     *
     * @param secondArgument - the item's name
     * @param inventory - the only inventory
     */
    private static void view(String secondArgument, Inventory inventory) {
        Item item = inventory.getItem(secondArgument);
        if (item == null) {
            System.out.println("Invalid item name. Check your inventory to find valid names.");
            return;
        }

        System.out.println(item);
        interactWithItem(item);
    }

    /**
     * Allows user to interact with the inventory.
     *
     * @param inventory - the only inventory
     */
    private static void interact(Inventory inventory) {
        help();
        while (true) {
            String[] userInput = getUserInput();
            String firstArgument = userInput[0];
            String secondArgument = userInput[1];
            switch (firstArgument) {
                case "open":
                    System.out.println(inventory);
                    break;

                case "view":
                    view(secondArgument, inventory);
                    break;

                case "help":
                    help();
                    break;

                case "exit":
                    return;

                default:
                    System.out.println("Invalid command.\n" +
                            "Type in \"help\" for the list of valid commands.");
                    break;
            }
        }
    }

    /**
     * Creates an inventory with some items that were displayed in the presentation.
     * It then allows the user to interact with it.
     *
     * @param args - none
     */
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // pre written items
        Item armorCase = new Rewards(
                "Armor Case (Level: 53)",
                "Open this container to get items usable at or around the indicated level. Containers are not affected by Luck.",
                "Resource",
                0.5,
                inventory,
                "Uncommon",
                5,
                "Bind On Equip"
        );

        Item fighterHatchet = new Weapons(
                "Mammoth's Tusk",
                "\"The ivory of the mammoth makes for a lightweight and durable hatchet, perfect for carving up your enemies.\"",
                "Hatchet",
                3.6,
                inventory,
                "Legendary",
                550,
                5,
                3000,
                0,
                "",
                "63 Base Damage\n" +
                        "4.0% Critical Hit Chance\n" +
                        "1.4 Critical Damage Multiplier\n" +
                        "42.0 Block Stamina Damage\n" +
                        "42.0 Stagger Damage\n" +
                        "19% Block Stability\n" +
                        "178 Slash Damage",
                "30 Strength\n" +
                        "Brash IV: +30% damage against targets with full Health. \n" +
                        "Refreshing Torrent: Every hit of Raging Torrent reduces all Hatchet cooldowns by 4.6%.\n" +
                        "Keen Speed: On Critical: gain 30% Haste 3s. (Cooldown 5s.)\n" +
                        "Rogue: +19% more backstab damage.",
                "Bind On Equip\n" +
                        "Named Item",
                "Strength 90%, Dexterity 65%",
                true,
                false
        );

        Item gloves = new Apparel(
                "Covenant Herald's Gloves of the Priest",
                "The court regalia of a Covenant herald.",
                "Light Glove",
                1.5,
                inventory,
                "Rare",
                350,
                3,
                500,
                0,
                "66.3 Armor Rating - Elemental\n" +
                        "39.0 Armor Rating - Physical",
                "9 Focus\n" +
                        "6 Intelligence\n" +
                        "Empty Gem Socket: An empty socket for a gem.\n" +
                        "Corrupted Ward: +3.9% Damage Absorption against Corrupted.",
                "Bind On Pickup",
                true,
                false
        );

        Item arrows = new Ammo(
                "Iron Arrow",
                "Ammunition for bows.",
                "Ammo",
                45.8,
                inventory,
                1.05,
                2,
                true
        );

        Item potion = new Utilities(
                "Infused Health Potion",
                "USE: Restore 2400 health +7% of your max health.",
                "Consumable",
                0.5,
                inventory,
                500,
                5,
                60,
                30.0,
                true
        );

        Item meal = new BasicFood(
                "Hearty Meal",
                "Recover 220 health per second for 20 seconds. This recovery stops if damage is taken. Afterwards, recover 1% of your health every 2.5 seconds for 40 minutes.",
                "Consumable",
                27.3,
                inventory,
                5,
                40,
                60,
                true
        );

        Item fish = new AttributeFood(
                "Recipe: Poached Fish with Lemon and Dill\n",
                "Crafting recipe for Poached Fish with Lemon and Dill",
                "Foods",
                10.5,
                inventory,
                2,
                25,
                false
        );

        Item melon = new TradeskillFood(
                "Melon Infusion",
                "Increases your minimum gear score when crafting Jewelcrafting items by 10. Increases maximum gear score when crafting Jewelcrafting items by 10. Effects last for 30 minutes. Your health slowly recovers while under these effects.",
                "Consumable",
                0.3,
                inventory,
                3,
                30,
                20
        );

        Item repairKit = new RepairKits(
                "Advanced Repair Kit",
                "An Advanced Repair Kit. Fully repairs any Tier 3 item.",
                "Quest Item",
                0.6,
                inventory,
                3
        );

        Item chicken = new Cooking(
                "Poultry Thigh",
                "The thigh meat of a turkey, fatty and delicious.",
                "Consumable",
                0.2,
                inventory,
                "Uncommon",
                5,
                10,
                "Tier 5 Meats, Raw Meats, Raw Foods, Tier 5 Raw Foods\n",
                "Turkey, Uncommon",
                false
        );

        Item salmon = new Fishing(
                "Small Salmon",
                "\n" +
                        "A small salmon. This can be salvaged into food with a chance of acquiring fish oil.",
                "Resource",
                0.3,
                inventory,
                "Common",
                2,
                "Raw Foods, Fish, Tier 2 Raw Foods"
        );

        Item fang = new CraftMods(
                "Jagged Animal Fang",
                "Crafting item with an attunement to the Skinning Luck perk.",
                "Resource",
                0.1,
                inventory,
                "Uncommon",
                "Any Craft Mods"
        );

        Item rabbitsFoot = new Resources(
                "Rabbit's Foot",
                "A lucky rabbit's foot. Use this to craft a Luck trophy.",
                "Resource",
                0.3,
                inventory,
                "Epic"
        );

        Item orb = new TurningOrbs(
                "Amrine Tuning Orb",
                "A tuning orb that allows access to the Amrine Excavation expedition.",
                "Event Key",
                4.0,
                inventory,
                "Uncommon",
                "Bind On Pickup"
        );

        Item diamond = new Jewelcrafting(
                "Diamond",
                "Used in Jewelcrafting, but must be cut and polished at a Stonecurring Station first.",
                "Resource",
                0.1,
                inventory,
                "Uncommon",
                3,
                "Ore Veins",
                "Gemstones, Standard Gemstones"
        );

        Item solvent = new RefiningReagents(
                "Potent Solvent",
                "A potent solvent used in advanced weaving.",
                "Resource",
                3.4,
                inventory,
                "Uncommon",
                4,
                "Solvent, Refining Materials Tier 4",
                "Supply Containers"
        );

        Item ore = new Smelting(
                "Starmetal Ore",
                "Raw Resource used in crafting. Can be refined.",
                "Resource",
                12,
                inventory,
                4,
                "Starmetal Veins"
        );

        Item hide = new Leatherworking(
                "Rawhide",
                "Raw Resource used in crafting. Can be refined.",
                "Resource",
                47.8,
                inventory,
                1,
                "Skinnable Creatures"
        );

        Item linen = new Weaving(
                "Linen",
                "Crafting Material.",
                "Resource",
                1.5,
                inventory,
                2,
                "Tier 2 Cloth, Cloth",
                "Loom Tier 2"
        );

        Item charcoal = new Woodworking(
                "Charcoal",
                "Crafting Material.",
                "Resource",
                1.9,
                inventory,
                2,
                "Smelter"
        );

        Item brick = new Stonecutting(
                "Stone Brick",
                "Cut stnoe mainly used to upgrade parts of a settlement of fortress.",
                "Resource",
                21,
                inventory,
                3,
                "Stonecutter Tier 3"
        );

        Item earthshell = new AlchemyAndArcana(
                "Earthshell Tail",
                "The tail of a Earthshell Turtle",
                "Resource",
                0.3,
                inventory,
                "Epic",
                "Earth Reagents, Protective Reagents, Tier 5 Earth Reagents, Tier 5 Protective Reagents",
                "Earthshell Turtle",
                5
        );

        Item letter = new Furniture(
                "Letter of Marque",
                "An old letter of marque - once a free pass to pillage and terrorize, now just a fond memento.",
                "",
                0.6,
                inventory,
                1
        );

        Item pigment = new Dyes(
                "Purple Pigment",
                "Used in dye crafting to create dyes in shades of purple.",
                "Resource",
                0.3,
                inventory
        );

        Item thread = new QuestItems(
                "Infused Orichalcum thread",
                "Thin strands of orichalcum are worked into the fibers.",
                "Quest Item",
                0,
                inventory
        );

        // initial state
        inventory.addItem(armorCase, "Rewards");
        inventory.addItem(fighterHatchet, "Weapons");
        inventory.addItem(gloves, "Apparel");
        inventory.addItem(arrows, "Ammo");
        inventory.addItem(potion, "Utilities");
        inventory.addItem(meal, "BasicFood");
        inventory.addItem(fish, "AttributeFood");
        inventory.addItem(melon, "TradeskillFood");
        inventory.addItem(repairKit, "RepairKits");
        inventory.addItem(chicken, "Cooking");
        inventory.addItem(salmon, "Fishing");
        inventory.addItem(fang, "CraftMods");
        inventory.addItem(rabbitsFoot, "Resources");
        inventory.addItem(orb, "TurningOrbs");
        inventory.addItem(diamond, "Jewelcrafting");
        inventory.addItem(solvent, "RefiningReagents");
        inventory.addItem(ore, "Smelting");
        inventory.addItem(hide, "Leatherworking");
        inventory.addItem(linen, "Weaving");
        inventory.addItem(charcoal, "Woodworking");
        inventory.addItem(brick, "Stonecurring");
        inventory.addItem(earthshell, "AlchemyAndArcana");
        inventory.addItem(letter, "Furniture");
        inventory.addItem(pigment, "Dyes");
        inventory.addItem(thread, "QuestItems");

        // user interaction
        interact(inventory);
    }
}
















