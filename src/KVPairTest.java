
/**
 * Test class for KVPair
 * @author Christian Carminucci <cdc97> Bob Bao <bob313>
 * @version 11/20/2018
 *
 */
public class KVPairTest extends student.TestCase {
    
    /**
     * Tests the value and key getter methods
     */
    public void testGetters() {
        KVPair<String> pair = new KVPair<String>("Christian", 42);
        assertEquals("Christian", pair.key());
        assertEquals(42, pair.value());
    }
}
