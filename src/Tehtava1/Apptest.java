package Tehtava1;

import Tehtava1.Dinotype.AquaticDinosaur;
import Tehtava1.Dinotype.FlyingDinosaur;
import Tehtava1.Dinotype.LandDinosaur;
//import Tehtava1.Dinotype.Territorial;
import Tehtava1.ttrooli.ParkManager;
import Tehtava1.ttrooli.SecurityOfficer;
import Tehtava1.ttrooli.Veterinarian;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Apptest {


    public static void main(String[] args) throws FileNotFoundException {


        //luodaan uusi Park objekkti nimellä D...
        Park park = new Park("Dinosaur Park in TUAS");
        Jeep jeep = new Jeep("Safari Jeep", 4);
        Helicopter helicopter = new Helicopter("Park Helicopter", 6);

        //Dinosaur dino = new Dinosaur("Dino", 5, "Carnivore", "Land", MainFoodSource.CARNIVORE);
        //Dinosaur dino2 = new Dinosaur("Dino2", 5, "Carnivore", "Land", MainFoodSource.CARNIVORE);
        //System.out.println(dino.equals(dino2));

        Employee emp = new Employee("Emp", "Job", 5);
        Employee emp2 = new Employee("Emp", "Job", 5);
        System.out.println(emp.equals(emp2));


        //tt
        Veterinarian vet = new Veterinarian("Liisa", "Veterinarian", 7, "Dinosaur medicine");
        SecurityOfficer security = new SecurityOfficer("Jack", "Security officer", 5, true, true);

        //dinot
        FlyingDinosaur flyingDino = new FlyingDinosaur("Pterodactyl", 5, "Flying", "sky", MainFoodSource.HERBIVORE, true, true);
        AquaticDinosaur aquaticDino = new AquaticDinosaur("Mosasaurus", 7, "Aquatic", "sea", MainFoodSource.OMNIVORE, true);
        LandDinosaur landDino = new LandDinosaur("T-Rex", 12, "Land", "land", MainFoodSource.CARNIVORE, true, "park");

        jeep.travel();
        helicopter.travel();

        //System.out.println(park);


        //lisätään dinoja
        park.addDinosaur(flyingDino);
        park.addDinosaur(aquaticDino);
        park.addDinosaur(landDino);

        System.out.println("The program start reeding");

        //dinohoito
        vet.feedAnimal("T-Rex");
        vet.conductHealthCheck("T-Rex");

        //dino tervtieto
        System.out.println("T-Rex health status: " + vet.getHealthStatus("T-Rex"));
        System.out.println(vet);

        //opetus
        security.conductSafetyTrain();
        security.respondToEmergency("Dinosaur escape in sector 7");

        System.out.println("Is certified for emergency response: " + security.isCertified());


        //camouflage
        flyingDino.activateCamouflage();
        System.out.println("Is " + flyingDino.getName() + " camouflaged?" + flyingDino.isCamouflaged());
        flyingDino.deactivateCamouflage();
        System.out.println(flyingDino);

        //territory
        System.out.println("Is Triceraptors in its territory (Park)? " + landDino.isInTerritory("Park"));
        landDino.defendTerritory();
        landDino.defineTerritory("Forest");
        System.out.println(landDino);


        // read the files for employees and for dinosaurs
        park.readEmployeesFromFile();
        //System.out.println(park);
        park.readDinosaursFromFile();
        //tulostetaan park objekti
        System.out.println(park);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        //toistuu kunnes käyttäjä haluaa poistua
        while (!exit) {
            //näytetään valikko
            displayMenu(park.getName());
            //käyttäjän valinta
            int choice = scanner.nextInt();
            scanner.nextLine();
            //käsitellään käyttäjän valinta
            handleMenuChoice(choice, park, scanner);
        }
    }

    //metodi näyttää päävalikon
    public static void displayMenu(String parkName) {
        System.out.println("\n\nWelcome to *** " + parkName + " ***");
        System.out.println("1. Manage Dinosaur");
        System.out.println("2. Manage Park Employees");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");
    }

    //metodi käsittelee valinnan valikossa
    public static void handleMenuChoice(int choice, Park park, Scanner scanner) {
        switch (choice) {
            case 1:
                manageDinosaurs(park, scanner);
                break;
            case 2:
                manageEmployees(park, scanner);
                break;
            case 3:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice");
        }
    }

    //metodi käsittelee työntekijöiden hallinnan
    public static void manageEmployees(Park park, Scanner scanner) {
        //tulostetaan kaikki työntekijät
        System.out.println("All park employees: ");
        System.out.println(park.getEmployees());

        System.out.println("a(dd) - r(emove) - u(pdate) - c(ancel)");
        String answer = scanner.nextLine();

        switch (answer.charAt(0)) {
            case 'a':
                //lisätään uusi tt
                Employee e = askEmployeeInfo(scanner);
                park.addEmployee(e);
                break;
            case 'r':
                //poistetaan tt
                System.out.println("Enter the employee index to remove: ");
                int removeIndex = scanner.nextInt();
                scanner.nextLine();
                if (removeIndex >= 0 && removeIndex < park.getEmployees().size()) {
                    Employee employeeToRemove = park.getEmployees().get(removeIndex);
                    park.removeEmployee(employeeToRemove);//park.removeEmployee(removeIndex);
                } else {
                    System.out.println("Invalid index");
                }
                break;
            case 'u':
                System.out.println("Enter the employee index to update: ");
                int updateIndex = scanner.nextInt();
                scanner.nextLine();
                if (updateIndex >= 0 && updateIndex < park.getEmployees().size()) {
                    Employee employeeToUpdate = park.getEmployees().get(updateIndex);
                    updateEmployeeInfo(employeeToUpdate, scanner);//park.updateEmployee(updateIndex);
                } else {
                    System.out.println("Invalid index");
                }
                break;
            case 'c':
                System.out.println("Canceling operation");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void updateEmployeeInfo(Employee employee, Scanner scanner) {
        System.out.println("updating employee: " + employee);
        System.out.println("Enter new job title");
        String newJobTitle = scanner.nextLine();
        newJobTitle = newJobTitle.isEmpty() ? null : newJobTitle;

        System.out.println("Enter new years of experience");
        String experienceInput = scanner.nextLine();
        Integer newYearsOfExperience = experienceInput.isEmpty() ? null : Integer.parseInt(experienceInput);

        if (newJobTitle != null) {
            employee.setJobTitle(newJobTitle);
        }

        if (newYearsOfExperience != null) {
            employee.setYearsOfExperience(newYearsOfExperience);
        }

        System.out.println("Employee updated: " + employee);

    }

    //kysytään tt tiedot
    public static Employee askEmployeeInfo(Scanner scanner) {
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.println("Enter job title: ");
        String jobTitle = scanner.nextLine();
        System.out.println("Enter years of experience: ");
        int yearsOfExperience = scanner.nextInt();
        scanner.nextLine();

        //valitaan tt rooli
        System.out.println("Is the employee a Park manager? (y/n)");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Enter bonus: ");
            double bonus = scanner.nextDouble();
            scanner.nextLine();
            return new ParkManager(name, jobTitle, yearsOfExperience, bonus);
        }

        System.out.println("Is the employee a Secutity Officer? (y/n)");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Does the emloyee have a gun license? (y/n)");
            boolean hasGunLicense = scanner.nextLine().equalsIgnoreCase("y");
            boolean emergencyCert = scanner.nextLine().equalsIgnoreCase("y");
            return new SecurityOfficer(name, jobTitle, yearsOfExperience, hasGunLicense, emergencyCert);
        }

        System.out.println("is the employee a Veterinarian? (y/n)");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Enter veterinarian specialization: ");
            String specialization = scanner.nextLine();
            return new Veterinarian(name, jobTitle, yearsOfExperience, specialization);
        }

        return new Employee(name, jobTitle, yearsOfExperience);
    }
