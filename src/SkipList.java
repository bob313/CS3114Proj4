import java.util.Random;

/**
 * @author Christian
 *
 */
public class SkipList {
    private SkipNode head;
    private int level;
    private int size;
    static private Random ran = new Random(); // Hold the Random class object

    public SkipList() {
      head = new SkipNode(null, null, 0);
      level = -1;
      size = 0;
    }
    
    
    
    public Object find(Comparable key) {
        SkipNode x = head; // Dummy header node
        for (int i = level; i >= 0; i--) // For each level...
          while ((x.getForward()[i] != null) && (x.getForward()[i].key().compareTo(key) < 0)) // go forward
            x = x.getForward()[i]; // Go one last step
        x = x.getForward()[0]; // Move to actual record, if it exists
        if ((x != null) && (x.key().compareTo(key) == 0)) return x.element(); // Got it
        else return null; // Its not there
      }
    
    
    int randomLevel() {
        int lev;
        for (lev = 0; Math.abs(ran.nextInt()) % 2 == 0; lev++) // ran is random generator
          ; // Do nothing
        return lev;
      }
    
    
    public void insert(Comparable key, Object elem) {
        int newLevel = randomLevel(); // New node's level
        if (newLevel > level) // If new node is deeper
          adjustHead(newLevel); // adjust the header
        // Track end of level
        SkipNode[] update = new SkipNode[level + 1];
        SkipNode x = head; // Start at header node
        for (int i = level; i >= 0; i--) { // Find insert position
          while ((x.getForward()[i] != null) && (x.getForward()[i].key().compareTo(key) < 0))
            x = x.getForward()[i];
          update[i] = x; // Track end at level i
        }
        x = new SkipNode(key, elem, newLevel);
        for (int i = 0; i <= newLevel; i++) { // Splice into list
          x.getForward()[i] = update[i].getForward()[i]; // Who x points to
          update[i].getForward()[i] = x; // Who points to x
        }
        size++; // Increment dictionary size
      }

      private void adjustHead(int newLevel) {
        SkipNode temp = head;
        head = new SkipNode(null, null, newLevel);
        for (int i = 0; i <= level; i++)
          head.getForward()[i] = temp.getForward()[i];
        level = newLevel;
      }
}
