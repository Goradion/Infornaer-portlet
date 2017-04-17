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

package de.ki.sbam.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import de.ki.sbam.model.Difficulty;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Difficulty in entity cache.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see Difficulty
 * @generated
 */
@ProviderType
public class DifficultyCacheModel implements CacheModel<Difficulty>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DifficultyCacheModel)) {
			return false;
		}

		DifficultyCacheModel difficultyCacheModel = (DifficultyCacheModel)obj;

		if (score == difficultyCacheModel.score) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, score);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{guaranteed=");
		sb.append(guaranteed);
		sb.append(", score=");
		sb.append(score);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Difficulty toEntityModel() {
		DifficultyImpl difficultyImpl = new DifficultyImpl();

		difficultyImpl.setGuaranteed(guaranteed);
		difficultyImpl.setScore(score);

		difficultyImpl.resetOriginalValues();

		return difficultyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		guaranteed = objectInput.readBoolean();

		score = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeBoolean(guaranteed);

		objectOutput.writeLong(score);
	}

	public boolean guaranteed;
	public long score;
}