package com.yang.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "xml")
public class BaseEvent {

	@JacksonXmlProperty(localName = "ToUserName")
	private String ToUserName;// 开发者微信号

	@JacksonXmlProperty(localName = "FromUserName")
	private String FromUserName;// 发送方帐号（一个OpenID）

	@JacksonXmlProperty(localName = "Content")
	private String Content;

	@JacksonXmlProperty(localName = "CreateTime")
	private long CreateTime;// 消息创建时间 （整型）

	@JacksonXmlProperty(localName = "MsgType")
	private String MsgType;// 消息类型，event

	@JacksonXmlProperty(localName = "MsgId")
	private String MsgId;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	@Override
	public String toString() {
		return "BaseEvent{" + "ToUserName='" + ToUserName + '\'' + ", FromUserName='" + FromUserName + '\''
				+ ", Content='" + Content + '\'' + ", CreateTime=" + CreateTime + ", MsgType='" + MsgType + '\'' + '}';
	}

}
