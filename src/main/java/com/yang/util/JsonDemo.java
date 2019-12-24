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

//@author KRY Alt + Shift + J �ĵ�ע��
//Ctrl + Alt + ��/�� �� �Ƶ�ǰ��
//Alt + ��/�� �ƶ���ǰ��
//Ctrl + / ����ע�� 
//Ctrl + D ɾ����ǰ�� 
//Ctrl + 1 quick fix

public class JsonDemo {

	// ��ע�ⷴ���л� <���л���������>
	// json�����к��к�������(\"age\":20,�ɴ��ɲ���)
	// bean��email�������Ϊmy_email

	public void deSerialize2() {
		String jsonData = "{\"name\":\"yang\"," + "\"age\":20," + "\"birthday\":\"1996��6��5��\","
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
		 * ObjectMapper��JSON�����ĺ��ģ�Jackson������JSON����������ObjectMapper��ʵ�֡�
		 * ObjectMapper�ж��JSON���л��ķ��������԰�JSON�ַ�������File��OutputStream�Ȳ�ͬ�Ľ����С�
		 * writeValue(File arg0, Object arg1)��arg1ת��json���У������浽arg0�ļ��С�
		 * writeValue(OutputStream arg0, Object arg1)��arg1ת��json���У������浽arg0������С�
		 * writeValueAsBytes(Object arg0)��arg0ת��json���У����ѽ��������ֽ����顣
		 * writeValueAsString(Object arg0)��arg0ת��json���У����ѽ��������ַ�����
		 */
		ObjectMapper mapper = new ObjectMapper();

		// User��תJSON
		// {"name":"zhangsan","birthday":"1996��09��30��","my_email":"zhangsan@163.com"}
		String json = mapper.writeValueAsString(user);
		System.out.println(json);

		// Java����תJSON
		// [{"name":"zhangsan","birthday":"1996��09��30��","my_email":"zhangsan@163.com"}]
		List<User> users = new ArrayList<User>();
		users.add(user);

		String jsonlist = mapper.writeValueAsString(users);
		System.out.println(jsonlist);
	}

}
