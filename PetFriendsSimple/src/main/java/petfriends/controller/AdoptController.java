package petfriends.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import petfriends.model.AdoptBean;
import petfriends.service.AdoptService;

@Controller
@RequestMapping("/")
public class AdoptController {
	@Autowired
	private AdoptService adoptService;
	@InitBinder
	protected void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(String.class,new StringTrimmerEditor(true));
		CustomDateEditor customerDateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		webDataBinder.registerCustomEditor(java.util.Date.class, customerDateEditor);
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
		AdoptBean adoptBean = new AdoptBean();
        model.addAttribute("adoptBean", adoptBean);
        return "index";
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public String savePetInfo(@Valid AdoptBean adoptBean, BindingResult result, ModelMap model) {
		System.out.println(adoptBean.toString());
		
		if (result.hasErrors()) {
			return "index";
		}
			
		if(!result.hasErrors()){
			AdoptBean resultBean = adoptService.insert(adoptBean);
			if(resultBean==null) {
				model.addAttribute("action", "Insert失敗");
			} else {
				model.addAttribute("Adopt.success", resultBean.getUserName() + "您好，您的寵物紀錄已成功登記。");
				return "view";
			}
			return "index";
			}
		
		return "index";
	}
	/*
	@ModelAttribute("city")
	public List<String> initCity() {
		List<String> city = new ArrayList<String>();
		String[] cityStr = { "臺北市", "新北市", "桃園市", "臺中市", "臺南市", "高雄市", "基隆市", "新竹市", "嘉義市", "新竹縣", "苗栗縣", "彰化縣", "南投縣",
				"雲林縣", "嘉義縣", "屏東縣", "宜蘭縣", "花蓮縣", "臺東縣", "澎湖縣" };
		for (int i = 0; i <= cityStr.length; i++) {
			city.add(cityStr[i]);
		}
		return city;
	}

	@ModelAttribute("type")
	public List<String> initPetType() {
		List<String> type = new ArrayList<String>();
		String[] typeStr = { "狗狗","貓咪","兔子","鳥類","鼠類","烏龜","其他" };
		for (int i = 0; i <= typeStr.length; i++) {
			type.add(typeStr[i]);
		}
		return type;
	}
	
	@ModelAttribute("sex")
	public List<String> initPetSex() {
		List<String> sex = new ArrayList<String>();
		String[] sexStr = { "未知","男","女" };
		for (int i = 0; i <= sexStr.length; i++) {
			sex.add(sexStr[i]);
		}
		return sex;
	}*/
}
