
/**
 * 
 * @author bob313 cdc97
 * @version Nov 21
 *
 */
public class BinTree {

    private static int MAX_DEM = 1024;
    private BinNode root;
    private static LeafNode EMPT_LEAF = new LeafNode();
    private int level;

    /**
     * initialize 3d BinTree
     */
    public BinTree() {
        root = null;
    }


   public void insert(AirObject obj, BinNode curr) {
        BinNode cur = curr;
        boolean isRoot = false;
        if (cur ==  null) {
            cur = root;
            isRoot = true;
        }
        if (cur == EMPT_LEAF) {
            cur = new LeafNode();
            cur.insert(obj);
            if (isRoot) {
                root = cur;
            }
        }
        if (cur.size() < 3) {
            cur.insert(obj);
        }
        
        
    }


    public void print() {

    }

}
