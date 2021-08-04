import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockManagementTests {
    @Test
    public void testCanGetACorrectLocatorCode() {
        String isbn = "0140177396";
        StockManager stockManager = new StockManager();
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

}
