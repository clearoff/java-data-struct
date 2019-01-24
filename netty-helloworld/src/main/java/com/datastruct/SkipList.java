package com.datastruct;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * 1.每次插入数据的时候随机产生的level:决定了新节点的层数；
 * 2.数组update的作用：用以存储新节点所有层数上，各自的前一个节点的信息；
 * 3.节点内的forwards数组：用以存储该节点所有层的下一个节点的信息；
 * 4.当所有节点的最大层级变量maxlevel=1的时候，跳表退化成一个普通链表
 */
public class SkipList {

    private static final Integer MAX_LEVEL = 2;

    private int levelCount = 1;

    private Random random = new Random();

    private Node head = new Node(); //带头链表

    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (random.nextInt() % 2 == 1) {
                level++;
            }
        }

        return level;
    }

    public void insert(int value) {
        int level = randomLevel();  //产生一个随机的level决定当前node的最大层层数
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node update[] = new Node[level];

        // 创建从lowLevel到当前节点的maxLeve的所有节点
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        // record every level largest value which smaller than insert value in update[]
        // 插入上面创建的节点
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            // 按照Level查找插入
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            // 保存搜索路径上的最后一个节点
            update[i] = p;// use update save node in search path
        }

        // in search path node next node become new node forwords(next)
        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // 更新当前最大level
        if (levelCount < level) levelCount = level;
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    @Data
    private class Node {
        private int data;
        private int maxLevel = 0;
        private Node forwards[] = new Node[MAX_LEVEL];

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        for (int i = 0; i < 10; i++) {
            skipList.insert(i);
        }
        skipList.insert(11);
        skipList.printAll();
    }
}
