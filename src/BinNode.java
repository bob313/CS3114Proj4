/**
 * 
 * @author bob313 cdc97
 * @version nov 25
 *
 */
public class BinNode {
    private int depth = 0;
    private String state;
    private BinNode left;
    private BinNode right;


    public BinNode() {
        
    }
    
    public void setDepth(int deep) {
        depth = deep;
    }
    
    public int getDepth() {
        return depth;
    }

    public BinNode getLeft() {
        return left;
    }
    
    public BinNode getRight() {
        return right;
    }

    /**
     * set the state of the node
     * 
     * @param what
     *            to set the state of the node
     */
    public void setState(String what) {
        state = what;
    }


    /**
     * 
     * @return the state;
     */
    public String getState() {
        return state;
    }


    /**
     * 
     * @param which
     *            value to set
     * @param value
     *            to set leaf node
     */
    public void setNode(String which, BinNode value) {
        if (which == "left") {
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
        if (which == "left") {
            return getLeft();
        }
        return right;
    }


}
