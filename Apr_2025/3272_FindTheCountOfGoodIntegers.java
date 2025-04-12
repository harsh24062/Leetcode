class Solution {

   

    public long countGoodIntegers(int n, int k) {

        int leftDigit=(n+1)/2;
        // find range
        long start=(long)Math.pow(10,leftDigit-1);
        long end=(long)Math.pow(10,leftDigit)-1;

        Set<String> set=new HashSet<>();
        long result=0;

        long factorial[]=new long[11];
        factorial[0]=1;
        for(int i=1;i<11;i++){
            factorial[i]=i*factorial[i-1];
        }


        for(long i=start;i<=end;i++){
           String lefthalf = Long.toString(i);
           String full="";

           if(n%2==0){
             String right=lefthalf;
             right=new StringBuilder(right).reverse().toString();
             full=lefthalf+right;
           }else{
              String right=lefthalf.substring(0,leftDigit-1 );
              right=new StringBuilder(right).reverse().toString();
             full=lefthalf+right;
           }

           long number =Long.parseLong(full);
           if(number%k!=0)continue;
           char[] charArray = full.toCharArray();

           // Sort the char array
           Arrays.sort(charArray);

           // Convert sorted char array back to string
           String sorted = new String(charArray);
           set.add(sorted);
        }

        for(String s:set){
            int freq[]=new int[10];
            for(char i:s.toCharArray()){
                freq[i-'0']++;
            }
            int totalDigit=s.length();
            int zero=freq[0];
            int nonzero =totalDigit-zero;

            long prem = nonzero * factorial[totalDigit-1];

            for(int i=0;i<10;i++){
                prem/=factorial[freq[i]];
            }
            result+=prem;
        }
     return result;
    }
}
