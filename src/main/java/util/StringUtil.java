package util;

import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by root on 3/28/17.
 */
public class StringUtil {
    public static int StringArrayDistinctedSize(String[] strings) {
        HashSet<String> strSet = new HashSet<String>();
        for (String string : strings) {
            String[] splited = string.split("\\s+");
            Collections.addAll(strSet, splited);
        }
        return strSet.size();
    }

    public static TreeSet<String> StringArrayDistincted(String[] strings) {
        TreeSet<String> strSet = new TreeSet<String>();
        for (String string : strings) {
            String[] splited = string.split("\\s+");
            Collections.addAll(strSet, splited);
        }
        return strSet;
    }

    public static String[] StringtoArray(String str) {
        TreeSet<String> strSet = new TreeSet<String>();
        String[] splited = str.split("\\s+");
        Collections.addAll(strSet, splited);
        return splited;

    }
}
