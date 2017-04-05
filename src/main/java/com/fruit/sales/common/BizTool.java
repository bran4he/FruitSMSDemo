package com.fruit.sales.common;

import com.fruit.sales.entity.AssignDetail;

public class BizTool {

	public static String genAssRemarkFromAD(AssignDetail ad){
		StringBuffer sb = new StringBuffer("remark:");
		
		sb.append("m_phone:").append(ad.getMasterPhone());
		sb.append("m_name:").append(ad.getMasterName());
		sb.append("s_phone:").append(ad.getSlavePhone());
		sb.append("s_name:").append(ad.getSlaveName());
		sb.append("remark:").append(ad.getRemark());
		
		return sb.toString();
	}
}
