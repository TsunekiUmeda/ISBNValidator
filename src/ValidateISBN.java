public class ValidateISBN {

    public boolean checkISBN(String isbn) {
        if (isbn.length() != 10) {
            throw new NumberFormatException("ISBN numbers must be 10 digit long");
        }

        int total = 0;

        for (int i = 0; i < 10; i++) {
            char isbnDigit = isbn.charAt(i);
            if (!Character.isDigit(isbnDigit)) {
                if (i == 9 && isbnDigit == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("ISBN numbers can only contains numeric digits");
                }

            } else {
                total += Character.getNumericValue(isbnDigit) * (10 - i);
            }

        }

        return total % 11 == 0;
    }
}
