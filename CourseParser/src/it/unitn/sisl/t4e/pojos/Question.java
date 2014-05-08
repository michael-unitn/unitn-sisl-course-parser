package it.unitn.sisl.t4e.pojos;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private String questionId;
	private String questionText = "";
	private List<Answer> answers;
	private List<String> tokens = new ArrayList<String>();
	private List<String> sentences = new ArrayList<String>();
	
	public List<String> getTokens() {
		return tokens;
	}
	public void setTokens(List<String> tokens) {
		this.tokens = tokens;
	}
	public List<String> getSentences() {
		return sentences;
	}
	public void setSentences(List<String> sentences) {
		this.sentences = sentences;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public static Question copy(Question question){
		if(question == null){
			return question;
		}
		if(!(question instanceof Question)){
			return null;
		}
		Question copiedQuestion = new Question();
		copiedQuestion.setQuestionId(question.getQuestionId());
		copiedQuestion.setQuestionText(question.getQuestionText());
		copiedQuestion.setAnswers(question.getAnswers());
		copiedQuestion.setSentences(question.getSentences());
		copiedQuestion.setTokens(question.getTokens());
		return copiedQuestion;
	}
}
