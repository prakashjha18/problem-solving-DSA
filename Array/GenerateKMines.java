// You are given a m*n grid. You are asked to generate k mines on this grid randomly.
// Each cell should have equal probability of k / m*n of being chosen.

import java.util.*;

public class GenerateKMines {

    public static void main(String[] args) {
        Random random = new Random();
        char grid[][]=new char[][]{{'-','-','-','-'},{'-','-','-','-'},{'-','-','-','-'}};
        new GenerateKMines().generateKMines(grid,3);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void generateKMines(char[][]grid, int K){
        int m = grid.length, n=grid[0].length;
        int count=0;
        Random random = new Random();
        while(count!=K){
            int index = random.nextInt(m*n);
            //System.out.println(index);
            int i = index%m, j=index%n;
            //System.out.println(i+"___"+j);
            if(grid[i][j]!='X'){
                grid[i][j]='X';
                count++;
            }

        }
    }
}
