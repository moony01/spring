package member.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.service.MemberService;

@Controller
@RequestMapping(value="member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public @ResponseBody String login(@RequestParam String id, 
			                          @RequestParam String pwd,
			                          HttpSession session) {
		MemberDTO memberDTO = memberService.login(id, pwd);
		
		String loginResult=null;
		if(memberDTO==null)
			loginResult = "fail";
		
		else {
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", id);
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			
			loginResult = "success";
		}
			
		return loginResult;
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.invalidate();//무효화
		return new ModelAndView("redirect:/main/index");
	}
	
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public String writeForm(Model model) {
		model.addAttribute("display", "/member/writeForm.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(@ModelAttribute MemberDTO memberDTO, Model model) {
		System.out.println("aaa");
		memberService.write(memberDTO);
		
		model.addAttribute("display", "/member/write.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="checkId", method=RequestMethod.POST)
	@ResponseBody
	public String checkid(@RequestParam String id, Model model) {
		MemberDTO memberDTO = memberService.checkId(id);
		
		if(memberDTO==null)
			return "not_exist";
		else
			return "exist";
	}
	
	@RequestMapping(value="checkPost", method=RequestMethod.GET)
	public String checkPost() {
		return "/member/checkPost";
	}
	
	@RequestMapping(value="postSearch", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView postSearch(@RequestParam Map<String, String> map) {
		List<ZipcodeDTO> list = memberService.postSearch(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="modifyForm", method=RequestMethod.GET)
	public String modifyForm(Model model) {
		model.addAttribute("display", "/member/modifyForm.jsp");
		return "/main/index";
	}
	
	
	
	
	
}
















