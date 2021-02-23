package Methods;

import Creat.Person;
import myFile.File_IO;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Contact implements Serializable {

    static String filePath = "/Users/thaodangxuan/IdeaProjects/Test_Module_2_ManageContact/src/ManageContact.dat";

    public static ArrayList<Person> listPerson = (ArrayList<Person>) File_IO.readFromFile(filePath) == null ? new ArrayList<>(): (ArrayList<Person>) File_IO.readFromFile(filePath);

    static Scanner sc = new Scanner(System.in);

    public static Person getInputInfoPerson() {

        Person person = new Person();

        System.out.println("Nhap ten: ");
        person.setName(sc.nextLine());

        System.out.println("Nhap gioi tinh: ");
        person.setGender(sc.nextLine());

        System.out.println("Nhap dia chi: ");
        person.setAddress(sc.nextLine());

        System.out.println("Nhap so dien thoai (sdt can co 10 so): ");
        while (true) {
            String phoneInput = sc.nextLine();
            boolean check = person.setPhoneNumber(phoneInput);
            if (check) {
                break;
            }
        }

        System.out.println("Nhap email (email can co ky tu '@' va khong chua ky tu ' ') : ");
        while (true) {
            String emailInput = sc.nextLine();
            boolean check = person.setEmail(emailInput);
            if (check) {
                break;
            }
        }
        return person;
    }


    public static void addInfoPerson() throws Exception {
        int n;
        System.out.println("Nhap so luong nguoi:");
        n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap nguoi thu " + (i + 1));
            Person std = getInputInfoPerson();
            listPerson.add(std);
        }

        File_IO.writeObjectToFile(listPerson, filePath);
    }

    public static void showInfoStudent() throws IOException {
        File_IO.readFromFile(filePath);

        for (int i = 0; i < listPerson.size(); i++) {
            System.out.println(listPerson.get(i).toString());
        }
    }

    public static void editInfoPerson() throws Exception{
        File_IO.readFromFile(filePath);

        int count = 0;
        System.out.println("Nhap so dien thoai muon sua ?");
        String editPhone = sc.nextLine();

        for (Person std : listPerson) {
            if (std.getPhoneNumber().equals(editPhone)) {
                System.out.println("Moi sua thong tin !");

                Person newP = Contact.getInputInfoPerson();

                std.setName(newP.getName());
                std.setGender(newP.getName());
                std.setEmail(newP.getEmail());
                std.setAddress(newP.getAddress());
                std.setPhoneNumber(newP.getPhoneNumber());

                count++;
            }
        }
        if (count == 0) {
            System.err.println("Khong tim thay nguoi trong danh sach !");
        }

        File_IO.writeObjectToFile(listPerson, filePath);
    }

    public static void deleteInfoPerson() throws Exception{
        File_IO.readFromFile(filePath);

        int count = 0;
        System.out.println("Nhap so dien thoai muon xoa ?");
        String removeRollNo = sc.nextLine();

        for (Person std : listPerson) {
            if (std.getPhoneNumber().equals(removeRollNo)) {
                listPerson.remove(std);
                count++;
                break;
            }
        }
        if (count == 0) {
            System.err.println("Khong tim thay nguoi trong danh sach !");
        }

        File_IO.writeObjectToFile(listPerson, filePath);
    }

    public static void findInfoPerson() {
        System.out.println("Nhap so dien thoai can tim: ");
        String rollNoFind = sc.nextLine();

        int count = 0;

        for (Person std : listPerson) {
            if (std.getPhoneNumber().equals(rollNoFind)) {
                System.out.println(std.toString());
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Khong tim thay nguoi trong danh sach !");
        }
    }

    public static void sortContact() {
        Collections.sort(listPerson, (o1, o2) -> {
            int cpm = o1.getName().compareTo(o2.getName());
            if (cpm >= 0) {
                return 1;
            } else {
                return -1;
            }
        });

        for (int i = 0; i < listPerson.size(); i++) {
            listPerson.get(i).toString();
        }
    }

    public static void showMenu() {
        System.out.println("1 - Them thong tin nguoi :");
        System.out.println("2 - Hien thi thong tin contact theo A - Z :");
        System.out.println("3 - Tim thong tin nguoi :");
        System.out.println("4 - Sua thong tin nguoi :");
        System.out.println("5 - Xoa nguoi :");
        System.out.println("6 - Thoat : ");
    }
}
