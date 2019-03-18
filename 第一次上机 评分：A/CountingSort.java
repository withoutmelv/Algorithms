public class CountingSort {
    public int[] countingSort(int []a,int n,int k){
        int c[]=new int[k+1];
        int b[]=new int[n];
        for (int i=0;i<=k;i++){
            c[i]=0;
        }
        for (int j=0;j<n;j++){
            c[a[j]]=c[a[j]]+1;
        }
        for (int i=1;i<=k;i++){
            c[i]+=c[i-1];
        }
        for (int j=n-1;j>=0;j--){
            b[c[a[j]]-1]=a[j];
            c[a[j]]=c[a[j]]-1;
        }
        return b;
    }
    public static void main(String[] args){
        int a[]={2,5,3,0,2,3,0,3};
        int b[];
        CountingSort c=new CountingSort();
        b=c.countingSort(a,8,5);
        for (int m=0;m<b.length;m++){
            System.out.println(b[m]);
        }
    }
}
