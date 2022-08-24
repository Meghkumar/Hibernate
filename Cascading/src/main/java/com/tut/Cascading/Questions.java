package com.tut.Cascading;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Questions {

	@Id
	@Column(name = "question_id")
	private int question_id;
	private String questions;

	
	//Cascading used so need to save all answers seperately
	@OneToMany(mappedBy = "questions",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Answers> answers;

	public Questions() {
		super();
		
	}

	public Questions(int question_id, String questions, List<Answers> answers) {
		super();
		this.question_id = question_id;
		this.questions = questions;
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Questions [question_id=" + question_id + ", questions=" + questions + ", answers=" + answers + "]";
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}

}
