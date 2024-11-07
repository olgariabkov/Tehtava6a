package Tehtava1;

public abstract class Vehicle {

    private String name;
    private int capacity;

    public Vehicle(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public abstract void travel();


    @Override
    public String toString() {
        return "Vehicle [name=" + name + ", capacity=" + capacity + "]";
    }
}
