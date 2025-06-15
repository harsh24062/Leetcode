class Solution {
    public int maxDiff(int num) {

        String max=""+num;

        for(int i=0;i<max.length();i++){
          char ch=max.charAt(i);
          if(ch!='9'){
          max = max.replace(ch,'9');
            break;
          }
        }

        String min=""+num;
        
          for(int i=0;i<min.length();i++){
          char ch=min.charAt(i);
          if(i==0 && ch!='1'){
           min = min.replace(ch,'1');
            break;
          }else if(ch!=min.charAt(0) && ch!='0'){
            min = min.replace(ch,'0');
            break;
          }
        }
        
        int a =Integer.parseInt(max);
        int b =Integer.parseInt(min);

        return (a-b)%1000000007;
    }
}
