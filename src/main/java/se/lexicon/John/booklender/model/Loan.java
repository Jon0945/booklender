package se.lexicon.John.booklender.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    //Fields
    private long loanId;
    private LibraryUser loanTaker;
    private Book book;
    private LocalDate loanDate;
    private boolean terminated;

    //Constructor 1
    public Loan(long loanId, LibraryUser loanTaker, Book book, LocalDate loanDate) {
        this.loanId = loanId;
        setLoanTaker(loanTaker);
        setBook(book);
        this.loanDate = loanDate;
        setTerminated(terminated);
    }

    //Constructor 2
    public Loan(LibraryUser loanTaker,Book book,LocalDate loanDate) { this(0,loanTaker,book,loanDate);}

    //Empty Constructor
    public Loan() { }

    //Getters & Setters
    public long getLoanId() { return loanId; }
    public LibraryUser getLoanTaker() { return loanTaker; }
    public void setLoanTaker(LibraryUser loanTaker) { this.loanTaker = loanTaker; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    //public boolean isOverdue() {}
    //public BigDecimal getFine() {}
    public LocalDate getLoanDate() { return loanDate; }
    public boolean isTerminated() { return terminated; }
    public void setTerminated(boolean terminated) { this.terminated = terminated; }
    //private boolean extendLoan(int days) {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return loanId == loan.loanId &&
                terminated == loan.terminated &&
                Objects.equals(loanTaker, loan.loanTaker) &&
                Objects.equals(book, loan.book) &&
                Objects.equals(loanDate, loan.loanDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, loanTaker, book, loanDate, terminated);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanTaker=" + loanTaker +
                ", book=" + book +
                ", loanDate=" + loanDate +
                ", terminated=" + terminated +
                '}';
    }
}
