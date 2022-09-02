package com.example.userquiz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuizPage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pageid;
	private int quizid;
	private int quesid;

	public int getPageid() {
		return pageid;
	}

	public void setPageid(int pageid) {
		this.pageid = pageid;
	}

	public int getQuizid() {
		return quizid;
	}

	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}

	public int getQuesid() {
		return quesid;
	}

	public void setQuesid(int quesid) {
		this.quesid = quesid;
	}

	@Override
	public String toString() {
		return "QuizPage [pageid=" + pageid + ", quizid=" + quizid + ", quesid=" + quesid + "]";
	}

}
