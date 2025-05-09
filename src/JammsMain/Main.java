package JammsMain;

import Jamms.Competitive;
import Jamms.Discipline;
import Jamms.Member;
import Jamms.Record;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {



        ArrayList<Discipline> disciplines = new ArrayList<>();
        disciplines.add(Discipline.FREESTYLE);
        disciplines.add(Discipline.BUTTERFLY);

        ArrayList<Record> records = new ArrayList<>();
        Record record1 = new Record(1,30,"12/5/2025",Discipline.FREESTYLE,1,"KBH");
        Record record2 = new Record(2,20,"12/5/2025",Discipline.BUTTERFLY,1,"KBH");
        records.add(record1);
        records.add(record2);


        Member member1 = new Member("qurt", 30, true, true);
        Competitive member2 = new Competitive("Magnus", 21, true, true, disciplines, records);

        //System.out.println(member1);
        System.out.println(member2);

    }
}