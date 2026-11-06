class StudentRow{
public String name;
public int marks;
}

class GradeCalculator{
public static char  grade(StudentRow r){
if(r.marks >= 80) return 'A';
if(r.marks >= 60) return 'B';
return 'C';
}
}

public class Code_3{
public static void main(String[] args){
 StudentRow r = new StudentRow();
 r.name = "Vikash kumar";
 r.marks = 82;
 System.out.println("This is my Marks :"+GradeCalculator.grade(r) );
}
}
