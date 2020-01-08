package se.lexicon.John.booklender.model;

import java.time.LocalDate;
import java.util.Objects;

public class LibraryUser {
    //Fields
    private int userId;
    private LocalDate regDate;
    private String name;
    private String email;

    //Constructor 1
    public LibraryUser(int userId, LocalDate regDate, String name, String email) {
        this.userId = userId;
        this.regDate = regDate;
        setName(name);
        setEmail(email);
    }

    //Constructor 2
    public LibraryUser(LocalDate regDate, String name, String email) { this(0,regDate,name,email);}

    //Empty Constructor
    public LibraryUser() { }


    //Getters & Setters
    public int getUserId() { return userId; }
    public LocalDate getRegDate() { return regDate; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryUser that = (LibraryUser) o;
        return userId == that.userId &&
                Objects.equals(regDate, that.regDate) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, regDate, name, email);
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "userId=" + userId +
                ", regDate=" + regDate +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
