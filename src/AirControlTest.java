import student.TestCase;

/**
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class AirControlTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing Here
    }


    /**
     * Get code coverage of the class declaration.
     */
    public void testRInit() {
        AirControl recstore = new AirControl();
        assertNotNull(recstore);
        AirControl.main(null);
    }


    /**
     * Get code coverage for AirObject class
     */
    public void testAO() {
        AirObject ao = new AirObject("airplane", "myName", "0", "0", "0", "1",
            "1", "1");
        AirObject ao2 = new AirObject("airplane", "myName2", "1", "2", "3", "1",
            "2", "3");
        assertTrue((ao.getName()).equals("myName"));
        assertEquals(ao.getXorig(), 0);
        assertEquals(ao.getYorig(), 0);
        assertEquals(ao.getZorig(), 0);
        assertEquals(ao.getXwidth(), 1);
        assertEquals(ao.getYwidth(), 1);
        assertEquals(ao.getZwidth(), 1);
        assertTrue(ao.compareTo(ao2) < 0);
    }


    /**
     * Get code coverage of the class declaration.
     */
    public void testSample() {
        AirControl recstore = new AirControl();
        assertNotNull(recstore);
        AirControl.main(null);
        String[] trial = { "P4SampleInput.txt" };
        AirControl.main(trial);
    }


    /**
     * tests a long tree
     */
    public void testsplit() {
        AirControl recstore = new AirControl();
        assertNotNull(recstore);
        AirControl.main(null);
        String[] trial = { "Longtree.txt" };
        AirControl.main(trial);
    }


    /**
     * tests many insertions
     */
    public void testMany() {
        AirControl recstore = new AirControl();
        assertNotNull(recstore);
        String[] test = { "Many.txt" };
        AirControl.main(test);
    }


    /**
     * tests split
     */
    public void testSplit() {
        AirControl recstore = new AirControl();
        assertNotNull(recstore);
        String[] test = { "Split.txt" };
        AirControl.main(test);
    }
    
    /**
     * tests intersect
     */
    public void testIntersect() {
        AirControl recstore = new AirControl();
        assertNotNull(recstore);
        String[] test = { "Intersect.txt" };
        AirControl.main(test);
    }
}
