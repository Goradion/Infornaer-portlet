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

import de.ki.sbam.model.UserStatistics;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserStatistics in entity cache.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see UserStatistics
 * @generated
 */
@ProviderType
public class UserStatisticsCacheModel implements CacheModel<UserStatistics>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserStatisticsCacheModel)) {
			return false;
		}

		UserStatisticsCacheModel userStatisticsCacheModel = (UserStatisticsCacheModel)obj;

		if (userId == userStatisticsCacheModel.userId) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", gamesWon=");
		sb.append(gamesWon);
		sb.append(", gamesPlayed=");
		sb.append(gamesPlayed);
		sb.append(", rightAnswers=");
		sb.append(rightAnswers);
		sb.append(", wrongAnswers=");
		sb.append(wrongAnswers);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserStatistics toEntityModel() {
		UserStatisticsImpl userStatisticsImpl = new UserStatisticsImpl();

		userStatisticsImpl.setUserId(userId);
		userStatisticsImpl.setGamesWon(gamesWon);
		userStatisticsImpl.setGamesPlayed(gamesPlayed);
		userStatisticsImpl.setRightAnswers(rightAnswers);
		userStatisticsImpl.setWrongAnswers(wrongAnswers);

		userStatisticsImpl.resetOriginalValues();

		return userStatisticsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();

		gamesWon = objectInput.readLong();

		gamesPlayed = objectInput.readLong();

		rightAnswers = objectInput.readLong();

		wrongAnswers = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);

		objectOutput.writeLong(gamesWon);

		objectOutput.writeLong(gamesPlayed);

		objectOutput.writeLong(rightAnswers);

		objectOutput.writeLong(wrongAnswers);
	}

	public long userId;
	public long gamesWon;
	public long gamesPlayed;
	public long rightAnswers;
	public long wrongAnswers;
}