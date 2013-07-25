package org.eason.common.demos.web;

import java.util.Collections;
import java.util.Map;

import org.eason.common.collected.utils.mapper.JsonMapper;
import org.springframework.stereotype.Controller;

/**
 * 输出JsonP格式的Mashup 服务端, 支持被跨域调用.
 * 
 * @author calvin
 */
@Controller
public class MashupServerController {

	private static final String DEFAULT_JQUERY_JSONP_CALLBACK_PARM_NAME = "callback";

	private final JsonMapper mapper = new JsonMapper();

	public String execute(String callbackName) {

		//设置需要被格式化为JSON字符串的内容.
		Map<String, String> map = Collections.singletonMap("content", "<p>你好，世界！</p>");

		//渲染返回结果.
		return mapper.toJsonP(callbackName, map);
	}
}
