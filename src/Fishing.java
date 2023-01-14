//Authors: Lucas Ueta and John Robert R.

public class Fishing extends Item implements Salvage, Discard {
    private int tier;
    private String rarity, ingredientTypes;

    public Fishing(String name, String description, String overarchingCategory, double weight, Inventory inventory, String rarity, int tier, String ingredientType) {
        super(name, description, overarchingCategory, weight, inventory);
        this.rarity = rarity;
        this.tier = tier;
        this.ingredientTypes = ingredientType;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
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
    public void salvage() {
        getInventory().removeItem(getName());
        System.out.printf("%s has been salvaged for %d coins.\n", getName(), (int) (Math.random() * 50));
    }

    @Override
    public String getActions() {
        return "Salvage\n" +
               "Discard\n" +
               "Link to Chat";
    }

    @Override
    public boolean act(String command) {
        switch (command){
            case "salvage":
                salvage();
                return true;

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
                             "%s\n" +
                             "%s\n" +
                             "Ingredient types: %s\n" +
                             "Tier %d\n" +
                             "%.1f Weight",
                getName(),
                getOverarchingCategory(),
                getDescription(),
                ingredientTypes,
                getTier(),
                getWeight()
        );
    }
}
