package com.cq.customview.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by cq on 2017/5/18.
 */

public class DataUtils {
    /**
     * 获取JsonObject
     *
     * @param jsonStr
     *
     * @return
     */
    public static JsonObject parseJson(String jsonStr) {
        return new JsonParser().parse(jsonStr).getAsJsonObject();
    }

    /**
     * 根据json字符串返回Map对象
     *
     * @param json
     *
     * @return
     */
    public static Map<String, Object> json2Map(String json) {
        return json2Map(parseJson(json));
    }

    /**
     * 将JSONObjec对象转换成Map-List集合
     *
     * @param jsonObj
     *
     * @return
     */
    public static Map<String, Object> json2Map(JsonObject jsonObj) {
        Map<String, Object> map = new HashMap<>();
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObj.entrySet();
        for (Iterator<Map.Entry<String, JsonElement>> iterator = entrySet.iterator(); iterator.hasNext(); ) {
            Map.Entry<String, JsonElement> entry = iterator.next();
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof JsonArray) {
                map.put(key, jsonArrayToList((JsonArray) value));
            } else if (value instanceof JsonObject) {
                map.put(key, json2Map((JsonObject) value));
            } else {
                map.put(key, value);
            }
        }
        return map;
    }

    /**
     * 将JSONArray对象转换成List集合
     *
     * @param json
     *
     * @return
     */
    public static List<Object> jsonArrayToList(JsonArray json) {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            Object value = json.get(i);
            if (value instanceof JsonArray) {
                list.add(jsonArrayToList((JsonArray) value));
            } else if (value instanceof JsonObject) {
                list.add(json2Map((JsonObject) value));
            } else {
                list.add(value);
            }
        }
        return list;
    }

    /**
     * 函数名称: jsonToMap
     * 函数描述: 将json字符串转换为map
     *
     * @param jsonStr
     *
     * @return
     */
    public static Map<String, String> jsonToMap(String jsonStr) {
        return new Gson().fromJson(jsonStr, new TypeToken<Map<String, String>>() {
        }.getType());
    }

}

