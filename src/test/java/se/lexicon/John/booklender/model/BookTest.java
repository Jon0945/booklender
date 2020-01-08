package se.lexicon.John.booklender.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

@SpringBootTest
public class BookTest {
    private Book testBook;
    private String testTitle = "Stora Testboken";
    private int testMaxLoanDays = 30;
    private BigDecimal testFinePerDay = BigDecimal.valueOf(5.0);
    private String testDescription = "En bok full med tester";

    @BeforeEach
    public void createTestBook() {
        testBook = new Book(testTitle,testMaxLoanDays,testFinePerDay,testDescription);
        testBook.setAvailable(true);
    }

    @AfterEach
    public void killTestBook() {
        testBook = null;
    }

    @Test
    public void testBeforeWorks() {
        //Arrange
        String expectedTitle = testTitle;
        int expectedMaxLoanDays = testMaxLoanDays;
        BigDecimal expectedFinePerDay = testFinePerDay;
        String expectedDescription = testDescription;

        //Act
        //done by @BeforeEach

        //Assert
        assertTrue(testBook.getBookId() > -1);
        assertEquals(expectedTitle,testBook.getTitle());
        assertTrue(testBook.isAvailable());
        assertFalse(testBook.isReserved());
        assertEquals(expectedMaxLoanDays,testBook.getMaxLoanDays());
        assertEquals(expectedFinePerDay,testBook.getFinePerDay());
        assertEquals(expectedDescription,testBook.getDescription());
    }

    @Test
    public void testToString() {

        //Act
        String result = testBook.toString();

        //Assert
        assertTrue(result.contains(testTitle));
        assertTrue(result.contains(String.valueOf(testMaxLoanDays)));
        assertTrue(result.contains(String.valueOf(testFinePerDay)));
        assertTrue(result.contains(testDescription));
        assertTrue(result.contains(String.valueOf(testBook.getBookId())));
    }

    @Test
    public void testEqualsAndHashCode() {
        //Arrange
        Book testBook2 = new Book(testTitle,testMaxLoanDays,testFinePerDay,testDescription);
        testBook2.setAvailable(true);

        //Assert
        assertEquals(testBook2,testBook);
        assertEquals(testBook2.hashCode(),testBook.hashCode());
    }

}
