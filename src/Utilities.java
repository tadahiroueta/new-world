//Authors: Lucas Ueta and John Robert R.

class Utilities extends Item implements EquipUnequip, Use, Discard, Split {
    private int gearScore, tier, requirement;
    private double secondCooldown;
    private boolean equipped;

    public Utilities(String name, String description, String overarchingCategory, double weight, Inventory inventory, int gearScore, int tier, int requirement, double secondCooldown, boolean equipped) {
        super(name, description, overarchingCategory, weight, inventory);
        this.gearScore = gearScore;
        this.tier = tier;
        this.requirement = requirement;
        this.secondCooldown = secondCooldown;
        this.equipped = equipped;
    }

    public int getGearScore() {
        return gearScore;
    }

    public void setGearScore(int gearScore) {
        this.gearScore = gearScore;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public int getRequirement() {
        return requirement;
    }

    public void setRequirement(int requirement) {
        this.requirement = requirement;
    }

    public double getSecondCooldown() {
        return secondCooldown;
    }

    public void setSecondCooldown(double secondCooldown) {
        this.secondCooldown = secondCooldown;
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
                             "%d Gear Score\n" +
                             "%s\n" +
                             "Tier %d\n" +
                             "%.1f Weight\n" +
                             "%.1f Second Cooldown\n" +
                             "Requirement: Level %d",
                getName(),
                getOverarchingCategory(),
                gearScore,
                getDescription(),
                tier,
                getWeight(),
                secondCooldown,
                requirement
        );
    }
}