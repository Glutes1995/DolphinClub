package Controllers;

import java.util.Scanner;

interface ControllerInterface {
    Scanner getScanner();
    String getName();
    int getAge();
    String getPhoneNumber();
    boolean selectMembershipType();
    boolean selectPaymentStatus();
}


