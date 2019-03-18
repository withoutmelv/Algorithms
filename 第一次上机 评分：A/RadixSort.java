public class RadixSort {
    public int[] radixSort(int[] array,int d){
        int n=1;
        int k=0;
        int length=array.length;
        int[][] bucket=new int[10][length];
        int[] order=new int[length];
        while(n<d)
        {
            for(int num:array)
            {
                int digit=(num/n)%10;
                bucket[digit][order[digit]]=num;
                order[digit]++;
            }
            for(int i=0;i<length;i++)
            {
                if(order[i]!=0)
                {
                    for(int j=0;j<order[i];j++)
                    {
                        array[k]=bucket[i][j];
                        k++;
                    }
                }
                order[i]=0;
            }
            n*=10;
            k=0;
        }
        return array;
    }
    public static void main(String[] args){
        int a[]={3,22, 93, 43, 55, 14, 28, 65, 39, 81};
        int b[];
        RadixSort c=new RadixSort();
        b=c.radixSort(a,100);
        for (int m=0;m<b.length;m++){
            System.out.println(b[m]);
        }
    }

}
