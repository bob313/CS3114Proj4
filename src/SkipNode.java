
public class SkipNode {

    private KVPair rec;
    private SkipNode[] forward;

    public Object element() {
      return rec.getValue();
    }

    public Comparable key() {
      return rec.getKey();
    }

    public SkipNode(Comparable key, Object elem, int level) {
      rec = new KVPair(key, elem);
      setForward(new SkipNode[level + 1]);
      for (int i = 0; i < level; i++)
        getForward()[i] = null;
    }

    public String toString() {
      return rec.toString();
    }

    public SkipNode[] getForward() {
        return forward;
    }

    public void setForward(SkipNode[] forward) {
        this.forward = forward;
    }

}
