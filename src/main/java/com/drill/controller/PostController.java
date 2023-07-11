package com.drill.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drill.domain.Post;
import com.drill.domain.User;
import com.drill.dto.ResUserDto;
import com.drill.svc.PostService;

@Controller
public class PostController {
	

	@Autowired
	private PostService postService;
	
	
	// 글쓰기 페이지
	@GetMapping("/write")
	public String write() {
		return "post/write";
	}
	
	@PostMapping("/write")
	public @ResponseBody ResUserDto<?> postWrite(@RequestBody Post post, HttpSession session) {
		User sid = (User)session.getAttribute("sid");
		post.setUser(sid);
		postService.write(post);
		return new ResUserDto<>(HttpStatus.OK.value(), "등록완료!");		
	}
	

	
	// 글목록
	@GetMapping("/list")
	public String postList(Model model) {
		model.addAttribute("postList", postService.getList());
		return "post/list";
	}

}