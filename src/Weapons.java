//Authors: Lucas Ueta and John Robert R.

class Weapons extends Item implements Repair, Salvage, EquipUnequip, Upgrade, ReplaceGem, LockUnlock, ChangeSkin {
    private int gearScore, tier, durability, requirement;
    private String rarity, gearScoreComment, numericalValues, bonuses, highlightedInformation, scalesWith;
    private boolean equipped, locked;

    public Weapons(String name, String description, String overarchingCategory, double weight, Inventory inventory, String rarity, int gearScore, int tier, int durability, int requirement, String gearScoreComment, String numericalValues, String bonuses, String highlightedInformation, String scalesWith, boolean equipped, boolean locked) {
        super(name, description, overarchingCategory, weight, inventory);
        this.rarity = rarity;
        this.gearScore = gearScore;
        this.tier = tier;
        this.durability = durability;
        this.requirement = requirement;
        this.gearScoreComment = gearScoreComment;
        this.numericalValues = numericalValues;
        this.bonuses = bonuses;
        this.highlightedInformation = highlightedInformation;
        this.scalesWith = scalesWith;
        this.equipped = equipped;
        this.locked = locked;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
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

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getRequirement() {
        return requirement;
    }

    public void setRequirement(int requirement) {
        this.requirement = requirement;
    }

    public String getGearScoreComment() {
        return gearScoreComment;
    }

    public void setGearScoreComment(String gearScoreComment) {
        this.gearScoreComment = gearScoreComment;
    }

    public String getNumericalValues() {
        return numericalValues;
    }

    public void setNumericalValues(String numericalValues) {
        this.numericalValues = numericalValues;
    }

    public String getBonuses() {
        return bonuses;
    }

    public void setBonuses(String bonuses) {
        this.bonuses = bonuses;
    }

    public String getHighlightedInformation() {
        return highlightedInformation;
    }

    public void setHighlightedInformation(String highlightedInformation) {
        this.highlightedInformation = highlightedInformation;
    }

    public String getScalesWith() {
        return scalesWith;
    }

    public void setScalesWith(String scalesWith) {
        this.scalesWith = scalesWith;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public void changeSkin() {
        System.out.printf("%s's skin has been changed.\n", getName());
    }

    @Override
    public void equipUnequip() {
        equipped = !equipped;
        System.out.printf("%s has been %s.\n", getName(), equipped ? "equipped" : "unequipped");
    }

    @Override
    public void lockUnlock() {
        locked = !locked;
        System.out.printf("%s has been %s.\n", getName(), locked ? "locked" : "unlocked");

    }

    @Override
    public void repair() {
        durability += 100;
        System.out.printf("%s's durability has been increased by 100.\n", getName());
    }

    @Override
    public void replaceGem() {
        gearScore += 100;
        System.out.printf("%s's gem has been replaced and its Gear Score has increased by 100.\n", getName());
    }

    @Override
    public void salvage() {
        getInventory().removeItem(getName());
        System.out.printf("%s has been salvaged for %d coins.\n", getName(), (int) (Math.random() * 50));
    }

    @Override
    public void upgrade() {
        gearScore += 100;
        System.out.printf("%s has been upgraded and its Gear Score has increased by 100.\n", getName());
    }

    @Override
    public String getActions() {
        return String.format(
                "Repair\n" +
                "Salvage\n" +
                "%s\n" +
                "Upgrade\n" +
                "Replace gem\n" +
                "Link to Chat\n" +
                "%s\n" +
                "Change skin",
                equipped ? "Unequip" : "Equip",
                locked ? "Unlock" : "Lock"
        );
    }

    @Override
    public boolean act(String command) {
        switch (command){
            case "repair":
                repair();
                return true;

            case "salvage":
                salvage();
                return true;

            case "equip":
            case "unequip":
                equipUnequip();
                return true;

            case "upgrade":
                upgrade();
                return true;

            case "replace":
                replaceGem();
                return true;

            case "link":
                linkToChat();
                return true;

            case "lock":
            case "unlock":
                lockUnlock();
                return true;

            case "change":
                changeSkin();
                return true;

            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                             "%s\t%s\n" +
                             "%d\n" +
                             "%s\n" +
                             "%s\n" +
                             "%s\n" +
                             "%s\n" +
                             "%s\n" +
                             "Tier %d\n" +
                             "Scales with %s\n" +
                             "%.1f Weight\n" +
                             "%d Durability\n" +
                             "Requirement: Level %d",
                getName(),
                getOverarchingCategory(),
                getRarity(),
                gearScore,
                gearScoreComment,
                numericalValues,
                bonuses,
                getDescription(),
                highlightedInformation,
                tier,
                scalesWith,
                getWeight(),
                durability,
                requirement
        );
    }
}