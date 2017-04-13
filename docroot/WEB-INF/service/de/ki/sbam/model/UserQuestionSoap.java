/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.ki.sbam.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.ki.sbam.service.http.UserQuestionServiceSoap}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see de.ki.sbam.service.http.UserQuestionServiceSoap
 * @generated
 */
@ProviderType
public class UserQuestionSoap implements Serializable {
	public static UserQuestionSoap toSoapModel(UserQuestion model) {
		UserQuestionSoap soapModel = new UserQuestionSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setQuestionId(model.getQuestionId());
		soapModel.setQuestion(model.getQuestion());
		soapModel.setAnswerA(model.getAnswerA());
		soapModel.setAnswerB(model.getAnswerB());
		soapModel.setAnswerC(model.getAnswerC());
		soapModel.setAnswerD(model.getAnswerD());
		soapModel.setCategory(model.getCategory());
		soapModel.setDifficulty(model.getDifficulty());
		soapModel.setRightAnswer(model.getRightAnswer());

		return soapModel;
	}

	public static UserQuestionSoap[] toSoapModels(UserQuestion[] models) {
		UserQuestionSoap[] soapModels = new UserQuestionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserQuestionSoap[][] toSoapModels(UserQuestion[][] models) {
		UserQuestionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserQuestionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserQuestionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserQuestionSoap[] toSoapModels(List<UserQuestion> models) {
		List<UserQuestionSoap> soapModels = new ArrayList<UserQuestionSoap>(models.size());

		for (UserQuestion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserQuestionSoap[soapModels.size()]);
	}

	public UserQuestionSoap() {
	}

	public long getPrimaryKey() {
		return _questionId;
	}

	public void setPrimaryKey(long pk) {
		setQuestionId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	public String getQuestion() {
		return _question;
	}

	public void setQuestion(String question) {
		_question = question;
	}

	public String getAnswerA() {
		return _answerA;
	}

	public void setAnswerA(String answerA) {
		_answerA = answerA;
	}

	public String getAnswerB() {
		return _answerB;
	}

	public void setAnswerB(String answerB) {
		_answerB = answerB;
	}

	public String getAnswerC() {
		return _answerC;
	}

	public void setAnswerC(String answerC) {
		_answerC = answerC;
	}

	public String getAnswerD() {
		return _answerD;
	}

	public void setAnswerD(String answerD) {
		_answerD = answerD;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public int getDifficulty() {
		return _difficulty;
	}

	public void setDifficulty(int difficulty) {
		_difficulty = difficulty;
	}

	public String getRightAnswer() {
		return _rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		_rightAnswer = rightAnswer;
	}

	private long _userId;
	private String _userName;
	private long _questionId;
	private String _question;
	private String _answerA;
	private String _answerB;
	private String _answerC;
	private String _answerD;
	private String _category;
	private int _difficulty;
	private String _rightAnswer;
}