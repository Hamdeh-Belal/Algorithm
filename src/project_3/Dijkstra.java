package project_3;

import java.util.ArrayList;
import java.util.LinkedList;

public class Dijkstra {
	private TableEntity[] table;
	private Vertex source;
	private Vertex target;
	private ArrayList<Vertex> listC;
	double dis = 0.0;

	/**
	 * 
	 */
	public Dijkstra(Vertex source, Vertex target, ArrayList<Vertex> listC) {
		this.source = source;
		this.target = target;
		this.listC = listC;
		table = new TableEntity[listC.size()];
		intilTable();
		findShortestPath(table);
	}

	private void findShortestPath(TableEntity[] table) {

		TableEntity v = null;
		while (true) {
			v = findMinVertex();
			if (v == null) {
				break;
			}
//				System.out.println(v);
			int n = getIndex(v);
//			table[n].setKnown(true);
			v.setKnown(true);
			LinkedList<Edge> edges = v.getVertex().getEdges();
			for (int i = 0; i < edges.size(); i++) {

				Vertex targetE = edges.get(i).getTarget();
				int e = getIndex(targetE);
				TableEntity w = null;
				w = table[e];
				if (e != -1 && (!w.isKnown())) {
					if ((v.getDist() + edges.get(i).wight) < w.getDist()) {
						w.setDist((v.getDist() + edges.get(i).wight));
						w.setPrivVertex(v.getVertex());
//						
						if (table[e].getVertex().equals(target)) {
							break;
//
						}

					}

				}

			}
		}
	}

	private TableEntity findMinVertex() {
		TableEntity v = null;
		double n = Double.MAX_VALUE;
		for (int i = 0; i < table.length; i++) {
			if ((!table[i].isKnown()) && table[i].getDist() < n) {
				n = table[i].getDist();
				v = table[i];
			}
		}
		return v;

	}

	private void intilTable() {
		int s = listC.indexOf(source);
		for (int i = 0; i < table.length; i++) {
			table[i] = new TableEntity(null, false, null, Integer.MAX_VALUE);

		}
		for (int i = 0; i < listC.size(); i++) {
			table[i].setVertex(listC.get(i));
			if (listC.get(i).equals(source))
				s = i;
		}
		table[s].setDist(0.0);
	}

	private int getIndex(TableEntity e) {
		for (int i = 0; i < table.length; i++) {
			if (table[i].equals(e))
				return i;
		}
		return -1;
	}

	private int getIndex(Vertex e) {
		for (int i = 0; i < table.length; i++) {
			if (table[i].getVertex().equals(e))
				return i;
		}
		return -1;
	}

	public LinkedList<Vertex> getPath() {

		LinkedList<Vertex> linklist = new LinkedList<>();

		linklist.add(target);
		int n = getIndex(target);
		dis += table[n].getDist();
		while (true) {
			n = getIndex(table[n].getPrivVertex());

			if (n == -1) {
				break;
			}

			if (table[n].getVertex().equals(source)) {
				dis += table[n].getDist();
				linklist.add(source);
				break;
			}
			linklist.add(table[n].getVertex());
			dis += table[n].getDist();
		}
		return linklist;
	}

	public double getDis() {
		return dis;
	}
}
