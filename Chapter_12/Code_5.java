interface Point{
	double getX();
	double getY();
	void setCartesim(double x , double y);
	double getR();
	double getTheta();
	void setPoler(double r , double theta);
}

public class Code_5{
	public static void main(String args[]){
		
	}
}

class RectangularPoint implements Point{
	private double x , y;
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}

	public void setCartesim(double x , double y){
		this.x = x;
		this.y = y;
	}

	public double getR(){
		return Math.sqrt( x*x + y*y);
	}
	public double getTheta(){
		return Math.atan2(y,x);
	}
	public void setPoler(double r , double theta){
