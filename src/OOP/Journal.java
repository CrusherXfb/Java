package OOP;

/*
2. Создайте класс «Журнал». Необходимо хранить в
полях класса: название журнала, год основания, описа-
ние журнала, контактный телефон, контактный e-mail.
Реализуйте методы класса для ввода данных, вывода
данных, реализуйте доступ к отдельным полям через
методы класса.
*/

import java.util.Scanner;

public class Journal {
    private String title;
    private int year;
    private String excerpt;
    private String phone;
    private String email;

    public Journal(String title, int year, String excerpt, String phone, String email) {
        this.title = title;
        this.year = year;
        this.excerpt = excerpt;
        this.phone = phone;
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название журнала: ");
        this.title = scanner.nextLine();

        System.out.print("Введите год основания: ");
        this.year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите описание журнала: ");
        this.excerpt = scanner.nextLine();

        System.out.print("Введите контактный телефон: ");
        this.phone = scanner.nextLine();

        System.out.print("Введите контактный e-mail: ");
        this.email = scanner.nextLine();
    }

    public void displayData() {
        System.out.println("Название журнала: " + title);
        System.out.println("Год основания: " + year);
        System.out.println("Описание журнала: " + excerpt);
        System.out.println("Контактный телефон: " + phone);
        System.out.println("Контактный e-mail: " + email);
    }

    public static void main(String[] args) {
        Journal journal = new Journal("", 0, "", "", "");

        journal.inputData();
        journal.displayData();
    }
}
