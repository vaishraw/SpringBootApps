package com.example.onlineportal.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ans;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ques_id", referencedColumnName = "quesid")
	private Questions ques;

	public Answer() {
		super();

	}

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
