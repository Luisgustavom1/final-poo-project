package entity;

import entity.Person;
import java.time.LocalDate;

public abstract class Functionary extends Person{
    private int workCard;
    private String rg;
    private String sex;
    private String role;
    private double salary;
    private int admissionYearAt;

    public Functionary(String cpf, String name, String conjugalStatus, LocalDate birthday, Address address, int workCard, String rg, String sex, String role, double salary, int admissionYearAt) {
        super(cpf, name, conjugalStatus, birthday, address);
        this.workCard = workCard;
        this.rg = rg;
        this.sex = sex;
        this.role = role;
        this.salary = salary;
        this.admissionYearAt = admissionYearAt;
    }

    public int getWorkCard() {
        return workCard;
    }

    public void setWorkCard(int workCard) {
        this.workCard = workCard;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAdmissionYearAt() {
        return admissionYearAt;
    }

    public void setAdmissionYearAt(int admissionYearAt) {
        this.admissionYearAt = admissionYearAt;
    }

    public void salaryCalculator(double salary){
        if(admissionYearAt > 15) this.salary = salary * 1.10;
    }
}