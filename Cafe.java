/* This is a stub for the Cafe class */


public class Cafe extends Building implements CafeRequirements{

    //attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor for Cafe utilizing the constructor from the building class and initializing amounts of all inventory items
     * @param name String name of cafe for building construction
     * @param address String address of cafe for building construction
     * @param nFloors Integer value of how many floors cafe has for building construction
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 1000;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 50;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * overloaded constructor with no input parameters
     */
    public Cafe(){
        super();
        this.nCoffeeOunces = 1000;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 50;
        System.out.println("You have built a cafe: ☕");
    }


    /**
     * overloaded constructor with only address as a required input parameter
     * @param address String containing address of cafe
     */
    public Cafe(String address){
        super(address);
        this.nCoffeeOunces = 1000;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 50;
        System.out.println("You have built a cafe: ☕");
    }
    
    //methods
    /**
     * Checks if there is sufficient inventory to fulfill order, and if not calls restock method. Subtracts items used in order from inventory.
     * @param size size in ounces of coffee order
     * @param nSugarPackets amount of sugar packets ordered
     * @param nCreams amount of creams ordered
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces<size||this.nSugarPackets<nSugarPackets||this.nCreams<nCreams||this.nCups<1){
            restock(1000, 100, 100, 50);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        
    }

    /**
     * overloaded sellCoffee method requiring only size as a parameter. Sets default for sugar packets and creams to zero.
     * @param size size in ounces of coffee order
     */
    public void sellCoffee(int size){
        if (this.nCoffeeOunces<size||this.nCups<1){
            restock(1000, 100, 100, 50);
        }
        this.nCoffeeOunces -= size;
        this.nCups -= 1;
    }


    /**
     * Sets the inventory levels to the requested levels when called
     * @param nCoffeeOunces amount of coffee to restock to
     * @param nSugarPackets amount of sugar packets to restock to
     * @param nCreams amount of creams to restock to
     * @param nCups amount of cups to restock to
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    //overriden Building methods

    /**
     * prints out all available methods in cafe
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit()\n + sellCoffee()");
    }

    /**
     * throws exception if goToFloor is called for cafe
     */
    public void goToFloor(int floorNum){
        throw new RuntimeException("You cannot move floors in the Cafe. Sorry :^(");
    }

    /**
     * toString to format cafe and its inventory for testing purposes
     */
    public String toString() {
        return super.toString() + "with an inventory containing " + nCoffeeOunces + " ounces of coffee, " + nSugarPackets + " packets of sugar, " + nCreams + " 'splashes' of cream, and " + nCups + " cups."; 
    }

    public static void main(String[] args) {
        Cafe cafe = new Cafe("Compass", "7 Neilson Drive", 2);
        System.out.println(cafe);
        cafe.sellCoffee(12, 2, 3);
        System.out.println(cafe);
        cafe.sellCoffee(12, 100, 3);
        System.out.println(cafe);
        cafe.sellCoffee(12, 2, 3);
        System.out.println(cafe);
        cafe.sellCoffee(12, 2, 3);
        System.out.println(cafe);
    }
    
}
