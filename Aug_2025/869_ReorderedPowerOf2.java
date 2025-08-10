class Solution {
    String convertToString(int n){
       int ch[] = new int[10];

        while(n>0){
            ch[n%10]++;
            n=n/10;
        }

        StringBuilder sb=new StringBuilder();
        for(int i:ch){
            sb.append(i);
        }

        return sb.toString();
    }
    public boolean reorderedPowerOf2(int n) {
        String s = convertToString(n);

        long num=1; int pow=0;
        while(num<Integer.MAX_VALUE){
            num = (long)Math.pow(2,pow);
            pow++;
            String newStr = convertToString((int)num);
            if(newStr.equals(s))return true;
        }
        return false;
    }
}
