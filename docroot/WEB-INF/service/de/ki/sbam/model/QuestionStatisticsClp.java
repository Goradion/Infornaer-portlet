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
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import de.ki.sbam.service.ClpSerializer;
import de.ki.sbam.service.QuestionStatisticsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class QuestionStatisticsClp extends BaseModelImpl<QuestionStatistics>
	implements QuestionStatistics {
	public QuestionStatisticsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return QuestionStatistics.class;
	}

	@Override
	public String getModelClassName() {
		return QuestionStatistics.class.getName();
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
		attributes.put("answered_a", getAnswered_a());
		attributes.put("answered_b", getAnswered_b());
		attributes.put("answered_c", getAnswered_c());
		attributes.put("answered_d", getAnswered_d());

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

		Long answered_a = (Long)attributes.get("answered_a");

		if (answered_a != null) {
			setAnswered_a(answered_a);
		}

		Long answered_b = (Long)attributes.get("answered_b");

		if (answered_b != null) {
			setAnswered_b(answered_b);
		}

		Long answered_c = (Long)attributes.get("answered_c");

		if (answered_c != null) {
			setAnswered_c(answered_c);
		}

		Long answered_d = (Long)attributes.get("answered_d");

		if (answered_d != null) {
			setAnswered_d(answered_d);
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

		if (_questionStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _questionStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestionId", long.class);

				method.invoke(_questionStatisticsRemoteModel, questionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAnswered_a() {
		return _answered_a;
	}

	@Override
	public void setAnswered_a(long answered_a) {
		_answered_a = answered_a;

		if (_questionStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _questionStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswered_a", long.class);

				method.invoke(_questionStatisticsRemoteModel, answered_a);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAnswered_b() {
		return _answered_b;
	}

	@Override
	public void setAnswered_b(long answered_b) {
		_answered_b = answered_b;

		if (_questionStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _questionStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswered_b", long.class);

				method.invoke(_questionStatisticsRemoteModel, answered_b);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAnswered_c() {
		return _answered_c;
	}

	@Override
	public void setAnswered_c(long answered_c) {
		_answered_c = answered_c;

		if (_questionStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _questionStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswered_c", long.class);

				method.invoke(_questionStatisticsRemoteModel, answered_c);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAnswered_d() {
		return _answered_d;
	}

	@Override
	public void setAnswered_d(long answered_d) {
		_answered_d = answered_d;

		if (_questionStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _questionStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswered_d", long.class);

				method.invoke(_questionStatisticsRemoteModel, answered_d);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getQuestionStatisticsRemoteModel() {
		return _questionStatisticsRemoteModel;
	}

	public void setQuestionStatisticsRemoteModel(
		BaseModel<?> questionStatisticsRemoteModel) {
		_questionStatisticsRemoteModel = questionStatisticsRemoteModel;
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

		Class<?> remoteModelClass = _questionStatisticsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_questionStatisticsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			QuestionStatisticsLocalServiceUtil.addQuestionStatistics(this);
		}
		else {
			QuestionStatisticsLocalServiceUtil.updateQuestionStatistics(this);
		}
	}

	@Override
	public QuestionStatistics toEscapedModel() {
		return (QuestionStatistics)ProxyUtil.newProxyInstance(QuestionStatistics.class.getClassLoader(),
			new Class[] { QuestionStatistics.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		QuestionStatisticsClp clone = new QuestionStatisticsClp();

		clone.setQuestionId(getQuestionId());
		clone.setAnswered_a(getAnswered_a());
		clone.setAnswered_b(getAnswered_b());
		clone.setAnswered_c(getAnswered_c());
		clone.setAnswered_d(getAnswered_d());

		return clone;
	}

	@Override
	public int compareTo(QuestionStatistics questionStatistics) {
		long primaryKey = questionStatistics.getPrimaryKey();

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

		if (!(obj instanceof QuestionStatisticsClp)) {
			return false;
		}

		QuestionStatisticsClp questionStatistics = (QuestionStatisticsClp)obj;

		long primaryKey = questionStatistics.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{questionId=");
		sb.append(getQuestionId());
		sb.append(", answered_a=");
		sb.append(getAnswered_a());
		sb.append(", answered_b=");
		sb.append(getAnswered_b());
		sb.append(", answered_c=");
		sb.append(getAnswered_c());
		sb.append(", answered_d=");
		sb.append(getAnswered_d());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("de.ki.sbam.model.QuestionStatistics");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>questionId</column-name><column-value><![CDATA[");
		sb.append(getQuestionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answered_a</column-name><column-value><![CDATA[");
		sb.append(getAnswered_a());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answered_b</column-name><column-value><![CDATA[");
		sb.append(getAnswered_b());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answered_c</column-name><column-value><![CDATA[");
		sb.append(getAnswered_c());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answered_d</column-name><column-value><![CDATA[");
		sb.append(getAnswered_d());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _questionId;
	private long _answered_a;
	private long _answered_b;
	private long _answered_c;
	private long _answered_d;
	private BaseModel<?> _questionStatisticsRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}