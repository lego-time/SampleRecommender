package util;


public class ArrayUtil {
    public static double[][] mutiplyMatrix(double[][] a,double [][] b){
        assert a[0].length ==b.length;
        double[][] c=new double[a.length][b[0].length];
        for(int i=0;i<a.length;i++) {
            for(int j=0;j<b[0].length;j++) {
                for(int k=0;k<a[0].length;k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static double[] mutiplyArray(double[] a, double[] b){
        int count = a.length;
        assert count ==b.length;
        double[] c = new double[count];
        for (int i = 0; i < count; i ++){
            c[i] = a[i]*b[i];
        }
        return c;
    }

    public static double [] fllArray(double [] a,double obj){
        for (int i = 0; i<a.length;i++){
            a[i] = obj;
        }
        return a;
    }
    public static double [] sub(double[] a, double[] b){
        int count = a.length;
        assert count ==b.length;
        double[] c = new double[count];
        for (int i = 0; i < count; i ++){
            c[i] = a[i]-b[i];
        }
        return c;
    }
}
