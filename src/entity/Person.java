package entity;

import java.time.LocalDate;

public abstract class Person{
    private String cpf;
    private String name;
    private String conjugalStatus;
    private LocalDate birthday;
    private Address address;

    public Person(String cpf, String name, String conjugalStatus, LocalDate birthday, Address address) {
        this.cpf = cpf;
        this.name = name;
        this.conjugalStatus = conjugalStatus;
        this.birthday = birthday;
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConjugalStatus() {
        return conjugalStatus;
    }

    public void setConjugalStatus(String conjugalStatus) {
        this.conjugalStatus = conjugalStatus;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean cpfVerify(String[] cpf){
        //  Implementação para verificar CPF.
        return true;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Person{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", conjugalStatus='" + conjugalStatus + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}