class Solution {
    public int numRabbits(int[] answers) {
       int freq[] = new int[1000];
       for(int i:answers)freq[i]++;

       int ans=freq[0];
       
       for(int i=1;i<1000;i++){
         int x = freq[i]/(i+1);
         ans+=x*(i+1);
         if(freq[i]%(i+1)!=0)ans+=i+1;
       }

       return ans;
    }
}
