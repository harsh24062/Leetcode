class Solution {
    public int bestClosingTime(String customers) {
        int count_y=0;
        for(char ch:customers.toCharArray()){
            if(ch=='Y')count_y++;
        }

        int curY=0;
        int curN=0;
        int ans=0;
        int score=Integer.MAX_VALUE;

        for(int i=0;i<customers.length();i++){
           
           if(curN+(count_y-curY)<score){
            ans=i;
            score = curN+(count_y-curY);
           }
           
            if(customers.charAt(i)=='Y')curY++;
            else curN++;

        }

        if(curN+(count_y-curY)<score){
            ans=customers.length();
        }
        return ans;
    }
}
