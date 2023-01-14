import java.util.*;

/**
 * A category of a group of items.
 *
 * @author John Roberts R.
 * @author Lucas Ueta
 */
public class InventoryPart {
    private double weight;
    private ArrayList<Item> items;
    private String className;

    public InventoryPart(String name) {
        this.className = name;
        items = new ArrayList<Item>();
        weight = 0;
    }

    public String getClassName() {
        return className;
    }

    public double getWeight()
    {
        return weight;
    }

    public void addItem (Item thing) {
        items.add(thing);
        weight += thing.getWeight();
    }

    public Item removeItem (String name) {
        for (Item item : items)
            if (item.getName().equals(name)) {
                weight -= item.getWeight();
                Item toBeRemoved = item;
                items.remove(item);
                return toBeRemoved;
            }
        return null;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Gives a visual representation of the items in this category.
     *
     * @return - this inventory part's name and a list of the names of the items it stores.
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(className);
        for (Item item : items)
            output.append("\n\t").append(item.getName());

        return output.toString();
    }
}
