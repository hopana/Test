package model;

import java.util.List;

public class QuestionModel {
	Integer no;
	String Content;
	
	List<OptionModel> list;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public List<OptionModel> getList() {
		return list;
	}

	public void setList(List<OptionModel> list) {
		this.list = list;
	}
	
}
