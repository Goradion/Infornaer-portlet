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
 * The base model interface for the Highscore service. Represents a row in the &quot;sbam_Highscore&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.ki.sbam.model.impl.HighscoreModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.ki.sbam.model.impl.HighscoreImpl}.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see Highscore
 * @see de.ki.sbam.model.impl.HighscoreImpl
 * @see de.ki.sbam.model.impl.HighscoreModelImpl
 * @generated
 */
@ProviderType
public interface HighscoreModel extends BaseModel<Highscore> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a highscore model instance should use the {@link Highscore} interface instead.
	 */

	/**
	 * Returns the primary key of this highscore.
	 *
	 * @return the primary key of this highscore
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this highscore.
	 *
	 * @param primaryKey the primary key of this highscore
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the user ID of this highscore.
	 *
	 * @return the user ID of this highscore
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this highscore.
	 *
	 * @param userId the user ID of this highscore
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this highscore.
	 *
	 * @return the user uuid of this highscore
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this highscore.
	 *
	 * @param userUuid the user uuid of this highscore
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this highscore.
	 *
	 * @return the user name of this highscore
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this highscore.
	 *
	 * @param userName the user name of this highscore
	 */
	public void setUserName(String userName);

	/**
	 * Returns the score of this highscore.
	 *
	 * @return the score of this highscore
	 */
	public long getScore();

	/**
	 * Sets the score of this highscore.
	 *
	 * @param score the score of this highscore
	 */
	public void setScore(long score);

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
	public int compareTo(de.ki.sbam.model.Highscore highscore);

	@Override
	public int hashCode();

	@Override
	public CacheModel<de.ki.sbam.model.Highscore> toCacheModel();

	@Override
	public de.ki.sbam.model.Highscore toEscapedModel();

	@Override
	public de.ki.sbam.model.Highscore toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}