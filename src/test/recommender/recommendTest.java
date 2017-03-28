package recommender;

import java.util.Arrays;

/**
 * Created by legotime
 */
public class recommendTest {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        String[] products = {"dog cate pen cake pie","dog cat water coco","pie cake pen cate"};
        String s = "pie cake pen cate";
        recommend rec = new recommend();
        rec.fit(products);
        double[] doubles = rec.recommendFun(s);
        System.out.println(Arrays.toString(doubles));
        System.out.println(rec.getProduct());
        //[cake, cat, cate, coco, dog, pen, pie, water]
        //[0.0, 0.0, 0.0, 0.0, 0.8, 0.0, 0.0, 0.0]

        //所以推荐　买了　pie cake pen cate　的人买 dog
    }

}