package point_dist;

import java.awt.geom.Point2D;
import java.util.Random;


public class Dist {
	public static void main(String[] args) {
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
			for (int j=0; j<size; j++) {
				Point2D p_i = pts[i];
				Point2D p_j = pts[j];
				double dist = p_i.distance(p_j);
				sum_dist += dist;
			}
		}
		
		
		
	}
}
