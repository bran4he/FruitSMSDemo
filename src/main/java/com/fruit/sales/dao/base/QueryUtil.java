package com.fruit.sales.dao.base;

import javax.servlet.http.HttpServletRequest;

public class QueryUtil {

	private static final String QUERY_PAGE = "page";
	private static final String QUERY_ROWS = "rows";
	private static final String QUERY_SIDX = "sidx";
	private static final String QUERY_SORD = "sord";
	
	public static QueryParam getQueryParam(HttpServletRequest request){
		QueryParam param = new QueryParam();
		param.setPage(Integer.valueOf((String) request.getParameter(QUERY_PAGE)));
		param.setRows(Integer.valueOf((String) request.getParameter(QUERY_ROWS)));
		param.setSidx(request.getParameter(QUERY_SIDX));
		param.setSord(request.getParameter(QUERY_SORD));
		return param;
	}
	
	
}
