package com.ktdsuniversity.edu.movie.service;

import java.util.List;

import com.ktdsuniversity.edu.movie.vo.MovieVO;

public interface MovieService {

    List<MovieVO> findAllMovies();

    boolean createNewMovie(MovieVO movieVO);
}