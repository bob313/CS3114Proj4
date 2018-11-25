
/**
 * 
 * @author bob313 cdc97
 * @version Nov 21
 *
 */
public class BinTree {
    private LeafNode root;
    private LeafNode empty;
    private InnerNode innerRoot;


    /**
     * leaf node
     * 
     * @author bob313 cdc97
     *
     */
    private static class LeafNode {
        private AirObject box1;
        private AirObject box2;
        private AirObject box3;


        /**
         * create a node
         * 
         * @param object
         *            is the airobject
         */
        private LeafNode() {
            box1 = null;
            box2 = null;
            box3 = null;
        }


        /**
         * insert a value
         * 
         * @param object
         *            is airobject value
         */
        public boolean insert(AirObject obj) {
            if (getCount() < 3) {
                if (box1 == null && !intersect(obj, box1)) {
                    box1 = obj;
                    return true;
                }
                else if (box2 == null && !intersect(obj, box2)) {
                    box2 = obj;
                    return true;
                }
                else if (box3 == null && !intersect(obj, box3)) {
                    box3 = obj;
                    return true;
                }
            }
            return false;
        }


        /**
         * checks if leaf node is empty
         * 
         * @return true if leaf node is not null
         */
        public boolean getObj() {
            return (box1 != null || box2 != null || box3 != null);
        }


        /**
         * checks how many objects in leaf node
         * 
         * @return how many objects in leaf node
         */
        public int getCount() {
            int sum = 0;
            if (box1 != null) {
                sum++;
            }
            if (box2 != null) {
                sum++;
            }
            if (box3 != null) {
                sum++;
            }
            return sum;
        }


        /**
         * 
         * @param obj
         *            is the airobject to check if there is an intersection
         * @return true if it does intersect
         */
        public boolean intersect(AirObject obj, AirObject box) {
            return true;
        }

    }


    /**
     * inner node
     * 
     * @author bob313 cdc97
     * @version nov 21
     */
    private static class InnerNode {
        private LeafNode left;
        private LeafNode right;


        /**
         * creates inner Node
         * 
         */
        private InnerNode(LeafNode empty) {
            left = empty;
            right = empty;
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
        }
        else {

        }
    }


    public void print() {

    }

}
