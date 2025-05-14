package Controllers;

import java.util.Scanner;

public interface ControllerInterface {
    Scanner getScanner();
    String getName();
    int getAge();
    long getPhoneNumber();
    boolean selectMembershipType();
    boolean selectPaymentStatus();
}
