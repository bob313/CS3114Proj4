
/**
 * 
 * @author bob313 cdc97
 * @version Nov 21
 *
 */
public class BinTree {
    private Node root;


    /**
     * leaf node
     * 
     * @author bob313 cdc97
     *
     */
    private static class LeafNode {
        private AirObject obj;


        /**
         * create a node
         * 
         * @param object
         *            is the airobject
         */
        private LeafNode() {
            obj = null;
        }


        /**
         * insert a value
         * 
         * @param object
         *            is airobject value
         */
        public void insert(AirObject object) {
            obj = object;
        }


        /**
         * checks if leaf node is empty
         * 
         * @return true if leaf node is not null
         */
        public boolean getObj() {
            return (obj != null);
        }

    }


    /**
     * inner node
     * 
     * @author bob313 cdc97
     * @version nov 21
     */
    private static class InnerNode {
        private LeafNode upleft;
        private LeafNode upright;
        private LeafNode downleft;
        private LeafNode downright;


        /**
         * creates inner Node
         * 
         */
        private InnerNode() {
            upleft = null;
            upright = null;
            downleft = null;
            downright = null;
        }
    }


    /**
     * initialize 3d BinTree
     */
    public BinTree() {
        root = null;
    }


    public void insert(AirObject obj) {
        if (root == null) {
            root = new Node(obj);
        }
        else {

        }
    }

}