//}

    /*public static void updateEmployeeInfo(Employee employee, Scanner scanner) {
        System.out.println("Updating employee: " + employee);
        System.out.println("Enter new job title: ");
        String newJobTitle = scanner.nextLine();
        System.out.println("Enter new years of experience: ");
        int newYearsOfExperience = scanner.nextInt();
        scanner.nextLine();

        employee.setJobTitle(newJobTitle);
        employee.setYearsOfExperience(newYearsOfExperience);

        System.out.println("Employee updated: " + employee);
    }*/

    public static void manageDinosaurs(Park park, Scanner scanner) {
        System.out.println("All dinosaurs: ");
        System.out.println(park.getDinosaurs());

        System.out.println("a(dd) - r(remove) - u(pdate) - c(ancel)");
        String answer = scanner.nextLine();

        switch (answer.charAt(0)) {
            case 'a':
                //lisätään uusi dino
                Dinosaur d = askDinosaurInfo(scanner);
                if (d != null) {
                    park.addDinosaur(d);
                } else {
                    System.out.println("Unknown dinosaur type");
                }
                //park.addDinosaur(d);
                break;
            case 'r':
                //poistetaan dino
                System.out.println("Enter the dinosaur index to remove: ");
                int index = scanner.nextInt();
                scanner.nextLine();
                if (index >= 0 && index < park.getDinosaurs().size()) {
                    //park.removeDinosaur(index);
                    Dinosaur dinosaurToRemove = park.getDinosaurs().get(index);
                    park.removeDinosaur(dinosaurToRemove);
                } else {
                    System.out.println("Invalid index");
                }
                break;
            case 'u':
                System.out.println("Enter the dinosaur index to update: ");
                int updateIndex = scanner.nextInt();
                scanner.nextLine();
                if (updateIndex >= 0 && updateIndex < park.getDinosaurs().size()) {
                    //park.updateDinosaur(updateIndex);
                    Dinosaur dinosaurToUpdate = park.getDinosaurs().get(updateIndex);
                    updateDinoInfo(dinosaurToUpdate, scanner);
                    //park.updateDinosaur(dinosaurToUpdate);
                } else {
                    System.out.println("Invalid index");
                }
                break;
            case 'c':
                System.out.println("Canceling operation");
                break;
            default:
                System.out.println("Invalid choice");

        }
    }

    public static void updateDinoInfo(Dinosaur dinosaurs, Scanner scanner) {
        System.out.println("Updating dino: " + dinosaurs);
        System.out.println("Enter age: ");
        int newAge = scanner.nextInt();
        System.out.println("Enter species: ");
        String newSpecies = scanner.nextLine();
        scanner.nextLine();

        dinosaurs.setAge(newAge);
        dinosaurs.setSpecies(newSpecies);

        System.out.println("Dino updated: " + dinosaurs);
        //jos tyyppi ei ole valittu
    }

    //metodi uusi dino tiedot
    public static Dinosaur askDinosaurInfo(Scanner scanner) {
        System.out.println("Enter dinosaur name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the dinosaur age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter dinosaur species: ");
        String species = scanner.nextLine();
        System.out.println("Enter where does it live: ");
        String liveOn = scanner.nextLine();
        System.out.println("Enter the main food source: ");
        MainFoodSource food = MainFoodSource.valueOf(scanner.nextLine().toUpperCase());
        String territory = scanner.nextLine();

        System.out.println("Is this a flying dinosaur? (y/n)");
        boolean isFlying = scanner.nextLine().equalsIgnoreCase("y");

        if (isFlying) {
            System.out.println("Does it have feathers? (y/n)");
            boolean hasFeathers = scanner.nextLine().equalsIgnoreCase("y");
            System.out.println("Does it have camouflage? (y/n)");
            boolean hasCamouflage = scanner.nextLine().equalsIgnoreCase("y");
            return new FlyingDinosaur(name, age, species, liveOn, food, hasFeathers, hasCamouflage);
        }

        System.out.println("Is this an aquatic dinosaur? (y/n)");
        boolean isAquatic = scanner.nextLine().equalsIgnoreCase("y");

        if (isAquatic) {
            System.out.println("can it swim? (y/n)");
            boolean canSwim = scanner.nextLine().equalsIgnoreCase("y");
            return new AquaticDinosaur(name, age, species, liveOn, food, canSwim);
        }

        System.out.println("Is this a land dinosaur? (y/n)");
        boolean isLand = scanner.nextLine().equalsIgnoreCase("y");

        if (isLand) {
            System.out.println("Is it a predator? (y/n)");
            boolean isPredator = scanner.nextLine().equalsIgnoreCase("y");
            return new LandDinosaur(name, age, species, liveOn, food, isPredator, territory);
        }

        //return null;
        //return new Dinosaur(name, age, species);
        System.out.println("Unknown dinosaur type");
        return null;
    }
}
