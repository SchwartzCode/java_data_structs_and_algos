package point2D;

import java.util.Random;

public class Point2D {
	private double x;
	private double y;
	
	public Point2D(double x_in, double y_in) {
			x = x_in;
			y = y_in;
		 }
		 public double x() {
			 return x;
		 }
		 public double y() {
			 return y;
		 }
		 public double distanceTo(Point2D that) {
			 double delt_x = x - that.x();
			 double delt_y = y - that.y();
			 
			 double dist = Math.sqrt(delt_x * delt_x + delt_y * delt_y);
			 
			 return dist;
		 }
		 public String toString(double input) {
			 String input_as_string = Double.toString(input);
			 return input_as_string;
		 }
		 public static void main(String[] args) {
		 int x0 = 1;
		 int y0 = 2;
		 Point2D p = new Point2D(x0, y0);
		 System.out.println(p);
		 
				int size=1000;
				Point2D[] pts = new Point2D[size];
				
				Random rand = new Random();
				
				for (int i=0; i<size; i++) {
					double x = rand.nextDouble();
					double y = rand.nextDouble();
					pts[i] = new Point2D(x, y);
				}
				
				double sum_dist = 0;
				for (int i=0; i<size; i++) {
					for (int j=i; j<size; j++) {
						Point2D p_i = pts[i];
						Point2D p_j = pts[j];
						double dist = p_i.distanceTo(p_j);
						sum_dist += dist;
					}
				}
				
				int norm = size * (size-1)/2;
				
				System.out.println(size + " " + sum_dist/norm);
				System.out.println(pts[0]);
						
			}
}
