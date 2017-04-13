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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.ki.sbam.service.http.QuestionServiceSoap}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see de.ki.sbam.service.http.QuestionServiceSoap
 * @generated
 */
@ProviderType
public class QuestionSoap implements Serializable {
	public static QuestionSoap toSoapModel(Question model) {
		QuestionSoap soapModel = new QuestionSoap();

		soapModel.setQuestionId(model.getQuestionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setQuestionContent(model.getQuestionContent());
		soapModel.setAnswerA(model.getAnswerA());
		soapModel.setAnswerB(model.getAnswerB());
		soapModel.setAnswerC(model.getAnswerC());
		soapModel.setAnswerD(model.getAnswerD());
		soapModel.setCategoryId_fk(model.getCategoryId_fk());
		soapModel.setCategory(model.getCategory());
		soapModel.setDifficulty(model.getDifficulty());
		soapModel.setRightAnswer(model.getRightAnswer());

		return soapModel;
	}

	public static QuestionSoap[] toSoapModels(Question[] models) {
		QuestionSoap[] soapModels = new QuestionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuestionSoap[][] toSoapModels(Question[][] models) {
		QuestionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuestionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuestionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuestionSoap[] toSoapModels(List<Question> models) {
		List<QuestionSoap> soapModels = new ArrayList<QuestionSoap>(models.size());

		for (Question model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuestionSoap[soapModels.size()]);
	}

	public QuestionSoap() {
	}

	public long getPrimaryKey() {
		return _questionId;
	}

	public void setPrimaryKey(long pk) {
		setQuestionId(pk);
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getQuestionContent() {
		return _questionContent;
	}

	public void setQuestionContent(String questionContent) {
		_questionContent = questionContent;
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

	public long getCategoryId_fk() {
		return _categoryId_fk;
	}

	public void setCategoryId_fk(long categoryId_fk) {
		_categoryId_fk = categoryId_fk;
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

	private long _questionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _questionContent;
	private String _answerA;
	private String _answerB;
	private String _answerC;
	private String _answerD;
	private long _categoryId_fk;
	private String _category;
	private int _difficulty;
	private String _rightAnswer;
}