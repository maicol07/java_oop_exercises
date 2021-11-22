package it.unibo.oop.lab06.generics1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class GraphImpl<N> implements Graph<N> {

	private Set<N> nodes = new TreeSet<N>();
	private Map<N, List<N>> links = new HashMap<N, List<N>>();
	
	public GraphImpl() {
	}

	@Override
	public void addNode(N node) {
		nodes.add(node);
	}

	@Override
	public void addEdge(N source, N target) {
		var edges = this.links.getOrDefault(source, new ArrayList<N>());
		edges.add(target);
		
		links.put(source, edges);
	}

	@Override
	public Set<N> nodeSet() {
		var set = new TreeSet<N>();
		set.addAll(nodes);
		return set;
	}

	@Override
	public Set<N> linkedNodes(N node) {
		var set = new HashSet<N>();
		set.addAll(this.links.get(node));
		return set;
	}

	@Override
	public List<N> getPath(N source, N target) {
		var path = new ArrayList<N>();
		path.add(source);
		
		// List of nodes already tried
		var alreadyTried = new ArrayList<N>();
		
		N current = source;
		while (!path.contains(target)) {
			for (N node : linkedNodes(current)) {
				if (node == target || linkedNodes(node).contains(target)) {
					path.add(node);
					current = node;
					break;
				}
			}
		}
		
		return path;
	}

}
