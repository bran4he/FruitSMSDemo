package com.fruit.sales.sql;

import java.io.IOException;

public class Dump {

	public static void main(String[] args) {
		
		
		
		StringBuffer cmd = new StringBuffer("D:\\Progra~1\\MySQL\\MySQL Server 5.6\\bin\\mysqldump");
		
		cmd.append(" ").append(" -uroot -peBao1234 ebaodemo > ");
		
		String folder = "C:\\Users\\brandon.he\\git\\FruitSMSDemo\\src\\main\\webapp\\WEB-INF\\sql\\dump\\";
		cmd.append(folder).append(System.currentTimeMillis()).append(".dump");
		
		System.out.println(cmd.toString());
		Runtime runtime=Runtime.getRuntime();
		
		try {
			runtime.exec(cmd.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println(Dump.class.getResource("."));
//		System.out.println(Dump.class.getResource("/"));
	}
}
