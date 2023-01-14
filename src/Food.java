//Authors: Lucas Ueta and John Robert R.

public class Food extends Item
{
    private int tier;
    private double effectDuration;

    public Food(String name, String description, String overarchingCategory, double weight, Inventory inventory, int tier, double effectDuration) {
        super(name, description, overarchingCategory, weight, inventory);
        this.tier = tier;
        this.effectDuration = effectDuration;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public double getEffectDuration() {
        return effectDuration;
    }

    public void setEffectDuration(double effectDuration) {
        this.effectDuration = effectDuration;
    }
}
