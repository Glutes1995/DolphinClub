package JammsMain;

import Jamms.*;
import JammsFiles.FileHandler;

public class Main {
    public static void main(String[] args) {

        FileHandler fileHandler = new FileHandler();
        Club club = new Club();
        //club.hej();
        //System.out.println(club);
        //fileHandler.save("./ClubData/MemberInfo",club,false);
        fileHandler.load("./ClubData/MemberInfo",club);
        System.out.println(club);
    }
}