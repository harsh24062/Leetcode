// approach --https://www.youtube.com/watch?v=DNbvaC-EqyQ&t=1079s
class Solution {

    long func(String num, int limit, String s){
        int remaining = num.length() - s.length();
        if(remaining<0 )return 0;
       
            long ans=0;
           for(int i=0;i<remaining;i++){
             long digit=num.charAt(i)-'0';
             if(digit<=limit)
             ans+=digit*Math.pow(limit+1,remaining-i-1);
             else{
                ans+=Math.pow(limit+1,remaining-i);
                return ans;
             }
           }
           if(Long.parseLong(s)<=Long.parseLong(num.substring(remaining)))ans++;
           return ans;
        
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        
        // find powerful integer less than finish and start-1 amd subtract them
        return func(Long.toString(finish),limit,s) - func(Long.toString(start-1),limit,s);
    }
}
