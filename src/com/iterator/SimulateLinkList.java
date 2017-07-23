package com.Iterator;

public class SimulateLinkList<E> implements List<E>{
	private Node head;
	private Node tail;
	private int size;
//	private int index;
	 class Node{
		 E   data;
		 Node next;
		public Node(E data, SimulateLinkList<E>.Node next) {
			this.data = data;
			this.next = next;
		}
	}
	@Override
	public int size() {
		return size;
	}
	@Override
	public void put(E o) {
		Node node = new Node(o,null);
		if(head==null) {
			head = node;
			tail = node;
			size++;
		}else {
			tail.next = node;
			tail = node;
			size++;
		}
		
		System.out.print(size  + " ");
	}
	
	@Override
	public Iterator<E> iterator() {
		return new Iter();
	}
	
	class Iter implements Iterator<E>{
		private int counter;
		@Override
		public boolean hasNext() {
			if(counter<size) {
				counter++;
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			E e = head.data;
			head = head.next;
			return e;
		}
		
	}
}
