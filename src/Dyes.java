//Authors: Lucas Ueta and John Robert R.

class Dyes extends Item implements Split {
    public Dyes(String name, String description, String overarchingCategory, double weight, Inventory inventory) {
        super(name, description, overarchingCategory, weight, inventory);
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
                             "%.1f Weight",
                getName(),
                getOverarchingCategory(),
                getDescription(),
                getWeight()
        );
    }
}