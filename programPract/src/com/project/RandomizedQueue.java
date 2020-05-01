package com.project;

import java.util.Iterator;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] s;
    private int last;
    private int first;

    // construct an empty randomized queue
    public RandomizedQueue() {
        s = (Item[]) new Object[1];
        first = 0;
        last = 0;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = first; i < last; i++) {
            copy[i - first] = s[i];
        }
        int length = last - first;
        s = copy;
        first = 0;
        last = length;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return (first == last);
    }

    // return the number of items on the randomized queue
    public int size() {
        return (last - first);
    }

    // add the item
    public void enqueue(Item item) {
        if (size() == s.length) {
            resize(s.length * 2);
        }
        s[last++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
    	Random r = new Random();
        int num = r.nextInt(last-first)+first;
        Item hold = s[num];
        for (int j = num; j < last - 1; j++) {
            s[j] = s[j + 1];
        }
        last = last - 1;
        int N = last - first;
        if (N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }
        return hold;
    }

    // return a random item (but do not remove it)
    public Item sample() {
    	Random r = new Random();
        return s[r.nextInt(last-first)+first];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private int i = first;

        public boolean hasNext() {
            return last != i;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (size() < 1) {
                throw new java.util.NoSuchElementException("size = 1: no next object");
            }
            return s[i++];
        }
    }

}
