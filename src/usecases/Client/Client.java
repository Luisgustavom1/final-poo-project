import entity.Person;
import entity.Account;
import entity.Address;
import java.time.LocalDate;
public class Client extends Person{
    private String educationLevel;
    private Account account = new Account();

    public Client() {
        super(null, null, null, null, null);
        educationLevel = null;
        account = null;
    }

    public Client(String cpf, String name, String conjugalStatus, LocalDate birthday, String educationLevel, Address address) {
        super(cpf, name, conjugalStatus, birthday, address);
        this.educationLevel = educationLevel;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }
}