import java.util.*;
//Authors: Lucas Ueta and John Robert R.

class Apparel extends Item implements Salvage, EquipUnequip, Upgrade, Discard, Dye, LockUnlock, ChangeSkin {
    private int gearScore, tier, durability, requirement;
    private String rarity, numericalValues, bonuses, highlightedInformation;
    private boolean equipped, locked;

    public Apparel(String name, String description, String overarchingCategory, double weight, Inventory inventory, String rarity, int gearScore, int tier, int durability, int requirement, String numericalValues, String bonuses, String highlightedInformation, boolean equipped, boolean locked) {
        super(name, description, overarchingCategory, weight, inventory);
        this.rarity = rarity;
        this.gearScore = gearScore;
        this.tier = tier;
        this.durability = durability;
        this.requirement = requirement;
        this.numericalValues = numericalValues;
        this.bonuses = bonuses;
        this.highlightedInformation = highlightedInformation;
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
    public void discard() {
        getInventory().removeItem(getName());
        System.out.printf("%s has been discarded.\n", getName());
    }

    @Override
    public void dye() {
        System.out.printf("%s has been dyed.\n", getName());
    }

    @Override
    public String getActions() {
        return String.format(
                "Change Skin\n" +
                "%s\n" +
                "%s\n" +
                "Salvage\n" +
                "Upgrade\n" +
                "Discard\n" +
                "Link to chat\n" +
                "Dye",
                equipped ? "Unequip" : "Equip",
                locked ? "Unlock" : "Lock"
        );
    }

    @Override
    public boolean act(String command) {
        switch (command){
            case "discard":
                discard();
                return true;

            case "change":
                changeSkin();
                return true;

            case "equip":
            case "unequip":
                equipUnequip();
                return true;

            case "lock":

            case "unlock":
                lockUnlock();
                return true;

            case "salvage":
                salvage();
                return true;

            case "upgrade":
                upgrade();
                return true;

            case "dye":
                dye();
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
                             "%d\n" +
                             "%s\n" +
                             "%s\n" +
                             "%s\n" +
                             "%s\n" +
                             "Tier %d\n" +
                             "%.1f Weight\n" +
                             "%d Durability\n" +
                             "Requirement: Level %d",
                getName(),
                getOverarchingCategory(),
                getRarity(),
                gearScore,
                numericalValues,
                bonuses,
                getDescription(),
                highlightedInformation,
                tier,
                getWeight(),
                durability,
                requirement
        );
    }
}