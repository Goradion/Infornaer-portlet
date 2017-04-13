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
 * This class is used by SOAP remote services, specifically {@link de.ki.sbam.service.http.HighscoreServiceSoap}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see de.ki.sbam.service.http.HighscoreServiceSoap
 * @generated
 */
@ProviderType
public class HighscoreSoap implements Serializable {
	public static HighscoreSoap toSoapModel(Highscore model) {
		HighscoreSoap soapModel = new HighscoreSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setScore(model.getScore());

		return soapModel;
	}

	public static HighscoreSoap[] toSoapModels(Highscore[] models) {
		HighscoreSoap[] soapModels = new HighscoreSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HighscoreSoap[][] toSoapModels(Highscore[][] models) {
		HighscoreSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HighscoreSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HighscoreSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HighscoreSoap[] toSoapModels(List<Highscore> models) {
		List<HighscoreSoap> soapModels = new ArrayList<HighscoreSoap>(models.size());

		for (Highscore model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HighscoreSoap[soapModels.size()]);
	}

	public HighscoreSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getScore() {
		return _score;
	}

	public void setScore(long score) {
		_score = score;
	}

	private long _userId;
	private String _userName;
	private long _score;
}