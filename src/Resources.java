//Authors: Lucas Ueta and John Robert R.

class Resources extends Item implements Discard {
    private String rarity;

    public Resources(String name, String description, String overarchingCategory, double weight, Inventory inventory, String rarity) {
        super(name, description, overarchingCategory, weight, inventory);
        this.rarity = rarity;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
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
                             "%.1f Weight",
                getName(),
                getOverarchingCategory(),
                rarity,
                getDescription(),
                getWeight()
        );
    }
}