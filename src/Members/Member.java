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

    public double getAnnualFee(){

        //Metode til at hente kontingenttal for members

        if (!active){
            return 500;
        }
        
        if (age < 18){
            return 1000;
        } else if (age >= 60) {
            return 1600 * 0.75;
        }else {
            return 1600;
        }
    }
}
