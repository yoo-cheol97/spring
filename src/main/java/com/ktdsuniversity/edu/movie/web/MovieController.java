package com.ktdsuniversity.edu.movie.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ktdsuniversity.edu.movie.service.MovieService;
import com.ktdsuniversity.edu.movie.vo.MovieVO;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/listM")
	public String movieList(Model model) {
		model.addAttribute("movie", movieService.findAllMovies());
		return "movie/list";
	}

	@GetMapping("/writeM")
	public String writePage() {
		return "movie/write";
	}

	@PostMapping("/writeM")
	public String doWrite(MovieVO movieVO) {
		movieService.createNewMovie(movieVO);
		return "redirect:/list";
	}

}