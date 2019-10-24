package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.service.BoardService;

@Controller
@RequestMapping(value="board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardPaging boardPaging;
	
	@RequestMapping(value="boardWriteForm", method=RequestMethod.GET)
	public String boardWriteForm(Model model) {
		model.addAttribute("display","/board/boardWriteForm.jsp");
		return "/main/index";
	}
	
	
	@RequestMapping(value="boardWrite", method=RequestMethod.POST)
	@ResponseBody
	public void boardWrite(@RequestParam Map<String,String> map, HttpSession session) {
		System.out.println("test");
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		
		boardService.boardWrite(map);		
	}
	
	@RequestMapping(value="boardList", method=RequestMethod.GET)
	public String boardList(@RequestParam(required=false, defaultValue="1") String pg,
							Model model) {
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/board/boardList.jsp");
		return "/main/index";
	}
	
	@RequestMapping(value="getBoardList", method=RequestMethod.POST)
	public ModelAndView getBoardList(@RequestParam(required=false, defaultValue="1") String pg,
									 HttpSession session) {
		
		String memId = (String)session.getAttribute("memId");
		
		//1페이지당 5개씩
		int endNum = Integer.parseInt(pg)*5;
		int startNum = endNum-4;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<BoardDTO> list = boardService.getBoardList(map);
		
		//페이징처리
		int totalA = boardService.getTotalA();//총글수
		boardPaging.setCurrentPage(Integer.parseInt(pg));
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memId", memId);
		mav.addObject("list", list);
		mav.addObject("boardPaging", boardPaging);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="boardView", method=RequestMethod.GET)
	public String boardView(@RequestParam String seq,
							@RequestParam String pg,
							Model model) {
		//BoardDTO boardDTO = boardService.getBoard(Integer.parseInt(seq));
		model.addAttribute("seq", seq);
		model.addAttribute("pg", pg);
		//model.addAttribute("boardDTO", boardDTO);
		model.addAttribute("display", "/board/boardView.jsp");
		
		return "/main/index";
	}
	
	@RequestMapping(value="getBoard", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getBoard(@RequestParam int seq) {
		System.out.println("seq = "+seq);
		BoardDTO boardDTO = boardService.getBoard(seq);
		System.out.println("boardDTO = " +boardDTO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardDTO", boardDTO);
		mav.setViewName("jsonView");
		return mav;
	}
	
}










