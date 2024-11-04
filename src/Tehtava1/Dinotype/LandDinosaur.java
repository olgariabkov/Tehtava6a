package Tehtava1.Dinotype;

import Tehtava1.Dinosaur;
import Tehtava1.MainFoodSource;

public class LandDinosaur extends Dinosaur implements Territorial {
    private boolean isPredator;
    private String territory;

    //konstruktori

    public LandDinosaur(String name, int age, String species, String liveOn, MainFoodSource food, boolean isPredator, String territory) {
        super(name, age, species, liveOn, food);
        this.isPredator = isPredator;
        this.territory = territory;
    }

    //getter ja setter

    public boolean isPredator() {
        return isPredator;
    }

    public void setPredator(boolean predator) {
        isPredator = predator;
    }

    @Override
    public void move() {
        System.out.println(getName() + " is walking on land.");
    }
    @Override
    public void defineTerritory(String territoryName) {
        this.territory = territoryName;
        System.out.println(getName() + " has established a territory " + territoryName);
    }

    @Override
    public boolean isInTerritory(String location) {
        return territory != null && territory.equalsIgnoreCase(location);
    }

    @Override
    public void defendTerritory() {
        System.out.println(getName() + " has defended a territory " + territory);
    }

    @Override
    public String toString() {
        return "LandDinosaur{" +
                "isPredator=" + isPredator +
                '}';
    }
}
