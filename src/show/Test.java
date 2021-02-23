package show;

import Methods.Contact;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Test implements Serializable {
    public static void main(String[] args) throws Exception {

        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            Contact.showMenu();
            System.out.println("Nhap lua chon cua ban !");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Contact.addInfoPerson();
                    break;
                case 2:
                    Contact.showInfoStudent();
                    break;
                case 3:
                    Contact.findInfoPerson();
                    break;
                case 4:
                    Contact.editInfoPerson();
                    break;
                case 5:
                    Contact.deleteInfoPerson();
                    break;
                case 6:
                    System.out.println("Cam on Quy Khach da su dung dich vu cua toi !");
                    break;
                default:
                    System.err.println("Ban chon sai ... Hay chon tu 1 - 6 lua chon toi co...thanks !");
            }

        } while (choice != 6);
    }
}
