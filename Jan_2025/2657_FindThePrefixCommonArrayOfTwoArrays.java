// first approach 
// TC- O(N)
// SC- O(2N) exculding result array
// 61.72% faster

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n= A.length;
        int result[]= new int[n];

        if(A[0]==B[0])result[0]=1;

        Set<Integer> setA= new HashSet<>();
        Set<Integer> setB= new HashSet<>();
        setA.add(A[0]);
        setB.add(B[0]);

        for(int i=1;i<n;i++){
          setA.add(A[i]);
          setB.add(B[i]);

          if(A[i]==B[i]) result[i]++;
          else {
            if(setB.contains(A[i])) result[i]++;
             if(setA.contains(B[i])) result[i]++;
          }

          result[i]+=result[i-1];
        }

        return result;
    }
}

// secong approach 
// TC- O(N)
// SC- O(N) exculding result array
// 95.83% faster


class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n= A.length;
        int result[]= new int[n];

        if(A[0]==B[0])result[0]=1;

        int mark[]=new int[n+1];
        mark[A[0]]++;
        mark[B[0]]++;

        for(int i=1;i<n;i++){
        mark[A[i]]++;
        mark[B[i]]++;

          if(A[i]==B[i]) result[i]++;
          else {
            if(mark[A[i]]==2) result[i]++;
             if(mark[B[i]]==2) result[i]++;
          }

          result[i]+=result[i-1];
        }

        return result;
    }
}







