package appendix_B.employee;

import _02_movie.Money;

public class SalariedEmployee {
    private final String name;
    private final Money basePay;

    public SalariedEmployee(String name, Money basePay) {
        this.name = name;
        this.basePay = basePay;
    }

    public Money calculatePay(double taxRate) {
        return basePay.minus(basePay.times(taxRate));
    }
}
