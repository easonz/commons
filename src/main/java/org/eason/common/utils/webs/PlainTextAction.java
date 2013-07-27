package org.eason.common.utils.webs;

import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.opensymphony.xwork2.ActionSupport;

public class PlainTextAction extends ActionSupport {
	
	private String ajaxResult;
	
	public String getAjaxResult() {
		return ajaxResult;
	}
	
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}
	
    public String getPlainText() throws Exception {
    	List<String> lists = Lists.newArrayList(StringUtils.split("a b c d"));
		JSONArray optionArray = JSONArray.fromObject(lists);
    	ajaxResult = optionArray.toString();
    	return "ajaxResponse";
    }
}