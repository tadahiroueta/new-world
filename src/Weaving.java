//Authors: Lucas Ueta and John Robert R.

class Weaving extends Item implements Discard, Split {
    private int tier;
    private String ingredientTypes, refinedAt;

    public Weaving(String name, String description, String overarchingCategory, double weight, Inventory inventory, int tier, String ingredientTypes, String refinedAt) {
        super(name, description, overarchingCategory, weight, inventory);
        this.tier = tier;
        this.ingredientTypes = ingredientTypes;
        this.refinedAt = refinedAt;
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

    public String getRefinedAt() {
        return refinedAt;
    }

    public void setRefinedAt(String refinedAt) {
        this.refinedAt = refinedAt;
    }

    @Override
    public void discard() {
        getInventory().removeItem(getName());
        System.out.printf("%s has been discarded.\n", getName());
    }

    @Override
    public void split() {
        getInventory().removeItem(getName());
        System.out.printf("%s has been split.\n", getName());
    }

    @Override
    public String getActions() {
        return "Discard\n" +
               "Split\n" +
               "Link to Chat";
    }

    @Override
    public boolean act(String command) {
        switch (command){
            case "discard":
                discard();
                return true;

            case "split":
                split();
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
                             "Refined at: %s\n" +
                             "Tier %d\n" +
                             "%.1f Weight",
                getName(),
                getOverarchingCategory(),
                getDescription(),
                ingredientTypes,
                refinedAt,
                tier,
                getWeight()
        );
    }
}