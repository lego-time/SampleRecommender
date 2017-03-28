package recommender;

import Similar.Jaccard;
import Similar.Similarity;
import util.ArrayUtil;
import util.StringUtil;

import java.util.Arrays;
import java.util.TreeSet;


/**
 * Created by root on 3/28/17.
 */
public class recommend {
    //推荐函数
    private String[] products ;
    private Similarity sim;
    private double[][] simMatrix;



    public recommend(String[] products, Similarity sim) {
        this.products = products;
        this.sim = sim;
    }
    public recommend() {
    }

    public TreeSet<String> getProduct(){
        return StringUtil.StringArrayDistincted(products);
    }
    private double[][] getSimilarity(String[] products, Similarity sim){
//        int productSize = StringUtil.StringArrayDistinctedSize(products);
        int productSize = products.length;
        double[][] res = new double[productSize][productSize];
        for (int i = 0;i < productSize;i++){
            for (int j = 0;j < productSize;j++){
                res[i][j] = sim.distance(products[i],products[j]);
            }

        }
        return res;
    }

    /**
     * 计算user 和　product的　０－１　矩阵
     * @return
     */
    public double[][] RelationMatrix(){
        int userLength = products.length;
        TreeSet<String> allPrduct = StringUtil.StringArrayDistincted(products);

        int productLength = allPrduct.size();
        double[][] res = new double[userLength][productLength];
        for (int i = 0; i < userLength;i++){
            for (int j = 0; j < productLength; j++){
                String[] s = StringUtil.StringtoArray(products[i]);
                Object o = allPrduct.toArray()[j];
                res[i][j] = Arrays.asList(s).contains(o)?1:0;
            }
        }
        return res;
    }
    //训练函数
    public void fit(String[] products, Similarity sim){
        this.products = products;
        this.simMatrix =  getSimilarity(products,sim);
    }

    public void fit(String[] products){
        this.products = products;
        this.simMatrix =  getSimilarity(products,new Jaccard());
    }


    //推荐函数
    public double[] recommendFun(String product){
        double[][] p = ArrayUtil.mutiplyMatrix(simMatrix,RelationMatrix());


        int flag = 0;
        for(int i = 0; i < products.length;i++){
            if (products[i] == product){
                flag = i;
            }
        }
        double[] ng = ArrayUtil.fllArray(RelationMatrix()[flag],1);
        return ArrayUtil.mutiplyArray(p[flag],ArrayUtil.sub(ng,RelationMatrix()[flag]));
    }


}
