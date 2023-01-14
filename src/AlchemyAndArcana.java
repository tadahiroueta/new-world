//Authors: Lucas Ueta and John Robert R

class AlchemyAndArcana extends Item implements Discard {
    private String rarity, ingredientTypes, derivedFrom;
    private int tier;

    public AlchemyAndArcana(String name, String description, String overarchingCategory, double weight, Inventory inventory, String rarity, String ingredientTypes, String derivedFrom, int tier) {
        super(name, description, overarchingCategory, weight, inventory);
        this.rarity = rarity;
        this.ingredientTypes = ingredientTypes;
        this.derivedFrom = derivedFrom;
        this.tier = tier;
    }

    public String getRarity() {
        return rarity;
    }

    public String getIngredientTypes() {
        return ingredientTypes;
    }

    public String getDerivedFrom() {
        return derivedFrom;
    }

    public int getTier() {
        return tier;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public void setIngredientTypes(String ingredientTypes) {
        this.ingredientTypes = ingredientTypes;
    }

    public void setDerivedFrom(String derivedFrom) {
        this.derivedFrom = derivedFrom;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }


    @Override
    public void discard() {
        getInventory().removeItem(getName());
        System.out.printf("%s has been discarded.\n", getName());
    }

    @Override
    public String getActions() {
        return "Discard\n" +
               "Link to chat";
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