package io.design.test01;

import com.github.tools.generators.codes.ServiceGenerator;

import test.test.mappers.UserMapper;


public class App_sql_service 
{
	public static void main( String[] args )
    {
		ServiceGenerator sg = new ServiceGenerator();
		try {
			sg.createServiceFromMapper(UserMapper.class);
			sg.write();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
}
