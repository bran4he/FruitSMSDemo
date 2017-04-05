package com.fruit.sales.common;


public class BusinessConstant {

	public static final String MAX_ORDER_TO_DAY = "ORDER_DAY_TO";
	public static final String MAX_TEST_PARAM = "TEST_PARAM";
	
	//in assign and assgin detail, salve phone no is or not virtual
	public static final Integer IS_VIRTUAL = new Integer(1);
	public static final Integer NOT_VIRTUAL = new Integer(0);
	
	
	//assign is active or not
	public static final Integer NOT_ACTIVE = new Integer(0);
	public static final Integer IS_ACTIVE = new Integer(1);
	
	
	//default weechat openid for inital setup
	public static final String DEFAULT_WEECHAT_ID = "NA";
	
	//default effective period
	public static final Integer ASSIGN_DEF_EFF_PERIOD = new Integer(1);
	
	
	//weechat user order and return value, align with weechat back-end
	public static final String USER_ORDER_SUCCESS = new String("0");
	public static final String USER_NOT_AUTH = new String("1");
	public static final String BALANCE_NOT_ENOUGH = new String("2");
	public static final String EXCEED_MAX_ORDER_LIMIT = new String("3");
	public static final String EXCEED_MAX_ORDER_DATE = new String("4");
	public static final String EXCEED_ASSIGN_BALANCE_UNIT = new String("5");
	public static final String EXCEED_FRUIT_BALANCE = new String("6");
	
	
	
}
