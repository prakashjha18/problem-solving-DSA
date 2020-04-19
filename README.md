# Amazon-SDE

## 1) store element in heap according to value of key from hashmap
```
 PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));
```
other eg of using priorityqueue
```
 PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
 PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
 PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b) -> (b[0] * b[0] + b[1] * b[1] -(a[0] *a [0] + a[1] *a [1])));
```
  
## 2) to put elements in hashmap efficiently
```
    HashMap<Integer, Integer> count = new HashMap();
    for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
    }
```

## 3) to traverse a hashmap
```
for (int n: count.keySet()) {
      heap.add(n);
      if (heap.size() > k)
        heap.poll();
    }
```
## 4) convert int into string 
```
 s += String.valueOf(arr[i][j])+" "; 
 ```
 
 ## 5) traverse a hashmap
 ```
  hm.forEach((k, v) -> System.out.println(k + " : " + (v + 10))); 
  ```
  
 ## 6) insert two elements as pair in hashmap
 ```
    static class pair 
    {  
        int first, second;  
        public pair(int first, int second)  
        {  
            this.first = first;  
            this.second = second;  
        }  
    } 
    HashMap<Integer,pair> mp = new HashMap<Integer,pair>(); 
    mp.put(arr[i] + arr[j], new pair(i, j)); 
    pair p = mp.get(X - sum); 
 ```
 
 ## 7) treeset java
 ```
 TreeSet<Integer> set = new TreeSet<Integer>();
 set.add(head1.data);
 set.pollFirst()
 ```
 some links
 https://www.callicoder.com/java-treeset/
 https://www.javapedia.net/Queue-and-its-implementations/2109
 
 
 
 
 
