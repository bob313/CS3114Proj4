/**
 * 
 * @author cdc97 bob313
 * @version nov 21
 *
 */
public class SkipNodeTest extends student.TestCase {

    /**
     * Tests the element, key, and getForward methods
     */
    public void testGetters() {
        SkipNode<String> node = new SkipNode<String>("Christian", 42, 0);
        assertEquals("Christian", node.key());
        assertEquals(42, node.element());
        assertEquals(1, node.getForward().length);
        assertNull(node.getForward()[0]);
    }


    /**
     * Tests the toSting method of SkipNode
     */
    public void testToString() {
        SkipNode<String> node = new SkipNode<String>("Christian", 42, 0);
        assertEquals("42", node.toString());
    }
}
