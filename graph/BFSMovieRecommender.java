// You are given a list of movies, each with a unique title and a rating.
// You are also given a list of similarity relationships between pairs of movies.
// These relationships form an undirected graph, where nodes represent movies and edges represent similarity.

// Task

// Given:

// A starting movie title

// An integer N

// Return the top N movies that are most similar to the given movie, where similarity means:

// ✔ Movies reachable through similarity edges (BFS/DFS traversal)
// ✔ Sorted by rating, in descending order
// ✔ Do not include the starting movie itself
// ✔ If fewer than N similar movies exist, return all of them.
// Example 1

// You are given:

// Movies with ratings:
// Movie A → 6  
// Movie B → 7  
// Movie C → 8  
// Movie D → 9  
// Movie E → 5  
// Movie F → 9  
// Movie G → 4  
// Movie H → 10  
// Movie I → 3  
// Movie J → 8  
// Movie K → 9  
// Movie L → 6

// Similarity pairs (undirected):
// A - B  
// A - E  
// B - C  
// B - F  
// C - D  
// C - G  
// D - H  
// H - L  
// E - I  
// F - J  
// F - K

// Example Input:
// startMovie = "Movie A"
// N = 3

// Expected Output:
// ["Movie H", "Movie F", "Movie D"]


// Example 2
// You are given:

// Movies with ratings:
// Movie A → 6  
// Movie B → 7  
// Movie C → 8  
// Movie D → 9  


// Similarity pairs (undirected):
// A - B  
// B - A 
// B - C  
// C - B  

// Example Input:
// startMovie = "Movie A"
// N = 2

// Expected Output:
// ["Movie C", "Movie B"]

// (Because these have the highest ratings among all movies reachable from Movie A.)



import java.util.*;

public class BFSMovieRecommender {

    // Movie structure
    static class Movie {
        String title;
        int rating;
        Movie(String title, int rating) {
            this.title = title;
            this.rating = rating;
        }
    }

    public static List<String> getTopSimilarMovies(
            String startMovie, 
            int N, 
            Map<String, Movie> movieMap, 
            Map<String, List<String>> graph) {

        // BFS to find all connected similar movies
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startMovie);
        queue.add(startMovie);

        List<Movie> similarList = new ArrayList<>();

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            if (!graph.containsKey(curr)) continue;

            for (String next : graph.get(curr)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                    similarList.add(movieMap.get(next)); // store similar movie
                }
            }
        }

        // Sort by rating (descending)
        similarList.sort((a, b) -> b.rating - a.rating);

        // Limit to N results
        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(N, similarList.size()); i++) {
            result.add(similarList.get(i).title);
        }

        return result;
    }


    public static void main(String[] args) {

        // Movie ratings
        Map<String, Movie> movieMap = new HashMap<>();
        movieMap.put("Movie A", new Movie("Movie A", 6));
        movieMap.put("Movie B", new Movie("Movie B", 7));
        movieMap.put("Movie C", new Movie("Movie C", 8));
        movieMap.put("Movie D", new Movie("Movie D", 9));

        // Similarity graph
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("Movie A", Arrays.asList("Movie B"));
        graph.put("Movie B", Arrays.asList("Movie A", "Movie C"));
        graph.put("Movie C", Arrays.asList("Movie B"));

        // Example
        int N = 2;
        String movie = "Movie A";

        List<String> recommendations = getTopSimilarMovies(movie, N, movieMap, graph);

        System.out.println("N = " + N + ", movie = \"" + movie + "\" => " + recommendations);


         // Movie ratings
        movieMap = new HashMap<>();
        movieMap.put("Movie A", new Movie("Movie A", 6));
        movieMap.put("Movie B", new Movie("Movie B", 7));
        movieMap.put("Movie C", new Movie("Movie C", 8));
        movieMap.put("Movie D", new Movie("Movie D", 9));
        movieMap.put("Movie E", new Movie("Movie E", 5));
        movieMap.put("Movie F", new Movie("Movie F", 9));
        movieMap.put("Movie G", new Movie("Movie G", 4));
        movieMap.put("Movie H", new Movie("Movie H", 10));
        movieMap.put("Movie I", new Movie("Movie I", 3));
        movieMap.put("Movie J", new Movie("Movie J", 8));
        movieMap.put("Movie K", new Movie("Movie K", 9));
        movieMap.put("Movie L", new Movie("Movie L", 6));

        // Similarity graph (complex network)
        graph = new HashMap<>();

        graph.put("Movie A", Arrays.asList("Movie B", "Movie E"));
        graph.put("Movie B", Arrays.asList("Movie A", "Movie C", "Movie F"));
        graph.put("Movie C", Arrays.asList("Movie B", "Movie D", "Movie G"));
        graph.put("Movie D", Arrays.asList("Movie C", "Movie H"));
        graph.put("Movie E", Arrays.asList("Movie A", "Movie I"));
        graph.put("Movie F", Arrays.asList("Movie B", "Movie J", "Movie K"));
        graph.put("Movie G", Arrays.asList("Movie C"));
        graph.put("Movie H", Arrays.asList("Movie D", "Movie L"));
        graph.put("Movie I", Arrays.asList("Movie E"));
        graph.put("Movie J", Arrays.asList("Movie F"));
        graph.put("Movie K", Arrays.asList("Movie F"));
        graph.put("Movie L", Arrays.asList("Movie H"));

        // -------- TEST CASES --------
        System.out.println("\n===== TEST CASE 1 =====");
        System.out.println("Start = Movie A, N = 3");
        System.out.println(getTopSimilarMovies("Movie A", 3, movieMap, graph));

        System.out.println("\n===== TEST CASE 2 =====");
        System.out.println("Start = Movie C, N = 5");
        System.out.println(getTopSimilarMovies("Movie C", 5, movieMap, graph));

        System.out.println("\n===== TEST CASE 3 =====");
        System.out.println("Start = Movie F, N = 4");
        System.out.println(getTopSimilarMovies("Movie F", 4, movieMap, graph));

        System.out.println("\n===== TEST CASE 4 =====");
        System.out.println("Start = Movie H, N = 10");
        System.out.println(getTopSimilarMovies("Movie H", 10, movieMap, graph));

        System.out.println("\n===== TEST CASE 5 =====");
        System.out.println("Start = Movie E, N = 2");
        System.out.println(getTopSimilarMovies("Movie E", 2, movieMap, graph));
    }
}