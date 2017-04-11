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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Highscore}.
 * </p>
 *
 * @author Alexander Mueller
 * @see Highscore
 * @generated
 */
@ProviderType
public class HighscoreWrapper implements Highscore, ModelWrapper<Highscore> {
	public HighscoreWrapper(Highscore highscore) {
		_highscore = highscore;
	}

	@Override
	public Class<?> getModelClass() {
		return Highscore.class;
	}

	@Override
	public String getModelClassName() {
		return Highscore.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("score", getScore());

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

		Long score = (Long)attributes.get("score");

		if (score != null) {
			setScore(score);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new HighscoreWrapper((Highscore)_highscore.clone());
	}

	@Override
	public int compareTo(de.ki.sbam.model.Highscore highscore) {
		return _highscore.compareTo(highscore);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _highscore.getExpandoBridge();
	}

	/**
	* Returns the primary key of this highscore.
	*
	* @return the primary key of this highscore
	*/
	@Override
	public long getPrimaryKey() {
		return _highscore.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _highscore.getPrimaryKeyObj();
	}

	/**
	* Returns the score of this highscore.
	*
	* @return the score of this highscore
	*/
	@Override
	public long getScore() {
		return _highscore.getScore();
	}

	/**
	* Returns the user ID of this highscore.
	*
	* @return the user ID of this highscore
	*/
	@Override
	public long getUserId() {
		return _highscore.getUserId();
	}

	/**
	* Returns the user name of this highscore.
	*
	* @return the user name of this highscore
	*/
	@Override
	public java.lang.String getUserName() {
		return _highscore.getUserName();
	}

	/**
	* Returns the user uuid of this highscore.
	*
	* @return the user uuid of this highscore
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _highscore.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _highscore.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _highscore.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _highscore.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _highscore.isNew();
	}

	@Override
	public void persist() {
		_highscore.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_highscore.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_highscore.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_highscore.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_highscore.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_highscore.setNew(n);
	}

	/**
	* Sets the primary key of this highscore.
	*
	* @param primaryKey the primary key of this highscore
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_highscore.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_highscore.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the score of this highscore.
	*
	* @param score the score of this highscore
	*/
	@Override
	public void setScore(long score) {
		_highscore.setScore(score);
	}

	/**
	* Sets the user ID of this highscore.
	*
	* @param userId the user ID of this highscore
	*/
	@Override
	public void setUserId(long userId) {
		_highscore.setUserId(userId);
	}

	/**
	* Sets the user name of this highscore.
	*
	* @param userName the user name of this highscore
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_highscore.setUserName(userName);
	}

	/**
	* Sets the user uuid of this highscore.
	*
	* @param userUuid the user uuid of this highscore
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_highscore.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.ki.sbam.model.Highscore> toCacheModel() {
		return _highscore.toCacheModel();
	}

	@Override
	public de.ki.sbam.model.Highscore toEscapedModel() {
		return new HighscoreWrapper(_highscore.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _highscore.toString();
	}

	@Override
	public de.ki.sbam.model.Highscore toUnescapedModel() {
		return new HighscoreWrapper(_highscore.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _highscore.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HighscoreWrapper)) {
			return false;
		}

		HighscoreWrapper highscoreWrapper = (HighscoreWrapper)obj;

		if (Validator.equals(_highscore, highscoreWrapper._highscore)) {
			return true;
		}

		return false;
	}

	@Override
	public Highscore getWrappedModel() {
		return _highscore;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _highscore.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _highscore.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_highscore.resetOriginalValues();
	}

	private final Highscore _highscore;
}