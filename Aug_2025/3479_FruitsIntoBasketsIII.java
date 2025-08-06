class Solution {
    int segTree[];

    void createSegTree(int[] baskets, int l, int r, int node){
        if(l==r){
            segTree[node]=baskets[l];
            return;
        }
        int mid = (l+r)/2;
        createSegTree(baskets,l,mid,2*node+1);
        createSegTree(baskets,mid+1,r,2*node+2);
        segTree[node]=Math.max(segTree[2*node+1],segTree[2*node+2]);
    } 

    int search(int l, int r, int node, int f){
        if(segTree[node]<f)return -1;

        if(l==r){
            segTree[node]=-1;
            return 1;
        }
        
        int mid = (l+r)/2;
        int pos;
        if(segTree[2*node+1]>=f){
            pos=search(l,mid,2*node+1,f);
        }else{
            pos=search(mid+1,r,2*node+2,f);
        }
       segTree[node]=Math.max(segTree[2*node+1],segTree[2*node+2]);
        return pos;
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        segTree = new int[4*n];

        createSegTree(baskets,0,n-1,0);

        int unPlace=0;

        for(int f:fruits){
            if(search(0,n-1,0,f)==-1){
                unPlace++;
            }
        }
      
        return unPlace;

    }
}
