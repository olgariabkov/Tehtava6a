package Tehtava1;

public class Jeep extends Vehicle {

    public Jeep(String name, int capacity) {
        super(name, capacity);
    }

    @Override
    public void travel() {
        System.out.println(getName() + " is traveling on rough terrain witj capacity for " + getCapacity() + " passengers.");

    }
}
