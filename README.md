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
## 10) custom comparator for treemap
```
class MyComparator implements Comparator {

    Map map;
    
    public MyComparator(Map map) {
        this.map = map;
    }
    
    public int compare(Object o1, Object o2) {
        if((Integer)map.get(o2)==(Integer) map.get(o1)){
            return((Integer)o2-(Integer)o1);
        }
        return ((Integer) map.get(o2)-(Integer) map.get(o1));
    }
}
 MyComparator comp=new MyComparator(mp);

Map<Integer,Integer> newMap = new TreeMap<>(comp);
newMap.putAll(mp);
//https://github.com/prakashjha18/Amazon-SDE/blob/master/contests/gadgestofdoraland.java

```
## 11) A way of adding pairs 
```
List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
```

## 12) buffer reader to read array
```
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n= Integer.parseInt(br.readLine());
		    String str[] = br.readLine().split("\\s+");
		    int a[]=new int[n];
		    root=null;
		    c=1;
		    sum=0;
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(str[i]);
		        root= insert(root,a[i]);
		    }
  }
```
## 13) buffer reader for input type
```
1       --> no of testcase
7 2
8 4 10 15 14 88 64
15
88


BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int t = Integer.parseInt(br.readLine().trim());
while(t-->0){
    String line = br.readLine().trim();
    String[] tokens = line.split("\\s+");
    int n = Integer.parseInt(tokens[0]);
    int Q = Integer.parseInt(tokens[1]);
    int a[]=new int[n];
    line = br.readLine().trim();
    tokens = line.split("\\s+");
    root=null;
    for (int i=0; i<n; i++){ 
	a[i] = Integer.parseInt(tokens[i]);
	//root= insert(root,a[i]);
    }
    for(int i=0;i<Q;i++){
	int ele = Integer.parseInt(br.readLine().trim());
	//StringBuffer result = new StringBuffer();
	//print(root,ele,result);
	//if (result.length() == 0) result.append("Empty");
    	//System.out.println(result);
    }
}


```
## 14) custom sort for arraylist and array of objects
```
Sim[] temp;
temp = new Sim[j];
ArrayList<Sim> bs = new ArrayList<Sim>();
Collections.sort(bs, new Comparator<Sim>() {
    public int compare(Sim idx1, Sim idx2) {
	return Double.compare(idx2.getBalance(), idx1.getBalance());
    }
});
Arrays.sort(temp, new Comparator<Sim>() {
    public int compare(Sim idx1, Sim idx2) {
	return Double.compare(idx2.getBalance(), idx1.getBalance());
    }
});
class Sim {
    private int simId;
    private String name;
    private double balance;
    private double ratePersecond;
    private String circle;
    public Sim(int simId, String name, double balance, double ratePersecond, String circle) {
        this.simId = simId;
        this.name = name;
        this.balance = balance;
        this.ratePersecond = ratePersecond;
        this.circle = circle;
    }
    public int getSimId() {
        return simId;
    }
    public void setSimId(int simId) {
        this.simId = simId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getRatePersecond() {
        return ratePersecond;
    }
    public void setRatePersecond(double ratePersecond) {
        this.ratePersecond = ratePersecond;
    }
    public String getCircle() {
        return circle;
    }
    public void setCircle(String circle) {
        this.circle = circle;
    }
}
```


## 15) Sum of array
```
Array.stream(num).sum();
```

## 16) max from HashmapValues
```
int maxValues = Collections.max(hm.values());
```

## 17) Structure for many backtracking questions

This structure might apply to many other backtracking questions, but here I am just going to demonstrate Subsets, Permutations, and Combination Sum.

Subsets : https://leetcode.com/problems/subsets/

```
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}
```

Subsets II (contains duplicates) : https://leetcode.com/problems/subsets-ii/

```
public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
} 
```

Permutations : https://leetcode.com/problems/permutations/
```
public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   // Arrays.sort(nums); // not necessary
   backtrack(list, new ArrayList<>(), nums);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
   if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
   } else{
      for(int i = 0; i < nums.length; i++){ 
         if(tempList.contains(nums[i])) continue; // element already exists, skip
         tempList.add(nums[i]);
         backtrack(list, tempList, nums);
         tempList.remove(tempList.size() - 1);
      }
   }
} 
```

Permutations II (contains duplicates) : https://leetcode.com/problems/permutations-ii/
```
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
    if(tempList.size() == nums.length){
        list.add(new ArrayList<>(tempList));
    } else{
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
            used[i] = true; 
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false; 
            tempList.remove(tempList.size() - 1);
        }
    }
}
```

Combination Sum : https://leetcode.com/problems/combination-sum/
```
public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{ 
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }
    }
}
```

Combination Sum II (can't reuse same element) : https://leetcode.com/problems/combination-sum-ii/

```
public List<List<Integer>> combinationSum2(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
    
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i + 1);
            tempList.remove(tempList.size() - 1); 
        }
    }
} 
```

Palindrome Partitioning : https://leetcode.com/problems/palindrome-partitioning/

```
public List<List<String>> partition(String s) {
   List<List<String>> list = new ArrayList<>();
   backtrack(list, new ArrayList<>(), s, 0);
   return list;
}

public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
   if(start == s.length())
      list.add(new ArrayList<>(tempList));
   else{
      for(int i = start; i < s.length(); i++){
         if(isPalindrome(s, start, i)){
            tempList.add(s.substring(start, i + 1));
            backtrack(list, tempList, s, i + 1);
            tempList.remove(tempList.size() - 1);
         }
      }
   }
}

public boolean isPalindrome(String s, int low, int high){
   while(low < high)
      if(s.charAt(low++) != s.charAt(high--)) return false;
   return true;
} 
```