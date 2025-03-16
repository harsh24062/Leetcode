class Solution {

    boolean isRepairPossible(int ranks[], int cars, long time){
        int cars_count=0;

        for(int i:ranks){
          cars_count+=(int)(Math.sqrt(time/i));
          if(cars_count>=cars)return true;
        }
        return false;
    }

    public long repairCars(int[] ranks, int cars) {
        
        //using binary search
        int max=Integer.MIN_VALUE;

        for(int i:ranks){
          max=Math.max(i,max);
        }

        long left=1;
        long right=max;
        right=right*cars;
        right=right*cars;

       while(left<=right){
        long mid=left+(right-left)/2;

        if(isRepairPossible(ranks,cars,mid))right=mid-1;
        else left=mid+1;
       }
      return left;
    }
}
