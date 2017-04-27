package com.fruit.sales.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateJsonDeserializer extends JsonDeserializer<Date>{

    private static final Logger logger = LoggerFactory.getLogger(DateJsonDeserializer.class);

    private static final String FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    private static final String FORMAT_STR_SIMPLE = "yyyy-MM-dd";

	private SimpleDateFormat format = new SimpleDateFormat(FORMAT_STR);

	private SimpleDateFormat formatSimple = new SimpleDateFormat(FORMAT_STR_SIMPLE);

	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		try {
		    String dateStr = jsonParser.getText();
			//如果前端传递为空则置为当前时间
			if(StringUtils.isEmpty(dateStr)) {
				return new Date();
			}else {
			    if(FORMAT_STR.length() == dateStr.length()) {
			        return format.parse(dateStr);
                }else if (FORMAT_STR_SIMPLE.length() == dateStr.length()){
			        return  formatSimple.parse(dateStr);
                }
                logger.warn("cannot parse:{} to Date type!", dateStr);
				return new Date();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
