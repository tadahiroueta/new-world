//Authors: Lucas Ueta and John Robert R.

class QuestItems extends Item {
    public QuestItems(String name, String description, String overarchingCategory, double weight, Inventory inventory) {
        super(name, description, overarchingCategory, weight, inventory);
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
                             "%.1f Weight",
                getName(),
                getOverarchingCategory(),
                getDescription(),
                getWeight()
        );
    }
}