package Tehtava1.Dinotype;

import Tehtava1.Dinosaur;
import Tehtava1.MainFoodSource;

public class AquaticDinosaur extends Dinosaur {
    private boolean canSwim;

    // konstruktori

    public AquaticDinosaur(String name, int age, String species, String liveOn, MainFoodSource food, boolean canSwim) {
        super(name, age, species, liveOn, food);
        this.canSwim = canSwim;
    }

    //getter ja setter

    public boolean canSwim() {
        return canSwim;
    }

    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }

    public void serCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }

    @Override
    public void move() {

    }

    @Override
    public String toString() {
        return super.toString() + "AquaticDinosaur{" +
                "canSwim=" + canSwim +
                '}';
    }
}
