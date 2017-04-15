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

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the QuestionStatistics service. Represents a row in the &quot;sbam_QuestionStatistics&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.ki.sbam.model.impl.QuestionStatisticsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.ki.sbam.model.impl.QuestionStatisticsImpl}.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionStatistics
 * @see de.ki.sbam.model.impl.QuestionStatisticsImpl
 * @see de.ki.sbam.model.impl.QuestionStatisticsModelImpl
 * @generated
 */
@ProviderType
public interface QuestionStatisticsModel extends BaseModel<QuestionStatistics> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a question statistics model instance should use the {@link QuestionStatistics} interface instead.
	 */

	/**
	 * Returns the primary key of this question statistics.
	 *
	 * @return the primary key of this question statistics
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this question statistics.
	 *
	 * @param primaryKey the primary key of this question statistics
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the question ID of this question statistics.
	 *
	 * @return the question ID of this question statistics
	 */
	public long getQuestionId();

	/**
	 * Sets the question ID of this question statistics.
	 *
	 * @param questionId the question ID of this question statistics
	 */
	public void setQuestionId(long questionId);

	/**
	 * Returns the answered_a of this question statistics.
	 *
	 * @return the answered_a of this question statistics
	 */
	public long getAnswered_a();

	/**
	 * Sets the answered_a of this question statistics.
	 *
	 * @param answered_a the answered_a of this question statistics
	 */
	public void setAnswered_a(long answered_a);

	/**
	 * Returns the answered_b of this question statistics.
	 *
	 * @return the answered_b of this question statistics
	 */
	public long getAnswered_b();

	/**
	 * Sets the answered_b of this question statistics.
	 *
	 * @param answered_b the answered_b of this question statistics
	 */
	public void setAnswered_b(long answered_b);

	/**
	 * Returns the answered_c of this question statistics.
	 *
	 * @return the answered_c of this question statistics
	 */
	public long getAnswered_c();

	/**
	 * Sets the answered_c of this question statistics.
	 *
	 * @param answered_c the answered_c of this question statistics
	 */
	public void setAnswered_c(long answered_c);

	/**
	 * Returns the answered_d of this question statistics.
	 *
	 * @return the answered_d of this question statistics
	 */
	public long getAnswered_d();

	/**
	 * Sets the answered_d of this question statistics.
	 *
	 * @param answered_d the answered_d of this question statistics
	 */
	public void setAnswered_d(long answered_d);

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
	public int compareTo(de.ki.sbam.model.QuestionStatistics questionStatistics);

	@Override
	public int hashCode();

	@Override
	public CacheModel<de.ki.sbam.model.QuestionStatistics> toCacheModel();

	@Override
	public de.ki.sbam.model.QuestionStatistics toEscapedModel();

	@Override
	public de.ki.sbam.model.QuestionStatistics toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}