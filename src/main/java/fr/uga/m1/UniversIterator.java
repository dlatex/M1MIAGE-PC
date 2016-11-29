package fr.uga.m1;

import java.util.Iterator;

public interface UniversIterator<T> extends Iterator<T> {
	public boolean hasNext();
	public T next();
}
