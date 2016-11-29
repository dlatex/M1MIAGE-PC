package fr.uga.m1;

import java.util.ArrayList;
import java.util.List;

public class UniversIteratorImpl implements UniversIterator<Univers>{
	private List<Univers> univers;
	private int index;

	public UniversIteratorImpl() {
		index = 0;
		univers = new ArrayList<Univers>();
	}

	@Override
	public boolean hasNext() {
		return index < univers.size();

	}

	@Override
	public Univers next() {
		index++;
		Univers univ = univers.get(index);
		return univ;
	}

}