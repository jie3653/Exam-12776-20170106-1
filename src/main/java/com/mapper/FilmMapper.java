package com.mapper;

import java.util.List;

import com.pojo.Film;

public interface FilmMapper {
	List<Film> selectFilms(Film film);
}