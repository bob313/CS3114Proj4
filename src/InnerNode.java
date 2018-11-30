
/**
 * inner node
 * 
 * @author bob313 cdc97
 * @version nov 21
 */
public class InnerNode extends BinNode {
    private static LeafNode empty;
    private BinNode left;
    private BinNode right;


    /**
     * creates inner Node
     * 
     */
    public InnerNode() {
        left = empty;
        right = empty;
    }


    /**
     * gets left
     * 
     * @return left node
     */
    public BinNode getLeft() {
        return left;
    }


    /**
     * 
     * @return right node
     */
    public BinNode getRight() {
        return right;
    }


    /**
     * 
     * @param which
     *            value to set
     * @param value
     *            to set leaf node
     */
    public void setNode(String which, BinNode value) {
        if (which.equals("left")) {
            left = value;
        }
        else {
            right = value;
        }
    }


    /**
     * 
     * @param which
     *            node to get
     * @return the node desired
     */
    public BinNode getNode(String which) {
        if (which.equals("left")) {
            return getLeft();
        }
        return right;
    }


    /**
     * 
     * @param obj
     *            object to insert
     * @param nod
     *            current node
     * @param depth
     *            deep
     * @param x
     *            val
     * @param y
     *            val
     * @param z
     *            val
     * @param empt
     *            empty
     * @return node
     */
    public BinNode insert(
        AirObject obj,
        BinNode nod,
        int depth,
        int x,
        int y,
        int z,
        LeafNode empt) {
        if (nod.getClass() == empt.getClass()) {
            LeafNode cur = (LeafNode)nod;
            nod = cur.insert(obj, nod, depth, x, y, z, empt);
        }
        else {
            int lvl = depth % 3;
            int div = getDiv(depth, x, y, z);
            depth++;
            InnerNode cur = (InnerNode)nod;
            if (obj.getDimStart(lvl) < div) {
                if (lvl == 0) {
                    cur.setNode("left", insert(obj, cur.getLeft(), depth, x - x
                        / 2, y, z, empt));
                }
                else if (lvl == 1) {
                    cur.setNode("left", insert(obj, cur.getLeft(), depth, x, y
                        - y / 2, z, empt));
                }
                else {
                    cur.setNode("left", insert(obj, cur.getLeft(), depth, x, y,
                        z - z / 2, empt));
                }
            }
            if (obj.getDimEnd(lvl) >= div) {
                if (lvl == 0) {
                    cur.setNode("right", insert(obj, cur.getRight(), depth, x
                        + x / 2, y, z, empt));
                }
                else if (lvl == 1) {
                    cur.setNode("right", insert(obj, cur.getRight(), depth, x, y
                        + y / 2, z, empt));
                }
                else {
                    cur.setNode("right", insert(obj, cur.getRight(), depth, x,
                        y, z + z / 2, empt));
                }
            }
            nod = cur;
        }
        return nod;
    }

}
