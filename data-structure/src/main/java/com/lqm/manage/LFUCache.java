package com.lqm.manage;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class LFUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final Map<K, Integer> frequencies;
    private final Map<Integer, Set<K>> frequencyLists;
    private int minFrequency;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.frequencies = new HashMap<>();
        this.frequencyLists = new HashMap<>();
        this.minFrequency = 0;
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        int frequency = frequencies.get(key);
        frequencies.put(key, frequency + 1);
        frequencyLists.get(frequency).remove(key);

        if (frequency == minFrequency && frequencyLists.get(frequency).isEmpty()) {
            minFrequency++;
        }

        if (!frequencyLists.containsKey(frequency + 1)) {
            frequencyLists.put(frequency + 1, new LinkedHashSet<>());
        }
        frequencyLists.get(frequency + 1).add(key);

        return cache.get(key);
    }

    public void put(K key, V value) {
        if (capacity <= 0) {
            return;
        }

        if (cache.containsKey(key)) {
            cache.put(key, value);
            get(key); // Increase frequency
            return;
        }

        if (cache.size() >= capacity) {
            K evictKey = frequencyLists.get(minFrequency).iterator().next();
            frequencyLists.get(minFrequency).remove(evictKey);
            cache.remove(evictKey);
            frequencies.remove(evictKey);
        }

        cache.put(key, value);
        frequencies.put(key, 1);
        minFrequency = 1;
        frequencyLists.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
    }

    public int size() {
        return cache.size();
    }


    public static void main(String[] args) {
        LFUCache<String, String> cache = new LFUCache<>(5);

        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        System.out.println(cache.get("1"));
        cache.put("4", "3");
        cache.put("5", "3");
        cache.put("6", "3");
        cache.put("7", "3");

    }
}
