package com.datastruct;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private static final int MAX_NODE_NUM = 2 << 4;

    private int limit;

    public LRUCache() {
        this(MAX_NODE_NUM);
    }

    public LRUCache(int limit) {
        /**
         * accessOrder用来指定双向链表是否在元素被访问后改变其在双向链表中的位置
         * 当 Map 中的节点个数超过我们预定的阈值时候在 putValue 将会执行 afterNodeInsertion 删除最近没有访问的元素。
         */
        super(limit, 0.75f, true);
        this.limit = limit;
    }

    public V putValue(K key, V val) {
        return put(key, val);
    }

    public V getValue(K key) {
        return get(key);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<>(3);

        lruCache.putValue("老大", 1);
        lruCache.putValue("老二", 2);
        lruCache.putValue("老三", 3);

        System.out.println(lruCache.getValue("老大"));
        //超过指定 阈值 3 再次添加元素的 将会删除最近最少访问的节点
        lruCache.putValue("老四", 4);
        System.out.println("lruCache = " + lruCache);

    }
}
