package Tehtava1;

import Tehtava1.Dinotype.AquaticDinosaur;
import Tehtava1.Dinotype.FlyingDinosaur;
import Tehtava1.Dinotype.LandDinosaur;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Park {

    private static final int maxAmountOfDinosaurs = 12;
    private static final int employeeToDino = 3;
    private String name;
    private ArrayList<Employee> employees;
    private ArrayList<Dinosaur> dinosaurs;

    private static final Scanner scanner = new Scanner(System.in);

    //String name;
    //ArrayList<Employee> employees;
    //ArrayList<Dinosaur> dinosaurs;

    //int numberOfEmployees = 0;
    //int numberOfDinosaurs = 0;

    public Park(String name) {
        this.name = name;
        this.employees = new ArrayList<Employee>();
        this.dinosaurs = new ArrayList<Dinosaur>();
    }

    public String getName() {
        return this.name;
    }
    // park related stuff

    // dinosaur related stuff

    public ArrayList<Dinosaur> getDinosaurs() {
        return this.dinosaurs;
    }

    public int getNumberOfDinosaurs() {
        return this.dinosaurs.size();
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }

    public int getNumberOfEmployees() {
        return this.employees.size();
}

    //lisätään dinot puistoon
    public void addDinosaur(Dinosaur d) {
        if (d == null) {
            System.out.println("Dinosaur is null");
            return;
        }

        if (dinosaurs.contains(d)) {
            System.out.println("cannot add more dinosaurs. Dino already exists.");
            return;

        }
        if (dinosaurs.size() < (dinosaurs.size() + 1) * employeeToDino) {
            System.out.println("Cannot add dinosaur: There must be at least three times more employees");
            return;
        }

        dinosaurs.add(d);
        System.out.println(d.getName() + " was added to the park");


        /*if (dinosaurs.size() < maxAmountOfDinosaurs) {
            dinosaurs.add(d);
            System.out.println(d.getName() + " was added to the park");
        } else {
            System.out.println("cannot add more dinosaurs. Park is full."); */



    }

    public void updateDinosaur(int index) {
         if (index >= 0 && index < dinosaurs.size()) {
          Dinosaur d = askDinosaurInfo();
                    dinosaurs.set(index, d);
                    System.out.println("Dinosaur updated at index" + index);
                } else {
                    System.out.println("Invalid index for dinosaur update.");
                }
            }

            //poistetaan dino
            public void removeDinosaur(int index) {
                // Tarkista viel alkion olemassaolo.
                /*if (index >= 0 && index < dinosaurs.size()) {
                    dinosaurs.remove(index);
                    System.out.println("Dinosaur removed at index" + index);
                } else {
                    System.out.println("Invalid index for dinosaur removal");
                }*/
                if (index < 0 || index >= dinosaurs.size()) {
                    System.out.println("Invalid index for dinosaur removal");
                    return;
                }


               /* // Tarkista, onko dino olemassa.
                Dinosaur d = dinosaurs.get(index);
                if (d == null) {
                    System.out.println("Dinosaur not found at index " + index);
                    return;
                } */

                if (employees.size() <= (dinosaurs.size() - 1) * employeeToDino) {
                    System.out.println("Cannot remove dinosaur: There must be at least 3 employees per dinosaur.");
                    return;
                }

                Dinosaur dino = dinosaurs.remove(index);
                System.out.println(dino.getName() + " was removed from the park.");


            }

    public Dinosaur askDinosaurInfo() {
        System.out.println("Enter the name of the dinosaur: ");
        String name = scanner.nextLine();
        System.out.println("Enter dinosaur age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter dinosaur species: ");
        String species = scanner.nextLine();
        System.out.println("Enter dinosaur habitat (liveOn): ");
        String liveOn = scanner.nextLine();
        System.out.println("Enter dinosaur food source (HERBIVORE, CARNIVORE, OMNIVORE): ");
        MainFoodSource food = MainFoodSource.valueOf(scanner.nextLine().toUpperCase());


        System.out.println("Is this a flying dino? (y/n)");
        boolean isFlying = scanner.nextLine().equalsIgnoreCase("y");
        if (isFlying) {
            System.out.println("Does it have feathers");
            boolean hasFeathers = scanner.nextLine().equalsIgnoreCase("y");
            System.out.println("Does it have camouflage");
            boolean hasCamouflage = scanner.nextLine().equalsIgnoreCase("y");

            return new FlyingDinosaur(name, age, species, liveOn, food, hasFeathers, hasCamouflage);
        }

        System.out.println("Is this an aquastic dino");
        boolean isAquastic = scanner.nextLine().equalsIgnoreCase("y");

if (isAquastic) {
    System.out.println("Is this aquatic dino");
    boolean canSwim = scanner.nextLine().equalsIgnoreCase("y");
    return new AquaticDinosaur(name, age, species, liveOn, food, canSwim);
}

        System.out.println("is this a land dino");
boolean isLand = scanner.nextLine().equalsIgnoreCase("y");
        if (isLand) {
            System.out.println("Is it a predator");
            boolean ispredator = scanner.nextLine().equalsIgnoreCase("y");
            System.out.println("Enter territory");
            String territory = scanner.nextLine();
            return new LandDinosaur(name, age, species, liveOn, food, ispredator, territory);
        }
        System.out.println("Unknown dino");
        return null;
    }
           /* @Override
            public void move() {
                System.out.println(name + " is moving.");*/


                //tt metodit
            public void addEmployee(Employee e) {

                //tarkistetaan onko työntekijä null
                if (e == null) {
                    System.out.println("Employee is null");
                    return;
                }

                //tarkistetaan onko tt jo olemassa
                if (employees.contains(e)) {
                    System.out.println("Employee already exists");
                    return;
                }
                employees.add(e);
                System.out.println(e.getName() + " was added as an employee");
            }

            public Employee askEmployeeInformation() {
                System.out.println("Enter the name of the employee: ");
                String name = scanner.nextLine();
                System.out.println("Enter job title: ");
                String jobTitle = scanner.nextLine();
                System.out.println("Enter years of experience: ");
                int yearsOfExperience = Integer.parseInt(scanner.nextLine());
                return new Employee(name, jobTitle, yearsOfExperience);
            }

            public void updateEmployee(int index) {
                if (index >= 0 && index < employees.size()) {
                    Employee e = askEmployeeInformation();
                    employees.set(index, e);
                    System.out.println("Employee updated at index" + index);
                } else {
                    System.out.println("Invalid index for the employee update.");
                }
            }

            public void removeEmployee(int index) {
                // Etsi ensin se olio, joka halutaan poistaa
                //System.out.println("Anna poistettavan tyÃ¶ntekijÃ¤n nimi: ");
                //String name = scanner.nextLine();
                /*if (index >= 0 && index < employees.size()) {
                    employees.remove(index);
                    System.out.println("Employee removed at index" + index);
                } else {
                    System.out.println("Invalid index for the employee removal");
                }*/
                if (index < 0 || index >= employees.size()) {
                    System.out.println("Invalid index for employee removal");
                    return;
                }

                // Tarkista, onko tyÃ¶ntekijÃ¤n poistaminen mahdollista.
                if (employees.size() - 1 < dinosaurs.size() * 3) {
                    System.out.println("Cannot remove employee: There must be at least 3 employees per dinosaur.");
                    return;

                    }

                // Tarkista, onko tyÃ¶ntekijÃ¤ olemassa.
                Employee employee = employees.remove(index);
                    System.out.println(employee.getName() + " was removed from the park " );
                    return;

                }

               /* // Poista tyÃ¶ntekijÃ¤.
                employees.remove(index);
                System.out.println("Employee removed successfully.");
            } */

            //luetaan tiedostosta
            public void readDinosaursFromFile() throws FileNotFoundException {
                try (Scanner fileScanner = new Scanner(new File("dinosaurs.txt"))) {
                    while (fileScanner.hasNextLine()) {
            /*Scanner fileScanner = new Scanner(new File("dinosaurs.txt"));
            while (fileScanner.hasNextLine()) { */
                        String name = fileScanner.nextLine();
                        int age = Integer.parseInt(fileScanner.nextLine());
                        String species = fileScanner.nextLine();
                        String liveOn = fileScanner.nextLine();
                        MainFoodSource food = MainFoodSource.valueOf(fileScanner.nextLine().toUpperCase());


                        Dinosaur dinosaur = new Dinosaur(name, age, species, liveOn, food) {
                            @Override
                            public void move() {
                                System.out.println(name + " the " + species + " is moving in the habitat: " + liveOn);
                            }
                        };
                        addDinosaur(dinosaur);
                    }
                    fileScanner.close();
                    //System.out.println("The program start reading the information of all dinosaurs from file.");


                } catch (FileNotFoundException e) {
                    System.out.println("File not found dinosaurs");
                } catch (NumberFormatException e) {
                    System.out.println("Error");
                }
                // employee related stuff
            }

            public void readEmployeesFromFile() {//throws FileNotFoundException {
                try (Scanner fileScanner = new Scanner(new File("employees.txt"))) {

                //luetaan emp tiedot
                while (fileScanner.hasNextLine()) {
                    String name = fileScanner.nextLine();

                    String jobTitle = fileScanner.nextLine();
                    int yearsOfExperience = Integer.parseInt(fileScanner.nextLine());
                    addEmployee(new Employee(name, jobTitle, yearsOfExperience));
                }
                //fileScanner.close();
            } catch (FileNotFoundException e)

    {
        System.out.println("File not found employees");
    } catch (NumberFormatException e)

    {
        System.out.println("Error");
    }
}
            @Override
            public String toString() {
                return "Park{" +
                        "name='" + name + '\'' +
                        ", employees=" + employees +
                        ", dinosaurs=" + dinosaurs +
                        ", numberOfEmployees=" + getNumberOfEmployees() +
                        ", numberOfDinosaurs=" + getNumberOfDinosaurs() +
                        '}';
            }
        }

/*
    public void readEmployeesFromFile() {

    }

    public void readDinosaursFromFile() {
    }

    public void removeDinosaur(int index) {
    }
}*/