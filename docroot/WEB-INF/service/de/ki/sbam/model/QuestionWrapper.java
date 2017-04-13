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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Question}.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see Question
 * @generated
 */
@ProviderType
public class QuestionWrapper implements Question, ModelWrapper<Question> {
	public QuestionWrapper(Question question) {
		_question = question;
	}

	@Override
	public Class<?> getModelClass() {
		return Question.class;
	}

	@Override
	public String getModelClassName() {
		return Question.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("questionId", getQuestionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("questionContent", getQuestionContent());
		attributes.put("answerA", getAnswerA());
		attributes.put("answerB", getAnswerB());
		attributes.put("answerC", getAnswerC());
		attributes.put("answerD", getAnswerD());
		attributes.put("categoryId_fk", getCategoryId_fk());
		attributes.put("category", getCategory());
		attributes.put("difficulty", getDifficulty());
		attributes.put("rightAnswer", getRightAnswer());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long questionId = (Long)attributes.get("questionId");

		if (questionId != null) {
			setQuestionId(questionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String questionContent = (String)attributes.get("questionContent");

		if (questionContent != null) {
			setQuestionContent(questionContent);
		}

		String answerA = (String)attributes.get("answerA");

		if (answerA != null) {
			setAnswerA(answerA);
		}

		String answerB = (String)attributes.get("answerB");

		if (answerB != null) {
			setAnswerB(answerB);
		}

		String answerC = (String)attributes.get("answerC");

		if (answerC != null) {
			setAnswerC(answerC);
		}

		String answerD = (String)attributes.get("answerD");

		if (answerD != null) {
			setAnswerD(answerD);
		}

		Long categoryId_fk = (Long)attributes.get("categoryId_fk");

		if (categoryId_fk != null) {
			setCategoryId_fk(categoryId_fk);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Integer difficulty = (Integer)attributes.get("difficulty");

		if (difficulty != null) {
			setDifficulty(difficulty);
		}

		String rightAnswer = (String)attributes.get("rightAnswer");

		if (rightAnswer != null) {
			setRightAnswer(rightAnswer);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new QuestionWrapper((Question)_question.clone());
	}

	@Override
	public int compareTo(de.ki.sbam.model.Question question) {
		return _question.compareTo(question);
	}

	/**
	* Returns the answer a of this question.
	*
	* @return the answer a of this question
	*/
	@Override
	public java.lang.String getAnswerA() {
		return _question.getAnswerA();
	}

	/**
	* Returns the answer b of this question.
	*
	* @return the answer b of this question
	*/
	@Override
	public java.lang.String getAnswerB() {
		return _question.getAnswerB();
	}

	/**
	* Returns the answer c of this question.
	*
	* @return the answer c of this question
	*/
	@Override
	public java.lang.String getAnswerC() {
		return _question.getAnswerC();
	}

	/**
	* Returns the answer d of this question.
	*
	* @return the answer d of this question
	*/
	@Override
	public java.lang.String getAnswerD() {
		return _question.getAnswerD();
	}

	/**
	* Returns the category of this question.
	*
	* @return the category of this question
	*/
	@Override
	public java.lang.String getCategory() {
		return _question.getCategory();
	}

	/**
	* Returns the category id_fk of this question.
	*
	* @return the category id_fk of this question
	*/
	@Override
	public long getCategoryId_fk() {
		return _question.getCategoryId_fk();
	}

	/**
	* Returns the company ID of this question.
	*
	* @return the company ID of this question
	*/
	@Override
	public long getCompanyId() {
		return _question.getCompanyId();
	}

	/**
	* Returns the create date of this question.
	*
	* @return the create date of this question
	*/
	@Override
	public Date getCreateDate() {
		return _question.getCreateDate();
	}

	/**
	* Returns the difficulty of this question.
	*
	* @return the difficulty of this question
	*/
	@Override
	public int getDifficulty() {
		return _question.getDifficulty();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _question.getExpandoBridge();
	}

	/**
	* Returns the group ID of this question.
	*
	* @return the group ID of this question
	*/
	@Override
	public long getGroupId() {
		return _question.getGroupId();
	}

	/**
	* Returns the modified date of this question.
	*
	* @return the modified date of this question
	*/
	@Override
	public Date getModifiedDate() {
		return _question.getModifiedDate();
	}

	/**
	* Returns the primary key of this question.
	*
	* @return the primary key of this question
	*/
	@Override
	public long getPrimaryKey() {
		return _question.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _question.getPrimaryKeyObj();
	}

	/**
	* Returns the question content of this question.
	*
	* @return the question content of this question
	*/
	@Override
	public java.lang.String getQuestionContent() {
		return _question.getQuestionContent();
	}

	/**
	* Returns the question ID of this question.
	*
	* @return the question ID of this question
	*/
	@Override
	public long getQuestionId() {
		return _question.getQuestionId();
	}

	/**
	* Returns the right answer of this question.
	*
	* @return the right answer of this question
	*/
	@Override
	public java.lang.String getRightAnswer() {
		return _question.getRightAnswer();
	}

	/**
	* Returns the user ID of this question.
	*
	* @return the user ID of this question
	*/
	@Override
	public long getUserId() {
		return _question.getUserId();
	}

	/**
	* Returns the user name of this question.
	*
	* @return the user name of this question
	*/
	@Override
	public java.lang.String getUserName() {
		return _question.getUserName();
	}

	/**
	* Returns the user uuid of this question.
	*
	* @return the user uuid of this question
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _question.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _question.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _question.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _question.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _question.isNew();
	}

	@Override
	public void persist() {
		_question.persist();
	}

	/**
	* Sets the answer a of this question.
	*
	* @param answerA the answer a of this question
	*/
	@Override
	public void setAnswerA(java.lang.String answerA) {
		_question.setAnswerA(answerA);
	}

	/**
	* Sets the answer b of this question.
	*
	* @param answerB the answer b of this question
	*/
	@Override
	public void setAnswerB(java.lang.String answerB) {
		_question.setAnswerB(answerB);
	}

	/**
	* Sets the answer c of this question.
	*
	* @param answerC the answer c of this question
	*/
	@Override
	public void setAnswerC(java.lang.String answerC) {
		_question.setAnswerC(answerC);
	}

	/**
	* Sets the answer d of this question.
	*
	* @param answerD the answer d of this question
	*/
	@Override
	public void setAnswerD(java.lang.String answerD) {
		_question.setAnswerD(answerD);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_question.setCachedModel(cachedModel);
	}

	/**
	* Sets the category of this question.
	*
	* @param category the category of this question
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_question.setCategory(category);
	}

	/**
	* Sets the category id_fk of this question.
	*
	* @param categoryId_fk the category id_fk of this question
	*/
	@Override
	public void setCategoryId_fk(long categoryId_fk) {
		_question.setCategoryId_fk(categoryId_fk);
	}

	/**
	* Sets the company ID of this question.
	*
	* @param companyId the company ID of this question
	*/
	@Override
	public void setCompanyId(long companyId) {
		_question.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this question.
	*
	* @param createDate the create date of this question
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_question.setCreateDate(createDate);
	}

	/**
	* Sets the difficulty of this question.
	*
	* @param difficulty the difficulty of this question
	*/
	@Override
	public void setDifficulty(int difficulty) {
		_question.setDifficulty(difficulty);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_question.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_question.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_question.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this question.
	*
	* @param groupId the group ID of this question
	*/
	@Override
	public void setGroupId(long groupId) {
		_question.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this question.
	*
	* @param modifiedDate the modified date of this question
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_question.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_question.setNew(n);
	}

	/**
	* Sets the primary key of this question.
	*
	* @param primaryKey the primary key of this question
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_question.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_question.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the question content of this question.
	*
	* @param questionContent the question content of this question
	*/
	@Override
	public void setQuestionContent(java.lang.String questionContent) {
		_question.setQuestionContent(questionContent);
	}

	/**
	* Sets the question ID of this question.
	*
	* @param questionId the question ID of this question
	*/
	@Override
	public void setQuestionId(long questionId) {
		_question.setQuestionId(questionId);
	}

	/**
	* Sets the right answer of this question.
	*
	* @param rightAnswer the right answer of this question
	*/
	@Override
	public void setRightAnswer(java.lang.String rightAnswer) {
		_question.setRightAnswer(rightAnswer);
	}

	/**
	* Sets the user ID of this question.
	*
	* @param userId the user ID of this question
	*/
	@Override
	public void setUserId(long userId) {
		_question.setUserId(userId);
	}

	/**
	* Sets the user name of this question.
	*
	* @param userName the user name of this question
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_question.setUserName(userName);
	}

	/**
	* Sets the user uuid of this question.
	*
	* @param userUuid the user uuid of this question
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_question.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.ki.sbam.model.Question> toCacheModel() {
		return _question.toCacheModel();
	}

	@Override
	public de.ki.sbam.model.Question toEscapedModel() {
		return new QuestionWrapper(_question.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _question.toString();
	}

	@Override
	public de.ki.sbam.model.Question toUnescapedModel() {
		return new QuestionWrapper(_question.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _question.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuestionWrapper)) {
			return false;
		}

		QuestionWrapper questionWrapper = (QuestionWrapper)obj;

		if (Validator.equals(_question, questionWrapper._question)) {
			return true;
		}

		return false;
	}

	@Override
	public Question getWrappedModel() {
		return _question;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _question.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _question.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_question.resetOriginalValues();
	}

	private final Question _question;
}