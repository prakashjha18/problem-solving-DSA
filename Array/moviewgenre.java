/*
Create a class Movie with Attributes :
movieName String
 Company String
 Genre String
 budget int

​

Create setters and getters and parametrized Constructor as required
Create another class Solution with a main method and scan attributes as above sequence
ex :
aaa
Marvel
Action
250000000
and scan a search attribute 


Create a Static method getMovieByGenre which will take object array and search string as parameters and returns 
movies which are matching with genre(Search) having budget less than 80000000 if movie budget is above 8cr print 
"High Budget Movie" ( Case Senstive Search) else " Low Budget Movie"



input :
aaa
Arka
Action
250000000
bbbb
GeethaArts
Comedy
25000000
ccc
Marvel
Art
2000000
ddd
Mythri
Action
300000000
Action



Output:
High Budget Movie
High Budget Movie 
*/

import java.util.Scanner;
class Movie {
    private String movieName;
    private String company;
    private String genre;
    private int budget;

    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) { 
        this.company = company;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getBudget() {
        return budget;
    }
    public void setBudget(int budget) {
        this.budget = budget;
    }
    Movie (String movieName, String company, String genre, int budget) {
        this.movieName = movieName;
        this.company = company;
        this.genre = genre;
        this.budget = budget;
    }
}
public class moviewgenre {
    public static void getMovieByGenre(Movie[] obj,String key) {
        for(int i =0;i<4;i++) {
            if(obj[i].getGenre().equals(key) && obj[i].getBudget() > 80000000){
                System.out.println("High Budget Movie");
            }
            else if(obj[i].getGenre().equalsIgnoreCase(key) && obj[i].getBudget() < 80000000) {
                System.out.println("Low Budget Movie");
            }
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Movie[] arr = new Movie[4];
        for(int i =0;i<4;i++) {
            String name=in.nextLine();
            String company=in.nextLine();
            String genre=in.nextLine();
            int budget=in.nextInt();
            in.nextLine();
            arr[i]=new Movie(name,company,genre,budget);

        } 
        String search =in.nextLine();
        getMovieByGenre(arr,search);
        in.close();

    }
 } 
