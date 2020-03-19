package io.design.test01;

import com.github.tools.generators.docs.APIDocGenerator;

import test.test.services.UserService;


public class App_api 
{
	public static void main( String[] args )
    {
//		代码生成的默认路径为docs/API-User.md，提交到github
		APIDocGenerator apig = new APIDocGenerator();
		 
		try {
			//对应application.yml
			apig.createAPIDoc("http://127.0.0.1:12345", UserService.class);
			apig.write();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
