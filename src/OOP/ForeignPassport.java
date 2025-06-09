package OOP;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ForeignPassport {
    private String passportNumber;
    private String fullName;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    public ForeignPassport(String passportNumber, String fullName, LocalDate issueDate, LocalDate expiryDate) {
        this.passportNumber = passportNumber;
        this.fullName = fullName;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void displayInfo() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Номер паспорта: " + passportNumber);
        System.out.println("ФИО владельца: " + fullName);
        System.out.println("Дата выдачи: " + issueDate.format(dateFormat));
        System.out.println("Дата окончания срока действия: " + expiryDate.format(dateFormat));
    }

    public static void main(String[] args) {
        LocalDate currentIssueDate = LocalDate.now();
        LocalDate expiryDate = currentIssueDate.plusYears(10);

        ForeignPassport passport = new ForeignPassport(
                "123456789",
                "Иванов Иван Иванович",
                currentIssueDate,
                expiryDate
        );

        passport.displayInfo();
    }
}
