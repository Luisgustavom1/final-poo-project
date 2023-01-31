package entity;

import entity.Address;

public abstract class Agency {
    private int number;
    private String name;
    private Address address;

    public Agency(int number, String name, Address address) {
        this.number = number;
        this.name = name;
        this.address = address;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}