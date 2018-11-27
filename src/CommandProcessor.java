import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author cdc97 bob313
 * @version 9.5.18
 *          Processes command file and feeds instructions Hash and
 *          MemoryManager.
 * 
 */

public class CommandProcessor {
    private SkipList<String> skiplist;
    private BinTree bin;


    /**
     * 
     * Constructor for CommandProcessor. Takes inputs from main method and
     * processes the commands.
     * 
     * @param hashSize
     *            size of Hash received from main method
     * 
     * @param file
     *            the input file containing the commands to be read and
     *            processed
     * 
     */
    public CommandProcessor(String file) {
        Scanner scan = null;
        skiplist = new SkipList<String>();
        bin = new BinTree();
        try {
            scan = new Scanner(new File(file));
        }
        catch (FileNotFoundException e) {
            System.out.println("Command File Not Found");
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            processCommand(scan.nextLine());
        }
    }


    /**
     * 
     * Processes a given line of the command file for the command found in the
     * line
     * 
     * @param commandString
     *            the line of the command file being processed
     * 
     * @return true if proper command present false if not
     * 
     */
    private boolean processCommand(String commandString) {
        // Analyze the input string and figure out which command
        String[] inputs = commandString.trim().split("\\s+");
        if (inputs[0].equals("add")) {
            commandString = commandString.replaceFirst("add", "");
            if (!find(commandString)) {
                add(commandString);
            }
            else {
                System.out.println("Duplicate object names not permitted: |"
                    + inputs[2] + "|");
            }
            return true;
        }
        else if (inputs[0].equals("delete")) {
            if (find(commandString)) {
                delete(commandString);
                System.out.println("Deleted |" + inputs[1]
                    + "| from the database");
            }
            else {
                System.out.println("Object |" + inputs[1]
                    + "| not in the database");
            }
            return true;
        }
        else if (inputs[0].equals("print")) {
            print(commandString);
            return true;
        }
        else if (inputs[0].equals("rangeprint")) {
            rangeprint(commandString);
        }
        else if (inputs[0].equals("collisions")) {
            collisions(commandString);
        }
        else if (inputs[0].equals("intersect")) {
            intersect(commandString);
        }
        return false;
    }


    /**
     * Handles the find command
     * 
     * @param findCommand
     *            find command string
     * @return
     *         true if proper rating
     */
    private boolean find(String findCommand) {
        String[] inputs = findCommand.trim().split("\\s+");
        if (skiplist.find(inputs[1]) != null) {
            return true;
        }
        return false;
    }


    /**
     * Handles the add command
     * 
     * @param addCommand
     *            add command string
     * @return
     *         true if proper rating
     */
    private void add(String addCommand) {
        String[] inputs = addCommand.trim().split("\\s+");
        AirObject obj;
        if (inputs[0].equals("airplane")) {
            obj = new Airplane(inputs[0], inputs[1], inputs[2], inputs[3],
                inputs[4], inputs[5], inputs[6], inputs[7], inputs[8],
                inputs[9], inputs[10]);
        }
        else if (inputs[0].equals("balloon")) {
            obj = new Balloon(inputs[0], inputs[1], inputs[2], inputs[3],
                inputs[4], inputs[5], inputs[6], inputs[7], inputs[8],
                inputs[9]);
        }
        else if (inputs[0].equals("rocket")) {
            obj = new Rocket(inputs[0], inputs[1], inputs[2], inputs[3],
                inputs[4], inputs[5], inputs[6], inputs[7], inputs[8],
                inputs[9]);
        }
        else if (inputs[0].equals("drone")) {
            obj = new Drone(inputs[0], inputs[1], inputs[2], inputs[3],
                inputs[4], inputs[5], inputs[6], inputs[7], inputs[8],
                inputs[9]);
        }
        else {
            obj = new Bird(inputs[0], inputs[1], inputs[2], inputs[3],
                inputs[4], inputs[5], inputs[6], inputs[7], inputs[8],
                inputs[9]);
        }
        if (obj.getXwidth() < 0 || obj.getYwidth() < 0 || obj.getZwidth() < 0) {
            System.out.println("Bad box (" + inputs[2] + " " + inputs[3] + " "
                + inputs[4] + " " + inputs[5] + " " + inputs[6] + " "
                + inputs[7] + "). All widths must be positive.");
        }
        else if (obj.getXorig() >= 0 && obj.getXorig() + obj.getXwidth() <= 1024
            && obj.getYorig() >= 0 && obj.getYorig() + obj.getYwidth() <= 1024
            && obj.getZorig() >= 0 && obj.getZorig() + obj
                .getZwidth() <= 1024) {
            skiplist.insert(inputs[1], obj);
            bin.insert(obj);
            System.out.println(inputs[1] + " has been added to the database");
        }
        else {
            System.out.println("Bad box (" + inputs[2] + " " + inputs[3] + " "
                + inputs[4] + " " + inputs[5] + " " + inputs[6] + " "
                + inputs[7]
                + "). All boxes must be entirely within the world box.");
        }
    }


