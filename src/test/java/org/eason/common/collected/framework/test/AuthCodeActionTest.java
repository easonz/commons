package org.eason.common.collected.framework.test;

import org.eason.common.utils.webs.AuthCodeAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({})
public class AuthCodeActionTest  extends Struts2ActionTest1{
	
	private static Logger logger = LoggerFactory.getLogger(AuthCodeActionTest.class);

	@Test
    public void getAuthCode() throws Exception{
    	
        //servletContext;
        //applicationContext;
    	
    	request.setParameter("token", ".056157132");
        proxy=getActionProxy("/authCode");
        AuthCodeAction action = (AuthCodeAction)proxy.getAction();
        
        String result = proxy.execute();
        assertEquals("none", result);
        
        String authCode = (String) request.getSession().getAttribute("authCode");
        assertNotNull(authCode);
    }
}
