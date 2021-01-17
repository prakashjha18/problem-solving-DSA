/*
Create a Sim class with 5 attributes and also write getter ,setter 
methods.

Implement a method which takes array of sim objects as first parameter , string circle 
as a second parameter  and a double ratePerSecond as third parameter.

This method should return an array of the 
objects which containing second parameter and less than the third 
parameter and also the balance value of those objects must be in descending order.

In the main  method we have to display the id attribute values of the array 

​

input:

​

1
jio
430
1.32
mumbai
2
idea
320
2.26
mumbai
3
airtel
500
2.54
mumbai
4
vodafone
640
3.21
mumbai
mumbai
3.4



output:


4
3
1
2*/


import java.util.*;
public class simcardbyprice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sim[] sim = new Sim[4];
        for (int i = 0; i < sim.length; i++) {
            int simId = sc.nextInt();sc.nextLine();
            String name = sc.nextLine();
            double balance = sc.nextDouble();sc.nextLine();
            double ratePersecond = sc.nextDouble();sc.nextLine();
            String circle = sc.nextLine();
            sim[i] = new Sim(simId, name, balance, ratePersecond,circle);
        }
        String circle1 = sc.nextLine();
        double ratePerSecond1 = sc.nextDouble();
        Sim[] result = find(sim, circle1, ratePerSecond1);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getSimId());
        }
        sc.close();
    }
    public static Sim[] find(Sim[] sim, String circle1, double ratePerSecond1) {
        Sim[] temp;
        int j = 0;
        ArrayList<Sim> bs = new ArrayList<Sim>();
        for (int i = 0; i < sim.length; i++) {
            if (sim[i].getCircle().equals(circle1) &&
                sim[i].getRatePersecond() < ratePerSecond1) {
                j++;
            }
        }
        temp = new Sim[j];

        j=0;
        for (int i = 0; i < sim.length; i++) {
            if (sim[i].getCircle().equals(circle1) &&
                sim[i].getRatePersecond() < ratePerSecond1) {
                temp[j++] = sim[i];
                bs.add(sim[i]);
            }
        }
        Collections.sort(bs, new Comparator<Sim>() {
            public int compare(Sim idx1, Sim idx2) {
                return Double.compare(idx2.getBalance(), idx1.getBalance());
            }
        });
        for(int i=0;i<bs.size();i++){
            System.out.println(bs.get(i).getSimId());
        }
        Arrays.sort(temp, new Comparator<Sim>() {
            public int compare(Sim idx1, Sim idx2) {
                return Double.compare(idx2.getBalance(), idx1.getBalance());
            }
        });
        return temp;
    }
}
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
