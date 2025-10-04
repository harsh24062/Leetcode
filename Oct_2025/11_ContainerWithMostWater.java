class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int ans=0;
        while(l<r){
            int min = Math.min(height[l],height[r]);
            ans=Math.max(ans,min*(r-l));
            if(height[l]<height[r])l++;
            else if(height[l]>height[r])r--;
            else {
                l++;
                r--;
            }
        }
        return ans;
    }
}
