import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements{
  
  //attributes
  private Hashtable<String, Boolean> collection;

  /**
   * Library constructor utilizing constructor from building class and initializing empty hashtable of library's collection
   * @param name String name of the library, for building construction
   * @param address String address of the library, for building construction
   * @param nFloors Integer amount of floors in the library, for building construction
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Overloaded constructor with no input parameters.
   */
  public Library(){
    super();
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  //methods

  /**
   * Adds a title to hashtable of library's collection, automatically setting value to true to indicate it is available for checkout
   * @param title String containing title of book being added
   */
  public void addTitle(String title){
    this.collection.put(title, true);
  }

  /**
   * Removes a title from hashtable of library's collection, returning the title removed
   * @param title String containing title of book being removed
   */
  public String removeTitle(String title){
    this.collection.remove(title);
    return title;
  }

  /**
   * Changes the value connected to the title of the book being checked out to false
   * @param title String containing title of book being checked out
   */
  public void checkOut(String title){
    this.collection.replace(title, false);
  }

  /**
   * Overloaded checkOut method to check out two titles at once
   * @param titleA String containing the title of first book being checked out
   * @param titleB String containing the title of second book being checked out
   */
  public void checkOut(String titleA, String titleB){
    this.collection.replace(titleA, false);
    this.collection.replace(titleB, false);
  }

  /**
   * changes the value connected to the title of the book being returned to true
   * @param title String containing title of book being returned
   */
  public void returnBook(String title){
    this.collection.replace(title,true);
  }

  /**
   * Overloaded returnBook method to return two titles at once
   * @param titleA String containing the title of first book being returned
   * @param titleB String containing the title of second book being returned
   */
  public void returnBook(String titleA, String titleB){
    this.collection.replace(titleA,true);
    this.collection.replace(titleB,true);
  }

  /**
   * Checks if hashtable of library's collection contains a requested title
   * @param title String containing title being checked
   * @return boolean weather the requested title is in the collection or not
   */
  public boolean containsTitle(String title){
    if (this.collection.containsKey(title)){
      return true;
    } else{
      return false;
    }
  } 
  
  /**
   * Checks if a requested title is available based on its connected value in the hashtable
   * @param title String containing title being checked
   * @return boolean weather the requested title is availabe to be checked out or not
   */
  public boolean isAvailable(String title){
    if (this.collection.get(title)){
      return true;
    } else{
      return false;
    }
  } 
  
  /**
   * Prints "Collection: " then the library's collection by going through each entry in the hashtable and printing a formated version of its title and weather it is available for checkout
   */
  public void printCollection(){
    System.out.println("Collection:");
    this.collection.forEach(
      (k,v)-> System.out.println("Title: " + k + "; Available for checkout: " + v));
  } 

  //overriden Building methods

  /**
   * Overridden showOptions method that shows all available methods in library and parent class.
   */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + addTitle(t) \n + removeTitle(t) \n + checkOut(t) \n + returnBook(t)\n + containsTitle(t) \n + isAvailable(t)");
  } 
  
  /**
   * Overridden goToFloor method that doesn't actually override anything, it just calls the super method. The rubric asked for library to have this method so I put it here.
   */
  public void goToFloor(int floorNum){
    super.goToFloor(floorNum);
  }
  
  public static void main(String[] args) {
    Library library = new Library("Neilson", "7 Neilson Drive", 4);
    library.addTitle("The Lorax by Dr. Seuss");
    library.printCollection();
    library.addTitle("The Bell Jar by Sylvia Plath");
    library.checkOut("The Lorax by Dr. Seuss");
    library.printCollection();
    library.returnBook("The Lorax by Dr. Seuss");
    library.printCollection();
  }
  
}