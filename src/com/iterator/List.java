package com.Iterator;

public interface List<E> {
	public int size();
	public void put(E o);
	public Iterator<E> iterator();
}
