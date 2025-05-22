package Members;

public class Member {
    protected String name;
    protected int age;
    protected String phoneNumber;
    protected boolean active;
    protected boolean paid;

    public Member(String name, int age, String phoneNumber, boolean active, boolean paid) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.active = active;
        this.paid = paid;
    }

    @Override
    public String toString() {
        String isActive;
        String hasPaid;
        if (active) {
            isActive = "yes";
        } else {
            isActive = "no";
        }
        if (paid) {
            hasPaid = "yes";
        } else {
            hasPaid = "no";
        }
        return name + ";" + age + ";" + phoneNumber + ";" + isActive + ";" + hasPaid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
