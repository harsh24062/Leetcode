class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long sum=0;
        long max=0,min=0;

        for(int i:differences){
            sum+=i;
            max=Math.max(max,sum);
            min=Math.min(min,sum);
        }
        long sequences = (upper-max)-(lower-min)+1;
        return (int)Math.max(0,sequences);
    }
}

// 1 -3 4
// toh yai goga hidden sequence
// a a+1 a-2 a+2

// max is a+2 and min is a-2

// a+2 <= upper
// a <= 4

// a-2 >= lower
// a >= 3

// a = [3,4]

// total a position is (4-3) + 1 = 2  its the answer
