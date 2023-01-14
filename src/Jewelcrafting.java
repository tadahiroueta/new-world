//Authors: Lucas Ueta and John Robert R.

class Jewelcrafting extends Item implements Discard {
    private int tier;
    private String rarity, derivedFrom, ingredientTypes;

    public Jewelcrafting(String name, String description, String overarchingCategory, double weight, Inventory inventory, String rarity, int tier, String derivedFrom, String ingredientTypes) {
        super(name, description, overarchingCategory, weight, inventory);
        this.rarity = rarity;
        this.tier = tier;
        this.derivedFrom = derivedFrom;
        this.ingredientTypes = ingredientTypes;
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

    public String getDerivedFrom() {
        return derivedFrom;
    }

    public void setDerivedFrom(String derivedFrom) {
        this.derivedFrom = derivedFrom;
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
                             "Derived from: %s\n" +
                             "Tier %d\n" +
                             "%.1f Weight",
                getName(),
                getOverarchingCategory(),
                rarity,
                getDescription(),
                ingredientTypes,
                derivedFrom,
                tier,
                getWeight()
        );
    }
}