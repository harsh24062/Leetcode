//brute force
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {

        int n=colors.length;
        int ans=0; // groups

        for(int i=0;i<n;i++){
            boolean flag=true; // if not alternate then flag turn to false
            for(int j=1;j<k;j++){
                if(colors[(i+j-1)%n]==colors[(i+j)%n]){
                    flag=false;
                    break;
                }
            }
            if(flag)ans++;
        }
        return ans;
    }
}

// accepted
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        
        int n=colors.length;

        int colorChange[]=new int[n*2];

        colorChange[0]=1;

        for(int i=1;i<colorChange.length;i++){
            if(colors[(i-1)%n]!=colors[i%n]) colorChange[i]=1+colorChange[i-1];
            else colorChange[i]=colorChange[i-1];
        }

        int ans=0;

        for(int i=0;i<n;i++){
           if((i+k-1)-i==colorChange[i+k-1]-colorChange[i])ans++;
        }

        return ans;
    }
}



