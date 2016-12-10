package fr.uga.m1;


import java.util.List;

public class UniversIteratorImpl implements UniversIterator<Univers>{
	private List<Univers> univers;
	private int index;

	public UniversIteratorImpl(List<Univers> universListe) {
		index = 0;
		this.univers = universListe;
	}

	@Override
	public boolean hasNext() {
		return index < this.univers.size();

	}

	@Override
	public Univers next() {
		if (hasNext()) {
			Univers u = this.univers.get(index);
			index++;
			return u;
		}
		return null;
	}

}