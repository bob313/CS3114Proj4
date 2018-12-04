
/**
 * 
 * @author bob313 cdc97
 * @version Nov 21
 *
 */
public class BinTree {

    private final static int MAX = 1024;
    private BinNode root;
    private final static LeafNode EMPT_LEAF = new LeafNode();
    private LinkedList<InterNode> interstellar;
    private LinkedList<AirObject> objectstellar;


    /**
     * used for linked list collisions
     * 
     * @author bob313 cdc97
     * @version nov 28
     *
     */
    public static class InterNode {

        private AirObject box1;
        private AirObject box2;


        /**
         *
         * @param b1
         *            box1
         * @param b2
         *            box2
         */
        public InterNode(AirObject b1, AirObject b2) {
            box1 = b1;
            box2 = b2;
        }


        /**
         * 
         * @return box1
         */
        public AirObject getBox1() {
            return box1;
        }


        /**
         * 
         * @return box2
         */
        public AirObject getBox2() {
            return box2;
        }

    }


    /**
     * initialize 3d BinTree
     */
    public BinTree() {
        root = EMPT_LEAF;
        root.setDepth(0);
// depth = 0;
        interstellar = new LinkedList<InterNode>();
        objectstellar = new LinkedList<AirObject>();
    }


    /**
     * 
     * @return the root
     */
    public BinNode getRoot() {
        return root;
    }


    /**
     * 
     * @param obj
     *            insert airobject
     */
    public void insert(AirObject obj) {
        if (root.getClass() == EMPT_LEAF.getClass()) {
            LeafNode cur = (LeafNode)root;
            if (cur.size() == 0) {
                root = new LeafNode();
            }
            cur = (LeafNode)root;
            root = cur.insert(obj, cur, 0, 1024, 1024, 1024, EMPT_LEAF);
        }
        else {
            InnerNode cur = (InnerNode)root;
            root = cur.insert(obj, cur, 0, 1024, 1024, 1024, EMPT_LEAF);
        }
    }


    /**
     * 
     * @param obj
     *            delete airojbect
     */
    public void delete(AirObject obj) {
        if (root.getClass() == EMPT_LEAF.getClass()) {
            LeafNode cur = (LeafNode)root;
            if (cur.getBoxes().contains(obj)) {
                cur.delete(obj);
            }
            if (cur.getBoxes().size() == 0) {
                root = EMPT_LEAF;
            }
        }
        else {
            InnerNode cur = (InnerNode)root;
            root = cur.delete(obj, 0, root);
        }
    }


    /**
     * 
     * @param node
     *            root or curr node
     * @param deep
     *            depth
     * @return total nodes
     */
    public int print(BinNode node, int deep) {
        int val = 0;
        StringBuilder builder = new StringBuilder();
        if (node != null) {
            for (int i = 0; i < deep; i++) {
                builder.append("  ");
            }
            if (node.getClass() == EMPT_LEAF.getClass()) {
                LeafNode leaf = (LeafNode)node;
                if (leaf.size() == 0) {
                    builder.append('E');
                    System.out.println(builder.toString());
                }
                else {
                    System.out.println(builder.toString() + "Leaf with " + leaf
                        .size() + " objects:");
                    AirObject[] bus = leaf.print();
                    for (int i = 0; i < leaf.size(); i++) {
                        System.out.println(builder.toString() + "(" + bus[i]
                            .toString() + ")");
                    }
                }
                return (++val);
            }
            else {
                builder.append('I');
                System.out.println(builder.toString());
                InnerNode cur = (InnerNode)node;
                val++;
                val += print(cur.getNode("left"), deep + 1);
                val += print(cur.getNode("right"), deep + 1);
                return (val);
            }
        }
        return val;
    }


