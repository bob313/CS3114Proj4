/**
 * leaf node
 * 
 * @author bob313 cdc97
 *
 */
public class LeafNode extends BinNode {
    private LinkedList<AirObject> boxes;
    
    /**
     * create a node
     * 
     * @param object
     *            is the airobject
     */
    public LeafNode() {
        boxes = new LinkedList<AirObject>();
        
       // super.setNode("left", null);
        //super.setNode("right", null);
    }

    /**
     * insert a value
     * 
     * @param object
     *            is airobject value
     * @return true if can be added
     */
    public boolean insertCheck(AirObject obj) {
        if (size() < 3) {
            return true;
        }
        for (int i=0; i<boxes.size();i++) {
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
     * @return true if added
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
     * @param num
     *            box number
     * @return the box
     */
    public AirObject getBox(int num) {
        return boxes.get(num);
    }


    public boolean split() {
        if (boxes.size() < 4) {
            return false;
        }
        for(int i=0; i<boxes.size() - 1; i++) {
            for (int j=1; j<boxes.size(); j++) {
                if (intersect(boxes.get(i), boxes.get(j))) {
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
     * @return true if it does intersect
     */
    public boolean intersect(AirObject obj, AirObject box) {
        if ((obj.getXorig() + obj.getXwidth() <= box.getXorig() || obj
            .getXorig() >= box.getXorig() + box.getXwidth()) && (obj.getYorig()
                + obj.getYwidth() <= box.getYorig() || obj.getYorig() >= box
                    .getYorig() + box.getYwidth()) && (obj.getZorig() + obj
                        .getZwidth() <= box.getZorig() || obj.getZorig() >= box
                            .getZorig() + box.getZwidth())) {
            return false;
        }
        return true;
    }
    
    public void sort(AirObject arr[]) 
    { 
        int n = arr.length; 
        for (int i=1; i<n; ++i) 
        { 
            AirObject key = arr[i]; 
            int j = i-1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j>=0 && arr[j].compareTo(key) > 0) 
            { 
                arr[j+1] = arr[j]; 
                j = j-1; 
            } 
            arr[j+1] = key; 
        } 
    } 
    
    private AirObject[] array() {
        AirObject[] air = new AirObject[boxes.size()];
        for (int i=0; i<boxes.size(); i++) {
            air[i] = boxes.get(i);
        }
        return air;
    }
    
    public AirObject[] print() {
        AirObject[] air = array();
        int n = air.length; 
        for (int i=1; i<n; ++i) 
        { 
            AirObject key = air[i]; 
            int j = i-1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j>=0 && air[j].compareTo(key) > 0) 
            { 
                air[j+1] = air[j]; 
                j = j-1; 
            } 
            air[j+1] = key; 
        }
        return air;
    }

}
