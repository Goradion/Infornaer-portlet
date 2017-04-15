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
 * This class is used by SOAP remote services, specifically {@link de.ki.sbam.service.http.DifficultyServiceSoap}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see de.ki.sbam.service.http.DifficultyServiceSoap
 * @generated
 */
@ProviderType
public class DifficultySoap implements Serializable {
	public static DifficultySoap toSoapModel(Difficulty model) {
		DifficultySoap soapModel = new DifficultySoap();

		soapModel.setDifficultyId(model.getDifficultyId());
		soapModel.setDifficultyName(model.getDifficultyName());
		soapModel.setGuaranteed(model.getGuaranteed());

		return soapModel;
	}

	public static DifficultySoap[] toSoapModels(Difficulty[] models) {
		DifficultySoap[] soapModels = new DifficultySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DifficultySoap[][] toSoapModels(Difficulty[][] models) {
		DifficultySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DifficultySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DifficultySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DifficultySoap[] toSoapModels(List<Difficulty> models) {
		List<DifficultySoap> soapModels = new ArrayList<DifficultySoap>(models.size());

		for (Difficulty model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DifficultySoap[soapModels.size()]);
	}

	public DifficultySoap() {
	}

	public long getPrimaryKey() {
		return _difficultyId;
	}

	public void setPrimaryKey(long pk) {
		setDifficultyId(pk);
	}

	public long getDifficultyId() {
		return _difficultyId;
	}

	public void setDifficultyId(long difficultyId) {
		_difficultyId = difficultyId;
	}

	public String getDifficultyName() {
		return _difficultyName;
	}

	public void setDifficultyName(String difficultyName) {
		_difficultyName = difficultyName;
	}

	public boolean getGuaranteed() {
		return _guaranteed;
	}

	public boolean isGuaranteed() {
		return _guaranteed;
	}

	public void setGuaranteed(boolean guaranteed) {
		_guaranteed = guaranteed;
	}

	private long _difficultyId;
	private String _difficultyName;
	private boolean _guaranteed;
}