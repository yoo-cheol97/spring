package com.ktdsuniversity.edu.movie.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ktdsuniversity.edu.movie.vo.MovieVO;

@Mapper
public interface MovieDao {

    List<MovieVO> selectMovieList();

    int insertMovie(MovieVO movieVO);
}