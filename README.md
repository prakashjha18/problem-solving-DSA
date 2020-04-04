# Amazon-SDE

## 1) store element in heap according to value of key from hashmap
PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));
  
## 2) to put elements in hashmap efficiently
for (int n: nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
}


## 3) to traverse a hashmap
for (int n: count.keySet()) {
      heap.add(n);
      if (heap.size() > k)
        heap.poll();
}
