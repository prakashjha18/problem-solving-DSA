class Solution {
    public int subarrayBitwiseORs(int[] A) {
        List <Integer> ans = new ArrayList<>();
        List <Integer> cur = new ArrayList<>();
        cur.add(A[0]);
        ans.add(A[0]);
        for (int i=1;i<A.length;i++) {
            List <Integer> cur2 = new ArrayList<>();
            for (int y: cur)
                cur2.add(A[i] | y);
            cur2.add(A[i]);
            
            cur = cur2;
            System.out.print(cur);
            
            ans.addAll(cur);
        }
        //System.out.print(ans);
        return ans.size();
    }
}
