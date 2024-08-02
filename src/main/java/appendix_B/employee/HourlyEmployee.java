package appendix_B.employee;

import _02_movie.Money;

public class HourlyEmployee {
    private final String name;
    private final Money basePay;
    private final int timeCard;

    public HourlyEmployee(String name, Money basePay, int timeCard) {
        this.name = name;
        this.basePay = basePay;
        this.timeCard = timeCard;
    }

    public Money calculatePay(double taxRate) {
        return basePay.times(timeCard).minus(basePay.times(timeCard).times(taxRate));
    }
}
