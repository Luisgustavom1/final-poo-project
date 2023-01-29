package src.entity;


public class Agency {
    private int number;
    private String name;
    private Adress address;

    public Agency(int number, String name, Adress address) {
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

    public Adress getAddress() {
        return address;
    }

    public void setAddress(Adress address) {
        this.address = address;
    }
}