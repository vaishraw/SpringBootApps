package com.example.userquiz.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ScoreCompares")
public class ScoreCompare {

	@Id
	private String uname;
	private int scorecard;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getScorecard() {
		return scorecard;
	}

	public void setScorecard(int scorecard) {
		this.scorecard = scorecard;
	}

	@Override
	public String toString() {
		return "ScoreCompare [uname=" + uname + ", scorecard=" + scorecard + "]";
	}

}
