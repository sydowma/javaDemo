//package main.com.mark.collection;
//import java.util.*;
//
//public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
//    static final int SIZE = 997;
//
//    @SuppressWarnings("unchecked")
//    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];
//
//    @Override
//    public V put(K key, V value) {
//        V oldValue = null;
//        int index = Math.abs(key.hashCode()) % SIZE;
//        if (buckets[index] == null) {
//            buckets[index] = new LinkedList<MapEntry<K, V>>();
//        }
//        LinkedList<MapEntry<K, V>> bucket = buckets[index];
//        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
//        boolean found = false;
//        ListIterator<MapEntry<K, V>> it = bucket.ListIterator();
//        while(it.hasNext()) {
//            MapEntry<K, V> iPair = it.next();
//            if (iPair.getKey().equals(key)) {
//                oldValue = iPair.getValue();
//                it.set(pair);
//                found = true;
//                break;
//            }
//        }
//        if (!found) {
//            buckets[index].add(pair);
//        }
//
//        return oldValue;
//    }
//
//    public V get(Object key) {
//        int index = Math.abs(key.hashCode()) % SIZE;
//        if (buckets[index] == null) {
//            return null;
//        }
//    }
//
//    public Set<MapEntry<K, V>> entrySet() {
//        Set<MapEntry<K, V>> set = new HashSet<MapEntry<K, V>>();
//        for(LinkedList<MapEntry<K, V>> bucket : buckets) {
//            if (bucket == null) {
//                continue;
//            }
//            for (MapEntry<K, V> mpair : bucket) {
//                set.add(mpair);
//            }
//        }
//        return set;
//    }
//
//    public static void main(String[] args) {
//        SimpleHashMap<String, String> m = new SimpleHashMap<String, String>();
//
//    }
//
//    static class MapEntry<K, V> {
//        private K key;
//        private V value;
//
//        public static ListIterator ListIterator() {
//            return new ListIterator();
//        }
//
//        public MapEntry(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public K getKey() {
//            return key;
//        }
//
//        public void setKey(K key) {
//            this.key = key;
//        }
//
//        public V getValue() {
//            return value;
//        }
//
//        public void setValue(V value) {
//            this.value = value;
//        }
//    }
//}