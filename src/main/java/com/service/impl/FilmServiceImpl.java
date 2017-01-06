package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.FilmMapper;
import com.pojo.Film;
import com.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService{
	@Autowired
	private FilmMapper filmMapper;
	@Override
	public List<Film> selectFilms(Film film) {
		// TODO Auto-generated method stub
		return filmMapper.selectFilms(film);
	}

}
