package project_3;

public class Edge {
	
	Vertex source;
	Vertex target;
	double wight;
	
	
	/**
	 * @param source
	 * @param target
	 * @param wight
	 */
	public Edge(Vertex source, Vertex target, double wight) {
		super();
		this.source = source;
		this.target = target;
		this.wight = wight;
	}
	/**
	 * @return the source
	 */
	public Vertex getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(Vertex source) {
		this.source = source;
	}
	/**
	 * @return the target
	 */
	public Vertex getTarget() {
		return target;
	}
	/**
	 * @param target the target to set
	 */
	public void setTarget(Vertex target) {
		this.target = target;
	}
	/**
	 * @return the wight
	 */
	public double getWight() {
		return wight;
	}
	/**
	 * @param wight the wight to set
	 */
	public void setWight(double wight) {
		this.wight = wight;
	}
	

}
