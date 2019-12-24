package com.yang.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.entity.User;

//@author KRY Alt + Shift + J 文档注释
//Ctrl + Alt + ↑/↓ 复 制当前行
//Alt + ↑/↓ 移动当前行
//Ctrl + / 单行注释 
//Ctrl + D 删除当前行 
//Ctrl + 1 quick fix

public class JsonDemo {

	// 带注解反序列化 <序列化结果逆过程>
	// json数据中含有忽略属性(\"age\":20,可带可不带)
	// bean中email属性需变为my_email

	public void deSerialize2() {
		String jsonData = "{\"name\":\"yang\"," + "\"age\":20," + "\"birthday\":\"1996年6月5日\","
				+ "\"my_email\":\"zhangsan@163.com\"}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			User user = mapper.readValue(jsonData, User.class);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deSerialize() {

		String jsonData = "{\"name\":\"zhangsan\",\"age\":20,\"birthday\":844099200000,\"email\":\"zhangsan@163.com\"}";
		String jsonData2 = "[{\"name\":\"zhangsan\",\"age\":20,\"birthday\":844099200000,\"email\":\"zhangsan@163.com\"},"
				+ "{\"name\":\"zhangsan2\",\"age\":22,\"birthday\":844099200000,\"email\":\"zhangsan2@163.com\"}]";
		ObjectMapper mapper = new ObjectMapper();

		try {
			User user = mapper.readValue(jsonData, User.class);
			System.out.println(user);
			List<User> users = mapper.readValue(jsonData2, new TypeReference<List<User>>() {
			});
			for (User user2 : users) {
				System.out.println(user2);
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void serialize() throws ParseException, IOException {
		User user = new User();
		user.setName("zhangsan");
		user.setEmail("zhangsan@163.com");
		user.setAge(20);

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		user.setBirthday(dateformat.parse("1996-10-01"));

		/**
		 * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
		 * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
		 * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
		 * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
		 * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
		 * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
		 */
		ObjectMapper mapper = new ObjectMapper();

		// User类转JSON
		// {"name":"zhangsan","birthday":"1996年09月30日","my_email":"zhangsan@163.com"}
		String json = mapper.writeValueAsString(user);
		System.out.println(json);

		// Java集合转JSON
		// [{"name":"zhangsan","birthday":"1996年09月30日","my_email":"zhangsan@163.com"}]
		List<User> users = new ArrayList<User>();
		users.add(user);

		String jsonlist = mapper.writeValueAsString(users);
		System.out.println(jsonlist);
	}

}
