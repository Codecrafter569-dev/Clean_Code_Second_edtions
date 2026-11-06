public class MainTestBook{
  public static void main(String[] args){
    Library library = new Library();
    Member codecrafter = new Member("CodeCrafter");
    
    
    library.addBook("Clean Code");
        library.addBook("The Pragmatic Programmer");

        System.out.println("--- Initial catalog ---");
        library.printCatlog();

        library.borrowBooks("Clean Code", codecrafter);
        library.borrowBooks("Clean Code", codecrafter); // clear reason printed: not available

        System.out.println("--- After borrowing ---");
        library.printCatlog();

        library.returnBook("Clean Code");

        System.out.println("--- After returning ---");
        library.printCatlog();
  }
}