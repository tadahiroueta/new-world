//Authors: Lucas Ueta and John Robert R.

class AttributeFood extends Food implements EquipUnequip, Use, Discard, Split {
    private boolean equipped;

    public AttributeFood(String name, String description, String overarchingCategory, double weight, Inventory inventory, int tier, double effectDuration, boolean equipped) {
        super(name, description, overarchingCategory, weight, inventory, tier, effectDuration);
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
                             "%s\n" +
                             "Tier %d\n" +
                             "%.1f Weight\n" +
                             "%.1fm Effect Duration",
                getName(),
                getOverarchingCategory(),
                getDescription(),
                getTier(),
                getWeight(),
                getEffectDuration()
        );
    }
}