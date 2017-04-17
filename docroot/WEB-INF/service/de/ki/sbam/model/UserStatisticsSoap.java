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
 * This class is used by SOAP remote services, specifically {@link de.ki.sbam.service.http.UserStatisticsServiceSoap}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see de.ki.sbam.service.http.UserStatisticsServiceSoap
 * @generated
 */
@ProviderType
public class UserStatisticsSoap implements Serializable {
	public static UserStatisticsSoap toSoapModel(UserStatistics model) {
		UserStatisticsSoap soapModel = new UserStatisticsSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setGamesWon(model.getGamesWon());
		soapModel.setGamesPlayed(model.getGamesPlayed());
		soapModel.setRightAnswers(model.getRightAnswers());
		soapModel.setWrongAnswers(model.getWrongAnswers());

		return soapModel;
	}

	public static UserStatisticsSoap[] toSoapModels(UserStatistics[] models) {
		UserStatisticsSoap[] soapModels = new UserStatisticsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserStatisticsSoap[][] toSoapModels(UserStatistics[][] models) {
		UserStatisticsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserStatisticsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserStatisticsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserStatisticsSoap[] toSoapModels(List<UserStatistics> models) {
		List<UserStatisticsSoap> soapModels = new ArrayList<UserStatisticsSoap>(models.size());

		for (UserStatistics model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserStatisticsSoap[soapModels.size()]);
	}

	public UserStatisticsSoap() {
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

	public long getGamesWon() {
		return _gamesWon;
	}

	public void setGamesWon(long gamesWon) {
		_gamesWon = gamesWon;
	}

	public long getGamesPlayed() {
		return _gamesPlayed;
	}

	public void setGamesPlayed(long gamesPlayed) {
		_gamesPlayed = gamesPlayed;
	}

	public long getRightAnswers() {
		return _rightAnswers;
	}

	public void setRightAnswers(long rightAnswers) {
		_rightAnswers = rightAnswers;
	}

	public long getWrongAnswers() {
		return _wrongAnswers;
	}

	public void setWrongAnswers(long wrongAnswers) {
		_wrongAnswers = wrongAnswers;
	}

	private long _userId;
	private long _gamesWon;
	private long _gamesPlayed;
	private long _rightAnswers;
	private long _wrongAnswers;
}