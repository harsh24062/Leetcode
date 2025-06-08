class Solution {
    public List<Integer> lexicalOrder(int n) {
     List<Integer> list=new ArrayList<>();

     for(int i=1;i<=n;i++){
        list.add(i);
     }

     list.sort((a,b)->{
        String s1=a+"";
        String s2=b+"";

        int i=0,j=0;

        while(i<s1.length()&& j<s2.length()){
            if(s1.charAt(i)<s2.charAt(j))return -1;
            if(s1.charAt(i)>s2.charAt(j))return 1;
            i++;
            j++;
        }

        if(j!=s2.length())return -1;
        return 1;
     });

     return list;
    }
}




// 2nd approach using recursion


class Solution {

    private void solve(int curr, int n, List<Integer> result) {
        if (curr > n) {
            return;
        }
        
        result.add(curr);  // Add current number to result
        
        // Generate the next number by appending digits 0 to 9
        for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
            int nextNum = curr * 10 + nextDigit;
            
            if (nextNum > n) {
                return;
            }
            
            solve(nextNum, n, result);  // Recursive call
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        
        // Start from numbers 1 to 9
        for (int num = 1; num <= 9; num++) {
            solve(num, n, result);
        }
        
        return result;  // Return the result list
    }
}
