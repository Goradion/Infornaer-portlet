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

import de.ki.sbam.model.Highscore;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Highscore in entity cache.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see Highscore
 * @generated
 */
@ProviderType
public class HighscoreCacheModel implements CacheModel<Highscore>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HighscoreCacheModel)) {
			return false;
		}

		HighscoreCacheModel highscoreCacheModel = (HighscoreCacheModel)obj;

		if (userId == highscoreCacheModel.userId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", score=");
		sb.append(score);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Highscore toEntityModel() {
		HighscoreImpl highscoreImpl = new HighscoreImpl();

		highscoreImpl.setUserId(userId);

		if (userName == null) {
			highscoreImpl.setUserName(StringPool.BLANK);
		}
		else {
			highscoreImpl.setUserName(userName);
		}

		highscoreImpl.setScore(score);

		highscoreImpl.resetOriginalValues();

		return highscoreImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		score = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(score);
	}

	public long userId;
	public String userName;
	public long score;
}