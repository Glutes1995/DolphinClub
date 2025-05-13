package Jamms;

public class Member {
    protected static int memberIDCounter = 0;
    protected int memberID;
    protected String name;
    protected int age;
    protected boolean active;
    protected boolean paid;

    public Member(String name, int age, boolean active, boolean paid) {
    memberIDCounter++;
    memberID = memberIDCounter;
    this.name = name;
    this.age = age;
    this.active = active;
    this.paid = paid;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String toString() {
        String displayActive = "";
        String displayPaid = "";
        if (active) {
            displayActive = "Yes";
        } else {
            displayActive = "No";
        }
        if (paid) {
            displayPaid = "Yes";
        }else {
            displayPaid = "No";
        }
        return name + ";" + age + ";" + displayActive + ";" + displayPaid;
    }

}
