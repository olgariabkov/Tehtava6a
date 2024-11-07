package Tehtava1;

import java.util.Objects;

public abstract class Dinosaur {
    private String name;
    private int age;
    private String species;
    private String liveOn;
    private MainFoodSource food;

    public Dinosaur() {

    }

    public Dinosaur(String name, int age, String species, String liveOn, MainFoodSource food) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.liveOn = liveOn;
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public String getLiveOn() {
        return liveOn;
    }

    public MainFoodSource getFood() {
        return food;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setLiveOn(String liveOn) {
        this.liveOn = liveOn;
    }

    public void setFood(MainFoodSource food) {
        this.food = food;
    }

    public abstract void move();

    @Override
    public String toString() {
        return "Dinosaur{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", species='" + species + '\'' +
                '}';
    }

    public void updateDinoInfo(Integer newAge, String newLiveOn, MainFoodSource newFood) {
        if (newAge != null) {
            this.age = newAge;
        }

        if (newLiveOn != null) {
            this.liveOn = newLiveOn;
        }

        if (newFood != null) {
            this.food = newFood;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dinosaur other = (Dinosaur) obj;
        return age == other.age &&
                Objects.equals(name, other.name) &&
                Objects.equals(species, other.species) &&
                Objects.equals(liveOn, other.liveOn) &&
                food == other.food;

        /*Dinosaur dinosaur = (Dinosaur) obj;
        return age == dinosaur.age &&
                Objects.equals(name, dinosaur.name) &&
                Objects.equals(species, dinosaur.species) &&
                Objects.equals(liveOn, dinosaur.liveOn) &&
                food == dinosaur.food; */

                /*name.equals(dinosaur.name) &&
                species.equals(dinosaur.species) &&
                liveOn.equals(dinosaur.liveOn) &&
                food.equals(dinosaur.food);*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, species, liveOn, food);
    }
}