    /**
     * 
     * @param node
     *            root or current node
     * @param obj
     *            is object to check
     * @param divX
     *            xdivider
     * @param divY
     *            ydivider
     * @param divZ
     *            zdivider
     * @param depth
     *            how deep
     * @return total nodes
     */
    public int intersectRec(
        BinNode node,
        AirObject obj,
        int divX,
        int divY,
        int divZ,
        int depth) {
        int val = 0;
        if (node != null) {
            if (node.getClass() == EMPT_LEAF.getClass()) {
                LeafNode leaf = (LeafNode)node;
                AirObject[] bus = leaf.print();
                for (int j = 0; j < bus.length; j++) {
                    if (leaf.intersect(obj, bus[j])) {
                        if (objectstellar.size() == 0) {
                            objectstellar.add(bus[j]);
                        }
                        else {
                            if (!objectstellar.contains(bus[j])) {
                                objectstellar.add(bus[j]);
                            }
                        }
                    }
                }
                return (++val);
            }
            else {
                InnerNode cur = (InnerNode)node;
                val++;
                int lvl = depth % 3;
                int div = cur.getDiv(depth, divX, divY, divZ);
                depth++;
                if (lvl == 0) {
                    if (obj.getDimStart(lvl) < div) {
                        val += intersectRec(cur.getNode("left"), obj, divX
                            - divX / 2, divY, divZ, depth);
                    }
                    if (obj.getDimEnd(lvl) > div) {
                        val += intersectRec(cur.getNode("right"), obj, divX
                            + divX / 2, divY, divZ, depth);
                    }
                }
                else if (lvl == 1) {
                    if (obj.getDimStart(lvl) < div) {
                        val += intersectRec(cur.getNode("left"), obj, divX, divY
                            - divY / 2, divZ, depth);
                    }
                    if (obj.getDimEnd(lvl) > div) {
                        val += intersectRec(cur.getNode("right"), obj, divX,
                            divY + divY / 2, divZ, depth);
                    }
                }
                else {
                    if (obj.getDimStart(lvl) < div) {
                        val += intersectRec(cur.getNode("left"), obj, divX,
                            divY, divZ - divZ / 2, depth);
                    }
                    if (obj.getDimEnd(lvl) > div) {
                        val += intersectRec(cur.getNode("right"), obj, divX,
                            divY, divZ + divZ / 2, depth);
                    }
                }
                return val;
            }
        }
        return val;
    }


    /**
     * 
     * @param node
     *            root or current node
     * @param obj
     *            Airobject to check
     * @return total nodes
     */
    public int intersect(BinNode node, AirObject obj) {
        objectstellar.clear();
        int val = this.intersectRec(node, obj, MAX, MAX, MAX, 0);
        for (int i = 0; i < objectstellar.size(); i++) {
            System.out.println(objectstellar.get(i).toString());
        }
        return val;
    }


    /**
     * collisions method
     * 
     * @param node
     *            root or curr node
     * @param deep
     *            depth
     */
    public void collisions(BinNode node, int deep) {
        boolean add = true;
        if (node != null) {
            if (node.getClass() == EMPT_LEAF.getClass()) {
                LeafNode leaf = (LeafNode)node;
                if (leaf.size() > 1) {
                    AirObject[] air = leaf.print();
                    for (int i = 0; i < air.length; i++) {
                        for (int j = i + 1; j < air.length; j++) {
                            if (leaf.intersect(air[i], air[j])) {
                                if (interstellar.size() == 0) {
                                    interstellar.add(new InterNode(air[i],
                                        air[j]));
                                }
                                else {
                                    for (int k = 0; k < interstellar
                                        .size(); k++) {
                                        if (interstellar.get(k).getBox1()
                                            .getName() == air[i].getName()
                                            && interstellar.get(k).getBox2()
                                                .getName() == air[j]
                                                    .getName()) {
                                            add = false;
                                        }
                                    }
                                    if (add) {
                                        interstellar.add(new InterNode(air[i],
                                            air[j]));
                                        add = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else {
                InnerNode cur = (InnerNode)node;
                deep++;
                collisions(cur.getLeft(), deep);
                collisions(cur.getRight(), deep);
            }
        }
    }


    /**
     * runs collisions
     * 
     * @param node
     *            root or curr node
     * @param deep
     *            depth
     */
    public void stellar(BinNode node, int deep) {
        interstellar.clear();
        collisions(node, deep);
        for (int i = 0; i < interstellar.size(); i++) {
            System.out.println("(" + interstellar.get(i).getBox1().toString()
                + ") and (" + interstellar.get(i).getBox2().toString() + ")");
        }
    }
}
