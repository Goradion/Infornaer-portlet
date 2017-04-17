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
 * This class is a wrapper for {@link UserStatistics}.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see UserStatistics
 * @generated
 */
@ProviderType
public class UserStatisticsWrapper implements UserStatistics,
	ModelWrapper<UserStatistics> {
	public UserStatisticsWrapper(UserStatistics userStatistics) {
		_userStatistics = userStatistics;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("gamesWon", getGamesWon());
		attributes.put("gamesPlayed", getGamesPlayed());
		attributes.put("rightAnswers", getRightAnswers());
		attributes.put("wrongAnswers", getWrongAnswers());

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

		Long gamesPlayed = (Long)attributes.get("gamesPlayed");

		if (gamesPlayed != null) {
			setGamesPlayed(gamesPlayed);
		}

		Long rightAnswers = (Long)attributes.get("rightAnswers");

		if (rightAnswers != null) {
			setRightAnswers(rightAnswers);
		}

		Long wrongAnswers = (Long)attributes.get("wrongAnswers");

		if (wrongAnswers != null) {
			setWrongAnswers(wrongAnswers);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new UserStatisticsWrapper((UserStatistics)_userStatistics.clone());
	}

	@Override
	public int compareTo(de.ki.sbam.model.UserStatistics userStatistics) {
		return _userStatistics.compareTo(userStatistics);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userStatistics.getExpandoBridge();
	}

	/**
	* Returns the games played of this user statistics.
	*
	* @return the games played of this user statistics
	*/
	@Override
	public long getGamesPlayed() {
		return _userStatistics.getGamesPlayed();
	}

	/**
	* Returns the games won of this user statistics.
	*
	* @return the games won of this user statistics
	*/
	@Override
	public long getGamesWon() {
		return _userStatistics.getGamesWon();
	}

	/**
	* Returns the primary key of this user statistics.
	*
	* @return the primary key of this user statistics
	*/
	@Override
	public long getPrimaryKey() {
		return _userStatistics.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userStatistics.getPrimaryKeyObj();
	}

	/**
	* Returns the right answers of this user statistics.
	*
	* @return the right answers of this user statistics
	*/
	@Override
	public long getRightAnswers() {
		return _userStatistics.getRightAnswers();
	}

	/**
	* Returns the user ID of this user statistics.
	*
	* @return the user ID of this user statistics
	*/
	@Override
	public long getUserId() {
		return _userStatistics.getUserId();
	}

	/**
	* Returns the user uuid of this user statistics.
	*
	* @return the user uuid of this user statistics
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _userStatistics.getUserUuid();
	}

	/**
	* Returns the wrong answers of this user statistics.
	*
	* @return the wrong answers of this user statistics
	*/
	@Override
	public long getWrongAnswers() {
		return _userStatistics.getWrongAnswers();
	}

	@Override
	public int hashCode() {
		return _userStatistics.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _userStatistics.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userStatistics.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _userStatistics.isNew();
	}

	@Override
	public void persist() {
		_userStatistics.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userStatistics.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userStatistics.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userStatistics.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userStatistics.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the games played of this user statistics.
	*
	* @param gamesPlayed the games played of this user statistics
	*/
	@Override
	public void setGamesPlayed(long gamesPlayed) {
		_userStatistics.setGamesPlayed(gamesPlayed);
	}

	/**
	* Sets the games won of this user statistics.
	*
	* @param gamesWon the games won of this user statistics
	*/
	@Override
	public void setGamesWon(long gamesWon) {
		_userStatistics.setGamesWon(gamesWon);
	}

	@Override
	public void setNew(boolean n) {
		_userStatistics.setNew(n);
	}

	/**
	* Sets the primary key of this user statistics.
	*
	* @param primaryKey the primary key of this user statistics
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userStatistics.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userStatistics.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the right answers of this user statistics.
	*
	* @param rightAnswers the right answers of this user statistics
	*/
	@Override
	public void setRightAnswers(long rightAnswers) {
		_userStatistics.setRightAnswers(rightAnswers);
	}

	/**
	* Sets the user ID of this user statistics.
	*
	* @param userId the user ID of this user statistics
	*/
	@Override
	public void setUserId(long userId) {
		_userStatistics.setUserId(userId);
	}

	/**
	* Sets the user uuid of this user statistics.
	*
	* @param userUuid the user uuid of this user statistics
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userStatistics.setUserUuid(userUuid);
	}

	/**
	* Sets the wrong answers of this user statistics.
	*
	* @param wrongAnswers the wrong answers of this user statistics
	*/
	@Override
	public void setWrongAnswers(long wrongAnswers) {
		_userStatistics.setWrongAnswers(wrongAnswers);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.ki.sbam.model.UserStatistics> toCacheModel() {
		return _userStatistics.toCacheModel();
	}

	@Override
	public de.ki.sbam.model.UserStatistics toEscapedModel() {
		return new UserStatisticsWrapper(_userStatistics.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userStatistics.toString();
	}

	@Override
	public de.ki.sbam.model.UserStatistics toUnescapedModel() {
		return new UserStatisticsWrapper(_userStatistics.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _userStatistics.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserStatisticsWrapper)) {
			return false;
		}

		UserStatisticsWrapper userStatisticsWrapper = (UserStatisticsWrapper)obj;

		if (Validator.equals(_userStatistics,
					userStatisticsWrapper._userStatistics)) {
			return true;
		}

		return false;
	}

	@Override
	public UserStatistics getWrappedModel() {
		return _userStatistics;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userStatistics.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userStatistics.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userStatistics.resetOriginalValues();
	}

	private final UserStatistics _userStatistics;
}