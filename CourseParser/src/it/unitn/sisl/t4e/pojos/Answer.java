package it.unitn.sisl.t4e.pojos;

public class Answer {
	private String answerId;
	private String answerText;
	private int numVotes;
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
		return copiedAnswer;
	}
}
