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
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", active='" + active + '\'' +
                ", paid=" + paid +
                '}';
    }
}
