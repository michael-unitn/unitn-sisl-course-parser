package it.unitn.sisl.t4e.pojos;

import java.util.List;

public class Question {
	private String questionId;
	private String questionText;
	private List<Answer> answers;
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
		return copiedQuestion;
	}
}
