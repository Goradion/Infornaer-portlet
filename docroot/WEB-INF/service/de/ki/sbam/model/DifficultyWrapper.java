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
 * This class is a wrapper for {@link Difficulty}.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see Difficulty
 * @generated
 */
@ProviderType
public class DifficultyWrapper implements Difficulty, ModelWrapper<Difficulty> {
	public DifficultyWrapper(Difficulty difficulty) {
		_difficulty = difficulty;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("guaranteed", getGuaranteed());
		attributes.put("score", getScore());

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
	}

	@Override
	public java.lang.Object clone() {
		return new DifficultyWrapper((Difficulty)_difficulty.clone());
	}

	@Override
	public int compareTo(de.ki.sbam.model.Difficulty difficulty) {
		return _difficulty.compareTo(difficulty);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _difficulty.getExpandoBridge();
	}

	/**
	* Returns the guaranteed of this difficulty.
	*
	* @return the guaranteed of this difficulty
	*/
	@Override
	public boolean getGuaranteed() {
		return _difficulty.getGuaranteed();
	}

	/**
	* Returns the primary key of this difficulty.
	*
	* @return the primary key of this difficulty
	*/
	@Override
	public long getPrimaryKey() {
		return _difficulty.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _difficulty.getPrimaryKeyObj();
	}

	/**
	* Returns the score of this difficulty.
	*
	* @return the score of this difficulty
	*/
	@Override
	public long getScore() {
		return _difficulty.getScore();
	}

	@Override
	public int hashCode() {
		return _difficulty.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _difficulty.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _difficulty.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this difficulty is guaranteed.
	*
	* @return <code>true</code> if this difficulty is guaranteed; <code>false</code> otherwise
	*/
	@Override
	public boolean isGuaranteed() {
		return _difficulty.isGuaranteed();
	}

	@Override
	public boolean isNew() {
		return _difficulty.isNew();
	}

	@Override
	public void persist() {
		_difficulty.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_difficulty.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_difficulty.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_difficulty.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_difficulty.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this difficulty is guaranteed.
	*
	* @param guaranteed the guaranteed of this difficulty
	*/
	@Override
	public void setGuaranteed(boolean guaranteed) {
		_difficulty.setGuaranteed(guaranteed);
	}

	@Override
	public void setNew(boolean n) {
		_difficulty.setNew(n);
	}

	/**
	* Sets the primary key of this difficulty.
	*
	* @param primaryKey the primary key of this difficulty
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_difficulty.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_difficulty.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the score of this difficulty.
	*
	* @param score the score of this difficulty
	*/
	@Override
	public void setScore(long score) {
		_difficulty.setScore(score);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.ki.sbam.model.Difficulty> toCacheModel() {
		return _difficulty.toCacheModel();
	}

	@Override
	public de.ki.sbam.model.Difficulty toEscapedModel() {
		return new DifficultyWrapper(_difficulty.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _difficulty.toString();
	}

	@Override
	public de.ki.sbam.model.Difficulty toUnescapedModel() {
		return new DifficultyWrapper(_difficulty.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _difficulty.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DifficultyWrapper)) {
			return false;
		}

		DifficultyWrapper difficultyWrapper = (DifficultyWrapper)obj;

		if (Validator.equals(_difficulty, difficultyWrapper._difficulty)) {
			return true;
		}

		return false;
	}

	@Override
	public Difficulty getWrappedModel() {
		return _difficulty;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _difficulty.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _difficulty.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_difficulty.resetOriginalValues();
	}

	private final Difficulty _difficulty;
}