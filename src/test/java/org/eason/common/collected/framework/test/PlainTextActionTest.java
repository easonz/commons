package org.eason.common.collected.framework.test;
import net.sf.json.JSONArray;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionProxy;

public class PlainTextActionTest extends Struts2ActionTest1 {
	
	private static Logger logger = LoggerFactory.getLogger(PlainTextActionTest.class);

    private ActionProxy proxy;

    @Test
    public void getPlainText() throws Exception {
    	
        proxy = getActionProxy("/getPlainText"); 
        String result = proxy.execute();
        
    	String jsonResult = response.getContentAsString();
    	logger.info("result is : {}", result);
    	logger.info("content is : {}", jsonResult);
    	
    	JSONArray arrays = JSONArray.fromObject(jsonResult);
    }
}