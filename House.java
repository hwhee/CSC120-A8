import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  //attributes
  private ArrayList<Student> residents; //The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;


  /**
   * Constructor to create house, utilizing constructor from building class as well as initializing hasDining room and an empty array list of residents
   * @param name String name of the house, for building construction
   * @param address String address of the house, for building construction
   * @param nFloors Integer amount of floors in the house, for building construction
   * @param hasDiningRoom Boolean value indicating weather house has a dining room or not
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * overloaded constructor with no input parameters
   */
  public House(){
    super();
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = false;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * overloaded constructor with only the input parameters for building. Sets default for hasDiningRoom and hasElevator to false.
   * @param name String name of the house, for building construction
   * @param address String address of the house, for building construction
   * @param nFloors Integer amount of floors in the house, for building construction
   */
  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = false;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
  }


  //accessors

  /**
   * Accessor for boolean value indicating weather house has a dining room or not
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Accessor to get the amount of residents in the house
   */
  public int nResidents(){
    return this.residents.size();
  }


  //methods

  /**
   * Adds student to the array list of residents
   */
  public void moveIn(Student s){
    this.residents.add(s);
  }

  /**
   * Overloaded moveIn method, moves in two students at once
   * @param a student a
   * @param b student b
   */
  public void moveIn(Student a, Student b){
    this.residents.add(a);
    this.residents.add(b);
  }

  /**
   * Removes students from the array list of residents and returns the student removed
   * @return s String name of student being removed
   */
  public Student moveOut(Student s){
    this.residents.remove(s);
    return(s);
  }

  /**
   * Looks through residents array list to see if it contains requested student's name
   * @return boolean indicating weather requested student is a resident or not
   */
  public boolean isResident(Student s){
    if (this.residents.contains(s)){
      return true;
    } else{
      return false;
    }
  }

  // overridden Building methods

  /**
   * Overridden showOptions method from building class, shows all available methods based on whether house has an elevator or not.
   */
  public void showOptions() {
    if (this.hasElevator){
      super.showOptions();
      System.out.println(" + hasDiningRoom() \n + nResidents() \n + moveIn(s) \n + moveOut(s) \n + isResident()");
    } else {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown() \n + hasDiningRoom() \\n" + //
                " + nResidents() \\n" + //
                " + moveIn(s) \\n" + //
                " + moveOut(s) \\n" + //
                " + isResident()");
    }
  }

  /**
   * Overridden goToFloor method from building class, calling super's method if the house has an elevator and throwing an exception if not.
   */
  public void goToFloor(int floorNum){
    if (this.hasElevator){
      super.goToFloor(floorNum);
    } else{  
      throw new RuntimeException("This house has no elevator, try goUp() or goDown().");
    }
}

  public static void main(String[] args) {
    House house = new House("Talbot", "25 Prospect Street", 4, false,false);
    System.out.println(house);
  }

}