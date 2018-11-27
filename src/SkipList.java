import java.util.Random;

/**
 * Skip List class for comparable T
 * 
 * @author Christian Carminucci <cdc97> Bob Bao <bob313>
 * @version 11/20/2018
 * @param <T>
 *            a comparable type
 */
class SkipList<T extends Comparable<T>> {
    private SkipNode<T> head;
    private int level;
    private int size;
    static private Random ran = new Random(); // Hold the Random class object


    /**
     * Sets up the skip list with a head node at level 0
     */
    public SkipList() {
        head = new SkipNode<T>(null, null, 0);
        level = -1;
        size = 0;
    }


    /**
     * Finds the value to the corresponding key
     * 
     * @param key
     *            the key to search for
     * @return the value that goes with the key
     */
    public Object find(T key) {
        SkipNode<T> x = head; // Dummy header node
        for (int i = level; i >= 0; i--) { // For each level...
            while ((x.getForward()[i] != null) && (x.getForward()[i].key()
                .compareTo(key) < 0)) { // go forward
                x = x.getForward()[i]; // Go one last step
            }
        }
        x = x.getForward()[0]; // Move to actual record, if it exists
        if ((x != null) && (x.key().compareTo(key) == 0)) {
            return (x.element()); // Got it
        }
        else {
            return (null); // Its not there
        }
    }


    /**
     * Pick a level using a geometric distribution
     * 
     * @return the selected level
     */
    private int randomLevel() {
        int lev;
        for (lev = 0; Math.abs(ran.nextInt()) % 2 == 0; lev++) { // ran is
                                                                 // random
                                                                 // generator
        } // Do nothing
        return (lev);
    }


    /**
     * Insert a key, element pair into the skip list
     * 
     * @param key
     *            the key to be inserted
     * @param elem
     *            the element to be inserted
     */
    @SuppressWarnings("unchecked")
    public void insert(T key, Object elem) {
        int newLevel = randomLevel(); // New node's level
        if (newLevel > level) { // If new node is deeper
            adjustHead(newLevel); // adjust the header
        }
        // Track end of level
        SkipNode<T>[] update = new SkipNode[level + 1];
        SkipNode<T> x = head; // Start at header node
        for (int i = level; i >= 0; i--) { // Find insert position
            while ((x.getForward()[i] != null) && (x.getForward()[i].key()
                .compareTo(key) < 0)) {
                x = x.getForward()[i];
            }
            update[i] = x; // Track end at level i
        }
        x = new SkipNode<T>(key, elem, newLevel);
        for (int i = 0; i <= newLevel; i++) { // Splice into list
            x.getForward()[i] = update[i].getForward()[i]; // Who x points to
            update[i].getForward()[i] = x; // Who points to x
        }
        size++; // Increment dictionary size
    }


    /**
     * Adjusts the head node for the new level
     * 
     * @param newLevel
     *            the new level of the head node
     */
    private void adjustHead(int newLevel) {
        SkipNode<T> temp = head;
        head = new SkipNode<T>(null, null, newLevel);
        for (int i = 0; i <= level; i++) {
            head.getForward()[i] = temp.getForward()[i];
        }
        level = newLevel;
    }


    /**
     * Deletes a node from the skip list
     * 
     * @param key
     *            the key of the object to be deleted
     */
    @SuppressWarnings("unchecked")
    public void delete(T key) {
        SkipNode<T>[] upList = new SkipNode[level + 1];
        SkipNode<T> x = head;
        for (int i = level; i >= 0; i--) { // For each level...
            while ((x.getForward()[i] != null) && (x.getForward()[i].key()
                .compareTo(key) < 0)) { // go forward
                x = x.getForward()[i]; // Go one last step
            }
            upList[i] = x;
        }
        for (int i = level; i >= 0; i--) {
            if (upList[i] != null && upList[i].getForward()[i] != null) {
                upList[i].getForward()[i] = upList[i].getForward()[i]
                    .getForward()[i];
            }
        }
        size--;
    }


    /**
     * Prints the elements of the skip list
     */
    public void print() {
        System.out.println("SkipList dump:");
        SkipNode<T> x = head;
        while (x != null) {
            StringBuilder builder = new StringBuilder();
            builder.append("Node has depth ");
            builder.append(x.getForward().length);
            builder.append(", Value (");
            builder.append(x.toString());
            builder.append(")");
            x = x.getForward()[0];
            System.out.println(builder.toString());
        }
        System.out.println(size + " skiplist nodes printed");
    }


    /**
     * Prints given range from the skip list in order
     * 
     * @param keyStart
     *            start of range
     * @param keyEnd
     *            end of range
     */
    public void rangePrint(T keyStart, T keyEnd) {
        SkipNode<T> x = head;
        for (int i = level; i >= 0; i--) { // For each level...
            while ((x.getForward()[i] != null) && (x.getForward()[i].key()
                .compareTo(keyStart) < 0)) { // go forward
                x = x.getForward()[i]; // Go one last step
            }
        }
        while (x.getForward()[0] != null && x.getForward()[0].key().compareTo(
            keyEnd) <= 0) {
            System.out.println(x.getForward()[0].toString());
            x = x.getForward()[0];
        }
    }
}
