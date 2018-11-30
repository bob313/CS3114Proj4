/**
<<<<<<< HEAD
 * 
 * @author bob313 cdc97
 * @version nov 28
 *
 * @param <T>
=======
 * The node class for the SkipList
 * 
 * @author Christian Carminucci <cdc97> Bob Bao <bob313>
 * @version 11/20/2018
 * @param <T>
 *            comparable generic
>>>>>>> 9778e42fd5c80b37a685c233202bd19002029adb
 */
class SkipNode<T extends Comparable<T>> {
    private KVPair<T> rec;
    private SkipNode<T>[] forward;


    /**
<<<<<<< HEAD
     * 
     * @return rec value
=======
     * Gets the element of the KVPair
     * 
     * @return the KVPair element
>>>>>>> 9778e42fd5c80b37a685c233202bd19002029adb
     */
    public Object element() {
        return rec.value();
    }


    /**
<<<<<<< HEAD
     * 
     * @return rec key
=======
     * Gets the key of the KVPair
     * 
     * @return the KVPair key
>>>>>>> 9778e42fd5c80b37a685c233202bd19002029adb
     */
    public Comparable<T> key() {
        return rec.key();
    }


<<<<<<< HEAD
=======
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
>>>>>>> 9778e42fd5c80b37a685c233202bd19002029adb
    @SuppressWarnings("unchecked")
    /**
     * 
     * @param key
     *            key to insert
     * @param elem
     *            element
     * @param level
     *            level
     */
    public SkipNode(Comparable<T> key, Object elem, int level) {
        rec = new KVPair<T>(key, elem);
        forward = new SkipNode[level + 1];
<<<<<<< HEAD
        for (int i = 0; i < level; i++) {
            getForward()[i] = null;
        }
=======
        for (int i = 0; i < level; i++)
            getForward()[i] = null;
>>>>>>> 9778e42fd5c80b37a685c233202bd19002029adb
    }


    /**
<<<<<<< HEAD
     * conver to string
     * 
     * @return a string
=======
     * Retrieves the element of the KVPair in string form
     * 
     * @return the string form of the KVPair element
>>>>>>> 9778e42fd5c80b37a685c233202bd19002029adb
     */
    public String toString() {
        return rec.toString();
    }


    /**
<<<<<<< HEAD
     * 
     * @return the next node
=======
     * Gets the forward array of SkipNode
     * 
     * @return the forward array of SkipNode
>>>>>>> 9778e42fd5c80b37a685c233202bd19002029adb
     */
    public SkipNode<T>[] getForward() {
        return forward;
    }

}
