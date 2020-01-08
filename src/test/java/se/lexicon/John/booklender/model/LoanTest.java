package se.lexicon.John.booklender.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
public class LoanTest {
    private Loan testLoan;
    private LibraryUser testLoanTaker;
    private LocalDate testRegDate = LocalDate.parse("2020-01-08");
    private String testName = "Lasse Lånare";
    private String testEmail = "lasse.lanare@gmail.com";
    private Book testBook;
    private String testTitle = "Stora Testboken";
    private int testMaxLoanDays = 30;
    private BigDecimal testFinePerDay = BigDecimal.valueOf(5.0);
    private String testDescription = "En bok full med tester";
    private LocalDate testLoanDate = LocalDate.parse("2020-01-08");

    @BeforeEach
    public void createTestObjects() {
        testLoanTaker = new LibraryUser(testRegDate,testName,testEmail);
        testBook = new Book(testTitle,testMaxLoanDays,testFinePerDay,testDescription);
        testBook.setAvailable(true);
        testLoan = new Loan(testLoanTaker,testBook,testLoanDate);
    }

    @AfterEach
    public void killTestObjects() {
        testLoanTaker = null;
        testBook = null;
        testLoan = null;
    }

    @Test
    public void testBeforeWorks() {
        //Arrange
        LibraryUser expectedLoanTaker = testLoanTaker;
        Book expectedBook = testBook;
        LocalDate expectLoanDate = testLoanDate;

        //Act
        //done by @BeforeEach

        //Assert
        assertTrue(testLoan.getLoanId() > -1);
        assertEquals(expectedLoanTaker, testLoan.getLoanTaker());
        assertEquals(expectedBook,testLoan.getBook());
        assertEquals(expectLoanDate,testLoan.getLoanDate());
        assertFalse(testLoan.isTerminated());
    }

    @Test
    public void testToString() {

        //Act
        String result = testLoan.toString();

        //Assert
        assertTrue(result.contains(String.valueOf(testLoan.getLoanTaker())));
        assertTrue(result.contains(String.valueOf(testLoan.getBook())));
        assertTrue(result.contains(String.valueOf(testLoanDate)));
        assertTrue(result.contains(String.valueOf(testLoan.getLoanId())));
    }

    @Test
    public void testEqualsAndHashCode() {
        //Arrange
        Loan testLoan2 = new Loan(testLoanTaker,testBook,testLoanDate);

        //Assert
        assertEquals(testLoan2,testLoan);
        assertEquals(testLoan2.hashCode(),testLoan.hashCode());
    }
}
