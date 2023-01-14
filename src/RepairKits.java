//Authors: Lucas Ueta and John Robert R.

class RepairKits extends Item implements Split {
    private int tier;

    public RepairKits(String name, String description, String overarchingCategory, double weight, Inventory inventory, int tier) {
        super(name, description, overarchingCategory, weight, inventory);
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    @Override
    public void split() {
        getInventory().removeItem(getName());
        System.out.printf("%s has been split.\n", getName());
    }

    @Override
    public String getActions() {
        return "Split\n" +
               "Link to Chat";
    }

    @Override
    public boolean act(String command) {
        switch (command){
            case "open":
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
                             "Tier %d\n" +
                             "%.1f Weight",
                getName(),
                getOverarchingCategory(),
                getDescription(),
                getTier(),
                getWeight()
        );
    }
}