package Similar;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Jaccard 系数　
 */
public class Jaccard extends StringBaseCalculate implements Similarity {

    @Override
    public double distance(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new NullPointerException("s1 must not be null");
        }
        if (s1.equals(s2)){
            return 1;
        }

        Map<String, Integer> h1 = getHashKey(s1);
        Map<String, Integer> h2 = getHashKey(s2);

        Set<String> union = new HashSet<String>();

        union.addAll(h1.keySet());
        union.addAll(h2.keySet());

        int flag = 0;
        for (String key : union) {
            if (h1.containsKey(key) && h2.containsKey(key)){
                flag++;
            }

        }

        return 1.0*flag / union.size();
    }

}
