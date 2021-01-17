/*
Write a class named as Main. Read the following parameters
- id (int)
- name (String)
- exp (int)
- matchesPlayed (int)
- runsScored (int)

​

Calculate the average of the players in that innings depends upon the target(int)
- if avgRuns >=80 and <=100, print Grade A
- if avgRuns >=50 and <=79, print Grade B
- else, print Grade C

​

Input:


100
Sachin
5
150
13000
101
Sehwag
4
120
10000
103
Dhoni
7
110
7000
104
Kohli
15
57
4400


100


Output:


Grade A
Grade A
Grade B 
*/



import java.util.Scanner;
public class cricketscore {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        Players []players=new Players[4];
        for(int i=0;i<players.length;i++){
            int playerid=sc.nextInt();sc.nextLine();
            String playername=sc.nextLine();
            int iccrank =sc.nextInt();sc.nextLine();
            int matchplayed=sc.nextInt();sc.nextLine();
            int runscored=sc.nextInt();sc.nextLine();
            players[i]=new
            Players(playerid,playername,iccrank,matchplayed,runscored);
        }
        int target=sc.nextInt();
        double avgrunrate[]=findavgofruns(players,target);
        for(int i=0;i<avgrunrate.length;i++){
            if(avgrunrate[i]>=80&& avgrunrate[i]<=100)
            System.out.println("Grade A");
            else if(avgrunrate[i]>=50&& avgrunrate[i]<=79)
            System.out.println("Grade B");
            else
            System.out.println("Grade C");
        }
    }
    public static double[] findavgofruns(Players[] ob, int target) {
        // TODO Auto-generated method stub
        double temp[];
        int j=0;
        for(int i=0;i<ob.length;i++){
            if(ob[i].getmatchplayed()>=target)
            j++;
        }
        temp=new double[j];
        j=0;
        for(int i=0;i<ob.length;i++){
            if(ob[i].getmatchplayed()>=target){
            temp[i]=(double)
            (ob[i].getrunscored()/ob[i].getmatchplayed());
            }
        }
        return temp;
    }
}
class Players{
    int id;
    String name;
    int iccrank;
    int matchplayed;
    int runscored;
    public Players(int id,String name,int iccrank,int matchplayed,int runscored){
        this.id=id;
        this.name=name;
        this.iccrank=iccrank;
        this.matchplayed=matchplayed;
        this.runscored=runscored;
    }
    public int getid(){
        return id;
    }
    public String getname(){
        return name;
    }
    public int geticcrank(){
        return iccrank;
    }
    public int getmatchplayed(){
        return matchplayed;
    }
    public int getrunscored(){
        return runscored;
    }
}
