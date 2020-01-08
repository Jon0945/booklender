package se.lexicon.John.booklender.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;

@SpringBootTest
public class LibraryUserTest {
    private LibraryUser testLibraryUser;
    private LocalDate testRegDate = LocalDate.parse("2020-01-08");
    private String testName = "Lasse Lånare";
    private String testEmail = "lasse.lanare@gmail.com";

    @BeforeEach
    public void createTestLibraryUser() {
        testLibraryUser = new LibraryUser(testRegDate,testName,testEmail);
    }

    @AfterEach
    public void killTestLibraryUser() {testLibraryUser = null;}

    @Test
    public void testBeforeWorks() {
        //Arrange
        LocalDate expectedRegDate = testRegDate;
        String expectedName = testName;
        String expectedEmail = testEmail;

        //Act
        //done by @BeforeEach

        //Assert
        assertTrue(testLibraryUser.getUserId() > -1);
        assertEquals(expectedRegDate, testLibraryUser.getRegDate());
        assertEquals(expectedName,testLibraryUser.getName());
        assertEquals(expectedEmail,testLibraryUser.getEmail());
    }

    @Test
    public void testToString() {

        //Act
        String result = testLibraryUser.toString();

        //Assert
        assertTrue(result.contains(String.valueOf(testRegDate)));
        assertTrue(result.contains(testName));
        assertTrue(result.contains(testEmail));
        assertTrue(result.contains(String.valueOf(testLibraryUser.getUserId())));
    }

    @Test
    public void testEqualsAndHashCode() {
        //Arrange
        LibraryUser testLibraryUser2 = new LibraryUser(testRegDate,testName,testEmail);

        //Assert
        assertEquals(testLibraryUser2,testLibraryUser);
        assertEquals(testLibraryUser2.hashCode(),testLibraryUser.hashCode());
    }
}
