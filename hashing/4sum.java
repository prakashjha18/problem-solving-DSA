class 4sum {
    static class pair 
    {  
        int first, second;  
        public pair(int first, int second)  
        {  
            this.first = first;  
            this.second = second;  
        }  
    } 
    public List<List<Integer>> fourSum(int[] arr, int X) {
        int n=arr.length;
        List<List<Integer>> fourSu = new ArrayList<>();
        HashMap<Integer,pair> mp = new HashMap<Integer,pair>(); 
        for (int i = 0; i < n - 1; i++) 
            for (int j = i + 1; j < n; j++){
                mp.put(arr[i] + arr[j], 
                        new pair(i, j)); 
                //System.out.print(arr[i]+""+arr[j]+"___");
            }
        int t=0;
        for (int i = 0; i < n - 1; i++) 
        { 
            for (int j = i + 1; j < n; j++) 
            { 
                int sum = arr[i] + arr[j]; 
             
                if (mp.containsKey(X - sum)) 
                {
                    pair p = mp.get(X - sum); 
                    
                    if (p.first != i && p.first != j && 
                        p.second != i && p.second != j) 
                    {  
                       
                        fourSu.add(new ArrayList<Integer>()); 
                        fourSu.get(t).add(arr[i]);
                        fourSu.get(t).add(arr[j]);
                        fourSu.get(t).add(arr[p.first]);
                        fourSu.get(t).add(arr[p.second]);
                        Collections.sort(fourSu.get(t));
                        t++;
                     
                    } 
                } 
            } 
        }
        // Set<ArrayList<Integer>> set = new LinkedHashSet<ArrayList<Integer>>();
        // set.addAll(fourSu);
        // fourSu.clear();
        // fourSu.addAll(set);
        return fourSu;
    }
}
