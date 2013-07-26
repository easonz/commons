/**
 * <p>Title: AuthCodeAction.java </p>
 * <p>Description: AuthCodeAction.java </p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: zhiyuan</p>
 *
 * @author zhangchao
 * @date 2013-7-17
 * @version 1.0
 */
package org.eason.common.utils.webs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title: AuthCodeAction.java </p>
 * <p>Description: AuthCodeAction.java </p>
 *
 * @author zhangchao
 * @date 2013-7-17
 * @version 1.0
 */
public class AuthCodeAction extends ActionSupport {

	Logger logger = LoggerFactory.getLogger(AuthCodeAction.class);

	/**
	 * 验证码图片的宽度。
	 */
	private int width = 60;

	/**
	 * 验证码图片的高度。
	 */
	private int height = 20;

	/**
	 * 验证码字符个数
	 */
	private int codeCount = 4;

	/**
	 * xx
	 */
	private int xx = 0;

	/**
	 * 字体高度
	 */
	private int fontHeight;

	/**
	 * codeY
	 */
	private int codeY;

	/**
	 * codeSequence
	 */
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	
	/**
	 * 
	 */
	public AuthCodeAction() {
		xx = width / (codeCount + 1);
		fontHeight = height - 2;
		codeY = height - 4;
	}

	@Override
	public String execute() throws Exception {
		
        // 定义图像buffer   
        BufferedImage buffImg = new BufferedImage(width, height,   
                BufferedImage.TYPE_INT_RGB);   
        Graphics2D gd = buffImg.createGraphics();   
        
        // 创建一个随机数生成器类   
        Random random = new Random();   
  
        // 将图像填充为白色   
        gd.setColor(Color.WHITE);   
        gd.fillRect(0, 0, width, height);   
  
        // 创建字体，字体的大小应该根据图片的高度来定。   
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);   
        // 设置字体。   
        gd.setFont(font);   
  
        // 画边框。   
        gd.setColor(Color.BLACK);   
        gd.drawRect(0, 0, width - 1, height - 1);   
  
        // 随机产生160条干扰线，使图象中的认证码不易被其它程序探测到。   
        gd.setColor(Color.BLACK);   
        for (int i = 0; i < 5; i++) {   
            int x = random.nextInt(width);   
            int y = random.nextInt(height);   
            int xl = random.nextInt(12);   
            int yl = random.nextInt(12);   
            gd.drawLine(x, y, x + xl, y + yl);   
        }   
  
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。   
        StringBuffer randomCode = new StringBuffer();   
        int red = 0, green = 0, blue = 0;   
  
        // 随机产生codeCount数字的验证码。   
        for (int i = 0; i < codeCount; i++) {   
            // 得到随机产生的验证码数字。   
            String strRand = String.valueOf(codeSequence[random.nextInt(36)]);   
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。   
            red = random.nextInt(255);   
            green = random.nextInt(255);   
            blue = random.nextInt(255);   
  
            // 用随机产生的颜色将验证码绘制到图像中。   
            gd.setColor(new Color(red, green, blue));   
            gd.drawString(strRand, (i + 1) * xx, codeY);   
  
            // 将产生的四个随机数组合在一起。   
            randomCode.append(strRand);   
        }   
        // 将四位数字的验证码保存到Session中。   
        HttpServletRequest request = ServletActionContext.getRequest(); //得到HttpServletRequest对象
        HttpServletResponse response = ServletActionContext.getResponse(); //得到HttpServletRequest对象
        HttpSession session = request.getSession(); //得到HttpSession对象    
        session.setAttribute("authCode", randomCode.toString());  
        logger.info("session:[{}], code:[{}]", session.getId(), randomCode.toString());
        //System.out.println("session: " + session.getId());
        // 禁止图像缓存。   
        response.setHeader("Pragma", "no-cache");   
        response.setHeader("Cache-Control", "no-cache");   
        response.setDateHeader("Expires", 0);   
        response.setContentType("image/jpeg");   
  
        // 将图像输出到Servlet输出流中。   
        ServletOutputStream sos = response.getOutputStream();   
        ImageIO.write(buffImg, "jpeg", sos);   
        sos.close();   
		return NONE;
	}
}
