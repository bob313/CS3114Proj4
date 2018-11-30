<<<<<<< HEAD
/**
 * 
 * @author bob313
 * @version cdc97
=======

/**
 * Test class for KVPair
 * @author Christian Carminucci <cdc97> Bob Bao <bob313>
 * @version 11/20/2018
>>>>>>> 9778e42fd5c80b37a685c233202bd19002029adb
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
