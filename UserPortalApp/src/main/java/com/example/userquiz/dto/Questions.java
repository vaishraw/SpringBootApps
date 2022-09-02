package com.example.userquiz.dto;

import java.util.HashSet;
import java.util.Set;

public class Questions {

	private int quesid;
	private String ques;
	
	private Set<Answer> answers = new HashSet<>();
	
	

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public int getQuesid() {
		return quesid;
	}

	public void setQuesid(int quesid) {
		this.quesid = quesid;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	@Override
	public String toString() {
		return "Questions [quesid=" + quesid + ", ques=" + ques + ", answers=" + answers + "]";
	}

}
