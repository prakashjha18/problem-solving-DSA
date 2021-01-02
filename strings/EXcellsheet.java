// Given a positive integer, return its corresponding column title as appear in an Excel sheet.

// For example:

//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB 
//     ...
// Example 1:

// Input: 1
// Output: "A"
// Example 2:

// Input: 28  
// Output: "AB"
// Example 3:

// Input: 701
// Output: "ZY"


class EXcellsheet {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder(""); // use SB to reduce concatenation cost
        while(n>0){
            n--;         // values are from 0.. 25 so reduce by 1 to meet the criteria
            char letter = (char)('A'+ (n%26)); // get last digit, move  R-> L
            sb.append(letter);
            n=n/26;
        }
        return sb.reverse().toString(); // reverse to get output
    }
}
