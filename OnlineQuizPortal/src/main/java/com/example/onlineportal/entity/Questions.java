package com.example.onlineportal.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quesid;

	private String ques;

	@OneToMany(mappedBy = "ques", cascade = { CascadeType.ALL })
	private Set<Answer> answers = new HashSet<>();

	public int getId() {
		return quesid;
	}

	public void setId(int id) {
		this.quesid = id;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	@Override
	public String toString() {
		return "Questions [id=" + quesid + ", ques=" + ques + ", answers=" + answers + "]";
	}

}
