
// greedy

class Solution {
    public int countOperations(int num1, int num2) {
        int count=0;
        
        while(num1!=0 && num2!=0){
            int max = Math.max(num1,num2);
            int min = Math.min(num1,num2);

            count+=max/min;
            max=max%min;
            num1=max;
            num2=min;
        }

        return count;
    }
}



// recursion

class Solution {
    
    int recur(int num1, int num2){
        if(num1==0 || num2==0)return 0;
        if(num2>num1) return 1+recur(num2-num1,num1);
        else return 1+recur(num1-num2,num2);
    }

    public int countOperations(int num1, int num2) {
       return recur(num1,num2);   
    }
}
