import student.TestCase;

/**
 * @author bob313 cdc97
 * @version Nov 25
 */
public class LeafNodeTest extends TestCase{
    AirObject ugh;
    AirObject oof;
    LeafNode leaf;
    
    /**
     * sets up objects
     */
    public void setUp() {
        leaf = new LeafNode();
        ugh = new AirObject("airplane", "myName", "100", "100", "100", "20", "20", "20");
        oof = new AirObject("airplane", "myName2", "3", "3", "3", "3", "3", "3");
    }
    
    public void testIntersect() {
        AirObject box1 = new AirObject("airplane", "box1", "110", "110", "110", "2", "2", "2");
        AirObject box2 = new AirObject("airplane", "box2", "90", "90", "90", "29", "29", "29");
        assertFalse(leaf.intersect(ugh, oof));
        assertTrue(leaf.intersect(ugh, box1));
        assertTrue(leaf.intersect(ugh, box2));
    }
    
}
