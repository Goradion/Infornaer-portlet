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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import de.ki.sbam.service.ClpSerializer;
import de.ki.sbam.service.UserQuestionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class UserQuestionClp extends BaseModelImpl<UserQuestion>
	implements UserQuestion {
	public UserQuestionClp() {
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
	public long getPrimaryKey() {
		return _questionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setQuestionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _questionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_userQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _userQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userQuestionRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_userQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _userQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_userQuestionRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getQuestionId() {
		return _questionId;
	}

	@Override
	public void setQuestionId(long questionId) {
		_questionId = questionId;

		if (_userQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _userQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestionId", long.class);

				method.invoke(_userQuestionRemoteModel, questionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQuestion() {
		return _question;
	}

	@Override
	public void setQuestion(String question) {
		_question = question;

		if (_userQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _userQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion", String.class);

				method.invoke(_userQuestionRemoteModel, question);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswerA() {
		return _answerA;
	}

	@Override
	public void setAnswerA(String answerA) {
		_answerA = answerA;

		if (_userQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _userQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswerA", String.class);

				method.invoke(_userQuestionRemoteModel, answerA);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswerB() {
		return _answerB;
	}

	@Override
	public void setAnswerB(String answerB) {
		_answerB = answerB;

		if (_userQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _userQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswerB", String.class);

				method.invoke(_userQuestionRemoteModel, answerB);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswerC() {
		return _answerC;
	}

	@Override
	public void setAnswerC(String answerC) {
		_answerC = answerC;

		if (_userQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _userQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswerC", String.class);

				method.invoke(_userQuestionRemoteModel, answerC);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswerD() {
		return _answerD;
	}

	@Override
	public void setAnswerD(String answerD) {
		_answerD = answerD;

		if (_userQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _userQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswerD", String.class);

				method.invoke(_userQuestionRemoteModel, answerD);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategory() {
		return _category;
	}

	@Override
	public void setCategory(String category) {
		_category = category;

		if (_userQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _userQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_userQuestionRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDifficulty() {
		return _difficulty;
	}

	@Override
	public void setDifficulty(int difficulty) {
		_difficulty = difficulty;

		if (_userQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _userQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setDifficulty", int.class);

				method.invoke(_userQuestionRemoteModel, difficulty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRightAnswer() {
		return _rightAnswer;
	}

	@Override
	public void setRightAnswer(String rightAnswer) {
		_rightAnswer = rightAnswer;

		if (_userQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _userQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setRightAnswer", String.class);

				method.invoke(_userQuestionRemoteModel, rightAnswer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserQuestionRemoteModel() {
		return _userQuestionRemoteModel;
	}

	public void setUserQuestionRemoteModel(BaseModel<?> userQuestionRemoteModel) {
		_userQuestionRemoteModel = userQuestionRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _userQuestionRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_userQuestionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			UserQuestionLocalServiceUtil.addUserQuestion(this);
		}
		else {
			UserQuestionLocalServiceUtil.updateUserQuestion(this);
		}
	}

	@Override
	public UserQuestion toEscapedModel() {
		return (UserQuestion)ProxyUtil.newProxyInstance(UserQuestion.class.getClassLoader(),
			new Class[] { UserQuestion.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserQuestionClp clone = new UserQuestionClp();

		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setQuestionId(getQuestionId());
		clone.setQuestion(getQuestion());
		clone.setAnswerA(getAnswerA());
		clone.setAnswerB(getAnswerB());
		clone.setAnswerC(getAnswerC());
		clone.setAnswerD(getAnswerD());
		clone.setCategory(getCategory());
		clone.setDifficulty(getDifficulty());
		clone.setRightAnswer(getRightAnswer());

		return clone;
	}

	@Override
	public int compareTo(UserQuestion userQuestion) {
		long primaryKey = userQuestion.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserQuestionClp)) {
			return false;
		}

		UserQuestionClp userQuestion = (UserQuestionClp)obj;

		long primaryKey = userQuestion.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", questionId=");
		sb.append(getQuestionId());
		sb.append(", question=");
		sb.append(getQuestion());
		sb.append(", answerA=");
		sb.append(getAnswerA());
		sb.append(", answerB=");
		sb.append(getAnswerB());
		sb.append(", answerC=");
		sb.append(getAnswerC());
		sb.append(", answerD=");
		sb.append(getAnswerD());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", difficulty=");
		sb.append(getDifficulty());
		sb.append(", rightAnswer=");
		sb.append(getRightAnswer());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("de.ki.sbam.model.UserQuestion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questionId</column-name><column-value><![CDATA[");
		sb.append(getQuestionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question</column-name><column-value><![CDATA[");
		sb.append(getQuestion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerA</column-name><column-value><![CDATA[");
		sb.append(getAnswerA());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerB</column-name><column-value><![CDATA[");
		sb.append(getAnswerB());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerC</column-name><column-value><![CDATA[");
		sb.append(getAnswerC());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerD</column-name><column-value><![CDATA[");
		sb.append(getAnswerD());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>difficulty</column-name><column-value><![CDATA[");
		sb.append(getDifficulty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rightAnswer</column-name><column-value><![CDATA[");
		sb.append(getRightAnswer());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _userQuestionRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}