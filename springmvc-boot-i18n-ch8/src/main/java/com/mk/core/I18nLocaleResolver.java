package com.mk.core;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

public class I18nLocaleResolver extends AcceptHeaderLocaleResolver {
	private Locale myLocal;

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		return myLocal == null ? request.getLocale() : myLocal;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		myLocal = locale;
	}
}