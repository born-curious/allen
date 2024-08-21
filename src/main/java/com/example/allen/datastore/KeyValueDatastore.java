package com.example.allen.datastore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class KeyValueDatastore<K, V> {
    private final ConcurrentHashMap<K, V> datastore;

    public KeyValueDatastore() {
        datastore = new ConcurrentHashMap<>();
    }

    public void setData(K key, V value) {
        datastore.put(key, value);
    }

    public void removeData(K key) {
        datastore.remove(key);
    }

    public V setDataIfAbsent(K key, V value) {
        return datastore.putIfAbsent(key, value);
    }

    public V getData(K key) {
        return datastore.get(key);
    }

    public List<V> getList() {
        return new ArrayList<>(datastore.values());
    }
}

