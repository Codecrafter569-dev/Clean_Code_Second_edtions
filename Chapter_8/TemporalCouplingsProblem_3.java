import java.io.*;
public class TemporalCouplingsProblem_3{
  static FileWriter file;
  
  static void openFile(String name) throws IOException{
    file = new FileWriter(name);
  }
  static void writeLine(String text) throws IOException{
    file.write(text+"\n");
  }
  static void closeFile() throws IOException{
    file.close();
  }
  
  public static void main(String[] args) throws IOException{
    openFile("text.txt");
    writeLine("Hello clean code i am a vikash kumar.");
    closeFile();
  }
}