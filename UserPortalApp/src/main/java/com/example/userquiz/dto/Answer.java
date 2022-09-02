package com.example.userquiz.dto;

public class Answer {

	private int id;
	private String ans;
	private Questions ques;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public Questions getQues() {
		return ques;
	}

	public void setQues(Questions ques) {
		this.ques = ques;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", ans=" + ans + ", ques=" + ques + "]";
	}

}
