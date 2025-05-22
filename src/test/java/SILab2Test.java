import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    public void testEveryStatement() {
        try {
            SILab2.checkCart(null, "1234567812345678");
            fail("Expected exception for null allItems list");
        } catch (RuntimeException ex) {
            assertEquals("allItems list can't be null!", ex.getMessage());
        }

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item(null, 1, 100, 0));
        try {
            SILab2.checkCart(items2, "1234567812345678");
            fail("Expected exception for invalid item");
        } catch (RuntimeException ex) {
            assertEquals("Invalid item!", ex.getMessage());
        }

        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("Product", 11, 400, 0.1));
        try {
            SILab2.checkCart(items3, "1234");
            fail("Expected exception for invalid card number");
        } catch (RuntimeException ex) {
            assertEquals("Invalid card number!", ex.getMessage());
        }

        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("Product", 1, 100, 0));
        try {
            SILab2.checkCart(items4, "12345678123456AB");
            fail("Expected exception for invalid character in card number");
        } catch (RuntimeException ex) {
            assertEquals("Invalid character in card number!", ex.getMessage());
        }

        List<Item> items5 = new ArrayList<>();
        items5.add(new Item("Product", 11, 400, 0.1));
        String validCard = "1234567812345678";
        double expected5 = -30 + 400 * 0.9 * 11;
        assertEquals(expected5, SILab2.checkCart(items5, validCard), 0.01);
    }


    @Test
    public void testMultipleCondition() {
        String validCard = "1234567812345678";

        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("item1", 1, 100, 0));
        assertEquals(100, SILab2.checkCart(items1, validCard), 0.01);

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("item2", 11, 100, 0));
        assertEquals(-30 + 1100, SILab2.checkCart(items2, validCard), 0.01);

        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("item3", 1, 100, 0.2));
        assertEquals(-30 + 100 * 0.8, SILab2.checkCart(items3, validCard), 0.01);

        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("item4", 11, 100, 0.1));
        assertEquals(-30 + 100 * 0.9 * 11, SILab2.checkCart(items4, validCard), 0.01);

        List<Item> items5 = new ArrayList<>();
        items5.add(new Item("item5", 1, 400, 0));
        assertEquals(-30 + 400, SILab2.checkCart(items5, validCard), 0.01);

        List<Item> items6 = new ArrayList<>();
        items6.add(new Item("item6", 11, 400, 0));
        assertEquals(-30 + 400 * 11, SILab2.checkCart(items6, validCard), 0.01);

        List<Item> items7 = new ArrayList<>();
        items7.add(new Item("item7", 1, 400, 0.25));
        assertEquals(-30 + 400 * 0.75, SILab2.checkCart(items7, validCard), 0.01);

        List<Item> items8 = new ArrayList<>();
        items8.add(new Item("item8", 11, 400, 0.1));
        assertEquals(-30 + 400 * 0.9 * 11, SILab2.checkCart(items8, validCard), 0.01);
    }
}