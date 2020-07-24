// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//         int []dx = new int[]{0,0,-1,1};
//         int []dy = new int[]{-1,1,0,0};
//         if (image[sr][sc] == newColor) return image;
//         int m = image.length, n = image[0].length;
//         Queue<int[]> q = new LinkedList<>();
//         int color = image[sr][sc];
//         image[sr][sc] = newColor;
//         q.add(new int[]{sr,sc});
//         while(!q.isEmpty()){
//                 int []cur = q.poll();
//                 for(int i=0;i<4;i++){
//                     int x = dx[i]+cur[0];
//                     int y = dy[i]+cur[1];
//                     //System.out.print(x+" "+y+"__");
//                     if(x>=0 && y>=0 && x<m&& y<n && image[x][y]==color){
//                         image[x][y]=newColor;
//                         q.add(new int[]{x,y});
                        
//                     }   
//             }
//         }
//         return image;
//     }
// }


//dfs
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}
