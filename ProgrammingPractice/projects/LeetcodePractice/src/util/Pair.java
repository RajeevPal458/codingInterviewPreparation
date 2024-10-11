package util;

public class Pair implements Comparable<Pair> {
	int weight;
	int vertex;
	public Pair(int weight, int vertex) {
		super();
		this.weight = weight;
		this.vertex = vertex;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getVertex() {
		return vertex;
	}
	public void setVertex(int vertex) {
		this.vertex = vertex;
	}
	
	@Override
	public boolean equals(Object pair) {
		// TODO Auto-generated method stub
		if(pair instanceof Pair) {
			Pair p = (Pair)pair;
			return this.vertex==p.vertex;
		}
		return false;
	}
	
	@Override
	public int compareTo(Pair pair) {
		return Integer.compare(this.weight, pair.weight);
	}
	@Override
	public String toString() {
		return "Pair [weight=" + weight + ", vertex=" + vertex + "]";
	}
	
}
