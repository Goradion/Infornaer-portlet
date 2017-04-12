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
 * This class is a wrapper for {@link Difficulty}.
 * </p>
 *
 * @author Alexander Mueller
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

		attributes.put("difficultyId", getDifficultyId());
		attributes.put("difficultyName", getDifficultyName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long difficultyId = (Long)attributes.get("difficultyId");

		if (difficultyId != null) {
			setDifficultyId(difficultyId);
		}

		String difficultyName = (String)attributes.get("difficultyName");

		if (difficultyName != null) {
			setDifficultyName(difficultyName);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _difficulty.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _difficulty.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _difficulty.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _difficulty.getExpandoBridge();
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
	public de.ki.sbam.model.Difficulty toUnescapedModel() {
		return new DifficultyWrapper(_difficulty.toUnescapedModel());
	}

	@Override
	public int compareTo(de.ki.sbam.model.Difficulty difficulty) {
		return _difficulty.compareTo(difficulty);
	}

	@Override
	public int hashCode() {
		return _difficulty.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _difficulty.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DifficultyWrapper((Difficulty)_difficulty.clone());
	}

	/**
	* Returns the difficulty name of this difficulty.
	*
	* @return the difficulty name of this difficulty
	*/
	@Override
	public java.lang.String getDifficultyName() {
		return _difficulty.getDifficultyName();
	}

	@Override
	public java.lang.String toString() {
		return _difficulty.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _difficulty.toXmlString();
	}

	/**
	* Returns the difficulty ID of this difficulty.
	*
	* @return the difficulty ID of this difficulty
	*/
	@Override
	public long getDifficultyId() {
		return _difficulty.getDifficultyId();
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
	public void persist() {
		_difficulty.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_difficulty.setCachedModel(cachedModel);
	}

	/**
	* Sets the difficulty ID of this difficulty.
	*
	* @param difficultyId the difficulty ID of this difficulty
	*/
	@Override
	public void setDifficultyId(long difficultyId) {
		_difficulty.setDifficultyId(difficultyId);
	}

	/**
	* Sets the difficulty name of this difficulty.
	*
	* @param difficultyName the difficulty name of this difficulty
	*/
	@Override
	public void setDifficultyName(java.lang.String difficultyName) {
		_difficulty.setDifficultyName(difficultyName);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_difficulty.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_difficulty.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_difficulty.setExpandoBridgeAttributes(serviceContext);
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DifficultyWrapper)) {
			return false;
		}

		DifficultyWrapper difficultyWrapper = (DifficultyWrapper)obj;

		if (Objects.equals(_difficulty, difficultyWrapper._difficulty)) {
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