// Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
// Output: [2,2,2,1,4,3,3,9,6,7,19]
class relativesorting {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        
        for (int num : arr1) map[num]++;
        
        int idx = 0;
        for (int num : arr2) {
            int freq = map[num];
            while (freq-- > 0) {
                arr1[idx++] = num;
            }
            map[num] = 0;
        }
        
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) continue;
            int freq = map[i];
            while (freq-- > 0) {
                arr1[idx++] = i;
            }
        }
        
        return arr1;
        
    }
}
