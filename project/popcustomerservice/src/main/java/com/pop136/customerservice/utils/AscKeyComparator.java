package com.pop136.customerservice.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AscKeyComparator implements  Comparator<Map.Entry<String, String>>
{
    public static List<Map.Entry<String, String>> getAscMap(HashMap<String, String> map) {
    
        Set<Map.Entry<String, String>> entrySet = map.entrySet();    //获取map集合的所有"映射"的Set集合,这里规范每个映射的类型为Map.Entry<K, V>（于Set集合中无序存放）
        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(entrySet);    //新建List集合获取Set集合的所有元素（"映射"对象）（顺序与Set集合一样）
        /** 
         * 接下来的排序是list的专长了
         * 通过“比较器(AscKeyComparator)”，对list进行排序
         */
        Collections.sort(list, new AscKeyComparator());

        Iterator<Map.Entry<String, String>> iter = list.iterator();    //获取List集合的迭代器,Map.Entry<K, V>为迭代元素的类型
        while(iter.hasNext()){
            Map.Entry<String, String> item = iter.next();
            String key = item.getKey();
            String value = item.getValue();
            System.out.println("key:" + key + "-->value:" + value);
        }
        
        return list;

    }
    
    @Override
    public int compare(Map.Entry<String, String> item1, Map.Entry<String, String> item2){
        return item1.getKey().compareTo(item2.getKey());    //升序排序
    }
}
