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
import de.ki.sbam.service.DifficultyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class DifficultyClp extends BaseModelImpl<Difficulty>
	implements Difficulty {
	public DifficultyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Difficulty.class;
	}

	@Override
	public String getModelClassName() {
		return Difficulty.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _score;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScore(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _score;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("guaranteed", getGuaranteed());
		attributes.put("score", getScore());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Boolean guaranteed = (Boolean)attributes.get("guaranteed");

		if (guaranteed != null) {
			setGuaranteed(guaranteed);
		}

		Long score = (Long)attributes.get("score");

		if (score != null) {
			setScore(score);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public boolean getGuaranteed() {
		return _guaranteed;
	}

	@Override
	public boolean isGuaranteed() {
		return _guaranteed;
	}

	@Override
	public void setGuaranteed(boolean guaranteed) {
		_guaranteed = guaranteed;

		if (_difficultyRemoteModel != null) {
			try {
				Class<?> clazz = _difficultyRemoteModel.getClass();

				Method method = clazz.getMethod("setGuaranteed", boolean.class);

				method.invoke(_difficultyRemoteModel, guaranteed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getScore() {
		return _score;
	}

	@Override
	public void setScore(long score) {
		_score = score;

		if (_difficultyRemoteModel != null) {
			try {
				Class<?> clazz = _difficultyRemoteModel.getClass();

				Method method = clazz.getMethod("setScore", long.class);

				method.invoke(_difficultyRemoteModel, score);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDifficultyRemoteModel() {
		return _difficultyRemoteModel;
	}

	public void setDifficultyRemoteModel(BaseModel<?> difficultyRemoteModel) {
		_difficultyRemoteModel = difficultyRemoteModel;
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

		Class<?> remoteModelClass = _difficultyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_difficultyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			DifficultyLocalServiceUtil.addDifficulty(this);
		}
		else {
			DifficultyLocalServiceUtil.updateDifficulty(this);
		}
	}

	@Override
	public Difficulty toEscapedModel() {
		return (Difficulty)ProxyUtil.newProxyInstance(Difficulty.class.getClassLoader(),
			new Class[] { Difficulty.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DifficultyClp clone = new DifficultyClp();

		clone.setGuaranteed(getGuaranteed());
		clone.setScore(getScore());

		return clone;
	}

	@Override
	public int compareTo(Difficulty difficulty) {
		int value = 0;

		if (getScore() < difficulty.getScore()) {
			value = -1;
		}
		else if (getScore() > difficulty.getScore()) {
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

		if (!(obj instanceof DifficultyClp)) {
			return false;
		}

		DifficultyClp difficulty = (DifficultyClp)obj;

		long primaryKey = difficulty.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{guaranteed=");
		sb.append(getGuaranteed());
		sb.append(", score=");
		sb.append(getScore());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("de.ki.sbam.model.Difficulty");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>guaranteed</column-name><column-value><![CDATA[");
		sb.append(getGuaranteed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>score</column-name><column-value><![CDATA[");
		sb.append(getScore());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private boolean _guaranteed;
	private long _score;
	private BaseModel<?> _difficultyRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}