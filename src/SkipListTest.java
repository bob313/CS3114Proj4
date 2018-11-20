
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
    }
}
