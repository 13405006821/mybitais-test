package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.axis2.databinding.types.soapencoding.DateTime;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@SuppressWarnings({"rawtypes", "unchecked"})
public class PageData extends HashMap implements Map{
	
private static final long serialVersionUID = 1L;
	
	Map map = null;
	HttpServletRequest request;
	/**
	 * 用于解密
	 * @param request
	 * @param isdes
	 */
	public PageData(HttpServletRequest request,boolean isdes){
		
		this.request = request;
		Map properties = request.getParameterMap();
		Map returnMap = new HashMap(); 
		Iterator entries = properties.entrySet().iterator(); 
		Map.Entry entry; 
		String name = "";  
		
		while (entries.hasNext()) {
			String value = "";  
			entry = (Map.Entry) entries.next(); 
			name = (String) entry.getKey(); 
			Object valueObj = entry.getValue(); 
			if(null == valueObj){ 
				value = ""; 
			}else if(valueObj instanceof String[]){ 
				String[] values = (String[])valueObj;
				for(int i=0;i<values.length;i++){ 
					 value += values[i] + ",";
				}
				value = value.substring(0, value.length()-1); 
			}else if(valueObj instanceof DateTime){
				SimpleDateFormat sdfTime = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				value = sdfTime.format(valueObj);
			}else{
				value = valueObj.toString(); 
			}
			returnMap.put(name, value); 
		}
		
		//解密
		//根据TOKEN获取USERID，进行解密
		
		//解密完获取明文PAreturnMap.put("pa", pa);
		
		map = returnMap;
	}
	
	public PageData(HttpServletRequest request){
		this.request = request;
		Map properties = request.getParameterMap();
		Map returnMap = new HashMap(); 
		Iterator entries = properties.entrySet().iterator(); 
		Map.Entry entry; 
		String name = "";  
		
		while (entries.hasNext()) {
			String value = "";  
			entry = (Map.Entry) entries.next(); 
			name = (String) entry.getKey(); 
			Object valueObj = entry.getValue(); 
			if(null == valueObj){ 
				value = ""; 
			}else if(valueObj instanceof String[]){ 
				String[] values = (String[])valueObj;
				for(int i=0;i<values.length;i++){ 
					 value += values[i] + ",";
				}
				value = value.substring(0, value.length()-1); 
			}else if(valueObj instanceof DateTime){
				SimpleDateFormat sdfTime = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				value = sdfTime.format(valueObj);
			}else{
				value = valueObj.toString(); 
			}
			returnMap.put(name, value); 
		}
		map = returnMap;
	}
	
	public PageData() {
		map = new HashMap();
	}
	
	public PageData(JSONObject json){
		map = json;
	}
	//获取对象
	public PageData getObject(Object key){
		JSONObject obj = JSON.parseObject(map.get(key) + "");
		return new PageData(obj);
	}
	//获取list
	public List<PageData> getList(Object key){
		List<PageData> List = new ArrayList<PageData>();
		JSONArray arrlist = JSON.parseArray(map.get(key) + "");
		for(int i = 0;i<arrlist.size();i++){
			PageData obj = new PageData(arrlist.getJSONObject(i));
			List.add(obj);
		}
		return List;
	}
	
	@Override
	public Object get(Object key) {
		Object obj = null;
		if(map.get(key) instanceof Object[]) {
			Object[] arr = (Object[])map.get(key);
			obj = request == null ? arr:(request.getParameter((String)key) == null ? arr:arr[0]);
		}else if(map.get(key) instanceof Timestamp){
			SimpleDateFormat sdfTime = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			obj = sdfTime.format(map.get(key));
		} else {
			obj = map.get(key);
		}
		return obj;
	}
	
	public PageData getPageData(Object key){
		JSONObject obj = JSON.parseObject(map.get(key) + "");
		Map m = obj;
		return (PageData)m;
	}
	
	public String getString(Object key) {
		Object object = get(key);
		if(object == null){
			return null;
		}
		return object.toString();
	}
	
	public static void main(String[] args) {
		PageData pd = new PageData();
		System.out.println(pd.getString("id"));
		System.out.println(pd.get("id"));
		System.out.println(pd.get("id").toString());
	}
	
	@Override
	public Object put(Object key, Object value) {
		return map.put(key, value);
	}
	
	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	public Set entrySet() {
		return map.entrySet();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public Set keySet() {
		return map.keySet();
	}

	public void putAll(Map t) {
		map.putAll(t);
	}

	public int size() {
		return map.size();
	}

	public Collection values() {
		return map.values();
	}
}