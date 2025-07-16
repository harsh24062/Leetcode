class Solution {
    public int maximumLength(int[] nums) {
        int odd=0;
        int even=0;
        int oe=0;
        boolean foe=false; //false for odd, true for even
        int eo=0;
         boolean feo=true;
        for(int i:nums){
            if(i%2==0){
             even++;
             if(foe){
                foe=false;
                oe++;
             }
             if(feo){
                feo=false;
                eo++;
             }
            }
            else {
             odd++;
               if(!foe){
                foe=true;
                oe++;
             }
             if(!feo){
                feo=true;
                eo++;
             }
            }
        }

        
        int max1=Math.max(odd,even);
        int max2=Math.max(oe,eo);
        return Math.max(max1,max2);      
    }
}
