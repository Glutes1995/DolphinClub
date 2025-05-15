package Members;

public class Member {
    String name;
    int age;
    long phoneNumber;
    boolean active;
    boolean paid;

    public Member(String name, int age, long phoneNumber, boolean active, boolean paid) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.active = active;
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Members.Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", active='" + active + '\'' +
                ", paid=" + paid +
                '}';
    }
    private static final double JUNIOR_FEE   = 1000;
    private static final double SENIOR_FEE   = 1600;
    private static final double PASSIVE_FEE  =  500;
    private static final double SENIOR_DISCOUNT = 0.25;   // 25 %

    public double getAnnualFee() {
        //Metode til at hente kontingenttal for members

        if (!active) return PASSIVE_FEE;
        if (age < 18) return JUNIOR_FEE;
        if (age >= 60) return SENIOR_FEE * (1 - SENIOR_DISCOUNT);
        return SENIOR_FEE;
    }
}
