package com.service;

import java.util.List;

import com.pojo.Film;

public interface FilmService {
	List<Film> selectFilms(Film film);
}
