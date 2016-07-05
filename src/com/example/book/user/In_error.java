package com.example.book.user;

import java.io.Serializable;

public class In_error  implements Serializable {
	private String date;
	private String time;
	private String type;
	private String section;
	private String reason;
	private String knowledge;
	private String texterror;
	private String experience;
	private String analysis;
	private String text;
	private String leveltext;
	public In_error() {
		super();
		// TODO Auto-generated constructor stub
	}
	public In_error(String date, String time, String type, String section,String reason,String knowledge,String texterror
			,String experience,String analysis,String text, String leveltext ) {
		super();
		this.date = date;
		this.time = time;
		this.type = type;
		this.section = section;
		this.reason=reason;
		this.knowledge=knowledge;
		this.texterror=texterror;
		this.experience=experience;
		this.analysis=analysis;
		this.setText(text);
		this.leveltext=leveltext;
	}
	public String getLeveltext() {
		return leveltext;
	}
	public void setLeveltext(String leveltext) {
		this.leveltext = leveltext;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date= date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}
	public String getTexterror() {
		return texterror;
	}
	public void setTexterror(String texterror) {
		this.texterror = texterror;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "user [date=" + date + ", time=" + time + ", type="
				+ type + ", section=" + section + ", reason=" + reason +
				", knowledge=" + knowledge +", texterror=" + texterror +
				", experience=" + experience +", analysis=" + analysis + ", text=" + text + ",leveltext =" + leveltext +"]";
	}
	
}
