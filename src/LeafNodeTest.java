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
    private AirObject box5;
    private AirObject box6;
    private LeafNode leaf;


    /**
     * sets up objects
     *        return !(obj.getXorig() + obj.getXwidth() <= box.getXorig() || obj
            .getXorig() >= box.getXorig() + box.getXwidth() || obj.getYorig()
                + obj.getYwidth() <= box.getYorig() || obj.getYorig() >= box
                    .getYorig() + box.getYwidth() || obj.getZorig() + obj
                        .getZwidth() <= box.getZorig() || obj.getZorig() >= box
                            .getZorig() + box.getZwidth());
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
        box5 = new AirObject("airplane", "box2", "90", "90", "900", "29", "29",
            "29");
        box6 = new AirObject("airplane", "box2", "90", "900", "90", "29", "29",
            "29");
    }


    /**
     * tests intersect
     */
    public void testIntersect() {
        assertFalse(leaf.intersect(box1, box2));
        assertTrue(leaf.intersect(box1, box3));
        assertTrue(leaf.intersect(box1, box4));
        assertFalse(leaf.intersect(box5, box4));
        assertFalse(leaf.intersect(box4, box5));
        assertFalse(leaf.intersect(box6, box4));
        assertFalse(leaf.intersect(box4, box6));
    }

}
