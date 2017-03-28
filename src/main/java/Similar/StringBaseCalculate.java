package Similar;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by legotime
 */
abstract class StringBaseCalculate {

    /**
     * 把reducebykey的结果中的value　进行统计（reducebykey((a, b) => a+' '+b)） 尽量多一个空格
     * @param s
     * @return
     */
    public final Map<String, Integer> getHashKey(final String s){
        HashMap<String, Integer> res = new HashMap<String, Integer>();
        String[] strings = s.split("\\s+");
        for (String string : strings) {
            res.put(string,1);
        }
        return res;

    }
}

