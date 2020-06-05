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
    
        hash_map.put("Geeks", 10); 
        hash_map.put("4", 15); 
        hash_map.put("Geeks", 20); 
        hash_map.put("Welcomes", 25); 
        hash_map.put("You", 30); 
        for(Map.Entry<String, Integer> entry : hash_map.entrySet()) {
            System.out.print(entry.getValue()+" ");
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
 
 ## 8) new way of adding a pair value
 ```
  Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(A[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
 int []cur = q.poll();
```

### 9) custom sort on inbuilt library
```
class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}
class CompareByFirstN implements Comparator<Pair>
{
  public int compare(Pair a, Pair b)
    {
        return a.y - b.y;
    }
}
Arrays.sort(arr, new CompareByFirstN());
```
## 9) custom sort of encapsulated method
```
class Dimension implements Comparable<Dimension> {
    int height;
    int length;
    int width;

    Dimension(int height, int length, int width) {
        this.height = height;
        this.length = length;
        this.width = width;
    }
     @Override
    public int compareTo(Dimension d) {
        if (this.length * this.width >= d.length * d.width) {
            return -1;
        } else {
            return 1;
        }
    }
}
Dimension[] allRotationInput = new Dimension[input.length * 3];
createAllRotation(input, allRotationInput);

//sort these boxes in non increasing order by their base area.(length X width)
Arrays.sort(allRotationInput);
refered from https://github.com/prakashjha18/Amazon-SDE/blob/master/dynamic%20programming/boxstacking.java
```
 
 
