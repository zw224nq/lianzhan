package com.how2java.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ForePageController {


	@GetMapping(value="/test")
	public String test(){
		return "include/back/backNavigator";
	}

	@GetMapping(value="/footer")
	public String footer(){
		return "include/back/backFooter";
	}

	//前台首页
	@GetMapping(value="/")
	public String demo(){
		return "back/index";
	}
	//关于我们
	@GetMapping(value="/back_about")
	public String about(){
		return "back/about";
	}

	//新闻
	@GetMapping(value="/back_news")
	public String news(){
		return "back/news";
	}
	//新闻详情
	@GetMapping(value="/back_news_detail")
	public String news_detail(){
		return "back/news_detail";
	}

	//行业资讯
	@GetMapping(value="/back_lines")
	public String lines(){
		return "back/lines";
	}
	//行业资讯详情
	@GetMapping(value="/back_lines_detail")
	public String lines_detail(){
		return "back/lines_detail";
	}

	//冲压产品案例
	@GetMapping(value="/back_products")
	public String products(){
		return "back/products";
	}

	//钣金产品案例
	@GetMapping(value="/back_banJin")
	public String banJin(){
		return "back/productsTwo";
	}


	//企业文化
	@GetMapping(value="/back_culture")
	public String culture(){
		return "back/culture";
	}

     //联系我们
	@GetMapping(value="/back_contact")
	public String contact(){
		return "back/contact";
	}

     //招聘
	@GetMapping(value="/back_recruit")
	public String recruit(){
		return "back/join";
	}
	//应聘
	@GetMapping(value="/back_accept")
	public String accept(){
		return "back/join_test";
	}

	//
	@GetMapping(value="/back_product_list")
	public String listProduct(){
		return "back/banjin";

	}
	/*
	@GetMapping(value="/")
	public String index(){
		return "redirect:loginAdmin";
	}*/
	/*@GetMapping(value="/homeback")
	public String home(){
		return "fore/home";
	}

	@GetMapping(value="/homebacktest")
	public String hometest(){
		return "fore/hometest";
	}



	@GetMapping(value="/register")
	public String register(){
		return "fore/register";
	}
	@GetMapping(value="/alipay")
	public String alipay(){
		return "fore/alipay";
	}
	@GetMapping(value="/bought")
	public String bought(){
		return "fore/bought";
	}
	@GetMapping(value="/buy")
	public String buy(){
		return "fore/buy";
	}
	@GetMapping(value="/cart")
	public String cart(){
		return "fore/cart";
	}
	@GetMapping(value="/category")
	public String category(){
		return "fore/category";
	}
	@GetMapping(value="/confirmPay")
	public String confirmPay(){
		return "fore/confirmPay";
	}
	*//*@GetMapping(value="/login")
	public String login(){
		return "fore/login";
	}*//*
	@GetMapping(value="/orderConfirmed")
	public String orderConfirmed(){
		return "fore/orderConfirmed";
	}
	@GetMapping(value="/payed")
	public String payed(){
		return "fore/payed";
	}
	@GetMapping(value="/product")
	public String product(){
		return "fore/product";
	}
	@GetMapping(value="/registerSuccess")
	public String registerSuccess(){
		return "fore/registerSuccess";
	}
	@GetMapping(value="/review")
	public String review(){
		return "fore/review";
	}
	@GetMapping(value="/search")
	public String searchResult(){
		return "fore/search";
	}
*/

	@GetMapping("/forelogout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:login";
	}

}
