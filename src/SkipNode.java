/**
 * 
 * @author bob313 cdc97
 * @version nov 28
 *
 * @param <T>
 */
class SkipNode<T extends Comparable<T>> {
    private KVPair<T> rec;
    private SkipNode<T>[] forward;


    /**
     * 
     * @return rec value
     */
    public Object element() {
        return rec.value();
    }


    /**
     * 
     * @return rec key
     */
    public Comparable<T> key() {
        return rec.key();
    }


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
        for (int i = 0; i < level; i++) {
            getForward()[i] = null;
        }
    }


    /**
     * conver to string
     * 
     * @return a string
     */
    public String toString() {
        return rec.toString();
    }


    /**
     * 
     * @return the next node
     */
    public SkipNode<T>[] getForward() {
        return forward;
    }

}
