/**
 * 
 * @author bob313 cdc97
 * @version nov 25
 *
 */
public class BinNode {
    private int depth = 0;
    private String state;


    /**
     * Bin node!
     */
    public BinNode() {
        // none needed
    }


    /**
     * sets depth
     * 
     * @param deep
     *            depth
     */
    public void setDepth(int deep) {
        depth = deep;
    }


    /**
     * gets the depth of node
     * 
     * @return depth
     */
    public int getDepth() {
        return depth;
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
     * @param deep
     *            to calc level
     * @param x
     *            to find xdiv
     * @param y
     *            to find ydiv
     * @param z
     *            to find zdiv
     * @return the div
     */
    public int getDiv(int deep, int x, int y, int z) {
        int lvl = deep % 3;
        if (lvl == 0) {
            return x / 2;
        }
        else if (lvl == 1) {
            return y / 2;
        }
        else {
            return z / 2;
        }
    }

}
