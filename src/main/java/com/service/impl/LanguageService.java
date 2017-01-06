package com.service.impl;

import java.util.List;

import com.pojo.Language;
import com.pojo.LanguageExample;

public interface LanguageService {
	List<Language> selectByExample(LanguageExample example);
}
