public class ValidateISBN {

    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int LONG_ISBN_LENGTH = 13;
    public static final int LONG_ISBN_MULTIPLIER = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;
    
    public boolean checkISBN(String isbn) {
        isbn = isbn.replaceAll("[^0-9X]", "");
        int isbnLength = isbn.length();

        validateISBNLength(isbnLength);

        if (isbnLength == SHORT_ISBN_LENGTH) {
            return isValid10DigitISBN(isbn);
        } else {
            return isValid13DigitISBN(isbn);
        }
    }

    private void validateISBNLength(int isbnLength) {
        if (isbnLength != SHORT_ISBN_LENGTH && isbnLength != LONG_ISBN_LENGTH) {
            throw new NumberFormatException("ISBN numbers must be 10 digit long");
        }
    }

    private boolean isValid13DigitISBN(String isbn) {

        int total = 0;

        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            if (i % 2 == 0) {
                total += Character.getNumericValue(isbn.charAt(i));
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * 3;
            }
        }

        return total % LONG_ISBN_MULTIPLIER == 0;
    }

    private boolean isValid10DigitISBN(String isbn) {

        int total = 0;
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            char isbnDigit = isbn.charAt(i);
            if (!Character.isDigit(isbnDigit)) {
                if (i == 9 && isbnDigit == 'X') {
                    total += SHORT_ISBN_LENGTH;
                } else {
                    throw new NumberFormatException("ISBN numbers can only contains numeric digits");
                }

            } else {
                total += Character.getNumericValue(isbnDigit) * (SHORT_ISBN_LENGTH - i);
            }

        }

        return total % SHORT_ISBN_MULTIPLIER == 0;
    }
}
