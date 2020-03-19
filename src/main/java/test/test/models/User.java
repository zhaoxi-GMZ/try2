/**
 * Copyrigt (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package test.test.models;
//validation校验，可以查看validation官网或别的资料去了解它的用法
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.AutoIncrement;
import com.github.tools.annotations.mysql.DefaultValue;
import com.github.tools.annotations.mysql.JavaBean;
import com.github.tools.annotations.mysql.NotNull;
import com.github.tools.annotations.mysql.PrivateKey;

/*必须有JavaBean的注解
 * 每一个成员变量都必须有FieldDescriber注解，用于生成文档
 * 每一个成员变量至少有一个注解（com.github.tools.annotations.mysql目录下），用于生成SQL中的元素
 * 每一个成员变量可以有长度约束，当前仅仅支持整型和字符串类型（javax.validation.constraints目录下），用于生成SQL语句中的长度约束
 * 每一个成员变量应该有一个Reqired变量（没有默认表示该参数是前端请求的必填项）
 * */

//实体类必须要有JavaBean注解
@JavaBean
public class User {

	@PrivateKey//私钥？
	@AutoIncrement//数据库id自增长？
	
//	每一个成员变量都必须有FieldDescriber注解，用于生成文档
	@FieldDescriber("用户的ID")
	private int id;

	@NotNull
	@Size(min = 10, max = 20, message = "{user.name.length.illegal}") 
	
	@FieldDescriber("用户名")
//	每一个成员变量应该有一个Reqired变量（没有默认表示该参数是前端请求的必填项）
	@Required(true)
	private String name;

	@Size(min = 8, max = 20)
	@NotNull
	@FieldDescriber("用户密码")
	private String pwd;

	@DefaultValue("11")
	@Min(8)
	@Max(100)
	
	@FieldDescriber("用户年龄")
	private int age;

	@DefaultValue("baseball")
	@Size(max = 200)
	
	@FieldDescriber("用户爱好")
	@Required(false)
	private String habits;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHabits() {
		return habits;
	}

	public void setHabits(String habits) {
		this.habits = habits;
	}

}