package com.yang.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.yang.entity.BaseEvent;
import com.yang.entity.Group;
import com.yang.entity.Student;
import com.yang.entity.Teacher;
import com.yang.entity.TeacherType;

public class XMLDemo {

	// XML转换核心
	// 要想灵活地进行转换，需要在实体上使用到Jackson提供的四个注解
	// @JacksonXmlElementWrapper：可用于指定List等集合类，外围标签名
	// @JacksonXmlProperty：指定包装标签名，或者指定标签内部属性名
	// @JacksonXmlRootElement：指定生成XML根标签的名字
	// @JacksonXmlText：指定当前这个值，没有XML标签包裹

	@Test
	public void XMLTest() throws JsonProcessingException {

		final Logger logger = LogManager.getLogger();
		logger.info("hello boy");

		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.setDefaultUseWrapper(false);

		// 字段为null，自动忽略，不再序列化
		// xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		// 关于JsonInclude{url:https://blog.csdn.net/weixin_39793752/article/details/80946674}

		xmlMapper.setSerializationInclusion(Include.NON_NULL);

		// XML标签名:使用骆驼命名的属性名
		xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);

		// 设置转换模式
		xmlMapper.enable(MapperFeature.USE_STD_BEAN_NAMING);

		// 序列化 bean--->XML
		Group group = new Group(); // 忍者班级
		Teacher teacher = new Teacher();
		teacher.setTeacherTypeCode(new TeacherType("0", "严师"));
		teacher.setName("卡卡西");
		teacher.setAge("25");
		teacher.setGender("1");

		Student student1 = new Student();
		student1.setId("001"); // 学号
		student1.setName("鸣人");
		student1.setAge("18");
		student1.setGender("1");

		Student student2 = new Student();
		student2.setId("002"); // 学号
		student2.setName("佐助");
		student2.setAge("18");
		student2.setGender("1");

		Student student3 = new Student();
		student3.setId("003"); // 学号
		student3.setName("小樱");
		student3.setAge("18");
		student3.setGender("0");

		group.setTeacher(teacher);
		group.setStudent(Arrays.asList(student1, student2, student3));
		String result = xmlMapper.writeValueAsString(group);
		System.out.println("序列化结果：" + result);
	}

	// ======================微信公众号XML解析==================================================

	// 接受微信公众号信息
	// @RequestMapping(value = "/wx", method = RequestMethod.POST, produces =
	// MediaType.APPLICATION_XML_VALUE)
	// @ResponseBody
	public String messageService(HttpServletRequest request) throws IOException {
		char[] buf = new char[1024];
		int length;
		StringBuilder builder = new StringBuilder();
		InputStreamReader inputStreamReader = new InputStreamReader(request.getInputStream(), "utf-8");
		while ((length = inputStreamReader.read(buf)) != -1) {
			builder.append(new String(buf, 0, length));
		}
		inputStreamReader.close();
		System.out.println(builder);
		XmlMapper xmlMapper = new XmlMapper();
		// 忽略pojo中不存在的字段
		xmlMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
		BaseEvent baseEvent = xmlMapper.readValue(builder.toString(), BaseEvent.class);
		System.out.println(baseEvent);
		return "";
	}
}
