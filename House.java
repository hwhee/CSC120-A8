import java.util.ArrayList;

public class House extends Building{

  //attributes
  private ArrayList<Student> residents; //The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;


  /**
   * Constructor to create house, utilizing constructor from building class as well as initializing hasDining room and an empty array list of residents
   * @param name String name of the house, for building construction
   * @param address String address of the house, for building construction
   * @param nFloors Integer amount of floors in the house, for building construction
   * @param hasDiningRoom Boolean value indicating weather house has a dining room or not
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
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

  public static void main(String[] args) {
    House house = new House("Talbot", "25 Prospect Street", 4, false);
    System.out.println(house);
  }

}