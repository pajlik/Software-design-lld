package entities;

public class Dice {
    private final int minValue;
    private final int maxValue;

    public Dice(int min, int max) {
        this.minValue = min;
        this.maxValue = max;
    }
    public int roll(){
        return (int)(Math.random()*(maxValue-minValue+1) + minValue);
    }
}
