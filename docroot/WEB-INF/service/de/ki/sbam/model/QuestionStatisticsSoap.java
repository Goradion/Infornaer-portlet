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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.ki.sbam.service.http.QuestionStatisticsServiceSoap}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see de.ki.sbam.service.http.QuestionStatisticsServiceSoap
 * @generated
 */
@ProviderType
public class QuestionStatisticsSoap implements Serializable {
	public static QuestionStatisticsSoap toSoapModel(QuestionStatistics model) {
		QuestionStatisticsSoap soapModel = new QuestionStatisticsSoap();

		soapModel.setQuestionId(model.getQuestionId());
		soapModel.setAnswered_a(model.getAnswered_a());
		soapModel.setAnswered_b(model.getAnswered_b());
		soapModel.setAnswered_c(model.getAnswered_c());
		soapModel.setAnswered_d(model.getAnswered_d());

		return soapModel;
	}

	public static QuestionStatisticsSoap[] toSoapModels(
		QuestionStatistics[] models) {
		QuestionStatisticsSoap[] soapModels = new QuestionStatisticsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuestionStatisticsSoap[][] toSoapModels(
		QuestionStatistics[][] models) {
		QuestionStatisticsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new QuestionStatisticsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuestionStatisticsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuestionStatisticsSoap[] toSoapModels(
		List<QuestionStatistics> models) {
		List<QuestionStatisticsSoap> soapModels = new ArrayList<QuestionStatisticsSoap>(models.size());

		for (QuestionStatistics model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuestionStatisticsSoap[soapModels.size()]);
	}

	public QuestionStatisticsSoap() {
	}

	public long getPrimaryKey() {
		return _questionId;
	}

	public void setPrimaryKey(long pk) {
		setQuestionId(pk);
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	public long getAnswered_a() {
		return _answered_a;
	}

	public void setAnswered_a(long answered_a) {
		_answered_a = answered_a;
	}

	public long getAnswered_b() {
		return _answered_b;
	}

	public void setAnswered_b(long answered_b) {
		_answered_b = answered_b;
	}

	public long getAnswered_c() {
		return _answered_c;
	}

	public void setAnswered_c(long answered_c) {
		_answered_c = answered_c;
	}

	public long getAnswered_d() {
		return _answered_d;
	}

	public void setAnswered_d(long answered_d) {
		_answered_d = answered_d;
	}

	private long _questionId;
	private long _answered_a;
	private long _answered_b;
	private long _answered_c;
	private long _answered_d;
}