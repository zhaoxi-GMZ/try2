package io.design.test01;

import com.github.tools.generators.sqls.MyqlTableGenerator;

import test.test.models.User;

/**
 * Hello world!
 *
 */
public class App_sql 
{
	public static void main( String[] args )
    {
		MyqlTableGenerator sql;
		try {
			sql = new MyqlTableGenerator(
					"jdbc:mysql://127.0.0.1:3306/test",
					"com.mysql.cj.jdbc.Driver",
					"root", "root");
			sql.setDbName("mypoj");
			sql.createDatabase();
			sql.createTable(User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
    }
}
