package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Film;
import com.pojo.Language;
import com.pojo.LanguageExample;
import com.service.FilmService;
import com.service.impl.LanguageService;
import com.util.PageUtil;

@Controller
public class FilmController {
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private LanguageService languageService;
	
	/**
	 * film查询方法
	 * @param filmId
	 * @param title
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	
	@RequestMapping(value="/queryFilms",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public PageUtil<Film> queryFilms(@RequestParam(value = "filmId",defaultValue = "") Short filmId,
						@RequestParam(value = "title",defaultValue = "")String title,
			 			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			 			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		
		System.out.println("查询Film");
		PageHelper.startPage(currentPage,pageSize);
		
		Film film = new Film();
		film.setFilmId(filmId);
		film.setTitle(title);
		List<Film> films = filmService.selectFilms(film);
		PageInfo<Film> info = new PageInfo<>(films);
		
		PageUtil<Film> page = new PageUtil<Film>();
		page.setData(films);
		page.setCurrentPage(currentPage);
		page.setPageCount(info.getPages());
		page.setPageSize(info.getPageSize());
		page.setTotal(info.getTotal());
		
		for(Film f:films){
		System.out.println(f.getFilmId()+f.getTitle()+f.getDescription()+f.getLanguage());
		}
		return page;	
	}
	
	
	@RequestMapping(value="/queryLanguage",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public List<Language> selectLanguage(){
	List<Language> list;
	LanguageExample e = new LanguageExample();
	list = languageService.selectByExample(e);
	for(Language l:list){
		System.out.println(l.getName());
		}
	return list;
	}
}
