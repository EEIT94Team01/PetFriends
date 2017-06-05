package petfriends.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import petfriends.model.AdoptBean;
import petfriends.service.AdoptService;

@Controller
@RequestMapping("/adopt.controller")
public class AdoptController {
	@Autowired
	private AdoptService adoptService;

	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET})
	public String savePetInfo(@Valid AdoptBean adoptBean, BindingResult result, Model model) {
		Map<String, String> errors = new HashMap<String, String>();
		if (result.hasErrors()) {
			for (int i = 0; i < result.getErrorCount(); i++){
				errors.put(result.getFieldErrors().get(i).getField(), result.getFieldErrors().get(i).getDefaultMessage());
			}
			model.addAttribute("errors", errors);
			return "Adopt.error";
		}

		model.addAttribute("Adopt.success", adoptBean.getUserName() + "您好，您的紀錄已成功登記。");
		return "Adopt.success";
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
