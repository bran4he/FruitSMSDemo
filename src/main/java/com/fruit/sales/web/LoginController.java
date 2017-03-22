package com.fruit.sales.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fruit.sales.common.LoginUtil;
import com.fruit.sales.common.Result;
import com.fruit.sales.common.WebContextHolder;
import com.fruit.sales.entity.LoginLog;
import com.fruit.sales.entity.User;
import com.fruit.sales.service.LoginLogService;
import com.fruit.sales.service.UserService;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginLogService loginLogService;
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username")String username,
			@RequestParam("password")String password){
		logger.info("{}, {}", username, password);
		//add one more time background verify to prohibit front-end bypass
		Result result = new Result();
		result = verify(username, password);
		if(result != null && result.isResult()){
			//save to session
			WebContextHolder.getSession(true).setAttribute(LoginUtil.USER_SESSION, username);
			//save to db
			User user = (User) result.getMsg().get("msg");
			LoginLog log = new LoginLog(null, user.getId(), new Date(), LoginUtil.getIpAddr());
			loginLogService.add(log);
			
			return "redirect:/index/index";
		}else{
			return "redirect:/login/login";
		}
	}
	
	
	@RequestMapping(value = "verify", method = RequestMethod.POST)
	public @ResponseBody Result verifyUser(@RequestParam("username")String username,
			@RequestParam("password")String password){
		Result result = new Result();
		result = verify(username, password);
		return result;
	}
	
	@RequestMapping(value = "verifyAuthCode", method = RequestMethod.POST)
	public @ResponseBody Result verifyAuthCode(@RequestParam("authcode")String authcode){
		
		Result result = new Result();
		Map<String, Object> data = new HashMap<String, Object>();
		String code = (String) WebContextHolder.getSession().getAttribute(LoginUtil.AUTH_CODE_SESSION);
		
		logger.info("get authcode:{} from front-end and sesson code:{}",authcode, code);
		
		if(StringUtils.isNotEmpty(code)){
			if(StringUtils.equalsIgnoreCase(code, authcode)){
				result.setResult(true);
			}
		}else{
			result.setResult(false);
			data.put("msg", "code error");
		}
		result.setMsg(data);
		return result;
	}
	
	@RequestMapping(value= "authcode")
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response,HttpSession session)
            throws IOException {
        int width = 65;
        int height = 30;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman",0,28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for(int i=0;i<40;i++){
            g.setColor(this.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        //绘制字符
        String strCode = "";
        for(int i=0;i<4;i++){
            String rand = String.valueOf(random.nextInt(10));
            strCode = strCode + rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand, 13*i+6, 28);
        }
        //将字符保存到session中用于前端的验证
        session.setAttribute(LoginUtil.AUTH_CODE_SESSION, strCode);
        g.dispose();

        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();

    }
	
	//创建颜色
    Color getRandColor(int fc,int bc){
        Random random = new Random();
        if(fc>255)
            fc = 255;
        if(bc>255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }
    
	public Result verify(String username, String password) {
		// TODO Auto-generated method stub
		Result result = new Result();
		User userQuery = userService.findByUsername(username);
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		if(null == userQuery){
			result.setResult(false);
			data.put("msg", "user not exist!");
		}else{
			if(StringUtils.equals(password, userQuery.getPassword())){
				result.setResult(true);
				data.put("msg", userQuery);
			}else{
				result.setResult(false);
				data.put("msg", "password not correct!");
			}
		}
		
		result.setMsg(data);
		return result;
	}
}
