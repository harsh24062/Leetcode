// my first approach
class Solution {
    public long coloredCells(int n) {

      long colored_Cell=2*n-1;
      long cell=colored_Cell-2;
      
      while(cell>=1){
        colored_Cell+=2*cell;
        cell-=2;
      }

       return colored_Cell;  
    }
}


// end approach
class Solution {
    public long coloredCells(int n) {

      long colored_Cell=1;

      //logic
      // 1 + 4 + 8 + 12
      // 1 + 4(1+2+3+.....m)
      // 1 + 4(m(m+1)/2)
      // 1 + 2m(m+1)

      long m=n-1;
      colored_Cell+=2*m*(m+1);

      return colored_Cell;  
    }
}
