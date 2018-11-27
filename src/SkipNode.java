/**
 * The node class for the SkipList
 * 
 * @author Christian Carminucci <cdc97> Bob Bao <bob313>
 * @version 11/20/2018
 * @param <T>
 *            comparable generic
 */
class SkipNode<T extends Comparable<T>> {
    private KVPair<T> rec;
    private SkipNode<T>[] forward;


    /**
     * Gets the element of the KVPair
     * 
     * @return the KVPair element
     */
    public Object element() {
        return rec.value();
    }


    /**
     * Gets the key of the KVPair
     * 
     * @return the KVPair key
     */
    public Comparable<T> key() {
        return rec.key();
    }


    /**
     * Constructor for SkipNode
     * Initializes the KVPair and Forward SkipNode array
     * 
     * @param key
     *            the key of the KVPair
     * @param elem
     *            the element of the KVPair
     * @param level
     *            the level of the SkipNode
     */
    @SuppressWarnings("unchecked")
    public SkipNode(Comparable<T> key, Object elem, int level) {
        rec = new KVPair<T>(key, elem);
        forward = new SkipNode[level + 1];
        for (int i = 0; i < level; i++)
            getForward()[i] = null;
    }


    /**
     * Retrieves the element of the KVPair in string form
     * 
     * @return the string form of the KVPair element
     */
    public String toString() {
        return rec.toString();
    }


    /**
     * Gets the forward array of SkipNode
     * 
     * @return the forward array of SkipNode
     */
    public SkipNode<T>[] getForward() {
        return forward;
    }

}
