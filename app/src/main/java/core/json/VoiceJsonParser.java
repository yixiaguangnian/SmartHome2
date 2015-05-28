package core.json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import utils.L;

/**
 * User: niuwei(nniuwei@163.com)
 * Date: 2015-04-05
 * Time: 00:58
 * Json格式数据的解析器
 */
public class VoiceJsonParser {

    public static String parseIatResult(String json){
        StringBuffer ret = new StringBuffer();
        try {
            JSONTokener tokener = new JSONTokener(json);
            JSONObject joResult = new JSONObject(tokener);
            JSONArray words = joResult.getJSONArray("ws");
            for (int i = 0; i < words.length(); i++) {
                // 转写结果词，默认使用第一个结果
                JSONArray items = words.getJSONObject(i).getJSONArray("cw");
                JSONObject obj = items.getJSONObject(0);
                ret.append(obj.getString("w"));
            }

        } catch (Exception e) {
            L.d("class = VoiceJsonParser , function = parseIatResult()");
            e.printStackTrace();
        }
        return ret.toString();
    }
}
