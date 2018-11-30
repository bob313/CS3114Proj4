import student.TestCase;

/**
 * @author bob313 cdc97
 * @version Nov 25
 */
public class LeafNodeTest extends TestCase {
    private AirObject box1;
    private AirObject box2;
    private AirObject box3;
    private AirObject box4;
    private LeafNode leaf;


    /**
     * sets up objects
     */
    public void setUp() {
        leaf = new LeafNode();
        box1 = new AirObject("airplane", "myName", "100", "100", "100", "20",
            "20", "20");
        box2 = new AirObject("airplane", "myName2", "3", "3", "3", "3", "3",
            "3");
        box3 = new AirObject("airplane", "box1", "110", "110", "110", "2", "2",
            "2");
        box4 = new AirObject("airplane", "box2", "90", "90", "90", "29", "29",
            "29");
    }


    /**
     * tests intersect
     */
    public void testIntersect() {
        assertFalse(leaf.intersect(box1, box2));
        assertTrue(leaf.intersect(box1, box3));
        assertTrue(leaf.intersect(box1, box4));
    }

}
