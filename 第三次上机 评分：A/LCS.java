public class LCS {
    public static void main (String[] args){
        String str1="ACCGGTCGAGATGCAG";
        String str2="ACCGGTCGAGATGCAG";
        printLCS(str1,str2);
    }


    public static void printLCS(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();
        int[][] cLenNUm = new int[str1.length() + 1][str2.length() + 1];
        String [][] point= new String[str1.length() + 1][str2.length() + 1];
        //构造一个LCS长度数组
        for (int j=0;j<=str2Len;j++){
            point[0][j]="^|";
            cLenNUm[0][j]=0;
        }
        for (int i=0;i<=str1Len;i++){
            cLenNUm[i][0]=0;
        }
        for (int i = 1; i <= str1Len; i++) {
            for (int j = 1; j <= str2Len; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    cLenNUm[i][j] = cLenNUm[i - 1][j - 1] + 1;
                    point[i][j]="^\\";
                } else if(cLenNUm[i - 1][j] >= cLenNUm[i][j - 1]) {
                    cLenNUm[i][j] = cLenNUm[i - 1][j];
                    point[i][j]="^|";
                }else{
                    cLenNUm[i][j] = cLenNUm[i][j - 1];
                    point[i][j]="<-";
                }
            }
        }
        for (int i = 1; i <= str1Len; i++) {
            for (int j = 1; j <= str2Len; j++) {
                System.out.print(cLenNUm[i][j]);
                if (j==str2Len){
                    System.out.println(point[i][j]);
                }else{
                    System.out.print(point[i][j] + " ");
                }
            }
        }
        //反推结果
        int i = str1Len;
        int j = str2Len;
        StringBuffer sb = new StringBuffer();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (cLenNUm[i][j - 1] > cLenNUm[i - 1][j]) {
                    j--;
                } else if (cLenNUm[i][j - 1] < cLenNUm[i - 1][j]) {
                    i--;
                } else if (cLenNUm[i][j - 1] == cLenNUm[i - 1][j]) {
                    i--;
                }
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
