class Point1{
	public int x;
	public int y;
}
public class Code_4{
	public static void main(String args[]){
		Point1 p1 = new Point1();
		p1.x = 300;
		p1.y = 200;

		System.out.println("This is a x :"+p1.x+" , Y:"+p1.y);
		p1.y += 200;
	    System.out.println("This is a x :"+p1.x+" , Y:"+p1.y);
	}
}
