package com.how2java.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * 页面控制器
 */
@Controller
public class AdminPageController {

    //return 连接页面路径

	//后台登录界面
	@GetMapping(value="/login")
	public String loginBack(){
		return "admin/loginAdmin";
	}


	//管理员界面
	@GetMapping(value="/homeCommon")
	public String indexCommon(){
		return "admin/indexCommon";
	}


	//超管首页
	@GetMapping(value="/home")
	public String index(){
		return "admin/index";
	}


	//欢迎界面
	@GetMapping(value="/welcome")
	public String welcome(){
		return "admin/welcome";
	}
	//公司概况
	@GetMapping(value="/admin_companySummary_list")
	public String companySummaryList(){
		return "admin/companySummaryList";
	}

	@GetMapping(value="/admin_companySummary_edit")
	public String companySummaryEdit(){
		return "admin/companySummaryEdit";
	}


	//公司文化
	@GetMapping(value="/admin_companyCulture_list")
	public String companyCultureList(){
		return "admin/companyCultureList";
	}

	@GetMapping(value="/admin_companyCulture_edit")
	public String companyCultureEdit(){
		return "admin/companyCultureEdit";
	}



	//行业资讯
	@GetMapping(value="/admin_line_list")
	public String lineList(){
		return "admin/lineList";
	}

	@GetMapping(value="/admin_line_add")
	public String lineAdd(){
		return "admin/lineAdd";
	}

	@GetMapping(value="/admin_line_edit")
	public String lineEdit(){
		return "admin/lineEdit";
	}

	//新闻展示
	@GetMapping(value="/admin_new_list")
	public String newsList(){
		return "admin/newList";
	}

	@GetMapping(value="/admin_new_add")
	public String newsAdd(){
		return "admin/newAdd";
	}

	@GetMapping(value="/admin_new_edit")
	public String newsEdit(){
		return "admin/newEdit";
	}


	//招聘信息
	@GetMapping(value="/admin_recruit_list")
	public String recruitList(){
		return "admin/recruitList";
	}

	@GetMapping(value="/admin_recruit_add")
	public String recruitAdd(){
		return "admin/recruitAdd";
	}

	@GetMapping(value="/admin_recruit_edit")
	public String recruitEdit(){
		return "admin/recruitEdit";
	}


	//应聘信息
	@GetMapping(value="/admin_accept_list")
	public String acceptList(){
		return "admin/acceptList";
	}

	@GetMapping(value="/admin_accept_edit")
	public String acceptEdit(){
		return "admin/acceptEdit";
	}

	@GetMapping(value="/admin_accept_add")
	public String acceptAdd(){
		return "admin/acceptAdd";
	}



	//联系方式
	@GetMapping(value="/admin_contact_list")
	public String contactList(){
		return "admin/contactList";
	}


	//编辑联系方式
	@GetMapping(value="/admin_contact_edit")
	public String contactEdit(){
		return "admin/contactEdit";
	}


	//模块信息
	@GetMapping(value="/moudleList")
	public String moudletList(){
		return "admin/moudleList";
	}


	//------华丽的分割线

	/*@GetMapping(value="/admin")
	public String admin(){
		return "redirect:admin_category_list";
	}*/

	@GetMapping(value="/admin_category_list")
	public String listCategory(){
		return "admin/categoryList";
	}

	@GetMapping(value="/admin_category_add")
	public String categoryAdd(){
		return "admin/categoryAdd";
	}

	@GetMapping(value="/admin_category_edit")
	public String editCategory(){
		return "admin/categoryEdit";

	}

	@GetMapping(value="/admin_order_list")
	public String listOrder(){
		return "admin/orderList";

	}

	@GetMapping(value="/admin_product_list")
	public String listProduct(){
		return "admin/productList";

	}

	@GetMapping(value="/admin_product_edit")
	public String editProduct(){
		return "admin/productEdit";

	}
	@GetMapping(value="/admin_productImage_list")
	public String listProductImage(){
		return "admin/productImageList";

	}

	@GetMapping(value="/admin_property_list")
	public String listProperty(){
		return "admin/propertyList";

	}

	@GetMapping(value="/admin_property_edit")
	public String editProperty(){
		return "admin/propertyEdit";

	}

	@GetMapping(value="/admin_propertyValue_edit")
	public String editPropertyValue(){
		return "admin/propertyValueEdit";

	}

	 //用户模块
	@GetMapping(value="/admin_user_list")
	public String listUser(){
		return "admin/userList";

	}

	@GetMapping(value="/admin_user_edit")
	public String userEdit(){
		return "admin/userEdit";

	}

	@GetMapping(value="/admin_user_add")
	public String userAdd(){
		return "admin/userAdd";

	}


}
