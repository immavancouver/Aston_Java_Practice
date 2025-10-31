package collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class ArrayList<T> {

	private static final int DEFAULT_CAPACITY = 10;

	private Object[] elements;
	private int size;

	public ArrayList() {
		this.elements = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	public int size() {
		return size;
	}

	public void ensureCapacity(int minCapacity) {
		if (minCapacity > elements.length) {
			grow(minCapacity);
		}
	}

	private void ensureCapacityInternal(int minCapacity) {
		if (minCapacity - elements.length > 0) {
			grow(minCapacity);
		}
	}

	private Object[] grow(int minCapacity) {
		int oldCapacity = elements.length;

		int newCapacity = oldCapacity + (oldCapacity >> 1);

		if (newCapacity < minCapacity) {
			newCapacity = minCapacity;
		}

		if (newCapacity < 0) {
			newCapacity = Integer.MAX_VALUE;
		}

		return elements = Arrays.copyOf(elements, newCapacity);
	}

	private Object[] grow() {
		return grow(elements.length + (elements.length >> 1));
	}

	public boolean add(T value) {
		ensureCapacityInternal(size + 1);
		elements[size++] = value;
		return true;
	}

	public void add(int index, T value) {
		rangeCheckForAdd(index);

		final int s;
		Object[] elements;

		if((s = size) == (elements = (this.elements)).length)
			elements = grow();
		System.arraycopy(elements, index,
				         elements, index + 1, s - index);

		elements[index] = value;
		size = s + 1;
	}

	private void rangeCheckForAdd(int index) {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}

	public T remove(int index) {
		Objects.checkIndex(index, size);
		@SuppressWarnings("unchecked")
		T old = (T) elements[index];

		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elements, index + 1, elements, index, numMoved);
		}

		elements[--size] = null;
		return old;
	}

	public boolean addAll(Collection<? extends T> c) {
		Object[] newArray = c.toArray();
		int numNew = newArray.length;
		if (numNew == 0)
			return false;
		Object[] elements;
		final int s;
		if (numNew > (elements = this.elements).length - (s = size))
			elements = grow(s + numNew);
		System.arraycopy(newArray, 0, elements, s, numNew);
		size = s + numNew;
		return true;
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		Objects.checkIndex(index, size);
		return (T) elements[index];
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(elements, size));
	}
}
