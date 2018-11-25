   /**
     * leaf node
     * 
     * @author bob313 cdc97
     *
     */
    public class LeafNode extends BinNode{
        private AirObject box1;
        private AirObject box2;
        private AirObject box3;


        /**
         * create a node
         * 
         * @param object
         *            is the airobject
         */
        public LeafNode() {
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
            if (size() < 3) {
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
        public int size() {
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
