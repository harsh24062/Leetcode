class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        // shashcode approach
        //https://youtu.be/p06jf-QUYQE?si=Gdn_3DIWHQ-bq9ZG

// will do by cumulative sum
        int shift[]=new int[s.length()];

        for(int k[]:shifts){
            //forword shift
            if(k[2]==1){
              shift[k[0]]++;
              if(k[1]+1 < s.length()){
                shift[k[1]+1]--;
              }
            }
            // backword shift
            else{
              shift[k[0]]--;
               if(k[1]+1 < s.length()){
                shift[k[1]+1]++;
              }
            }
        }

        int sum=0; // it will contain number of shifts

        StringBuilder sb=new StringBuilder(s);

        for(int i=0;i<s.length();i++){
            sum=(sum+shift[i])%26;
            if(sum<0) sum=sum+26;

            char ch=sb.charAt(i);
            int num=ch+sum;
            if(num>122){
              num=num%123;
              ch=(char)('a'+num);
              sb.setCharAt(i,ch);
              }
             
              else sb.setCharAt(i,(char)num);
            
        }

        return sb.toString();
    }
}
