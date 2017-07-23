package com.Iterator;

import java.util.NoSuchElementException;

/**
 * 所有代码基于源码
 * @author 竹
 *
 */
public class SimulateArrayList<E> implements List<E>  {
	private final static int DEFAULT = 8;
	private final static double LOAD_FACTOR=1.75;
	private Object [] object ;
	private int size ;
	public SimulateArrayList() {
		object = new Object[DEFAULT];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public void put(E o) {
		ensureCapacity();
		object[size] = o;
		System.out.print(object[size] + " : " + size+" ");
		size++;
	}

	private void ensureCapacity() {
		if(size >= object.length){
			Object[] newObject = new Object[(int) (object.length*LOAD_FACTOR)];
			System.arraycopy(object, 0, newObject, 0, object.length);
			object = newObject;
			newObject=null;
		}
	}

	public Iterator<E> iterator(){
		System.out.println("数组长度 " + size);
		return new Iter();
	}
	
	class Iter implements Iterator<E>{
		int index ;
		int cursor;
		@Override
		public boolean hasNext() {
			if(index < size) {	
				index++;
				return true;
			}
		
			return false;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
			cursor = index -1;
	            if (index > size)
	                throw new NoSuchElementException();
			return (E) object[cursor];
		}
		
	}
}
