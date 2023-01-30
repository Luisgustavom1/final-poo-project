package entity;

public abstract class Address {
  private String city;
  private String state;
  private String country;
  private String neighborhood;
  private String streetName;
  private String streetNumber;

  public Address(
    String city,
    String state,
    String country,
    String neighborhood,
    String streetName,
    String streetNumber
  ) {
    this.city = city;
    this.state = state;
    this.country = country;
    this.neighborhood = neighborhood;
    this.streetName = streetName;
    this.streetNumber = streetNumber;
  }

  @Override
  public abstract String toString();

  public void setCity(String city) {
    this.city = city;
  }

  public String getCity() {
    return city;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCountry() {
    return country;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  public String getStreetNumber() {
    return streetNumber;
  }
}

