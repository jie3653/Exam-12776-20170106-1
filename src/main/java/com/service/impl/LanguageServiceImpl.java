package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.LanguageMapper;
import com.pojo.Language;
import com.pojo.LanguageExample;
@Service
public class LanguageServiceImpl implements LanguageService{
	@Autowired
	private LanguageMapper languageMapper;
	
	@Override
	public List<Language> selectByExample(LanguageExample example) {
		// TODO Auto-generated method stub
		return languageMapper.selectByExample(example);
	}

}
