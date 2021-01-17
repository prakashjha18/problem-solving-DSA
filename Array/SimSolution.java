/*
Create a Sim Class with following Attributes
int simId;
String customerName;
double balance;
double ratePerSecond; 
String circle;


create a public Class Solution in which take input of 5 object and then take 2 input (circle1, circle2) for circle 
of matches as circle1 and choose only those objects which are match with circle1.



Create a method named as transferCircle() and passed sim object and circle1, circle2 as parameter and 
arrange sim object in descending order as per ratePerSecond


Print the output as simId, customerName, circle, ratePerSecond.

​

Input:


1
raju
130
1.32
mum
2
sachin
120
2.26
ahd
3
ram
200
2.54
kol
4
shubham
640
3.21
ahd
5
kalpesh
150
1.8
ahd
ahd
kol


Output:


4 shubham kol 3.21
2 sachin kol 2.26
5 kalpesh kol 1.8

​*/

import java.util.*;
public class SimSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sim1[] sim = new Sim1[5];
        for (int i = 0; i < sim.length; i++) {
            int simId = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            double balance = sc.nextDouble();
            double ratePersecond = sc.nextDouble();
            sc.nextLine();
            String circle = sc.nextLine();
            sim[i] = new Sim1(simId, name, balance,
            ratePersecond, circle);
        }
        String circle1 = sc.nextLine();
        String circle2 = sc.nextLine();
        Sim1[] result = transferCircle(sim, circle1, circle2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getSimId()+" "+result[i].getName()+" "+result[i].getCircle()+" "+ result[i].getRatePersecond());
        }
        sc.close();
    }
    public static Sim1[] transferCircle(Sim1[] sim, String circle1, String circle2) {
        Sim1[] temp;
        int j = 0;
        for (int i = 0; i < sim.length; i++) {
            if (sim[i].getCircle().equals(circle1)) {
                j++;
            }
        }
        temp = new Sim1[j];
        j = 0;
        for (int i = 0; i < sim.length; i++) {
            if (sim[i].getCircle().equals(circle1)) {
                temp[j] = sim[i];
                temp[j++].setCircle(circle2);
            }
        }
        Arrays.sort(temp, new Comparator<Sim1>() {
            public int compare(Sim1 idx1, Sim1 idx2) {
                return Double.compare(idx2.getRatePersecond(), idx1.getRatePersecond());
            }
        });
        return temp;
    }
}
class Sim1 {
    private int simId;
    private String name;
    private double balance;
    private double ratePersecond;
    private String circle;
    public Sim1(int simId, String name, double balance, double ratePersecond, String circle) {
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
