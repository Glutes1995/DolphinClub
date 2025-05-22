package Files;

import java.io.*;
import java.util.Scanner;

import Controllers.CompetitiveMemberController;
import Members.CompetitiveMember;
import Members.Member;
import Package.*;
import java.time.LocalDate;
import Records.*;
import Records.Record;

public class FileHandler {
    Club club;
    RecordManager recordManager;

    public FileHandler(Club club, RecordManager recordManager) {
        this.club = club;
        this.recordManager = recordManager;
    }

    public FileHandler(Club club){
        this.club = club;
    }

    public void saveFile(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path, false);
            PrintStream ps = new PrintStream(fos);
            if (path.equals("./ClubData/MemberInfo")) {
                ps.print(club);
                ps.close();
            }
            if (path.equals("./ClubData/MemberRecords")) {
                ps.print(recordManager);
                ps.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public void loadFile(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
                while (scanner.hasNextLine()) {
                    String[] arr = scanner.nextLine().split(";");
                    //load member file
                    if (path.equals("./ClubData/MemberInfo")) {
                        if (!arr[0].equalsIgnoreCase("name")) {
                            String name = arr[0];
                            int age = Integer.parseInt(arr[1]);
                            String phoneNumber = arr[2];
                            boolean active = arr[3].equalsIgnoreCase("yes");
                            boolean paid = arr[4].equalsIgnoreCase("yes");
                            //creates standard member
                            if (arr.length == 5) {
                                Member member = new Member(name, age, phoneNumber, active, paid);
                                club.getMembers().add(member);
                            //creates competitive member
                            } else {
                                Discipline discipline = Discipline.valueOf(arr[5].toUpperCase());
                                String team = arr[6];

                                CompetitiveMember compMember = new CompetitiveMember(name, age, phoneNumber, active, paid, discipline, team);
                                club.getMembers().add(compMember);
                            }
                        }
                    } //load record file
                    else {
                        if (!arr[0].equalsIgnoreCase("type")) {

                        String type = arr[0];
                        String phoneNumber = arr[1];
                        Discipline discipline = Discipline.valueOf(arr[2].toUpperCase());
                        double time = Double.parseDouble(arr[3]);
                        LocalDate date = LocalDate.parse(arr[4]);
                        String team = arr[5];

                        Record record = new Record(phoneNumber, discipline, time, date, type, team);
                        recordManager.getRecords().add(record);
                        }
                    }
                }
            scanner.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}