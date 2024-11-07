package Tehtava1;

import java.util.Objects;

public class Employee {

    private String name;
    private String jobTitle;
    private int yearsOfExperience;

    public Employee(String name, String jobTitle, int yearsOfExperience) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void updateEmployeeInfo(String newJobTitle, Integer newYearsOfExperience) {
        if (newJobTitle != null) {
            this.jobTitle = newJobTitle;
        }

        if (newYearsOfExperience != null) {
            this.yearsOfExperience = newYearsOfExperience;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee other = (Employee) obj;
        return yearsOfExperience == other.yearsOfExperience &&
                name.equals(other.name) &&
                jobTitle.equals(other.jobTitle);

       /* Employee employee = (Employee) obj;
        return yearsOfExperience == employee.yearsOfExperience &&
                name.equals(employee.name) &&
                jobTitle.equals(employee.jobTitle); */
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, jobTitle, yearsOfExperience);
    }

}
