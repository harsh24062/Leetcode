class Solution {
    int freq[];
    boolean func(int index, char ch[], String pattern, char prev){

       if(index==ch.length-1){

        for(char i='1';i<='9';i++){
        if(freq[i-'0']<0)continue;
        else if(prev=='I' && i-'0'<=ch[index-1]-'0')continue;
        else if(prev=='D' && i-'0'>=ch[index-1]-'0')continue;
        
        freq[i-'0']--;
        ch[index]=i;
        return true;
        
       }
        return false; 
       }

    for(char i='1';i<='9';i++){
        if(freq[i-'0']<0)continue;
        else if(prev=='I' && i-'0'<=ch[index-1]-'0')continue;
        else if(prev=='D' && i-'0'>=ch[index-1]-'0')continue;
        
        freq[i-'0']--;
        ch[index]=i;
        if(func(index+1,ch,pattern,pattern.charAt(index)))return true;
        freq[i-'0']=0;
        ch[index]='\u0000';
    }

       return false;
    }

    public String smallestNumber(String pattern) {

        char ch[]=new char[pattern.length()+1];
        freq=new int[10];

        for(char i='1';i<='9';i++){
          ch[0]=i;
          freq[i-'0']--;
          if(func(1,ch,pattern,pattern.charAt(0))) return new String(ch);
          freq[i-'0']=0;
        }

        return "";
    }
}
