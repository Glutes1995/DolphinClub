package Jamms;

import java.util.ArrayList;

public class Club {
    private ArrayList<Member> nonCompList = new ArrayList<>();
    private ArrayList<Competitive> compList = new ArrayList<>();

    public ArrayList<Competitive> getCompList() {
        return compList;
    }

    public ArrayList<Member> getNonCompList() {
        return nonCompList;
    }

    public void hej() {
        Member member1 = new Member("qurt", 30, true, true);
        Member member2 = new Member("Magnus", 21, true, true);
        nonCompList.add(member1);
        nonCompList.add(member2);
    }

    public String toString() {
        String members = "name;age;active;paid\n";
        for (Member member : nonCompList) {
            members += member + "\n";
        }
        return members;
    }
}
