package Package;

import Members.Member;

import java.util.ArrayList;

public class Club {
    ArrayList<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found.");
        } else {
            System.out.println("List of members:");
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }
}
