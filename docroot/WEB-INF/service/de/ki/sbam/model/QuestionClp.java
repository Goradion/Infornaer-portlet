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
import de.ki.sbam.service.QuestionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class QuestionClp extends BaseModelImpl<Question> implements Question {
	public QuestionClp() {
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
		attributes.put("difficultyId_fk", getDifficultyId_fk());
		attributes.put("rightAnswer", getRightAnswer());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		Long difficultyId_fk = (Long)attributes.get("difficultyId_fk");

		if (difficultyId_fk != null) {
			setDifficultyId_fk(difficultyId_fk);
		}

		String rightAnswer = (String)attributes.get("rightAnswer");

		if (rightAnswer != null) {
			setRightAnswer(rightAnswer);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getQuestionId() {
		return _questionId;
	}

	@Override
	public void setQuestionId(long questionId) {
		_questionId = questionId;

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestionId", long.class);

				method.invoke(_questionRemoteModel, questionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_questionRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_questionRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_questionRemoteModel, userId);
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

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_questionRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_questionRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_questionRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQuestionContent() {
		return _questionContent;
	}

	@Override
	public void setQuestionContent(String questionContent) {
		_questionContent = questionContent;

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestionContent",
						String.class);

				method.invoke(_questionRemoteModel, questionContent);
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

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswerA", String.class);

				method.invoke(_questionRemoteModel, answerA);
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

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswerB", String.class);

				method.invoke(_questionRemoteModel, answerB);
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

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswerC", String.class);

				method.invoke(_questionRemoteModel, answerC);
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

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswerD", String.class);

				method.invoke(_questionRemoteModel, answerD);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId_fk() {
		return _categoryId_fk;
	}

	@Override
	public void setCategoryId_fk(long categoryId_fk) {
		_categoryId_fk = categoryId_fk;

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId_fk", long.class);

				method.invoke(_questionRemoteModel, categoryId_fk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDifficultyId_fk() {
		return _difficultyId_fk;
	}

	@Override
	public void setDifficultyId_fk(long difficultyId_fk) {
		_difficultyId_fk = difficultyId_fk;

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setDifficultyId_fk", long.class);

				method.invoke(_questionRemoteModel, difficultyId_fk);
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

		if (_questionRemoteModel != null) {
			try {
				Class<?> clazz = _questionRemoteModel.getClass();

				Method method = clazz.getMethod("setRightAnswer", String.class);

				method.invoke(_questionRemoteModel, rightAnswer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getQuestionRemoteModel() {
		return _questionRemoteModel;
	}

	public void setQuestionRemoteModel(BaseModel<?> questionRemoteModel) {
		_questionRemoteModel = questionRemoteModel;
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

		Class<?> remoteModelClass = _questionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_questionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			QuestionLocalServiceUtil.addQuestion(this);
		}
		else {
			QuestionLocalServiceUtil.updateQuestion(this);
		}
	}

	@Override
	public Question toEscapedModel() {
		return (Question)ProxyUtil.newProxyInstance(Question.class.getClassLoader(),
			new Class[] { Question.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		QuestionClp clone = new QuestionClp();

		clone.setQuestionId(getQuestionId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setQuestionContent(getQuestionContent());
		clone.setAnswerA(getAnswerA());
		clone.setAnswerB(getAnswerB());
		clone.setAnswerC(getAnswerC());
		clone.setAnswerD(getAnswerD());
		clone.setCategoryId_fk(getCategoryId_fk());
		clone.setDifficultyId_fk(getDifficultyId_fk());
		clone.setRightAnswer(getRightAnswer());

		return clone;
	}

	@Override
	public int compareTo(Question question) {
		int value = 0;

		if (getQuestionId() < question.getQuestionId()) {
			value = -1;
		}
		else if (getQuestionId() > question.getQuestionId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuestionClp)) {
			return false;
		}

		QuestionClp question = (QuestionClp)obj;

		long primaryKey = question.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{questionId=");
		sb.append(getQuestionId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", questionContent=");
		sb.append(getQuestionContent());
		sb.append(", answerA=");
		sb.append(getAnswerA());
		sb.append(", answerB=");
		sb.append(getAnswerB());
		sb.append(", answerC=");
		sb.append(getAnswerC());
		sb.append(", answerD=");
		sb.append(getAnswerD());
		sb.append(", categoryId_fk=");
		sb.append(getCategoryId_fk());
		sb.append(", difficultyId_fk=");
		sb.append(getDifficultyId_fk());
		sb.append(", rightAnswer=");
		sb.append(getRightAnswer());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("de.ki.sbam.model.Question");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>questionId</column-name><column-value><![CDATA[");
		sb.append(getQuestionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questionContent</column-name><column-value><![CDATA[");
		sb.append(getQuestionContent());
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
			"<column><column-name>categoryId_fk</column-name><column-value><![CDATA[");
		sb.append(getCategoryId_fk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>difficultyId_fk</column-name><column-value><![CDATA[");
		sb.append(getDifficultyId_fk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rightAnswer</column-name><column-value><![CDATA[");
		sb.append(getRightAnswer());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private long _difficultyId_fk;
	private String _rightAnswer;
	private BaseModel<?> _questionRemoteModel;
	private Class<?> _clpSerializerClass = de.ki.sbam.service.ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}