package io.design.test01;

import com.github.tools.generators.docs.SqlDocGenerator;

public class App_sql_docs 
{
	public static void main( String[] args )
    {
		SqlDocGenerator wg = new SqlDocGenerator();
		try {
			wg.createSqlDoc("test.test.models.User");
			wg.print();
			wg.write();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
