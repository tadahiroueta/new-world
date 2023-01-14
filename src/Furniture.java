//Authors: Lucas Ueta and John Robert R.

class Furniture extends Item {
    private int tier;

    public Furniture(String name, String description, String overarchingCategory, double weight, Inventory inventory, int tier) {
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
    public String getActions() {
        return "Link to Chat";
    }

    @Override
    public boolean act(String command) {
        switch (command){
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
                             "Tier %d\n" +
                             "%.1f Weight",
                getName(),
                getDescription(),
                tier,
                getWeight()
        );
    }
}