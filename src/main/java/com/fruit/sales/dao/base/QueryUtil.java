package com.fruit.sales.dao.base;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryUtil {

	private static final Logger logger = LoggerFactory.getLogger(QueryUtil.class);
	
	private static final String QUERY_PAGE = "page";
	private static final String QUERY_ROWS = "rows";
	private static final String QUERY_SIDX = "sidx";
	private static final String QUERY_SORD = "sord";
	private static final String SEARCH_FLAG = "_search";
	private static final String QUERY_ND = "nd";
	
	public static QueryParam getQueryParam(HttpServletRequest request){
		QueryParam param = new QueryParam();
		param.setPage(Integer.valueOf((String) request.getParameter(QUERY_PAGE)));
		param.setRows(Integer.valueOf((String) request.getParameter(QUERY_ROWS)));
		param.setSidx(request.getParameter(QUERY_SIDX));
		param.setSord(request.getParameter(QUERY_SORD));
		
		String seachFlag = request.getParameter(SEARCH_FLAG);
		param.set_search(seachFlag);
		
		Map<String, String> searchMap = new HashMap<String, String>();
		if(StringUtils.equalsIgnoreCase(seachFlag, "true")){
			Map<String, String[]> reqMap = request.getParameterMap();
			
			searchMap = reqMap.entrySet().stream().filter(set -> 
				!StringUtils.equalsAnyIgnoreCase(set.getKey(), QUERY_PAGE, QUERY_ROWS, QUERY_SIDX, QUERY_SORD, SEARCH_FLAG, QUERY_ND)
						&& StringUtils.isNotEmpty(set.getValue()[0])
			).collect(Collectors.toMap(
					e -> e.getKey(),
					e -> String.valueOf(e.getValue()[0])
		        ));;
		   
		}
		param.setSearchMap(searchMap);
		/*
		 * http://localhost:8080/fruit/order/list?
		 * _search=true&
		 * nd=1491553063279&
		 * rows=10&
		 * page=1&
		 * sidx=id&
		 * sord=desc&
		 * statusId=2
		 */
		
		logger.info("getQueryParam : {}", param.toString());
		
		return param;
	}
	
	
}
