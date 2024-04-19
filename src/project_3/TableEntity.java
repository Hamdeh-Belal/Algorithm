package project_3;

import java.util.Objects;

public class TableEntity {
	private Vertex vertex;
	private boolean known;
	private Vertex privVertex;
	private double dist;
	/**
	 * @param vertex
	 * @param known
	 * @param privVertex
	 * @param dist
	 */
	public TableEntity(Vertex vertex, boolean known, Vertex privVertex, double dist) {
		super();
		setVertex(vertex);
		setKnown(known);
		setDist(dist);
		setPrivVertex(privVertex);
		
	}
	/**
	 * @return the vertex
	 */
	public Vertex getVertex() {
		return vertex;
	}
	/**
	 * @param vertex the vertex to set
	 */
	public void setVertex(Vertex vertex) {
		this.vertex = vertex;
	}
	/**
	 * @return the known
	 */
	public boolean isKnown() {
		return known;
	}
	/**
	 * @param known the known to set
	 */
	public void setKnown(boolean known) {
		this.known = known;
	}
	/**
	 * @return the privVertex
	 */
	public Vertex getPrivVertex() {
		return privVertex;
	}
	/**
	 * @param privVertex the privVertex to set
	 */
	public void setPrivVertex(Vertex privVertex) {
		this.privVertex = privVertex;
	}
	/**
	 * @return the dist
	 */
	public double getDist() {
		return dist;
	}
	/**
	 * @param dist the dist to set
	 */
	public void setDist(double dist) {
		this.dist = dist;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TableEntity))
			return false;
		TableEntity other = (TableEntity) obj;
		return vertex.equals(other.getVertex());
	}
	public String toString() {
		return vertex.toString();
	}
}
