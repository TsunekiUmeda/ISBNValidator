import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateISBNTest {
    @Test
    public void checkValid10digitsISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue(result, "first value");
        result = validator.checkISBN("0140177396");
        assertTrue(result, "second value");
    }

    @Test
    public void checkValid13digitsISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780596005689");
        assertTrue(result, "first value");
        result = validator.checkISBN("9780596802295");
        assertTrue(result, "second value");
    }

    @Test
    public void ISBNNumbersEndingInAnXAreValid() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void checkInvalid10digitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
        result = validator.checkISBN("978-0596005688");
        assertFalse(result);
    }

    @Test
    public void checkInvalid13digitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("978-0596005688");
        assertFalse(result);
    }


    @Test
    public void nineDigitISBNsAreNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class,
                () -> validator.checkISBN("123456789"));
    }

    @Test
    public void elevenDigitISBNsAreNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class,
                () -> validator.checkISBN("12345678911"));
    }

    @Test
    public void notNumericISBNAreNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class,
                () -> validator.checkISBN("HelloWorld"));
        assertThrows(NumberFormatException.class,
                () -> validator.checkISBN("HelloWorldabc"));
    }
}
