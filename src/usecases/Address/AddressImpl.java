package usecases.Address;

import entity.Address;

/*
    This is a implementation of a Address (abstract class).
 */
public class AddressImpl extends Address {
  public AddressImpl(
    String city,
    String state,
    String country,
    String neighborhood,
    String streetName,
    String streetNumber
  ) {
    super(
      city,
      state,
      country,
      neighborhood,
      streetName,
      streetNumber
    );
  }

  public String toString() {
    return "Address{" +
        "City='" + this.getCity() + '\'' +
        ", State='" + this.getState() + '\'' +
        ", Country='" + this.getCountry() + '\'' +
        ", Neighborhood='" + this.getNeighborhood() + '\'' +
        ", StreetName=" + this.getStreetName() + '\'' +
        ", StreetNumber=" + this.getStreetNumber() +
        '}';
  }
}

