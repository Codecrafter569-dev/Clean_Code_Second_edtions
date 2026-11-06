//LineCounterTest_1.java
import java.io.*;
public class LineCounterTest_1{
  private static int nLines;
  private static BufferedReader reader;
  
  private static void initialize(String fileName) throws IOException{
    nLines = 0;
    reader = new BufferedReader(new FileReader(fileName));
  }
  
  private static void countTheLines() throws IOException{
    while(reader.readLine() != null){
      nLines++;
    }
  }
  
  private static int finalizeCount() throws IOException{
    reader.close();
    return nLines;
  }
  public static int count(String fileName) throws IOException{
    initialize(fileName);
    countTheLines();
    return finalizeCount();
  }
  public static void main(String args[]) throws IOException{
    try(FileWriter fw = new FileWriter("sample.txt")){
      fw.write("Line1 \n Line2 \n Line3 \n Line4\n");
    }
    int lines = count("sample.txt");
    System.out.println("Total lines :"+lines);
  }
}