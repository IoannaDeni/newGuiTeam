package GeometryPack;

import java.awt.Graphics;
import java.awt.Point;

public class GeometryPack {

	/**
	 * The function takes a point with Cartesian coordinates and transforms them into the
	 *  screen
	 * @param thisHeight - height of the current window
	 * @param currentCoord - the coordinates of a point in cartesian coordinates
	 * @return the screen coordinates of a point
	 * @author Mashka 
	 */
	public Point coorScreen(int thisHeight, Point currentCoord)
	{
		Point newCoord = currentCoord;
		newCoord.setLocation(currentCoord.getX(), thisHeight - currentCoord.getY());
		return newCoord;
	}

	/**
	 * The function takes a point with screen coordinates and transforms them into the
	 *  cartesian
	 * @param thisHeight - height of the current window
	 * @param currentCoord - the coordinates of a point in screen coordinates
	 * @return the cartesian coordinates of a point
	 * @author Mashka 
	 */
	public Point coorCartesian(int thisHeight, Point currentCoord)
	{
		Point newCoord = currentCoord;
		newCoord.setLocation(currentCoord.getX(), thisHeight - currentCoord.getY());
		return newCoord;
	}

	/**
	 * Calculates angle a of a triangle
	 * @param height - height of the triangle
	 * @param hypotenuse - side adjacent to the angle
	 * @return angle in radians 
	 * @author Mashka 
	 */
	public double angleTriangle(double height, double hypotenuse)
	{
		return Math.asin(Math.abs(height/hypotenuse));
	}


	/**
	 * Calculates height of the triangle
	 * @param a coordinates of point a
	 * @param b coordinates of point b
	 * @param c coordinates of point c
	 * @return height of the triangle 
	 * @author Mashka 
	 */
	public double heightTriangle(Point a, Point b, Point c) {

		// calculates length of sides
		int base = lineLength(a,c);
		int sideL = lineLength(a,b);
		int sideR= lineLength(c,b);
		// calculates half perimeter
		double p = (base+sideL+sideR)/2;
		while(p==base||p==sideL||p==sideR)
			p=p+0.005;

		double height = ((2*Math.sqrt(p*(p-base)*(p-sideR)* (p-sideL)))/base);
		// returns height of the triangle from annex b
		if(b.getY()<=a.getY())
			return height;
		else
			if(b.getY()>a.getY())
				return -height;
		return height;
	}



		/**
		 * Calculates line length from point a to point b
		 * @param a coordinates of point a
		 * @param b coordinates of point b
		 * @return length of line
		 * @author Mashka 
		 */
		public int lineLength( Point a, Point b)
		{
			//Uses Pythagorean theorem to find the line length
			return (int)Math.sqrt( (int) (Math.pow((a.getX()-b.getX()), 2) + Math.pow(a.getY()-b.getY(), 2)));
		}

		/**
		 * Finds the end coordinates of a line
		 * of a given length drawn at a given angle
		 * from a point
		 * @param a the start point for the line
		 * @param length the length of a line 
		 * @param angle - the angle between the line and X axis
		 * @return Point that contains the end coordinates of the line
		 */
		public Point lineAtAngle(Point a, int length, double angle)
		{

			double endX;
			double endY;

			//finds the length of the cathesuses
			double base = (int) (Math.cos(angle)*length);
			double height = (int) (Math.sin(angle)*length);

			if( angle>0)
			{
				endX = (int) (a.getX() - base);
				endY = (int) (a.getY() + height);
			}
			else
			{
				endX =  (a.getX() - base);
				endY = (a.getY() + height);
			}
			return new Point((int)endX,(int)endY);
		}

		/**
		 * Calculates coordinates d
		 * @param a coordinates of point a
		 * @param b coordinates of point b
		 * @param c coordinates of point c
		 * @return coordinates of point d
		 * @author Mashka 
		 */
		public Point pGram(Point a, Point b, Point c){
			double alpha = angleToX(a,b);
			return lineAtAngle(c,lineLength(a,b), Math.PI+alpha);
		}

		/**
		 * Finds an angle between X axis and a line
		 * @param a Point start point of the line
		 * @param b Point end point of the line
		 * @return the angle between X axis and a line
		 * @author Mashka 
		 */
		public double angleToX(Point a, Point b)
		{
			double dX = b.getX() - a.getX();
			double dY = b.getY() - a.getY();
			double tan = dY/dX;
			double angle = Math.atan(tan);

			if(dY<0&&dX<0)
				return -angle;
			if(dX<0)
				return -angle;
			if(dX>0&&dY>0)
				return Math.PI - angle;
			return  Math.PI -angle;
		}

	}
