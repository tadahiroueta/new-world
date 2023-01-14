import java.util.*;

/**
 * Where all inventory parts are stored.
 * There are many methods to interact with the items stored.
 *
 * @author John Robert R.
 * @author Lucas Ueta
 */
public class Inventory {
    private ArrayList<InventoryPart> inventory;
    private double weight;

    public Inventory() {
        inventory = new ArrayList<InventoryPart>();
        weight = 0;
    }

    public double getWeight() {
        return weight;
    }

    /**
     * Returns inventory part based on its class name.
     *
     * @param className - the class name of the desired inventory part.
     * @return - the desired inventory part.
     */
    public InventoryPart getPart(String className) {
        for (InventoryPart inventoryPart : inventory)
            if (inventoryPart.getClassName().equals(className))
                return inventoryPart;

        // if inventory part does not exist, yet
        return addPart(new InventoryPart(className));
    }

    private InventoryPart addPart(InventoryPart newPart) {
        inventory.add(newPart);
        return newPart;
    }

    private InventoryPart removePart(InventoryPart toBeRemoved) {
        inventory.remove(toBeRemoved);
        return toBeRemoved;
    }

    /**
     * Add item to its inventory part.
     *
     * @param toAdd - the item to be added.
     * @param className - the name of the inventory part where the item will be stored.
     * @return - the added item.
     */
    public Item addItem(Item toAdd, String className) {
        getPart(className).addItem(toAdd);
        this.weight += toAdd.getWeight();
        return toAdd;
    }

    /**
     * Removes item from the inventory.
     *
     * @param name - name of the item to be removed.
     * @return - the removed item.
     */
    public Item removeItem(String name) {
        for (InventoryPart part : inventory) {
            Item removed = part.removeItem(name);
            if (removed != null) {
                weight -= removed.getWeight();
                if (part.getItems().size() == 0)
                    removePart(part);

                return removed;
            }
        }
        return null;
    }

    /**
     * Returns the desired item by its name.
     *
     * @param name - the name of the desired item.
     * @return - the desired item.
     */
    public Item getItem(String name) {
        for (InventoryPart part : inventory)
            for (Item item : part.getItems())
                if (item.getName().toLowerCase(Locale.ROOT).equals(name))
                    return item;

        return null;
    }

    /**
     * Returns a string representing the inventory.
     *
     * @return - a visual representation of the inventory; includes its weight, inventory parts and the items stored in them.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(String.format("--- INVENTORY ---\n" +
                                                               "Weight: %.1f", weight));
        for (InventoryPart part : inventory)
            output.append("\n\n").append(part.toString());

        return output.toString();
    }
}