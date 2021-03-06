
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
        empty = new LeafNode();
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
     * Gets the right child
     * 
     * @return right node
     */
    public BinNode getRight() {
        return right;
    }


    /**
     * Sets the node as a left child or right child
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
     * gets if the node is a left child or a right child
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
     * Inserts and object into the child nodes of the current node
     * 
     * @param obj
     *            object to insert
     * @param nod
     *            current node
     * @param depth
     *            the depth of the node
     * @param x
     *            the divider for x
     * @param y
     *            the divider for y
     * @param z
     *            the divider for z
     * @param empt
     *            the empty node
     * @return node the inserted node
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


    /**
     * Deletes given AirObject from all child nodes
     * 
     * @param obj
     *            the object to be deleted from the child nodes
     * @param depth
     *            depth of the node
     * @param cur
     *            the current node
     * @return itself or the replacement merged node
     */
    public BinNode delete(AirObject obj, int depth, BinNode cur) {
        if (left.getClass() != empty.getClass()) {
            InnerNode inLeft = (InnerNode)left;
            left = inLeft.delete(obj, depth + 1, this);
        }
        if (right.getClass() != empty.getClass()) {
            InnerNode inRight = (InnerNode)right;
            right = inRight.delete(obj, depth + 1, this);
        }
        if (left.getClass() == empty.getClass()) {
            LeafNode lefLeft = (LeafNode)left;
            lefLeft.delete(obj);

        }
        if (right.getClass() == empty.getClass()) {
            LeafNode lefRight = (LeafNode)right;
            lefRight.delete(obj);
        }
        if (left.getClass() == empty.getClass() && right.getClass() == empty
            .getClass()) {
            return merge(depth, this);
        }
        return this;

    }


    /**
     * Merges child nodes into one leaf node if they meet requirements
     * 
     * @param dpeth
     *            the depth of the node
     * @param curr
     *            the current node
     * @return the current node if merging not required the merged node if it is
     */
    public BinNode merge(int dpeth, BinNode curr) {
        InnerNode cur = (InnerNode)curr;
        if (cur.getLeft().getClass() == empty.getClass() && cur.getRight()
            .getClass() == empty.getClass()) {
            LeafNode left = (LeafNode)cur.getLeft();
            LeafNode right = (LeafNode)cur.getRight();
            LeafNode node = new LeafNode();
            for (int i = 0; i < left.getBoxes().size(); i++) {
                node.insert(left.getBox(i));
            }
            for (int i = 0; i < right.getBoxes().size(); i++) {
                if (!node.getBoxes().contains(right.getBox(i))) {
                    if (node.insertCheck(right.getBox(i))) {
                        node.insert(right.getBox(i));
                    }
                    else {
                        return curr;
                    }
                }
            }
            return node;
        }
        return curr;
    }

}
