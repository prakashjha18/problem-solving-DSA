# Amazon-SDE

## 1) store element in heap according to value of key from hashmap
PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));
