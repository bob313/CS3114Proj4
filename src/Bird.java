/**
 * 
 * @author bob313 cdc97
 * @version Nov 25
 *
 */
public class Bird extends AirObject {
    private String type;
    private int num;


    /**
     * 
     * @param object
     *            object
     * @param inname
     *            name
     * @param xorig
     *            xcoord
     * @param yorig
     *            ycoord
     * @param zorig
     *            zcoord
     * @param xwidth
     *            xlength
     * @param ywidth
     *            ylength
     * @param zwidth
     *            zlength
     * @param type
     *            type of bird
     * @param number
     *            number of birds
     */
    public Bird(
        String object,
        String inname,
        String xorig,
        String yorig,
        String zorig,
        String xwidth,
        String ywidth,
        String zwidth,
        String type,
        String number) {
        super(object, inname, xorig, yorig, zorig, xwidth, ywidth, zwidth);
        this.type = type;
        num = Integer.parseInt(number);
    }


    @Override
    /**
     * @return the string of fields
     */
    public String toString() {
        return (string() + " " + type + " " + num);
    }


    /**
     * 
     * @return the type of bird
     */
    public String getType() {
        return type;
    }


    /**
     * 
     * @return number of birds
     */
    public int getNumber() {
        return num;
    }

}
