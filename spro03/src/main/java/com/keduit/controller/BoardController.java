package com.keduit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keduit.domain.BoardVO;
import com.keduit.domain.Criteria;
import com.keduit.domain.PageDTO;
import com.keduit.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService service;

//   @GetMapping("/list")
//   public void list(Model model) {
//      log.info("------- BoardController list ------ " );
//      model.addAttribute("list", service.getList());
//   }

	@GetMapping("/list")
	public void list(Criteria cri, Model model) {

		log.info("BoardController------- list : " + cri);
		model.addAttribute("list", service.getList(cri));
//      model.addAttribute("pageMaker", new PageDTO(cri, 123));

		int total = service.getTotalCount(cri);
		log.info("BoardController=============total : " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {

		log.info(" BoardController------------ register -- " + board);
		Long bno = service.register(board);
		log.info("BoardController------------- bno ------- " + bno);

		rttr.addFlashAttribute("result", bno); // addFlashAttribute : 1회용(=도배방지용)

		return "redirect:/board/list";

	}

	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {

		log.info("/get or /modify");
		model.addAttribute("board", service.get(bno));
	}


	@GetMapping("/register")
	public void register() {

	}

	
	
	
	
	@PostMapping("/modify")
   public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
      
      log.info("---------- controller modify -----------" + board);
      
      if(service.modify(board)) {
         rttr.addFlashAttribute("result","success");
      }
      
      rttr.addAttribute("pageNum", cri.getPageNum());
      rttr.addAttribute("amount", cri.getAmount());
      return "redirect:/board/list";
   }

 @PostMapping("/remove") 
 public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
 
 log.info("---------- remove ----------" + bno); if(service.remove(bno)) {
  rttr.addFlashAttribute("result","success"); }
  
  rttr.addAttribute("pageNum", cri.getPageNum());
  rttr.addAttribute("amount", cri.getAmount());
  
 return "redirect:/board/list"; 
 
 }
 
		 
		  
		  
		  
 
}

 	/*
	 * ///////////////////////////////////////////
	 * 
	 * 
	 @PostMapping("/remove") public String remove(@RequestParam("bno") Long bno,
	  
	  @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
	 
	  log.info("---------- remove ----------" + bno); if(service.remove(bno)) {
	  rttr.addFlashAttribute("result","success"); }
	  
	  rttr.addAttribute("pageNum", cri.getPageNum()); rttr.addAttribute("amount",
	  
	  return "redirect:/board/list";
	  
	  }
	 */

/*
 * 
 * 
 * package com.keduit.controller;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.servlet.mvc.support.RedirectAttributes;
 * 
 * import com.keduit.domain.BoardVO; import com.keduit.domain.Criteria; import
 * com.keduit.domain.PageDTO; import com.keduit.service.BoardService;
 * 
 * import lombok.RequiredArgsConstructor; import lombok.extern.log4j.Log4j;
 * 
 * @Controller
 * 
 * @Log4j
 * 
 * @RequestMapping("/board/*")
 * 
 * @RequiredArgsConstructor public class BoardController {
 * 
 * private final BoardService service;
 * 
 * // @GetMapping("/list") // public void list(Model model) { //
 * log.info("------- BoardController list ------ " ); //
 * model.addAttribute("list", service.getList()); // }
 * 
 * @GetMapping("/list") public void list(Criteria cri, Model model) {
 * 
 * log.info("-------- list : " + cri); model.addAttribute("list",
 * service.getList(cri)); // model.addAttribute("pageMaker", new PageDTO(cri,
 * 123));
 * 
 * int total = service.getTotalCount(cri); log.info("--------- total : " +
 * total); model.addAttribute("pageMaker", new PageDTO(cri, total)); }
 * 
 * @GetMapping("/register") public void register() {
 * 
 * }
 * 
 * @PostMapping("/register") public String register(BoardVO board,
 * RedirectAttributes rttr) {
 * 
 * log.info(" ------------ register -- " + board); Long bno =
 * service.register(board); log.info("------------- bno ------- " + bno);
 * 
 * rttr.addFlashAttribute("result", bno); //addFlashAttribute : 1회용(=도배방지용)
 * 
 * return "redirect:/board/list";
 * 
 * }
 * 
 * @GetMapping({"/get","/modify"}) public void get(@RequestParam("bno") Long
 * bno, @ModelAttribute("cri") Criteria cri, Model model) {
 * 
 * log.info("/get or /modify"); model.addAttribute("board",service.get(bno)); }
 * 
 * 
 * }
 * 
 * }
 */