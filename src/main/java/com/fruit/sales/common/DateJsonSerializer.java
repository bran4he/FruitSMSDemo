package com.fruit.sales.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateJsonSerializer extends JsonSerializer<Date>{

	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {
//		System.out.println(date);
		jsonGenerator.writeString(format.format(date));
		
	}

}
