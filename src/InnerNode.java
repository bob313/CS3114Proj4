
    /**
     * inner node
     * 
     * @author bob313 cdc97
     * @version nov 21
     */
    public class InnerNode {
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