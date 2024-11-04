package Tehtava1.ttrooli;

import Tehtava1.Employee;

public class SecurityOfficer extends Employee implements SafetyTraining {

    private boolean hasGunLicence;
    private boolean emergencyCert;


    //konstruktori

    public SecurityOfficer(String name, String jobTitle, int yearsOfExperience, boolean hasGunLicence, boolean emergencyCert) {
        super(name, jobTitle, yearsOfExperience);
        this.hasGunLicence = hasGunLicence;
        this.emergencyCert = emergencyCert;
    }

    //getter ja setter

    public boolean hasGunLicence() {
        return hasGunLicence;
    }

    public void setHasGunLicence(boolean hasGunLicence) {
        this.hasGunLicence = hasGunLicence;
    }

    @Override
    public void conductSafetyTrain() {
        System.out.println("Conduction a safety drill for all park staff.");
    }

    @Override
    public boolean isCertified() {
        return emergencyCert;
    }

    @Override
    public void respondToEmergency(String emergency) {
        if (emergencyCert) {
            System.out.println("responding to emergency: " + emergency);
        } else {
            System.out.println("Cannot respond. Not certified for emergency situations.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "SecurityOfficer{" +
                "hasGunLicence=" + hasGunLicence +
                '}';
    }
}
