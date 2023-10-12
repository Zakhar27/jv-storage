package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARR_SIZE = 10;
    private static final String ERROR_MESSAGE = "Can't store more than 10 elements";
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_ARR_SIZE];
        this.values = (V[]) new Object[MAX_ARR_SIZE];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (checkKeys(i, key)) {
                values[i] = value;
                return;
            }
        }
        if (size < MAX_ARR_SIZE) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            System.out.println(ERROR_MESSAGE);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (checkKeys(i, key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean checkKeys(int actualKey, K key) {
        if (keys[actualKey] == null) {
            return key == null;
        } else {
            return keys[actualKey].equals(key);
        }
    }
}


