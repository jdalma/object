package appenddix_A.billing;

import _02_movie.Money;

public class Bill {
    private final Phone phone;
    private final Money fee;

    public Bill(Phone phone, Money fee) {
        if (phone == null) {
            throw new IllegalArgumentException();
        }

        if (fee.isLessThan(Money.ZERO)) {
            throw new IllegalArgumentException();
        }

        this.phone = phone;
        this.fee = fee;
    }
}
