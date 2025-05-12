class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
            if(digits[i]==0)continue;
            for(int j=0;j<n;j++){
                if(j==i )continue;
                for(int k=0;k<n;k++){
                  if(k==j ||k==i )continue;

                  int num =(digits[i]*100+digits[j]*10+digits[k]);
                  if(num%2==0)
                  set.add(num);
                }
            }
        }
         
        int ans[] =new int[set.size()];
        int index=0;
        for(int i:set){
            ans[index]=i;
            index++;
        }

        Arrays.sort(ans);
      
        return ans;
    }
}



// 2nd method

class Solution {
    public int[] findEvenNumbers(int[] digits) {

        Set<Integer> set = new HashSet<>();

        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        for (int i = 1; i <= 9; i++) {
            if (freq[i] == 0) continue;
            freq[i]--;

            for (int j = 0; j <= 9; j++) {
                if (freq[j] == 0) continue;
                freq[j]--;

                for (int k = 0; k <= 8; k += 2) { // Only even digits
                    if (freq[k] == 0) continue;
                    freq[k]--;

                    int num = i * 100 + j * 10 + k;
                    set.add(num);

                    freq[k]++;
                }

                freq[j]++;
            }

            freq[i]++;
        }
        int ans[] =new int[set.size()];
        int index=0;
        for(int i:set){
            ans[index]=i;
            index++;
        }

        Arrays.sort(ans);
      
        return ans;
    }
}
