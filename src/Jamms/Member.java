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

    public String toString() {
        return name + " " + memberID;
    }

}
