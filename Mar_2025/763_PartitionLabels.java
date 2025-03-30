class Solution {
    public List<Integer> partitionLabels(String s) {

        int n=s.length();

        int index[]=new int[26];
        for(int i=0;i<n;i++){
            index[s.charAt(i)-'a']=i;
        }

        List<Integer> ans=new ArrayList<>();
        int left=0,right=0;

        while(right<n){
          int indx=index[s.charAt(right)-'a'];
          while(right<indx){
            indx=Math.max(indx,index[s.charAt(right)-'a']);
            right++;
          }
          ans.add(right-left+1);
          left=right+1;
          right++;
        }

        return ans;
    }
}

//approach
// 1. Find last index of each char in string s and store it into a array index 
