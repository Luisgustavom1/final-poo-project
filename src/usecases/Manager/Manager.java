import usecases.Agency.Agency;
import entity.Functionary;
import java.time.LocalDate;

public class Manager extends Functionary{
    private boolean hasBasicCourse;
    private Agency agency;
    private LocalDate promotionAt;
    private static double comission;

    public Manager(String cpf, String name, String conjugalStatus, LocalDate birthday, Address address, int workCard, String rg, String sex, String role, double salary, int admissionYearAt, boolean hasBasicCourse, Agency agency, LocalDate promotionAt) {
        super(cpf, name, conjugalStatus, birthday, address, workCard, rg, sex, role, salary, admissionYearAt);
        this.hasBasicCourse = hasBasicCourse;
        this.agency = agency;
        this.promotionAt = promotionAt;
    }

    public boolean isHasBasicCourse() {
        return hasBasicCourse;
    }

    public void setHasBasicCourse(boolean hasBasicCourse) {
        this.hasBasicCourse = hasBasicCourse;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public LocalDate getPromotionAt() {
        return promotionAt;
    }

    public void setPromotionAt(LocalDate promotionAt) {
        this.promotionAt = promotionAt;
    }

    public static double getComission() {
        return comission;
    }

    public static void setComission(double comission) {
        Manager.comission = comission;
    }

    public void salaryCalculator(double salary){
        setSalary(getSalary() + getComission());
    }
}