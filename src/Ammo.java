//Authors: Lucas Ueta and John Robert R.

class Ammo extends Item implements EquipUnequip, Discard, Split {
    private double damageModifier;
    private int tier;
    private boolean equipped;

    public Ammo(String name, String description, String overarchingCategory, double weight, Inventory inventory, double damageModifier, int tier, boolean equipped) {
        super(name, description, overarchingCategory, weight, inventory);
        this.damageModifier = damageModifier;
        this.tier = tier;
        this.equipped = equipped;
    }

    public double getDamageModifier() {
        return damageModifier;
    }

    public void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
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
    public String getActions() {
        return String.format("Discard\n" +
                             "%s\n" +
                             "Split\n" +
                             "Link to Chat", equipped ? "Unequip" : "Equip");
    }

    @Override
    public boolean act(String command) {
        switch (command){
            case "discard":
                discard();
                return true;

            case "equip":
            case "unequip":
                equipUnequip();
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
                             "x %.1f Damage Modifier\n" +
                             "%s\n" +
                             "Tier %d\n" +
                             "%.1f Weight",
                getName(),
                getOverarchingCategory(),
                damageModifier,
                getDescription(),
                tier,
                getWeight()
        );
    }
}