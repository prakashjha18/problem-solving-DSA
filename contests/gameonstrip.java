
/*
Tzuyu gave Nayeon a strip of N cells (numbered 1 through N) for her birthday. This strip is 
described by a sequence A1,A2,…,AN, where for each valid i, the i-th cell is blocked if Ai=1 
or free if Ai=0. Tzuyu and Nayeon are going to use it to play a game with the following rules:

The players alternate turns; Nayeon plays first.
Initially, both players are outside of the strip. However, note that afterwards during the game, 
their positions are always different.
In each turn, the current player should choose a free cell and move there. Afterwards, this cell 
becomes blocked and the players cannot move to it again.
If it is the current player's first turn, she may move to any free cell.
Otherwise, she may only move to one of the left and right adjacent cells, i.e. from a cell c,
the current player may only move to the cell c−1 or c+1 (if it is free).
If a player is unable to move to a free cell during her turn, this player loses the game.
Nayeon and Tzuyu are very smart, so they both play optimally. Since it is Nayeon's birthday, 
she wants to know if she can beat Tzuyu. Find out who wins.

Input
The first line of the input contains a single integer T denoting the number of test cases.
The description of T test cases follows.
The first line of each test case contains a single integer N.
The second line contains N space-separated integers A1,A2,…,AN.
Output
For each test case, print a single line containing the string "Yes" if Nayeon wins the 
game or "No" if Tzuyu wins (without quotes).

Constraints
1≤T≤40,000
2≤N≤3⋅105
0≤Ai≤1 for each valid i
A1=AN=1
the sum of N over all test cases does not exceed 106
Subtasks
Subtask #1 (50 points): Ai=0 for each i (2≤i≤N−1)

Subtask #2 (50 points): original constraints

Example Input
4
7
1 1 0 0 0 1 1
8
1 0 1 1 1 0 0 1
4
1 1 0 1
4
1 1 1 1
Example Output
Yes
No
Yes
No
Explanation
Example case 1: Since both Nayeon and Tzuyu play optimally, Nayeon can start e.g. by 
moving to cell 4, which then becomes blocked. Tzuyu has to pick either the cell 3 or 
the cell 5, which also becomes blocked. Nayeon is then left with only one empty cell next 
to cell 4 (the one Tzuyu did not pick); after she moves there, Tzuyu is unable to move, 
so she loses the game.

Example case 2: Regardless of what cell Nayeon moves to at the start, Tzuyu will always 
be able to beat her.

*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class ARRGAME {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T>0) {
			int N = Integer.parseInt(br.readLine());
			String s[] = br.readLine().split(" ");
			int a[] = new int[N];
			int count = 0, max = 0;
			ArrayList<Integer> al = new ArrayList<Integer>();
			for(int i = 0;i<N;i++) {
				a[i] = Integer.parseInt(s[i]);
				if(a[i] == 0)
					count++;
				else {
					if(count!=0)
						al.add(count);
					count = 0;
				}
			}
			
			Collections.sort(al);
			Collections.reverse(al);
			System.out.println(al);
			if(al.size() == 0) {
				System.out.println("No");
			}
			else if(al.size()==1 && al.get(0)%2!=0) {
				System.out.println("Yes");
			}
			else if(al.size()>1&&al.get(0)>al.get(1)*2 && al.get(0)%2!=0) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
			T--;
		}
	}
}
