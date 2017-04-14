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
 * This class is a wrapper for {@link QuestionStatistics}.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionStatistics
 * @generated
 */
@ProviderType
public class QuestionStatisticsWrapper implements QuestionStatistics,
	ModelWrapper<QuestionStatistics> {
	public QuestionStatisticsWrapper(QuestionStatistics questionStatistics) {
		_questionStatistics = questionStatistics;
	}

	@Override
	public Class<?> getModelClass() {
		return QuestionStatistics.class;
	}

	@Override
	public String getModelClassName() {
		return QuestionStatistics.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("questionId", getQuestionId());
		attributes.put("answered_a", getAnswered_a());
		attributes.put("answered_b", getAnswered_b());
		attributes.put("answered_c", getAnswered_c());
		attributes.put("answered_d", getAnswered_d());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long questionId = (Long)attributes.get("questionId");

		if (questionId != null) {
			setQuestionId(questionId);
		}

		Long answered_a = (Long)attributes.get("answered_a");

		if (answered_a != null) {
			setAnswered_a(answered_a);
		}

		Long answered_b = (Long)attributes.get("answered_b");

		if (answered_b != null) {
			setAnswered_b(answered_b);
		}

		Long answered_c = (Long)attributes.get("answered_c");

		if (answered_c != null) {
			setAnswered_c(answered_c);
		}

		Long answered_d = (Long)attributes.get("answered_d");

		if (answered_d != null) {
			setAnswered_d(answered_d);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _questionStatistics.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _questionStatistics.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _questionStatistics.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _questionStatistics.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.ki.sbam.model.QuestionStatistics> toCacheModel() {
		return _questionStatistics.toCacheModel();
	}

	@Override
	public de.ki.sbam.model.QuestionStatistics toEscapedModel() {
		return new QuestionStatisticsWrapper(_questionStatistics.toEscapedModel());
	}

	@Override
	public de.ki.sbam.model.QuestionStatistics toUnescapedModel() {
		return new QuestionStatisticsWrapper(_questionStatistics.toUnescapedModel());
	}

	@Override
	public int compareTo(de.ki.sbam.model.QuestionStatistics questionStatistics) {
		return _questionStatistics.compareTo(questionStatistics);
	}

	@Override
	public int hashCode() {
		return _questionStatistics.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _questionStatistics.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new QuestionStatisticsWrapper((QuestionStatistics)_questionStatistics.clone());
	}

	@Override
	public java.lang.String toString() {
		return _questionStatistics.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _questionStatistics.toXmlString();
	}

	/**
	* Returns the answered_a of this question statistics.
	*
	* @return the answered_a of this question statistics
	*/
	@Override
	public long getAnswered_a() {
		return _questionStatistics.getAnswered_a();
	}

	/**
	* Returns the answered_b of this question statistics.
	*
	* @return the answered_b of this question statistics
	*/
	@Override
	public long getAnswered_b() {
		return _questionStatistics.getAnswered_b();
	}

	/**
	* Returns the answered_c of this question statistics.
	*
	* @return the answered_c of this question statistics
	*/
	@Override
	public long getAnswered_c() {
		return _questionStatistics.getAnswered_c();
	}

	/**
	* Returns the answered_d of this question statistics.
	*
	* @return the answered_d of this question statistics
	*/
	@Override
	public long getAnswered_d() {
		return _questionStatistics.getAnswered_d();
	}

	/**
	* Returns the primary key of this question statistics.
	*
	* @return the primary key of this question statistics
	*/
	@Override
	public long getPrimaryKey() {
		return _questionStatistics.getPrimaryKey();
	}

	/**
	* Returns the question ID of this question statistics.
	*
	* @return the question ID of this question statistics
	*/
	@Override
	public long getQuestionId() {
		return _questionStatistics.getQuestionId();
	}

	@Override
	public void persist() {
		_questionStatistics.persist();
	}

	/**
	* Sets the answered_a of this question statistics.
	*
	* @param answered_a the answered_a of this question statistics
	*/
	@Override
	public void setAnswered_a(long answered_a) {
		_questionStatistics.setAnswered_a(answered_a);
	}

	/**
	* Sets the answered_b of this question statistics.
	*
	* @param answered_b the answered_b of this question statistics
	*/
	@Override
	public void setAnswered_b(long answered_b) {
		_questionStatistics.setAnswered_b(answered_b);
	}

	/**
	* Sets the answered_c of this question statistics.
	*
	* @param answered_c the answered_c of this question statistics
	*/
	@Override
	public void setAnswered_c(long answered_c) {
		_questionStatistics.setAnswered_c(answered_c);
	}

	/**
	* Sets the answered_d of this question statistics.
	*
	* @param answered_d the answered_d of this question statistics
	*/
	@Override
	public void setAnswered_d(long answered_d) {
		_questionStatistics.setAnswered_d(answered_d);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_questionStatistics.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_questionStatistics.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_questionStatistics.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_questionStatistics.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_questionStatistics.setNew(n);
	}

	/**
	* Sets the primary key of this question statistics.
	*
	* @param primaryKey the primary key of this question statistics
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_questionStatistics.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_questionStatistics.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the question ID of this question statistics.
	*
	* @param questionId the question ID of this question statistics
	*/
	@Override
	public void setQuestionId(long questionId) {
		_questionStatistics.setQuestionId(questionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuestionStatisticsWrapper)) {
			return false;
		}

		QuestionStatisticsWrapper questionStatisticsWrapper = (QuestionStatisticsWrapper)obj;

		if (Objects.equals(_questionStatistics,
					questionStatisticsWrapper._questionStatistics)) {
			return true;
		}

		return false;
	}

	@Override
	public QuestionStatistics getWrappedModel() {
		return _questionStatistics;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _questionStatistics.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _questionStatistics.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_questionStatistics.resetOriginalValues();
	}

	private final QuestionStatistics _questionStatistics;
}