package usecases.Account;

import entity.Account;

public interface Rendimento {
    public static double rent = 0.075;
    public double calculaRendimento(); //Apenas SalaryAccount nao tem rendimento
}
