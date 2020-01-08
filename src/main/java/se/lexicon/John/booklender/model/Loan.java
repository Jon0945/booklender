package se.lexicon.John.booklender.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Loan {
    //Fields
    private long loanId;
    private LibraryUser loanTaker;
    private Book book;
    private LocalDate loanDate;
    private boolean terminated;

    //Constructor 1
    public Loan(long loanId, LibraryUser loanTaker, Book book, LocalDate loanDate, boolean terminated) {
        this.loanId = loanId;
        setLoanTaker(loanTaker);
        setBook(book);
        this.loanDate = loanDate;
        setTerminated(terminated);
    }

    //Constructor 2
    public Loan(LibraryUser loanTaker,Book book,LocalDate loanDate, boolean terminated) { this(0,loanTaker,book,loanDate,terminated);}

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
}
