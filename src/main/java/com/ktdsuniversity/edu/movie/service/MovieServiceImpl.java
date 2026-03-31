package com.ktdsuniversity.edu.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.movie.dao.MovieDao;
import com.ktdsuniversity.edu.movie.vo.MovieVO;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<MovieVO> findAllMovies() {
        List<MovieVO> movieList = this.movieDao.selectMovieList();
        return movieList;
    }

    @Override
    public boolean createNewMovie(MovieVO movieVO) {
        int insertCount = this.movieDao.insertMovie(movieVO);
        return insertCount == 1;
    }
}