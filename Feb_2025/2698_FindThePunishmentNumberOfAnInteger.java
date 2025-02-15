class Solution {

    boolean isPunish(int index, String s, int i, int sum){

        if(index==s.length()) return sum==i;

        for(int j=index;j<s.length();j++){
            int val=Integer.parseInt(s.substring(index,j+1));
            if(isPunish(j+1,s,i,sum+val))return true;
        }

        return false;
    }

    public int punishmentNumber(int n) {
        int ans=0;
        
        for(int i=1;i<=n;i++){
          String s=Integer.toString(i*i);
          if(isPunish(0,s,i,0))ans+=i*i;
        }

        return ans;
    }
}
