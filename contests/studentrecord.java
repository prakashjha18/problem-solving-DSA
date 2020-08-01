// Given N students with marks obtained by them in an exam. The task is to count the students 
// with same name and same marks.

// Input: First line of input contains number of testcases T. For each testcase, first line 
// of input contains N, number of students. Next N lines contains students name and his marks.

// Output: For each testcase, print students name, marks and count of same student with same
// name and marks, all seperated by space. The output is sorted in lexigraphically sorted order of names 
// and if two names are same then those are sorted in decreasing order of marks.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 104
// 1 <= marks <= 106

// Example:
// Input:
// 1
// 5
// john 50
// ankit 100
// ankit 100
// john 60
// ankit 30

// Output:
// ankit 100 2
// ankit 30 1
// john 60 1
// john 50 1

// Example:
// Testcase 1: 
// ankit with marks 100 occurs two times.
// ankit with marks 30 occurs one time.
// john with marks 60 occurs once.
// john with marks 50 occurs once.

import java.util.*;
import java.lang.*;
import java.io.*;

public class Student {
    String name;
    int marks;
    
    Student (String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    
    @Override
    public String toString() {
        return this.name + " " + this.marks;
    }
}

class MyComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if(s1.name.equals(s2.name)){
            return s2.marks - s1.marks;
        }
        return s1.name.compareTo(s2.name);
    }    
}

class GFG {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		while (T-->0) {
		    TreeMap<Student, Integer> map = new TreeMap<>(new MyComparator());

		    int N = Integer.parseInt(br.readLine().trim());
		    for (int i=0; i<N; i++) {
		        String line = br.readLine().trim();
		        String[] tokens = line.split("\\s+");
		        String name = tokens[0];
		        int marks = Integer.parseInt(tokens[1]);
		        
		        Student s = new Student(name, marks);
		        Integer counter = map.get(s);
		        if (counter == null) map.put(s, new Integer(1));
		        else map.put(s, new Integer(counter+1));
		    }
		    
		  //  System.out.println(map.entrySet());
		    for (Map.Entry<Student, Integer> entry: map.entrySet()) {
		        System.out.println(entry.getKey() + " " + entry.getValue());
		    }
		}
	}
}
