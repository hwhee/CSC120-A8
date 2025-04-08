import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Talbot House", "25 Prospect Street", 4, false, false));//1
        myMap.addBuilding(new House("Gillett", "47 Elm Street", 5, true, true));//2
        myMap.addBuilding(new Building("44 College Lane"));//3
        myMap.addBuilding(new Building("Lyman Plant House and Conservatory", "16 College Lane"));//4
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive", 1));//5
        myMap.addBuilding(new Cafe());//6
        myMap.addBuilding(new Library("Neilson Library","7 Neilson Drive",5));//7
        myMap.addBuilding(new Library());//8
        myMap.addBuilding(new House());//9
        myMap.addBuilding(new House ("Parsons House", "24 Henshaw Avenue", 4));//10


        
        System.out.println(myMap);
    }
    
}
