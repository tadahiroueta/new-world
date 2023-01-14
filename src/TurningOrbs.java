//Authors: Lucas Ueta and John Robert R.

class TurningOrbs extends Item implements Discard, Split {
    private String rarity, highlightedInformation;

    public TurningOrbs(String name, String description, String overarchingCategory, double weight, Inventory inventory, String rarity, String highlightedInformation) {
        super(name, description, overarchingCategory, weight, inventory);
        this.rarity = rarity;
        this.highlightedInformation = highlightedInformation;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getHighlightedInformation() {
        return highlightedInformation;
    }

    public void setHighlightedInformation(String highlightedInformation) {
        this.highlightedInformation = highlightedInformation;
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
                             "%s\t%s\n" +
                             "%s\n" +
                             "%s\n" +
                             "%.1f Weight",
                getName(),
                getOverarchingCategory(),
                rarity,
                getDescription(),
                highlightedInformation,
                getWeight()
        );
    }
}