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
import com.liferay.portal.kernel.util.StringPool;

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

		if (difficultyId == difficultyCacheModel.difficultyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, difficultyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{difficultyId=");
		sb.append(difficultyId);
		sb.append(", difficultyName=");
		sb.append(difficultyName);
		sb.append(", guaranteed=");
		sb.append(guaranteed);
		sb.append(", score=");
		sb.append(score);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Difficulty toEntityModel() {
		DifficultyImpl difficultyImpl = new DifficultyImpl();

		difficultyImpl.setDifficultyId(difficultyId);

		if (difficultyName == null) {
			difficultyImpl.setDifficultyName(StringPool.BLANK);
		}
		else {
			difficultyImpl.setDifficultyName(difficultyName);
		}

		difficultyImpl.setGuaranteed(guaranteed);
		difficultyImpl.setScore(score);

		difficultyImpl.resetOriginalValues();

		return difficultyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		difficultyId = objectInput.readLong();
		difficultyName = objectInput.readUTF();

		guaranteed = objectInput.readBoolean();

		score = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(difficultyId);

		if (difficultyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(difficultyName);
		}

		objectOutput.writeBoolean(guaranteed);

		objectOutput.writeInt(score);
	}

	public long difficultyId;
	public String difficultyName;
	public boolean guaranteed;
	public int score;
}