public class ValidateISBN {

    public static final int SHORT_ISBN_LENGTH = 10;
    public static final int LONG_ISBN_LENGTH = 13;
    public static final int LONG_ISBN_MULTIPLIER = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;

    public boolean checkISBN(String isbn) {
        isbn = isbn.replaceAll("[^0-9X]", "");
        int isbnLength = isbn.length();

        if (isbnLength == SHORT_ISBN_LENGTH) {
            return isValidShortISBN(isbn);
        } else if (isbnLength == LONG_ISBN_LENGTH) {
            return isValidLongISBN(isbn);
        }
        throw new NumberFormatException("ISBN numbers must be 10 or 13 digit long");
    }

    private boolean isValidLongISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            if (i % 2 == 0) {
                total += Character.getNumericValue(isbn.charAt(i));
            } else {
                total += 3 * Character.getNumericValue(isbn.charAt(i));
            }
        }

        return total % LONG_ISBN_MULTIPLIER == 0;
    }

    private boolean isValidShortISBN(String isbn) {
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
