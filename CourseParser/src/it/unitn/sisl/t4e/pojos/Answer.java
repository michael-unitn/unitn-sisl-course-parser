package it.unitn.sisl.t4e.pojos;

import java.util.ArrayList;
import java.util.List;

public class Answer {
	private String answerId;
	private String answerText;
	private int numVotes;
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
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public int getNumVotes() {
		return numVotes;
	}
	public void setNumVotes(int numVotes) {
		this.numVotes = numVotes;
	}
	
	public static Answer copy(Answer answer){
		if(answer == null){
			return answer;
		}
		if(!(answer instanceof Answer)){
			return null;
		}
		Answer copiedAnswer = new Answer();
		copiedAnswer.setAnswerId(answer.getAnswerId());
		copiedAnswer.setAnswerText(answer.getAnswerText());
		copiedAnswer.setNumVotes(answer.getNumVotes());
		copiedAnswer.setSentences(answer.getSentences());
		copiedAnswer.setTokens(answer.getTokens());
		return copiedAnswer;
	}
}
