package com.tut.one_one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Questions {

	@Id
	@Column(name = "question_id")
	private int question_id;
	private String questions;
	
	@OneToOne(mappedBy = "questions",fetch = FetchType.EAGER)
	@JoinColumn(name = "ans_id")
	private Answers answers;

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Questions(int quesrtion_id, String questions, Answers answers) {
		super();
		this.question_id = quesrtion_id;
		this.questions = questions;
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Questions [quesrtion_id=" + question_id + ", questions=" + questions + ", answers=" + answers + "]";
	}

	public int getQuesrtion_id() {
		return question_id;
	}

	public void setQuesrtion_id(int quesrtion_id) {
		this.question_id = quesrtion_id;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public Answers getAnswers() {
		return answers;
	}

	public void setAnswers(Answers answers) {
		this.answers = answers;
	}

}
