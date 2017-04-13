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
import de.ki.sbam.service.UserStatisticsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class UserStatisticsClp extends BaseModelImpl<UserStatistics>
	implements UserStatistics {
	public UserStatisticsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserStatistics.class;
	}

	@Override
	public String getModelClassName() {
		return UserStatistics.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _userId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("gamesWon", getGamesWon());
		attributes.put("gamesLost", getGamesLost());
		attributes.put("rightAnswers", getRightAnswers());
		attributes.put("wrongAnswers", getWrongAnswers());

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

		Long gamesWon = (Long)attributes.get("gamesWon");

		if (gamesWon != null) {
			setGamesWon(gamesWon);
		}

		Long gamesLost = (Long)attributes.get("gamesLost");

		if (gamesLost != null) {
			setGamesLost(gamesLost);
		}

		Long rightAnswers = (Long)attributes.get("rightAnswers");

		if (rightAnswers != null) {
			setRightAnswers(rightAnswers);
		}

		Long wrongAnswers = (Long)attributes.get("wrongAnswers");

		if (wrongAnswers != null) {
			setWrongAnswers(wrongAnswers);
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

		if (_userStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _userStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userStatisticsRemoteModel, userId);
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
	public long getGamesWon() {
		return _gamesWon;
	}

	@Override
	public void setGamesWon(long gamesWon) {
		_gamesWon = gamesWon;

		if (_userStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _userStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setGamesWon", long.class);

				method.invoke(_userStatisticsRemoteModel, gamesWon);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGamesLost() {
		return _gamesLost;
	}

	@Override
	public void setGamesLost(long gamesLost) {
		_gamesLost = gamesLost;

		if (_userStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _userStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setGamesLost", long.class);

				method.invoke(_userStatisticsRemoteModel, gamesLost);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRightAnswers() {
		return _rightAnswers;
	}

	@Override
	public void setRightAnswers(long rightAnswers) {
		_rightAnswers = rightAnswers;

		if (_userStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _userStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setRightAnswers", long.class);

				method.invoke(_userStatisticsRemoteModel, rightAnswers);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWrongAnswers() {
		return _wrongAnswers;
	}

	@Override
	public void setWrongAnswers(long wrongAnswers) {
		_wrongAnswers = wrongAnswers;

		if (_userStatisticsRemoteModel != null) {
			try {
				Class<?> clazz = _userStatisticsRemoteModel.getClass();

				Method method = clazz.getMethod("setWrongAnswers", long.class);

				method.invoke(_userStatisticsRemoteModel, wrongAnswers);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserStatisticsRemoteModel() {
		return _userStatisticsRemoteModel;
	}

	public void setUserStatisticsRemoteModel(
		BaseModel<?> userStatisticsRemoteModel) {
		_userStatisticsRemoteModel = userStatisticsRemoteModel;
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

		Class<?> remoteModelClass = _userStatisticsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userStatisticsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			UserStatisticsLocalServiceUtil.addUserStatistics(this);
		}
		else {
			UserStatisticsLocalServiceUtil.updateUserStatistics(this);
		}
	}

	@Override
	public UserStatistics toEscapedModel() {
		return (UserStatistics)ProxyUtil.newProxyInstance(UserStatistics.class.getClassLoader(),
			new Class[] { UserStatistics.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserStatisticsClp clone = new UserStatisticsClp();

		clone.setUserId(getUserId());
		clone.setGamesWon(getGamesWon());
		clone.setGamesLost(getGamesLost());
		clone.setRightAnswers(getRightAnswers());
		clone.setWrongAnswers(getWrongAnswers());

		return clone;
	}

	@Override
	public int compareTo(UserStatistics userStatistics) {
		long primaryKey = userStatistics.getPrimaryKey();

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

		if (!(obj instanceof UserStatisticsClp)) {
			return false;
		}

		UserStatisticsClp userStatistics = (UserStatisticsClp)obj;

		long primaryKey = userStatistics.getPrimaryKey();

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

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", gamesWon=");
		sb.append(getGamesWon());
		sb.append(", gamesLost=");
		sb.append(getGamesLost());
		sb.append(", rightAnswers=");
		sb.append(getRightAnswers());
		sb.append(", wrongAnswers=");
		sb.append(getWrongAnswers());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("de.ki.sbam.model.UserStatistics");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gamesWon</column-name><column-value><![CDATA[");
		sb.append(getGamesWon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gamesLost</column-name><column-value><![CDATA[");
		sb.append(getGamesLost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rightAnswers</column-name><column-value><![CDATA[");
		sb.append(getRightAnswers());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wrongAnswers</column-name><column-value><![CDATA[");
		sb.append(getWrongAnswers());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private long _gamesWon;
	private long _gamesLost;
	private long _rightAnswers;
	private long _wrongAnswers;
	private BaseModel<?> _userStatisticsRemoteModel;
	private Class<?> _clpSerializerClass = de.ki.sbam.service.ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}