/*
Take a class name inventory and its 4 object into array and implement a method replenish where it will take array 
objects and a limit as a parameter and it will display the id along with fillings where filling if greater than 
75 it will be critical filling and if it is between 74 and 50 then moderate filling else non-critical filling

​

Input:
1
100
50
50
2
200
60
40
3
150
35
45
4
80
45
40
45
Output:
2 Non-Critical Filling
3 Non-Critical Filling
4 Non-Critical Filling
*/

import java.util.Scanner;
public class InventorySolution {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Inventory[] in = new Inventory[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < in.length; i++) {
            String a = sc.nextLine();
            int b = sc.nextInt();
            sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            int d = sc.nextInt();
            sc.nextLine();
            in[i] = new Inventory(a, b, c, d);
        }
        int limit = sc.nextInt();
        Inventory[] result = replenish(limit, in);
        for (int i = 0; i < result.length; i++) {
            if (result[i].getThreshold() >= 75) {
                System.out.println(result[i].getInventoryId() + "Critical Filling");
            }
            else if (result[i].getThreshold() >= 50 && result[i].getThreshold() <= 74) {
                System.out.println(result[i].getInventoryId() + "Moderate Filling");
            }
            else {
                System.out.println(result[i].getInventoryId() + "Non-Critical Filling");
            }
        }
        sc.close();
    }
    public static Inventory[] replenish(int limit, Inventory[] in) {
    // TODO Auto-generated method stub
        Inventory[] temp;
        int j = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i].getThreshold() <= limit) {
                j++;
            }
        }
        temp = new Inventory[j];
        j = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i].getThreshold() <= limit) {
                temp[j++] = in[i];
            }
        }
        return temp;
    }
}
class Inventory {
    String inventoryId;
    int maximumQuantity;
    int currentQuantity;
    int threshold;
    public Inventory(String inventoryId, int maximumQuantity, int currentQuantity, int threshold) {
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }
    public String getInventoryId() {
        return inventoryId;
    }
    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }
    public int getMaximumQuantity() {
        return maximumQuantity;
    }
    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }
    public int getCurrentQuantity() {
        return currentQuantity;
    }
    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }
    public int getThreshold() {
        return threshold;
    }
    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
