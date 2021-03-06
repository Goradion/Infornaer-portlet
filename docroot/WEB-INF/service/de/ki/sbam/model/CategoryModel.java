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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Category service. Represents a row in the &quot;sbam_Category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.ki.sbam.model.impl.CategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.ki.sbam.model.impl.CategoryImpl}.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see Category
 * @see de.ki.sbam.model.impl.CategoryImpl
 * @see de.ki.sbam.model.impl.CategoryModelImpl
 * @generated
 */
@ProviderType
public interface CategoryModel extends BaseModel<Category> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a category model instance should use the {@link Category} interface instead.
	 */

	/**
	 * Returns the primary key of this category.
	 *
	 * @return the primary key of this category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this category.
	 *
	 * @param primaryKey the primary key of this category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the category ID of this category.
	 *
	 * @return the category ID of this category
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this category.
	 *
	 * @param categoryId the category ID of this category
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the category name of this category.
	 *
	 * @return the category name of this category
	 */
	@AutoEscape
	public String getCategoryName();

	/**
	 * Sets the category name of this category.
	 *
	 * @param categoryName the category name of this category
	 */
	public void setCategoryName(String categoryName);

	/**
	 * Returns the unlocked of this category.
	 *
	 * @return the unlocked of this category
	 */
	public boolean getUnlocked();

	/**
	 * Returns <code>true</code> if this category is unlocked.
	 *
	 * @return <code>true</code> if this category is unlocked; <code>false</code> otherwise
	 */
	public boolean isUnlocked();

	/**
	 * Sets whether this category is unlocked.
	 *
	 * @param unlocked the unlocked of this category
	 */
	public void setUnlocked(boolean unlocked);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(de.ki.sbam.model.Category category);

	@Override
	public int hashCode();

	@Override
	public CacheModel<de.ki.sbam.model.Category> toCacheModel();

	@Override
	public de.ki.sbam.model.Category toEscapedModel();

	@Override
	public de.ki.sbam.model.Category toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}