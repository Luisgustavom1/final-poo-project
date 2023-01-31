package usecases.Agency;

import entity.Address;
import entity.Agency;

public class AgencyImpl extends Agency {
    public AgencyImpl(int number, String name, Address address) {
        super(
            number,
            name,
            address
        );
    }
}