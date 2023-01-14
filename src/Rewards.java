//Authors: Lucas Ueta and John Robert R.

public class Rewards extends Item implements Open, Discard {
    private int tier;
    private String rarity, highlightedInformation;

    public Rewards(String name, String description, String overarchingCategory, double weight, Inventory inventory, String rarity, int tier, String highlightedInformation) {
        super(name, description, overarchingCategory, weight, inventory);
        this.rarity = rarity;
        this.tier = tier;
        this.highlightedInformation = highlightedInformation;
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

    public String getHighlightedInformation() {
        return highlightedInformation;
    }

    public void setHighlightedInformation(String highlightedInformation) {
        this.highlightedInformation = highlightedInformation;
    }

    @Override
    public void open() {
        getInventory().addItem(new Apparel(
                "Cloth Hat",
                "Cloth armor. Excellent mobility, but affords little protection.",
                "Light Headwear",
                1.5,
                getInventory(),
                "Common",
                250,
                2,
                375,
                0,
                "37.3 Armor Rating - Elemental\n" +
                        "37.3 Armor Rating - Physical",
                "50% Random Attribute if Gear Score is 170+\n" +
                        "25% Random Perk if Gear Score is 170+",
                "Bind On Pickup",
                false,
                false
        ), "Apparel");
        getInventory().addItem(new Apparel(
                "Cloth",
                "Cloth armor. Excellent mobility, but affords little protection.",
                "Light Chestwear",
                3.5,
                getInventory(),
                "Common",
                250,
                2,
                375,
                0,
                "87.0 Armor Rating - Elemental\n" +
                        "87.0 Armor Rating - Physical",
                "50% Random Attribute if Gear Score is 170+\n" +
                        "25% Random Perk if Gear Score is 170+",
                "Bind On Equip",
                false,
                false
        ), "Apparel");
        getInventory().removeItem(getName());
        System.out.printf("%s has been opened.\n", getName());
    }

    @Override
    public void discard() {
        getInventory().removeItem(getName());
        System.out.printf("%s has been discarded.\n", getName());
    }

    @Override
    public String getActions() {
        return "Open\n" +
               "Discard\n" +
               "Link to Chat";
    }

    @Override
    public boolean act(String command) {
        switch (command){
            case "open":
                open();
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
                             "%s\t%s\n" +
                             "%s\n" +
                             "%s\n" +
                             "Tier %d\n" +
                             "%.1f Weight",
                getName(),
                getOverarchingCategory(),
                getRarity(),
                getDescription(),
                highlightedInformation,
                tier,
                getWeight());
    }
}
