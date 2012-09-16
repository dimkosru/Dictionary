package ru.dimkos;

import java.util.ArrayList;
import ru.dimkos.Node;

public class MyDictionary<K, V> {

	Node<K, V> head = null;
	Node<K, V> tail = null;
	int size = 0;

	public V put(K key, V value) {
		V old = null;
		Node<K, V> node = new Node<>();
		node.key = key;
		node.value = value;

		if (head == null) {
			head = node;
			tail = node;
			size = 1;
		} else {
			Node<K, V> temp = search(key);
			if (temp != null) {
				old = temp.value;
				temp.value = value;
			} else {
				tail.next = node;
				tail = node;
				size++;
			}

		}
		return old;
	}

	public V get(K key) {
		Node<K, V> node = head;
		do {
			if (node.key.equals(key))
				return node.value;
			node = node.next;
		} while (node != null);
		return null;
	}

	public ArrayList<K> keys() {
		Node<K, V> node = head;
		ArrayList<K> key = new ArrayList<K>();
		while (node != null) {
			key.add(node.key);
			node = node.next;
		}
		return key;
	}

	public ArrayList<V> elements() {
		Node<K, V> node = head;
		ArrayList<V> element = new ArrayList<V>();
		while (node != null) {
			element.add(node.value);
			node = node.next;
		}
		return element;
	}

	public V remove(K key) {
		Node<K, V> node = head;
		Node<K, V> prev = head;

		do {
			if (node.key.equals(key)) {
				prev.next = node.next;
				size--;
				return node.value;
			}
			prev = node;
			node = node.next;
		} while (node != null);

		return null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void clear() {
		head = null;
		size = 0;
	}

	private Node<K, V> search(K key) {
		Node<K, V> node = head;
		if (head != null)
			do {
				if (node.key.equals(key))
					return node;
				node = node.next;
			} while (node != null);
		return null;
	}

}
