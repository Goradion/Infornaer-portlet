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

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link UserQuestion}.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see UserQuestion
 * @generated
 */
@ProviderType
public class UserQuestionWrapper implements UserQuestion,
	ModelWrapper<UserQuestion> {
	public UserQuestionWrapper(UserQuestion userQuestion) {
		_userQuestion = userQuestion;
	}

	@Override
	public Class<?> getModelClass() {
		return UserQuestion.class;
	}

	@Override
	public String getModelClassName() {
		return UserQuestion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("questionId", getQuestionId());
		attributes.put("question", getQuestion());
		attributes.put("answerA", getAnswerA());
		attributes.put("answerB", getAnswerB());
		attributes.put("answerC", getAnswerC());
		attributes.put("answerD", getAnswerD());
		attributes.put("category", getCategory());
		attributes.put("difficulty", getDifficulty());
		attributes.put("rightAnswer", getRightAnswer());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long questionId = (Long)attributes.get("questionId");

		if (questionId != null) {
			setQuestionId(questionId);
		}

		String question = (String)attributes.get("question");

		if (question != null) {
			setQuestion(question);
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
	public boolean isCachedModel() {
		return _userQuestion.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userQuestion.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userQuestion.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userQuestion.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.ki.sbam.model.UserQuestion> toCacheModel() {
		return _userQuestion.toCacheModel();
	}

	@Override
	public de.ki.sbam.model.UserQuestion toEscapedModel() {
		return new UserQuestionWrapper(_userQuestion.toEscapedModel());
	}

	@Override
	public de.ki.sbam.model.UserQuestion toUnescapedModel() {
		return new UserQuestionWrapper(_userQuestion.toUnescapedModel());
	}

	@Override
	public int compareTo(de.ki.sbam.model.UserQuestion userQuestion) {
		return _userQuestion.compareTo(userQuestion);
	}

	/**
	* Returns the difficulty of this user question.
	*
	* @return the difficulty of this user question
	*/
	@Override
	public int getDifficulty() {
		return _userQuestion.getDifficulty();
	}

	@Override
	public int hashCode() {
		return _userQuestion.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userQuestion.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new UserQuestionWrapper((UserQuestion)_userQuestion.clone());
	}

	/**
	* Returns the answer a of this user question.
	*
	* @return the answer a of this user question
	*/
	@Override
	public java.lang.String getAnswerA() {
		return _userQuestion.getAnswerA();
	}

	/**
	* Returns the answer b of this user question.
	*
	* @return the answer b of this user question
	*/
	@Override
	public java.lang.String getAnswerB() {
		return _userQuestion.getAnswerB();
	}

	/**
	* Returns the answer c of this user question.
	*
	* @return the answer c of this user question
	*/
	@Override
	public java.lang.String getAnswerC() {
		return _userQuestion.getAnswerC();
	}

	/**
	* Returns the answer d of this user question.
	*
	* @return the answer d of this user question
	*/
	@Override
	public java.lang.String getAnswerD() {
		return _userQuestion.getAnswerD();
	}

	/**
	* Returns the category of this user question.
	*
	* @return the category of this user question
	*/
	@Override
	public java.lang.String getCategory() {
		return _userQuestion.getCategory();
	}

	/**
	* Returns the question of this user question.
	*
	* @return the question of this user question
	*/
	@Override
	public java.lang.String getQuestion() {
		return _userQuestion.getQuestion();
	}

	/**
	* Returns the right answer of this user question.
	*
	* @return the right answer of this user question
	*/
	@Override
	public java.lang.String getRightAnswer() {
		return _userQuestion.getRightAnswer();
	}

	/**
	* Returns the user name of this user question.
	*
	* @return the user name of this user question
	*/
	@Override
	public java.lang.String getUserName() {
		return _userQuestion.getUserName();
	}

	/**
	* Returns the user uuid of this user question.
	*
	* @return the user uuid of this user question
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _userQuestion.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _userQuestion.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userQuestion.toXmlString();
	}

	/**
	* Returns the primary key of this user question.
	*
	* @return the primary key of this user question
	*/
	@Override
	public long getPrimaryKey() {
		return _userQuestion.getPrimaryKey();
	}

	/**
	* Returns the question ID of this user question.
	*
	* @return the question ID of this user question
	*/
	@Override
	public long getQuestionId() {
		return _userQuestion.getQuestionId();
	}

	/**
	* Returns the user ID of this user question.
	*
	* @return the user ID of this user question
	*/
	@Override
	public long getUserId() {
		return _userQuestion.getUserId();
	}

	@Override
	public void persist() {
		_userQuestion.persist();
	}

	/**
	* Sets the answer a of this user question.
	*
	* @param answerA the answer a of this user question
	*/
	@Override
	public void setAnswerA(java.lang.String answerA) {
		_userQuestion.setAnswerA(answerA);
	}

	/**
	* Sets the answer b of this user question.
	*
	* @param answerB the answer b of this user question
	*/
	@Override
	public void setAnswerB(java.lang.String answerB) {
		_userQuestion.setAnswerB(answerB);
	}

	/**
	* Sets the answer c of this user question.
	*
	* @param answerC the answer c of this user question
	*/
	@Override
	public void setAnswerC(java.lang.String answerC) {
		_userQuestion.setAnswerC(answerC);
	}

	/**
	* Sets the answer d of this user question.
	*
	* @param answerD the answer d of this user question
	*/
	@Override
	public void setAnswerD(java.lang.String answerD) {
		_userQuestion.setAnswerD(answerD);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userQuestion.setCachedModel(cachedModel);
	}

	/**
	* Sets the category of this user question.
	*
	* @param category the category of this user question
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_userQuestion.setCategory(category);
	}

	/**
	* Sets the difficulty of this user question.
	*
	* @param difficulty the difficulty of this user question
	*/
	@Override
	public void setDifficulty(int difficulty) {
		_userQuestion.setDifficulty(difficulty);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userQuestion.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userQuestion.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userQuestion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_userQuestion.setNew(n);
	}

	/**
	* Sets the primary key of this user question.
	*
	* @param primaryKey the primary key of this user question
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userQuestion.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userQuestion.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the question of this user question.
	*
	* @param question the question of this user question
	*/
	@Override
	public void setQuestion(java.lang.String question) {
		_userQuestion.setQuestion(question);
	}

	/**
	* Sets the question ID of this user question.
	*
	* @param questionId the question ID of this user question
	*/
	@Override
	public void setQuestionId(long questionId) {
		_userQuestion.setQuestionId(questionId);
	}

	/**
	* Sets the right answer of this user question.
	*
	* @param rightAnswer the right answer of this user question
	*/
	@Override
	public void setRightAnswer(java.lang.String rightAnswer) {
		_userQuestion.setRightAnswer(rightAnswer);
	}

	/**
	* Sets the user ID of this user question.
	*
	* @param userId the user ID of this user question
	*/
	@Override
	public void setUserId(long userId) {
		_userQuestion.setUserId(userId);
	}

	/**
	* Sets the user name of this user question.
	*
	* @param userName the user name of this user question
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_userQuestion.setUserName(userName);
	}

	/**
	* Sets the user uuid of this user question.
	*
	* @param userUuid the user uuid of this user question
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userQuestion.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserQuestionWrapper)) {
			return false;
		}

		UserQuestionWrapper userQuestionWrapper = (UserQuestionWrapper)obj;

		if (Objects.equals(_userQuestion, userQuestionWrapper._userQuestion)) {
			return true;
		}

		return false;
	}

	@Override
	public UserQuestion getWrappedModel() {
		return _userQuestion;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userQuestion.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userQuestion.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userQuestion.resetOriginalValues();
	}

	private final UserQuestion _userQuestion;
}