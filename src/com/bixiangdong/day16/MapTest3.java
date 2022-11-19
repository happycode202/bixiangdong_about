package com.bixiangdong.day16;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
练习：
"sdfgzxcvasdfxcvdf"获取该字符串中的字母出现的次数。
希望打印结果：a(1)c(2).....

通过结果发现，每一个字母都有对应的次数。
说明字母和次数之间都有映射关系。

注意了，当发现有映射关系时，可以选择map集合。
因为map集合中存放就是映射关系。

什么时候使用map集合呢？
当数据之间存在这映射关系时，就要先想map集合。

思路：
1，将字符串转换成字符数组。因为要对每一个字母进行操作。

2，定义一个map集合，因为打印结果的字母有顺序，所以使用treemap集合。

3，遍历字符数组。
	将每一个字母作为键去查map集合。
	如果返回null，将该字母和1存入到map集合中。
	如果返回不是null，说明该字母在map集合已经存在并有对应次数。
	那么就获取该次数并进行自增。，然后将该字母和自增后的次数存入到map集合中。覆盖调用原理键所对应的值。
4，将map集合中的数据变成指定的字符串形式返回。
*/
public class MapTest3 {
    public static void main(String[] args) {
        String str = charCout("sdfgzxcvasdfxcvdf");
        System.out.println(str);
    }

    public static String charCout(String str) {
        //将字符串变成字符数组
        char[] charArray = str.toCharArray();

        //定义一个集合，用来存放字符，因为后续涉及到排序，这里选择TreeMap
        TreeMap<Character, Integer> tm = new TreeMap<>();
        //将字符数组的每一项作为 key去treemap中比对，如果返回值为null，将字符存入，并将value计数为1.如果返回值不为null，说明里面已经有了，将key对应的value值+1
        for (int i = 0; i < charArray.length; i++) {
            Integer value = tm.get(charArray[i]);
            if (value == null) {
                tm.put(charArray[i], 1);
            } else {
                value++;
                tm.put(charArray[i], value);
            }
        }

        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Character, Integer>> entrySet = tm.entrySet();
        Iterator<Map.Entry<Character, Integer>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> me = it.next();
            Character key = me.getKey();
            Integer value = me.getValue();
            sb.append(key + "(" + value + ")");
        }
        return sb.toString();
    }
}
