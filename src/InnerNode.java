
/**
 * inner node
 * 
 * @author bob313 cdc97
 * @version nov 21
 */
public class InnerNode extends BinNode {
    private LeafNode left;
    private LeafNode right;


    /**
     * creates inner Node
     * 
     */
    public InnerNode(LeafNode empty) {
        left = empty;
        right = empty;
    }
}
