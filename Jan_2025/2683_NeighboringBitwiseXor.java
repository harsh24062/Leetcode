class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        
        int xor=0;

        for(int i: derived){
          xor^=i;
        }

        return (xor==0);
    }
}

// derived- [a,b,c]
// original-[x,y,z]

// x^y=a
// y^z=b
// z^x=c

// x^y^y^z^z^x = a^b^c
// a^b^c = 0


