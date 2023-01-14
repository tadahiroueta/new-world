//Authors: Lucas Ueta and John Robert R.

class TradeskillFood extends Food {
    private int requirement;

    public TradeskillFood(String name, String description, String overarchingCategory, double weight, Inventory inventory, int tier, double effectDuration, int requirement) {
        super(name, description, overarchingCategory, weight, inventory, tier, effectDuration);
        this.requirement = requirement;
    }

    public int getRequirement() {
        return requirement;
    }

    public void setRequirement(int requirement) {
        this.requirement = requirement;
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
                             "%s\n" +
                             "Tier %d\n" +
                             "%.1f Weight\n" +
                             "%.1fm Effect Duration\n" +
                             "Requirement: Level %d",
                getName(),
                getOverarchingCategory(),
                getDescription(),
                getTier(),
                getWeight(),
                getEffectDuration(),
                requirement
        );
    }
}