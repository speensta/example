package com.board.example.controller;

import com.board.example.dto.Token;
import com.board.example.service.SecurityService;
import com.board.example.util.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);



	@Autowired
	private SecurityService securityService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response
			,@CookieValue(value="JWT_COOKIE", required=false) Cookie jwtcookie) {

		logger.info("Welcome home! The client locale is {}.", locale);

		String uuid = UUID.randomUUID().toString();

		Token token = new Token();
		token.setToken(uuid);
		token.setUserid("speensta");
		token.setIp(request.getRemoteAddr());

		HashMap map = new HashMap();

		if(jwtcookie == null) {
			String tokenCookie = securityService.createToken(token.getUserid(), (2 * 1000 * 60), map);
			CookieUtil.setCookie(response, tokenCookie);
		}

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		HttpSession session = request.getSession();
		try {
			UUID uid = Optional.ofNullable(UUID.class.cast(session.getAttribute("uid")))
					.orElse(UUID.randomUUID());
			session.setAttribute("uid", uid);

		} catch (Exception e) {

		}

		UUID uid2 = (UUID)session.getAttribute("uid");
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}


	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response
			,@CookieValue(value="JWT_COOKIE", required=false) Cookie jwtcookie) {

		logger.info("Welcome home! The client locale is {}.", locale);

		return "test";
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public void rabbitMq(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response
			,@CookieValue(value="JWT_COOKIE", required=false) Cookie jwtcookie) {

		logger.info("Welcome home! The client locale is {}.", locale);

		String uuid = UUID.randomUUID().toString();

		Token token = new Token();
		token.setToken(uuid);
		token.setUserid("speensta");
		token.setIp(request.getRemoteAddr());
//		rabbitTemplate.convertAndSend("sample.route.first", token);

		securityService.rabbitmq(token);

//		rabbitTemplate.convertAndSend(topicExchangeName, "sample.route.first", token.getToken());

//		ConnectionFactory factory = new ConnectionFactory();
//		factory.setHost("localhost");
//		factory.setPort(5672);
//		factory.setUsername("guest");
//		factory.setPassword("guest");
//		factory.setAutomaticRecoveryEnabled(true);
//		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
////			for (int i = 0; i <= 100000; i++) {
//////				channel.queueDeclare(queueName, false, false, false, null);
//////				String message = "Hello World!" + (int) (Math.random() * 100);
////////				channel.basicPublish(topicExchangeName, queueName, null, message.getBytes());
////////				System.out.println(" [x] Set '" + message + "'");
//////				DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//////					System.out.println(" [x] Received '" + message + "'");
//////				};
//////				channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
//////				Thread.sleep(10);
//////			}
//
//			channel.queueDeclare(queueName, false, false, false, null);
//			String message = "Hello World!" + (int) (Math.random() * 100);
//			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//				System.out.println(" [x] Received '" + message + "'");
//			};
//			channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });


	}


}
