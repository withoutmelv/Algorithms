
import java.util.Scanner;
public class StrassenMatrix {
    private static int count;
    public static void matrixSub(int[][] matrixA, int[][] matrixB, int[][] result){
        for(int i = 0; i < matrixA.length; i++)
            for(int j = 0; j < matrixA.length; j++)
                result[i][j] = matrixA[i][j] - matrixB[i][j];
    }
    public static void matrixAdd(int[][] matrixA, int[][] matrixB, int[][] result){
        for(int i = 0; i < matrixA.length; i++)
            for(int j = 0; j < matrixA.length; j++)
                result[i][j] = matrixA[i][j] + matrixB[i][j];
    }
    public static void Strassen(int N, int[][] matrixA, int[][] matrixB, int[][] result){
        if(N == 1){
            result[0][0] = matrixA[0][0] * matrixB[0][0];
            return;
    }
        int halfSize = N / 2;
        int[][] A = new int[halfSize][halfSize];
        int[][] B = new int[halfSize][halfSize];
        int[][] C = new int[halfSize][halfSize];
        int[][] D = new int[halfSize][halfSize];
        int[][] E = new int[halfSize][halfSize];
        int[][] F = new int[halfSize][halfSize];
        int[][] G = new int[halfSize][halfSize];
        int[][] H = new int[halfSize][halfSize];
        int[][] C1 = new int[halfSize][halfSize];
        int[][] C2 = new int[halfSize][halfSize];
        int[][] C3 = new int[halfSize][halfSize];
        int[][] C4 = new int[halfSize][halfSize];

        int[][] P1 = new int[halfSize][halfSize];
        int[][] P2 = new int[halfSize][halfSize];
        int[][] P3 = new int[halfSize][halfSize];
        int[][] P4 = new int[halfSize][halfSize];
        int[][] P5 = new int[halfSize][halfSize];
        int[][] P6 = new int[halfSize][halfSize];
        int[][] P7 = new int[halfSize][halfSize];

        int[][] tempA = new int[halfSize][halfSize];
        int[][] tempB = new int[halfSize][halfSize];
        for(int i = 0; i < halfSize; i++)
            for(int j = 0; j < halfSize; j++){
                A[i][j] = matrixA[i][j];
                B[i][j] = matrixA[i][halfSize + j];
                C[i][j] = matrixA[i + halfSize][j];
                D[i][j] = matrixA[i + halfSize][j + halfSize];

                E[i][j] = matrixB[i][j];
                F[i][j] = matrixB[i][halfSize + j];
                G[i][j] = matrixB[i + halfSize][j];
                H[i][j] = matrixB[i + halfSize][j + halfSize];
            }
        matrixSub(F,H,tempB);
        Strassen(halfSize,A,tempB,P1);

        matrixAdd(A,B,tempA);
        Strassen(halfSize,tempA,H,P2);

        matrixAdd(C,D,tempA);
        Strassen(halfSize,tempA,E,P3);

        matrixSub(G,E,tempB);
        Strassen(halfSize,D,tempB,P4);

        matrixAdd(A,D,tempA);
        matrixAdd(E,H,tempB);
        Strassen(halfSize,tempA,tempB,P5);

        matrixSub(B,D,tempA);
        matrixAdd(G,H,tempB);
        Strassen(halfSize,tempA,tempB,P6);

        matrixSub(A,C,tempA);
        matrixAdd(E,F,tempB);
        Strassen(halfSize,tempA,tempB,P7);

        matrixAdd(P5,P4,C1);
        matrixSub(C1,P2,C1);
        matrixAdd(C1,P6,C1);

        matrixAdd(P1,P2,C2);

        matrixAdd(P3,P4,C3);

        matrixAdd(P5,P1,C4);
        matrixSub(C4,P3,C4);
        matrixSub(C4,P7,C4);

        for(int i = 0; i < halfSize; i++)
            for(int j = 0; j < halfSize; j++){
                result[i][j] = C1[i][j];
                result[i][j + halfSize] = C2[i][j];
                result[i + halfSize][j] = C3[i][j];
                result[i + halfSize][j + halfSize] = C4[i][j];
            }
        if(halfSize==count/2){
            System.out.println("S1:");
            for (int i=0;i<halfSize;i++){
                for (int j=0;j<halfSize;j++){
                    if(j!=halfSize-1)System.out.print(P1[i][j]+" ");
                    else System.out.println(P1[i][j]);
                }
            }
            System.out.println("S2:");
            for (int i=0;i<halfSize;i++){
                for (int j=0;j<halfSize;j++){
                    if(j!=halfSize-1)System.out.print(P2[i][j]+" ");
                    else System.out.println(P2[i][j]);
                }
            }
            System.out.println("S3:");
            for (int i=0;i<halfSize;i++){
                for (int j=0;j<halfSize;j++){
                    if(j!=halfSize-1)System.out.print(P3[i][j]+" ");
                    else System.out.println(P3[i][j]);
                }
            }
            System.out.println("S4:");
            for (int i=0;i<halfSize;i++){
                for (int j=0;j<halfSize;j++){
                    if(j!=halfSize-1)System.out.print(P4[i][j]+" ");
                    else System.out.println(P4[i][j]);
                }
            }
            System.out.println("S5:");
            for (int i=0;i<halfSize;i++){
                for (int j=0;j<halfSize;j++){
                    if(j!=halfSize-1)System.out.print(P5[i][j]+" ");
                    else System.out.println(P5[i][j]);
                }
            }
            System.out.println("S6:");
            for (int i=0;i<halfSize;i++){
                for (int j=0;j<halfSize;j++){
                    if(j!=halfSize-1)System.out.print(P6[i][j]+" ");
                    else System.out.println(P6[i][j]);
                }
            }
            System.out.println("S7:");
            for (int i=0;i<halfSize;i++){
                for (int j=0;j<halfSize;j++){
                    if(j!=halfSize-1)System.out.print(P7[i][j]+" ");
                    else System.out.println(P7[i][j]);
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        Scanner input = new Scanner(System.in);
//        while(input.hasNext()){
            int n = 16;
            count=n;
            int[][] matrixA = new int[n][n];
            int[][] matrixB = new int[n][n];
            int[][] result = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    matrixA[i][j] = 1;
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    matrixB[i][j] = 1;
            Strassen(n,matrixA,matrixB,result);
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++){
                    if(j != n - 1) System.out.print(result[i][j] + " ");
                    else           System.out.println(result[i][j]);
                }
        }
//    }
}
