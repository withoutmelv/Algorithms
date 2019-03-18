import java.util.*;

public class Line {
    public static void main(String[] args){
        int[][]a=new int[2][5];
        int[][]f=new int[2][5];
        int[][]t=new int[2][4];
        int[][]l=new int[2][5];
        int[]e=new int[2];
        int[]x=new int[2];

        a[0][0]=7;
        a[0][1]=9;
        a[0][2]=3;
        a[0][3]=4;
        a[0][4]=80;
        a[1][0]=8;
        a[1][1]=5;
        a[1][2]=6;
        a[1][3]=4;
        a[1][4]=5;
        e[0]=2;
        e[1]=4;
        x[0]=3;
        x[1]=6;
        t[0][0]=2;
        t[0][1]=3;
        t[0][2]=1;
        t[0][3]=3;
        t[1][0]=2;
        t[1][1]=1;
        t[1][2]=2;
        t[1][3]=2;
        int best=bestWay(a,f,t,e,x,l);
        System.out.println("最短时间："+best);
    }

    public static int bestWay(int a[][],int f[][],int t[][],int e[],int x[],int l[][]){
        int bestf,bestl;
        f[0][0]=e[0]+a[0][0];
        f[1][0]=e[1]+a[1][0];
        for(int j=1;j<a[0].length;j++) {
            if(f[0][j-1]+a[0][j]<=f[1][j-1]+t[1][j-1]+a[0][j]) {
                f[0][j]=f[0][j-1]+a[0][j];
                l[0][j]=1;
            }
            else {
                f[0][j]=f[1][j-1]+t[1][j-1]+a[0][j];
                l[0][j]=2;
            }
            if(f[1][j-1]+a[1][j]<=f[0][j-1]+t[0][j-1]+a[1][j]) {
                f[1][j]=f[1][j-1]+a[1][j];
                l[1][j]=2;
            }
            else {
                f[1][j]=f[0][j-1]+t[0][j-1]+a[1][j];
                l[1][j]=1;
            }
        }
        if(f[0][a[0].length-1]+x[0]<=f[1][a[0].length-1]+x[1]) {
            bestf=f[0][a[0].length-1]+x[0];
            bestl=1;
        }
        else{
            bestf=f[1][a[0].length-1]+x[1];
            bestl=2;
        }

        //输出最优路线
        System.out.println("line:"+bestl+" "+"station"+a[0].length);
        int temp=bestl;
        for(int j=a[0].length-1;j>0;j--) {
            temp=l[temp-1][j];
            System.out.println("line:"+temp+" "+"station"+j);
        }
        return bestf;
    }
}

