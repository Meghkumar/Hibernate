package com.tut.one_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answers {

	@Id
	@Column(name = "answer_id")
	private int answer_Id;
	private String answers;

	
	//This is basically for bidirection mapping	
	@OneToOne
	private Questions questions;

	public Answers() {
		super();
	
	}

	public Answers(int answer_Id, String answers, Questions questions) {
		super();
		this.answer_Id = answer_Id;
		this.answers = answers;
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Answers [answer_Id=" + answer_Id + ", answers=" + answers + ", questions=" + questions + "]";
	}

	public int getAnswer_Id() {
		return answer_Id;
	}

	public void setAnswer_Id(int answer_Id) {
		this.answer_Id = answer_Id;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

}
