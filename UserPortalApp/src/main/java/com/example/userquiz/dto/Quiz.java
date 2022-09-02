package com.example.userquiz.dto;

public class Quiz {

	private int quizid;
	private String quizname;

	public int getQuizid() {
		return quizid;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

	public String getQuizname() {
		return quizname;
	}

	public void setQuizname(String quizname) {
		this.quizname = quizname;
	}

	@Override
	public String toString() {
		return "Quiz [quizid=" + quizid + ", quizname=" + quizname + "]";
	}

}
