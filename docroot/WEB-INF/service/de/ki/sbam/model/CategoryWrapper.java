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
 * This class is a wrapper for {@link Category}.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see Category
 * @generated
 */
@ProviderType
public class CategoryWrapper implements Category, ModelWrapper<Category> {
	public CategoryWrapper(Category category) {
		_category = category;
	}

	@Override
	public Class<?> getModelClass() {
		return Category.class;
	}

	@Override
	public String getModelClassName() {
		return Category.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("unlocked", getUnlocked());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		Boolean unlocked = (Boolean)attributes.get("unlocked");

		if (unlocked != null) {
			setUnlocked(unlocked);
		}
	}

	/**
	* Returns the unlocked of this category.
	*
	* @return the unlocked of this category
	*/
	@Override
	public boolean getUnlocked() {
		return _category.getUnlocked();
	}

	@Override
	public boolean isCachedModel() {
		return _category.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _category.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _category.isNew();
	}

	/**
	* Returns <code>true</code> if this category is unlocked.
	*
	* @return <code>true</code> if this category is unlocked; <code>false</code> otherwise
	*/
	@Override
	public boolean isUnlocked() {
		return _category.isUnlocked();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _category.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.ki.sbam.model.Category> toCacheModel() {
		return _category.toCacheModel();
	}

	@Override
	public de.ki.sbam.model.Category toEscapedModel() {
		return new CategoryWrapper(_category.toEscapedModel());
	}

	@Override
	public de.ki.sbam.model.Category toUnescapedModel() {
		return new CategoryWrapper(_category.toUnescapedModel());
	}

	@Override
	public int compareTo(de.ki.sbam.model.Category category) {
		return _category.compareTo(category);
	}

	@Override
	public int hashCode() {
		return _category.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _category.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CategoryWrapper((Category)_category.clone());
	}

	/**
	* Returns the category name of this category.
	*
	* @return the category name of this category
	*/
	@Override
	public java.lang.String getCategoryName() {
		return _category.getCategoryName();
	}

	@Override
	public java.lang.String toString() {
		return _category.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _category.toXmlString();
	}

	/**
	* Returns the category ID of this category.
	*
	* @return the category ID of this category
	*/
	@Override
	public long getCategoryId() {
		return _category.getCategoryId();
	}

	/**
	* Returns the primary key of this category.
	*
	* @return the primary key of this category
	*/
	@Override
	public long getPrimaryKey() {
		return _category.getPrimaryKey();
	}

	@Override
	public void persist() {
		_category.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_category.setCachedModel(cachedModel);
	}

	/**
	* Sets the category ID of this category.
	*
	* @param categoryId the category ID of this category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_category.setCategoryId(categoryId);
	}

	/**
	* Sets the category name of this category.
	*
	* @param categoryName the category name of this category
	*/
	@Override
	public void setCategoryName(java.lang.String categoryName) {
		_category.setCategoryName(categoryName);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_category.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_category.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_category.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_category.setNew(n);
	}

	/**
	* Sets the primary key of this category.
	*
	* @param primaryKey the primary key of this category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_category.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_category.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this category is unlocked.
	*
	* @param unlocked the unlocked of this category
	*/
	@Override
	public void setUnlocked(boolean unlocked) {
		_category.setUnlocked(unlocked);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CategoryWrapper)) {
			return false;
		}

		CategoryWrapper categoryWrapper = (CategoryWrapper)obj;

		if (Objects.equals(_category, categoryWrapper._category)) {
			return true;
		}

		return false;
	}

	@Override
	public Category getWrappedModel() {
		return _category;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _category.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _category.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_category.resetOriginalValues();
	}

	private final Category _category;
}