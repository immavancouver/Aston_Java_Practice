package collections;

import java.util.Objects;

@SuppressWarnings("unchecked")
public class HashSet<T> {

	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;

	private Node<T>[] buckets;
	private int size;

	public HashSet() {
		buckets = (Node<T>[]) new Node[DEFAULT_INITIAL_CAPACITY];
		size = 0;
	}

	private static final class Node<V> {

		private final V value;
		private Node<V> next;

		Node(V value, Node<V> next) {
			this.value = value;
			this.next = next;
		}
	}

	public boolean add(T value) {
		int index = indexFor(value, buckets.length);
		Node<T> current = buckets[index];

		while (current != null) {
			if (Objects.equals(current.value, value)) {
				return false;
			}
			current = current.next;
		}

		Node<T> newNode = new Node<>(value, buckets[index]);
		buckets[index] = newNode;
		size++;

		if (size > buckets.length * DEFAULT_LOAD_FACTOR) {
			resize();
		}

		return true;
	}

	public boolean remove(T value) {
		int index = indexFor(value, buckets.length);
		Node<T> current = buckets[index];
		Node<T> prev = null;

		while (current != null) {
			if (Objects.equals(current.value, value)) {
				if (prev == null) {
					buckets[index] = current.next;
				} else {
					prev.next = current.next;
				}
				size--;
				return true;
			}
			prev = current;
			current = current.next;
		}

		return false;
	}

	private int indexFor(T value, int length) {
		return (value == null ? 0 : Math.abs(value.hashCode())) % length;
	}

	public boolean contains(T value) {
		int index = indexFor(value, buckets.length);

		Node<T> current = buckets[index];

		while (current != null) {
			if (Objects.equals(current.value, value)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	private void resize() {
		int newCapacity = buckets.length * 2;
		Node<T>[] newTable = new Node[newCapacity];

		for (Node<T> head : buckets) {
			Node<T> current = head;
			while (current != null) {
				Node<T> next = current.next;
				int index = indexFor(current.value, newCapacity);
				current.next = newTable[index];
				newTable[index] = current;
				current = next;
			}
		}

		buckets = newTable;
	}

	public int size() {
		return size;
	}
}
