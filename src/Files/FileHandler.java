package Files;

import java.io.*;
import java.util.Scanner;

import Members.CompetitiveMember;
import Members.Member;
import Package.*;

public class FileHandler {
    Club club;
    String path = "./ClubData/MemberInfo";

    public FileHandler (Club club) {
        this.club = club;
    }

    public void saveFile(boolean append) {
        try {
            FileOutputStream fos = new FileOutputStream(path, append);
            PrintStream ps = new PrintStream(fos);
            ps.print(club.getMembers());
            ps.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public void loadFile() {
        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()) {
                String[] arr = scanner.nextLine().split(";");
                if (!arr[0].contains("Members")) {
                    if (arr.length == 5) {
                        String name = arr[0];
                        int age = Integer.parseInt(arr[1]);
                        String phoneNumber = arr[2];
                        boolean active = Boolean.parseBoolean(arr[3]);
                        boolean paid = Boolean.parseBoolean(arr[4]);

                        Member member = new Member(name, age, phoneNumber, active, paid);
                        club.getMembers().add(member);
                    } else {
                        String name = arr[0];
                        int age = Integer.parseInt(arr[1]);
                        String phoneNumber = arr[2];
                        boolean active = Boolean.parseBoolean(arr[3]);
                        boolean paid = Boolean.parseBoolean(arr[4]);
                        //Disciplines
                        String team = arr[6];

                        CompetitiveMember compMember = new CompetitiveMember(name, age, phoneNumber, active, paid, /*Disciplines*/, team);
                        club.getMembers().add(compMember);
                    }
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}
