//Authors: Lucas Ueta and John Robert R.

class Stonecutting extends Item implements Split {
    private int tier;
    private String refinedAt;

    public Stonecutting(String name, String description, String overarchingCategory, double weight, Inventory inventory, int tier, String refinedAt) {
        super(name, description, overarchingCategory, weight, inventory);
        this.tier = tier;
        this.refinedAt = refinedAt;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String getRefinedAt() {
        return refinedAt;
    }

    public void setRefinedAt(String refinedAt) {
        this.refinedAt = refinedAt;
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
                             "Refined at: %s\n" +
                             "Tier %d\n" +
                             "%.1f Weight",
                getName(),
                getOverarchingCategory(),
                getDescription(),
                refinedAt,
                tier,
                getWeight()
        );
    }
}