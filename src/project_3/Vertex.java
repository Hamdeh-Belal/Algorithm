/**
 * 
 */
package project_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author Belal Hamdeh
 *
 */
public class Vertex {
	private String name;
	private boolean city_street;
	private double longitudeX;
	private double latitudeY;
	private double x;
	private double y;
	private LinkedList<Edge> edges;
	 double xMax=34.575060834817954;
	 double yMax=31.208163033163977;
	 double xMin=34.1707489947603;
	 double yMin=31.614521165206845;
	 double xwMax=592.0;
	 double ywMax=697.0;
	 double xwMin=0.0;
	 double ywMin=0.0;
	
	/**
	 * @param name
	 * @param city_street
	 * @param longitude
	 * @param latitude
	 */
	public Vertex(String name, boolean city_street, double longitudeX, double latitudeY) {
		edges=new LinkedList<>();
		setName(name);
		setCity_street(city_street);
		setLongitude(longitudeX);
		setLatitudeY(latitudeY);
		setX();
		setY();
		
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the city_street
	 */
	public boolean isCity_street() {
		return city_street;
	}
	/**
	 * @param city_street the city_street to set
	 */
	public void setCity_street(boolean city_street) {
		this.city_street = city_street;
	}
	/**
	 * @return the longitude
	 */
	public double getLongitudeX() {
		return longitudeX;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitudeX) {
		this.longitudeX = longitudeX;
	}
	/**
	 * @return the latitude
	 */
	public double getLatitudeY() {
		return latitudeY;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitudeY(double latitudeY) {
		this.latitudeY = latitudeY;
	}
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX() {
		
		this.x = (xwMax*(longitudeX-xMin))/(xMax-xMin);
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY() {
		this.y = (ywMax*(latitudeY-yMin))/(yMax-yMin);
	}
	public void addEdge (Vertex ve) {
		edges.add(new Edge(this, ve, findDistance(ve)));
	}
	private double findDistance(Vertex v) {
		double dis=Math.sqrt((Math.pow((x-v.getX()), 2))+(Math.pow((y-v.getY()), 2)));
		return dis;
//		return 0.0;
	}
	public LinkedList<Edge> getEdges() {
		return edges;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vertex))
			return false;
		Vertex other = (Vertex) obj;
		return name.equals(other.getName());
	}
	public String toString() {
		return name;
	}
	public String hasCityAdj() {
		String s ="";
		for(int i =0;i<edges.size();i++) {
			if(edges.get(i).target.city_street)
				s+=edges.get(i).target.getName();
				
		}
		return s;
	}
}
