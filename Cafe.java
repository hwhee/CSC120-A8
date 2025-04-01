/* This is a stub for the Cafe class */
public class Cafe extends Building{

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
