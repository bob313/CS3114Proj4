/**
 * 
 * @author bob313 cdc97
 * @version nov 30
 *
 */
public class SkipListTest extends student.TestCase {

    /**
     * Tests the insert method as well as the find method.
     */
    public void testInsert() {
        SkipList<String> list = new SkipList<String>();
        list.insert("Christian", 42);
        assertEquals(42, list.find("Christian"));
        list.insert("Bob", 25);
        assertEquals(25, list.find("Bob"));
        list.insert("Czarl", 8);
        list.print();
    }


    /**
     * Tests the delete method
     */
    public void testDelete() {
        SkipList<String> list = new SkipList<String>();
        list.insert("Christian", 42);
        assertEquals(42, list.find("Christian"));
        list.insert("Bob", 25);
        assertEquals(25, list.find("Bob"));
        list.insert("Czarl", 8);
        list.print();

        // begin delete testing
        list.delete("Christian");
        assertNull(list.find("Christian"));
        list.print();

        list.delete("Bob");
        assertNull(list.find("Bob"));
        list.print();
    }
}
