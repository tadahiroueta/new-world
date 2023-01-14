/**
 * Grandparent / parent class of all items.
 * Includes the similarities all items share.
 *
 * @authors John Robert R. and Lucas Ueta
 */
public class Item implements LinkToChat {
    private String name, description, overarchingCategory;
    private double weight;
    private Inventory inventory;

    public Item(String name, String description, String overarchingCategory, double weight, Inventory inventory) {
        this.name = name;
        this.description = description;
        this.overarchingCategory = overarchingCategory;
        this.weight = weight;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOverarchingCategory() {
        return overarchingCategory;
    }

    public double getWeight() {
        return weight;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getActions() {
        return "";
    }

    public boolean act(String command) {
        return false;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", overarchingCategory='" + overarchingCategory + '\'' +
                ", weight=" + weight +
                ", inventory=" + inventory +
                '}';
    }

    @Override
    public void linkToChat() {
        System.out.printf("%s has been linked to chat.\n", getName());
    }
}
