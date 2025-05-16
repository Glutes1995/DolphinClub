package Finance;

public enum MembershipFee {
    JUNIOR(1000),
    SENIOR(1600),
    PASSIVE(500),
    SENIOR_DISCOUNT(0.25);

    private final double value;

    MembershipFee(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
