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

	// XMLת������
	// Ҫ�����ؽ���ת������Ҫ��ʵ����ʹ�õ�Jackson�ṩ���ĸ�ע��
	// @JacksonXmlElementWrapper��������ָ��List�ȼ����࣬��Χ��ǩ��
	// @JacksonXmlProperty��ָ����װ��ǩ��������ָ����ǩ�ڲ�������
	// @JacksonXmlRootElement��ָ������XML����ǩ������
	// @JacksonXmlText��ָ����ǰ���ֵ��û��XML��ǩ����

	@Test
	public void XMLTest() throws JsonProcessingException {

		final Logger logger = LogManager.getLogger();
		logger.info("hello boy");

		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.setDefaultUseWrapper(false);

		// �ֶ�Ϊnull���Զ����ԣ��������л�
		// xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		// ����JsonInclude{url:https://blog.csdn.net/weixin_39793752/article/details/80946674}

		xmlMapper.setSerializationInclusion(Include.NON_NULL);

		// XML��ǩ��:ʹ������������������
		xmlMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);

		// ����ת��ģʽ
		xmlMapper.enable(MapperFeature.USE_STD_BEAN_NAMING);

		// ���л� bean--->XML
		Group group = new Group(); // ���߰༶
		Teacher teacher = new Teacher();
		teacher.setTeacherTypeCode(new TeacherType("0", "��ʦ"));
		teacher.setName("������");
		teacher.setAge("25");
		teacher.setGender("1");

		Student student1 = new Student();
		student1.setId("001"); // ѧ��
		student1.setName("����");
		student1.setAge("18");
		student1.setGender("1");

		Student student2 = new Student();
		student2.setId("002"); // ѧ��
		student2.setName("����");
		student2.setAge("18");
		student2.setGender("1");

		Student student3 = new Student();
		student3.setId("003"); // ѧ��
		student3.setName("Сӣ");
		student3.setAge("18");
		student3.setGender("0");

		group.setTeacher(teacher);
		group.setStudent(Arrays.asList(student1, student2, student3));
		String result = xmlMapper.writeValueAsString(group);
		System.out.println("���л������" + result);
	}

	// ======================΢�Ź��ں�XML����==================================================

	// ����΢�Ź��ں���Ϣ
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
		// ����pojo�в����ڵ��ֶ�
		xmlMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
		BaseEvent baseEvent = xmlMapper.readValue(builder.toString(), BaseEvent.class);
		System.out.println(baseEvent);
		return "";
	}
}
