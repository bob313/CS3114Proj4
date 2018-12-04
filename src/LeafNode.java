/**
 * leaf node
 * 
 * @author bob313 cdc97
 * @version NOV 29
 *
 */
public class LeafNode extends BinNode {
    private LinkedList<AirObject> boxes;


    /**
     * create a node
     * 
     */
    public LeafNode() {
        boxes = new LinkedList<AirObject>();
    }


    /**
     * insert a value
     * 
     * @param obj
     *            is airobject value
     * @return true if can be added
     */
    public boolean insertCheck(AirObject obj) {
        if (size() < 3) {
            return true;
        }
        for (int i = 0; i < boxes.size(); i++) {
            if (!intersect(obj, boxes.get(i))) {
                return false;
            }
        }
        return true;
    }


    /**
     * 
     * @param obj
     *            is airobject to be added
     * @param nod
     *            is current node
     * @param depth
     *            current depth
     * @param x
     *            current x
     * @param y
     *            current y
     * @param z
     *            current z
     * @param empt
     *            empty leaf node
     * @return next node
     */
    public BinNode insert(
        AirObject obj,
        BinNode nod,
        int depth,
        int x,
        int y,
        int z,
        LeafNode empt) {
        LeafNode cur = (LeafNode)nod;
        if (cur.size() == 0) {
            cur = new LeafNode();
            cur.insert(obj);
            return cur;
        }
        if (insertCheck(obj)) {
            boxes.add(obj);
            return (cur);
        }
        cur.insert(obj);
        return (splitter(obj, cur, depth, x, y, z, empt));
    }


    /**
     * insert into list
     * 
     * @param obj
     *            object to insert into list
     */
    public void insert(AirObject obj) {
        boxes.add(obj);
    }


    /**
     * checks how many objects in leaf node
     * 
     * @return how many objects in leaf node
     */
    public int size() {
        return boxes.size();
    }


    /**
     * 
     * @param obj
     *            object
     * @param nod
     *            node
     * @param depth
     *            deep
     * @param x
     *            val
     * @param y
     *            val
     * @param z
     *            z val
     * @param empt
     *            empty
     * @return an inner node containin 2 leaf nodes
     */
    public BinNode splitter(
        AirObject obj,
        BinNode nod,
        int depth,
        int x,
        int y,
        int z,
        LeafNode empt) {
        LeafNode left = new LeafNode();
        LeafNode right = new LeafNode();
        InnerNode cur = new InnerNode();
        BinNode lNod = new BinNode();
        BinNode rNod = new BinNode();
        LeafNode leaf = (LeafNode)nod;
        int lvl = depth % 3;
        int div = getDiv(depth, x, y, z);
        depth++;
        for (int i = 0; i < leaf.size(); i++) {
            if (leaf.getBox(i).getDimStart(lvl) < div) {
                // lNod = left.insert(leaf.getBox(i), left, depth, x, y, z);
                left.insert(leaf.getBox(i));
            }
            if (leaf.getBox(i).getDimEnd(lvl) > div) {
                // rNod = right.insert(leaf.getBox(i), right, depth, x, y, z);
                right.insert(leaf.getBox(i));
            }
        }
        if (left.size() == 0) {
            lNod = empt;
        }
        else {
            lNod = left;
        }
        if (right.size() == 0) {
            rNod = empt;
        }
        else {
            rNod = right;
        }
        if (left.split()) {
            if (lvl == 0) {
                lNod = left.splitter(obj, left, depth, x - x / 2, y, z, empt);
            }
            else if (lvl == 1) {
                lNod = left.splitter(obj, left, depth, x, y - y / 2, z, empt);
            }
            else {
                lNod = left.splitter(obj, left, depth, x, y, z - z / 2, empt);
            }
        }
        if (right.split()) {
            if (lvl == 0) {
                rNod = right.splitter(obj, right, depth, x + x / 2, y, z, empt);
            }
            else if (lvl == 1) {
                rNod = right.splitter(obj, right, depth, x, y + y / 2, z, empt);
            }
            else {
                rNod = right.splitter(obj, right, depth, x, y, z + z / 2, empt);
            }
        }
        cur.setNode("left", lNod);
        cur.setNode("right", rNod);
        return cur;

    }


    /**
     * 
     * @param num
     *            box number
     * @return the box
     */
    public AirObject getBox(int num) {
        return boxes.get(num);
    }


    /**
     * 
     * @return boxes list
     */
    public LinkedList<AirObject> getBoxes() {
        return boxes;
    }


    /**
     * 
     * @return true if box needs to be split
     */
    public boolean split() {
        if (boxes.size() < 4) {
            return false;
        }
        for (int i = 0; i < boxes.size() - 1; i++) {
            for (int j = i + 1; j < boxes.size(); j++) {
                if (!intersect(boxes.get(i), boxes.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 
     * @param obj
     *            is the airobject to check if there is an intersection
     * @param box
     *            is box to compare to
     * @return true if it does intersect
     */
    public boolean intersect(AirObject obj, AirObject box) {
// boolean x1 = obj.getXorig() + obj.getXwidth() <= box.getXorig();
// boolean x2 = obj.getXorig() >= box.getXorig() + box.getXwidth();
// boolean y1 = obj.getYorig() + obj.getYwidth() <= box.getYorig();
// boolean y2 = obj.getYorig() >= box.getYorig() + box.getYwidth();
// boolean z1 = obj.getZorig() + obj.getZwidth() <= box.getZorig();
// boolean z2 = obj.getZorig() >= box.getZorig() + box.getZwidth();
        return !(obj.getXorig() + obj.getXwidth() <= box.getXorig() || obj
            .getXorig() >= box.getXorig() + box.getXwidth() || obj.getYorig()
                + obj.getYwidth() <= box.getYorig() || obj.getYorig() >= box
                    .getYorig() + box.getYwidth() || obj.getZorig() + obj
                        .getZwidth() <= box.getZorig() || obj.getZorig() >= box
                            .getZorig() + box.getZwidth());
    }


    /**
     * 
     * @return list to array
     */
    private AirObject[] array() {
        AirObject[] air = new AirObject[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            air[i] = boxes.get(i);
        }
        return air;
    }


    /**
     * 
     * @return the array printed
     */
    public AirObject[] print() {
        AirObject[] air = array();
        int n = air.length;
        for (int i = 1; i < n; ++i) {
            AirObject key = air[i];
            int j = i - 1;
            while (j >= 0 && air[j].compareTo(key) > 0) {
                air[j + 1] = air[j];
                j = j - 1;
            }
            air[j + 1] = key;
        }
        return air;
    }


    /**
     * 
     * @param name
     *            name of object to delete
     * @param depth
     *            current depth
     * @param cur
     *            current node
     * @return the new innernode
     */
    public BinNode delete(AirObject obj, int depth, BinNode cur) {

    }
    
}
