package Creat;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String gender;
    private String email;
    private String address;
    private String phoneNumber;

    public Person() {
    }

    public Person(String name, String gender, String email, String address, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email != null && email.contains("@") && !email.contains(" ")) {
            this.email = email;
            return true;
        } else {
            System.err.println("Ban nhap sai(email phai co ky tu '@' va ko chua khoang trang)");
            return false;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.length() == 10) {
            this.phoneNumber = phoneNumber;
            return true;
        } else {
            System.err.println("So dien thoai phai co du 10 so !");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
