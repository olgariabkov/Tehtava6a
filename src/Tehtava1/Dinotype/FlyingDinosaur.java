package Tehtava1.Dinotype;

import Tehtava1.Dinosaur;
import Tehtava1.MainFoodSource;

import java.util.Objects;

public class FlyingDinosaur extends Dinosaur implements Camouflage {
    private boolean hasFeathers;
    private boolean camouflaged;

    //konstruktori

    public FlyingDinosaur(String name, int age, String species, String liveOn, MainFoodSource food, boolean hasFeathers, boolean camouflaged) {
        super(name, age, species, liveOn, food); //kutsutaan yliluokan konstruktoria
        this.hasFeathers = hasFeathers;
        this.camouflaged = camouflaged;
    }

    //getterr ja setter

    public boolean hasFeathers() {
        return hasFeathers;
    }

    public void setHasFeathers(boolean hasFeathers) {
        this.hasFeathers = hasFeathers;
    }

    @Override
    public void move() {
        System.out.println(getName() + " is flying.");
    }

    @Override
    public void activateCamouflage() {
        camouflaged = true;
        System.out.println(getName() + " has activated camouflage!");
    }

    @Override
    public void deactivateCamouflage() {
        camouflaged = false;
        System.out.println(getName() + " has deactivated camouflage!");
    }

    @Override
    public boolean isCamouflaged() {
        return camouflaged;
    }

    @Override
    public String toString() {
        return super.toString() + "FlyingDinosaur{" +
                "hasFeathers=" + hasFeathers + camouflaged +
                '}';
    }
        @Override
                public boolean equals(Object obj) {
            if (!super.equals(obj)) return false;
            FlyingDinosaur that = (FlyingDinosaur) obj;
            return hasFeathers == that.hasFeathers &&
                    camouflaged == that.camouflaged;
        }

        @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasFeathers, camouflaged);
        }
    }