    /**
     * Handles the delete command
     * 
     * @param deleteCommand
     *            delete command string
     */
    private void delete(String deleteCommand) {
        String[] inputs = deleteCommand.trim().split("\\s+");
        skiplist.delete(inputs[1]);
    }


    /**
     * handles the print commands
     * 
     * @param printCommand
     *            print command string
     */
    private void print(String printCommand) {
        String[] inputs = printCommand.trim().split("\\s+");
        if (inputs[1].equals("skiplist")) {
            skiplist.print();
        }
        else if (inputs[1].equals("bintree")) {
            System.out.println("Bintree dump:");
            bin.print(bin.getRoot(), 0);
        }
        else if (inputs[1].equals("object")) {
            printCommand = printCommand.replaceFirst("object", "");
            if (!find(printCommand)) {
                System.out.println("|" + inputs[2]
                    + "| does not exist in the database");
            }
            else {
                System.out.println("Found: " + skiplist.find(inputs[2])
                    .toString());
            }
        }
    }


    /**
     * handles the rangeprint commands
     * 
     * @param rangeprintCommand
     *            rangeprint command string
     */
    private void rangeprint(String rangeprintCommand) {
        String[] inputs = rangeprintCommand.trim().split("\\s+");
        if (inputs[1].compareTo(inputs[2]) <= 0) {
            System.out.println("Found these records in the range |" + inputs[1]
                + "| to |" + inputs[2] + "|");
            skiplist.rangePrint(inputs[1], inputs[2]);
        }
        else {
            System.out.println("Error in rangeprint parameters: |" + inputs[1]
                + "| is not less than |" + inputs[2] + "|");
        }
    }


    /**
     * handles the collision commands
     * 
     * @param collisionCommand
     *            collision command string
     */
    private void collisions(String collisionCommand) {
        String[] inputs = collisionCommand.trim().split("\\s+");
        System.out.println("The following collisions exist in the database:");
    }


    /**
     * handles the intersect commands
     * 
     * @param intersectCommand
     *            intersect command string
     */
    private void intersect(String intersectCommand) {
        String[] inputs = intersectCommand.trim().split("\\s+");
        System.out.println("The following objects intersect (" + inputs[1] + " "
            + inputs[2] + " " + inputs[3] + " " + inputs[4] + " " + inputs[5]
            + " " + inputs[6] + "):");
    }


    /**
     * Formats input strings to remove excess spaces and command words (i.e.
     * update, add, delete)
     * 
     * @param nameString
     *            unformatted string
     * @return formatted string
     */
    private String formatString(String nameString) {
        StringBuilder newString = new StringBuilder();
        char[] chars = nameString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isWhitespace(chars[i])) {
                while (i < chars.length && !Character.isWhitespace(chars[i])) {
                    newString.append(chars[i]);
                    i++;
                }
                newString.append(" ");
            }
        }
        newString.deleteCharAt(newString.length() - 1);
        return newString.toString();
    }

}
