 class SkipNode<T extends Comparable<T>> {
    private KVPair<T> rec;
    private SkipNode<T>[] forward;

    public Object element() {
      return rec.value();
    }

    public Comparable<T> key() {
      return rec.key();
    }

    @SuppressWarnings("unchecked")
    public SkipNode(Comparable<T> key, Object elem, int level) {
      rec = new KVPair<T>(key, elem);
      forward = new SkipNode[level + 1];
      for (int i = 0; i < level; i++)
        getForward()[i] = null;
    }

    public String toString() {
      return rec.toString();
    }

    public SkipNode<T>[] getForward() {
        return forward;
    }

    
  }
