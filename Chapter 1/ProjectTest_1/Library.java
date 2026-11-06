import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library{
  private final List<Book> books = new ArrayList<>();
  
  public void addBook(String title){
    books.add(new Book(title));
  }
  
  public boolean borrowBooks(String title, Member member){
    Optional<Book> book = findAvailableBook(title);
    if(book.isEmpty()){
      System.out.println(title+" is not available.");
      return false;
    }
    book.get().marksAsBorrowed();
    System.out.println(member.getName()+" borrowed "+title);
    return true;
  }
  
  public boolean returnBook(String title){
    Optional<Book> book = findBorrowedBook(title);
    if(book.isEmpty()){
      System.out.println(title+" was not borrowed.");
      return false;
    }
    book.get().marksAsReturned();
    System.out.println(title+" was returned.");
    return true;
  }
  
  public void printCatlog(){
    for(Book book : books){
      System.out.println(book);
    }
  }
  private Optional<Book> findAvailableBook(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equals(title) && !b.isBorrowed())
                .findFirst();
    }

    private Optional<Book> findBorrowedBook(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equals(title) && b.isBorrowed())
                .findFirst();
    }
  
}