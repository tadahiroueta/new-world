//Authors: Lucas Ueta and John Robert R.

public class CraftMods extends Item implements Discard{
    private String rarity, ingredientTypes;

    public CraftMods(String name, String description, String overarchingCategory, double weight, Inventory inventory, String rarity, String ingredientTypes) {
        super(name, description, overarchingCategory, weight, inventory);
        this.rarity = rarity;
        this.ingredientTypes = ingredientTypes;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getIngredientTypes() {
        return ingredientTypes;
    }

    public void setIngredientTypes(String ingredientTypes) {
        this.ingredientTypes = ingredientTypes;
    }

    @Override
    public void discard() {
        getInventory().removeItem(getName());
        System.out.printf("%s has been discarded.\n", getName());
    }

    @Override
    public String getActions() {
        return "Discard\n" +
               "Link to Chat";
    }

    @Override
    public boolean act(String command) {
        switch (command){
            case "discard":
                discard();
                return true;
            case "link":
                linkToChat();
                return true;

            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                             "%s\t%s\n" +
                             "%s\n" +
                             "Ingredient types: %s\n" +
                             "%.1f Weight",
                getName(),
                getOverarchingCategory(),
                rarity,
                getDescription(),
                ingredientTypes,
                getWeight()
        );
    }
}
