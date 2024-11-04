package Tehtava1.ttrooli;

import Tehtava1.Employee;

import java.util.HashMap;
import java.util.Map;

public class Veterinarian extends Employee implements AnimalCare {

    private String specialization;
    private Map<String, String> healthRecords; //Dinosaurusten terveydentilan tallentaminen


    //konstruktori

    public Veterinarian(String name, String jobTitle, int yearsOfExperience, String specialization) {
        super(name, jobTitle, yearsOfExperience);
        this.specialization = specialization;
        this.healthRecords = new HashMap<>();
    }

    //getter ja setter

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void feedAnimal(String animalName) {
        System.out.println("Feeding " + animalName + " ");
    }

    @Override
    public void conductHealthCheck(String animalName) {
        System.out.println("Conducting health check for " + animalName);
        healthRecords.put(animalName, "Healthy"); //Terveydentilan päivitys tarkastuksen jälkeen
    }

    @Override
    public String getHealthStatus(String animalName) {
        return healthRecords.getOrDefault(animalName, "No records found");
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "specialization='" + specialization + '\'' + ", healthrecords=" + healthRecords +
                '}';
    }
}

