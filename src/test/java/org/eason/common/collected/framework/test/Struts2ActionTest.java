package org.eason.common.collected.framework.test;

import org.apache.struts2.StrutsTestCase;
import org.eason.common.utils.webs.AuthCodeAction;

import com.opensymphony.xwork2.ActionProxy;

public class Struts2ActionTest extends StrutsTestCase{
	
	protected ActionProxy proxy;
	
    public void testAdd() throws Exception{
    	
    	request.setParameter("token", ".056157132");
        proxy=getActionProxy("/authCode");
        AuthCodeAction action = (AuthCodeAction)proxy.getAction();
        
        String result = proxy.execute();
        assertEquals("none", result);
        
        String authCode = (String) request.getSession().getAttribute("authCode");
        assertNotNull(authCode);
    }
}
