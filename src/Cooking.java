//Authors: Lucas Ueta and John Robert R.

class Cooking extends Item implements EquipUnequip, Use, Discard, Split {
    private int tier, effectDuration;
    private String rarity, ingredientTypes, derivedFrom;
    private boolean equipped;

    public Cooking(String name, String description, String overarchingCategory, double weight, Inventory inventory, String rarity, int tier, int effectDuration, String ingredientTypes, String derivedFrom, boolean equipped) {
        super(name, description, overarchingCategory, weight, inventory);
        this.rarity = rarity;
        this.tier = tier;
        this.effectDuration = effectDuration;
        this.ingredientTypes = ingredientTypes;
        this.derivedFrom = derivedFrom;
        this.equipped = equipped;
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

    public int getEffectDuration() {
        return effectDuration;
    }

    public void setEffectDuration(int effectDuration) {
        this.effectDuration = effectDuration;
    }

    public String getIngredientTypes() {
        return ingredientTypes;
    }

    public void setIngredientTypes(String ingredientTypes) {
        this.ingredientTypes = ingredientTypes;
    }

    public String getDerivedFrom() {
        return derivedFrom;
    }

    public void setDerivedFrom(String derivedFrom) {
        this.derivedFrom = derivedFrom;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    @Override
    public void discard() {
        getInventory().removeItem(getName());
        System.out.printf("%s has been discarded.\n", getName());
    }

    @Override
    public void equipUnequip() {
        equipped = !equipped;
        System.out.printf("%s has been %s.\n", getName(), equipped ? "equipped" : "unequipped");
    }

    @Override
    public void split() {
        getInventory().removeItem(getName());
        System.out.printf("%s has been split.\n", getName());
    }

    @Override
    public void use() {
        System.out.printf("%s has been used.\n", getName());
        getInventory().removeItem(getName());
    }

    @Override
    public String getActions() {
        return String.format(
                "%s\n" +
                "Use\n" +
                "Discard\n" +
                "Split\n" +
                "Link to Chat",
                equipped ? "Unequip" : "Equip"
        );
    }

    @Override
    public boolean act(String command) {
        switch (command){
            case "equip":
            case "unequip":
                equipUnequip();
                return true;

            case "use":
                use();
                return true;

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
                             "Derived from: %s\n" +
                             "Tier %d\n" +
                             "%.1f Weight\n" +
                             "%dm Effect Duration",
                getName(),
                getOverarchingCategory(),
                getDescription(),
                ingredientTypes,
                derivedFrom,
                getTier(),
                getWeight(),
                getEffectDuration()
        );
    }
}