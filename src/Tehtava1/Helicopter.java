package Tehtava1;

public class Helicopter extends Vehicle {

    public Helicopter(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public void travel() {
        System.out.println(getName() + " is flying over the park with capacity for " + getCapacity() + " passengers");

    }
}
