package com.wheebox.ils.controller.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.ContentCachingRequestWrapper;

public class HttpServletRequestUtil {
	public static String getMethod(final HttpServletRequest httpServletRequest) {
	    if (httpServletRequest == null) {
	      return null;
	    }

	    return httpServletRequest.getMethod();
	  }
	public static String getFullUrl(final ContentCachingRequestWrapper httpServletRequest) {
	    if (httpServletRequest == null) {
	      return null;
	    }

	    StringBuilder requestUrl = new StringBuilder(httpServletRequest.getRequestURL().toString());
	    String queryString = httpServletRequest.getQueryString();

	    if (queryString == null) {
	      return requestUrl.toString();
	    }
	    return requestUrl.append('?').append(queryString).toString();
	  }
	public static String getFullUrl(final HttpServletRequest httpServletRequest) {
	    if (httpServletRequest == null) {
	      return null;
	    }

	    StringBuilder requestUrl = new StringBuilder(httpServletRequest.getRequestURL().toString());
	    String queryString = httpServletRequest.getQueryString();

	    if (queryString == null) {
	      return requestUrl.toString();
	    }
	    return requestUrl.append('?').append(queryString).toString();
	  }

	
}
