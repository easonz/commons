package org.eason.common.demo;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

public class JsonOpetateDemo {

	private static Logger logger = LoggerFactory.getLogger(JsonOpetateDemo.class);
	
	@Test
	public void java2Json(){
		//list 2 json
		List<String> lists = Lists.newArrayList(StringUtils.split("a b c d"));
		JSONArray optionArray = JSONArray.fromObject(lists);
		logger.info("options : {}", optionArray.toString());
	}
	
	@Test
	public void buildJson(){
		JSONObject obj = new JSONObject();
		obj.put("key", "value");
		logger.info("obj : {}", obj.toString());
	}
	
}
