package JammsFiles;

import Jamms.Club;
import Jamms.Competitive;
import Jamms.Member;
import Jamms.Record;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    //Læser en fil og returner hvert element på en linje, opdelt af et semicolon
    public void load(String path, Club club) {
        String[] info = null;
        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()) {
                info = scanner.nextLine().split(";");
                if (!info[0].equalsIgnoreCase("name")) {
                    int age = Integer.parseInt(info[1]);
                    boolean active = info[2].equalsIgnoreCase("yes");
                    boolean paid = info[3].equalsIgnoreCase("yes");

                    Member member = new Member(info[0],age,active,paid);
                    club.getNonCompList().add(member);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    //Skriver til en fil og erstatter eller tilføjer data
    public void save(String path, Club club, boolean append) {
        try {
            FileOutputStream fos = new FileOutputStream(path, append);
            PrintStream ps = new PrintStream(fos);
            ps.print(club);
            ps.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}