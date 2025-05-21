package Files;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import Members.CompetitiveMember;
import Members.Member;
import Package.*;

public class FileHandler {
    Club club;

    public FileHandler(Club club) {
        this.club = club;
    }

    public void saveFile(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path, false);
            PrintStream ps = new PrintStream(fos);
            if (path.equals("./ClubData/MemberInfo")) {
                ps.print(club);
                ps.close();
            } else {
                //ps.print(records);
                //ps.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    public void loadFile(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            if (club.getMembers().isEmpty()/*&& record.getRecords().isEmpty()*/) {
                while (scanner.hasNextLine()) {
                    //load member file
                    String[] arr = scanner.nextLine().split(";");
                    if (path.equals("./ClubData/MemberInfo")) {
                        if (!arr[0].equalsIgnoreCase("name")) {
                            String name = arr[0];
                            int age = Integer.parseInt(arr[1]);
                            String phoneNumber = arr[2];
                            boolean active = Boolean.parseBoolean(arr[3]);
                            boolean paid = Boolean.parseBoolean(arr[4]);
                            if (arr.length == 5) {
                                Member member = new Member(name, age, phoneNumber, active, paid);
                                club.getMembers().add(member);
                            } else {
                                Discipline discipline = null;
                                switch (arr[5]) {
                                    case "Freestyle" -> discipline = Discipline.FREESTYLE;
                                    case "Butterfly" -> discipline = Discipline.BUTTERFLY;
                                    case "Breaststroke" -> discipline = Discipline.BREASTSTROKE;
                                    case "Backstroke" -> discipline = Discipline.BACKSTROKE;
                                    default -> System.out.println("No discipline");
                                }
                                String team = arr[6];

                                CompetitiveMember compMember = new CompetitiveMember(name, age, phoneNumber, active, paid, discipline, team);
                                club.getMembers().add(compMember);
                            }
                        }
                    } //load record file
                    else {
                        if (!arr[0].equalsIgnoreCase("time")) {
                        /*
                        time
                        placement
                        competition

                        Record record = new Record(time, placement, competition);
                        Record.getRecords().add(record);
                         */
                        }
                    }
                }
            } else {
                System.out.println("File has been loaded");
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
}