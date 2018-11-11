// Sheba Sow
package People;

public  class Person extends Characters{

    private String firstName, type;
    private int xLoc, yLoc;
    public Person (String firstName, int xLoc, int yLoc, String type)
    {
        super(firstName, xLoc,yLoc, type);
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.firstName = firstName;
        this.type = type;
    }
    public String toString()
    {
        return "  |⎦˚~˚⎣|  ";
    }

}
