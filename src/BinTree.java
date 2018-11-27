
/**
 * 
 * @author bob313 cdc97
 * @version Nov 21
 *
 */
public class BinTree {

    private static int MAX_DIM = 1024;
    private BinNode root;
    private static LeafNode EMPT_LEAF = new LeafNode();
    private int depth;
    private boolean isRoot = false;


    /**
     * initialize 3d BinTree
     */
    public BinTree() {
        root = EMPT_LEAF;
        root.setDepth(0);
        depth = 0;
    }


    public BinNode getRoot() {
        return root;
    }


    public void insert(AirObject obj) {
        depth = 0;
        BinNode[] binArr = find(obj, root, root);
        LeafNode cur = (LeafNode)binArr[1];
        BinNode prev = binArr[0];
        if (cur.insertCheck(obj)) {
            cur.insert(obj);
        } // split leaf
        else {
            int div = getDivide(obj, depth);
            splitNode(obj, cur, prev, div);
            
        }

//
// else {
// int lvl = depth % 3;
// int div = getDivide(obj, depth);
// LeafNode left = new LeafNode();
// LeafNode right = new LeafNode();
// for (int i = 0; i < cur.size(); i++) {
// if (cur.getBox(i).getDimStart(lvl) < div) {
// left.insert(cur.getBox(i));
// }
// if (cur.getBox(i).getDimEnd(lvl) >= div) {
// right.insert(cur.getBox(i));
// }
// }
// if (obj.getDimStart(lvl) < div) {
// left.insert(obj);
// }
// if (obj.getDimEnd(lvl) >= div) {
// right.insert(obj);
// }
// if (left.size() == 0) {
// left = EMPT_LEAF;
// }
// if (right.size() == 0) {
// right = EMPT_LEAF;
// }
// InnerNode innNod = new InnerNode(EMPT_LEAF);
// innNod.setNode("left", left);
// innNod.setNode("right", right);
// if (depth == 0) {
// root = innNod;
// }
// binArr[0].setNode(binArr[0].getState(), innNod);
// }

    }

    public void splitNode(AirObject obj, LeafNode cur, BinNode prev, int div) {
        int lvl = depth % 3;
        
        LeafNode left = new LeafNode();
        LeafNode right = new LeafNode();
        for (int i = 0; i < cur.size(); i++) {
            if (cur.getBox(i).getDimStart(lvl) < div) {
                left.insert(cur.getBox(i));
            }
            if (cur.getBox(i).getDimEnd(lvl) >= div) {
                right.insert(cur.getBox(i));
            }
        }
        if (obj != null && obj.getDimStart(lvl) < div) {
            left.insert(obj);
        }
        if (obj != null && obj.getDimEnd(lvl) >= div) {
            right.insert(obj);
        }
        if (left.size() == 0) {
            left = EMPT_LEAF;
        }
        if (right.size() == 0) {
            right = EMPT_LEAF;
        }
        BinNode innNod = new BinNode();
        innNod.setNode("left", left);
        innNod.setNode("right", right);
        if (depth == 0) {
            root = innNod;
        }
        prev.setNode(prev.getState(), innNod);
        if (left.split() || right.split()) {
            depth++;
        }
        if (left.split()) {
            int newDiv = div;
            if (lvl == 2) {
                newDiv = div - div / 2;
            }
            innNod.setState("left");
            splitNode(null, left, innNod, newDiv);
        }
        if (right.split()) {
            int newDiv = div;
            if (lvl == 2) {
                newDiv = div + div / 2;
            }
            innNod.setState("right");
            splitNode(null, right, innNod, newDiv);
        }
    }

    public int getDivide(AirObject obj, int depth) {
        int lvl = depth % 3;
        int min = 0;
        int max = MAX_DIM;
        int mid = 0;
        for (int i = 0; i <= depth / 3; i++) {
            mid = (max - min) / 2;
            if (obj.getDimStart(lvl) >= mid) {
                min = mid;
            }
            else {
                max = mid;
            }

        }
        return mid;

    }


    public BinNode[] find(AirObject obj, BinNode current, BinNode previous) {
        BinNode prev = previous;
        BinNode cur = current;
        int dps = depth;
        int div = getDivide(obj, dps);
        int lvl = dps % 3;// depth % 3;
        if (cur.getClass() == EMPT_LEAF.getClass()) {
            BinNode[] retArr = { prev, cur };
            return retArr;
        }
        if (obj.getDimStart(lvl) < div) {
            prev = cur;
            prev.setState("left");
            cur = cur.getNode("left");
            depth++;
            return find(obj, cur, prev);
        }
        // if (obj.getDimEnd(lvl) >= div) {
        prev = cur;
        prev.setState("right");
        cur = cur.getNode("right");
        depth++;
        return find(obj, cur, prev);
        // }
    }


    public void print(BinNode node, int deep) {
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
            }
            else {
                builder.append('I');
                System.out.println(builder.toString());
            }
            print(node.getNode("left"), deep + 1);
            print(node.getNode("right"), deep + 1);
        }
    }

}
