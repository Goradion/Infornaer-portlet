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

package de.ki.sbam.service.impl;

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import de.ki.sbam.model.UserStatistics;
import de.ki.sbam.service.base.UserStatisticsLocalServiceBaseImpl;
import de.ki.sbam.service.persistence.UserStatisticsUtil;

/**
 * The implementation of the user statistics local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.ki.sbam.service.UserStatisticsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Alexander Mueller
 * @see UserStatisticsLocalServiceBaseImpl
 * @see de.ki.sbam.service.UserStatisticsLocalServiceUtil
 */
@ProviderType
public class UserStatisticsLocalServiceImpl extends UserStatisticsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * de.ki.sbam.service.UserStatisticsLocalServiceUtil} to access the user
	 * statistics local service.
	 */

	public List<UserStatistics> findAll(){
		return UserStatisticsUtil.findAll();
	}
	
	public UserStatistics addRightAnswer(long userId){
		UserStatistics userStatistic = UserStatisticsUtil.fetchByPrimaryKey(userId);
		if (userStatistic == null) {
			userStatistic = UserStatisticsUtil.create(userId);
		}
		long rightAnswers = userStatistic.getRightAnswers() + 1;
		userStatistic.setRightAnswers(rightAnswers);
		UserStatisticsUtil.update(userStatistic);

		return userStatistic;
	}
	
	public UserStatistics addWrongAnswer(long userId){
		UserStatistics userStatistic = UserStatisticsUtil.fetchByPrimaryKey(userId);
		if (userStatistic == null) {
			userStatistic = UserStatisticsUtil.create(userId);
		}
		long wrongAnswers = userStatistic.getWrongAnswers() + 1;
		userStatistic.setWrongAnswers(wrongAnswers);
		UserStatisticsUtil.update(userStatistic);

		return userStatistic;
	}
	
	public UserStatistics addWonGame(long userId) {
		UserStatistics userStatistic = UserStatisticsUtil.fetchByPrimaryKey(userId);
		if (userStatistic == null) {
			userStatistic = UserStatisticsUtil.create(userId);
		}
		long gamesWon = userStatistic.getGamesWon() + 1;
		userStatistic.setGamesWon(gamesWon);
		UserStatisticsUtil.update(userStatistic);

		return userStatistic;
	}
	
	public UserStatistics addPlayedGame(long userId) {
		UserStatistics userStatistic = UserStatisticsUtil.fetchByPrimaryKey(userId);
		if (userStatistic == null) {
			userStatistic = UserStatisticsUtil.create(userId);
		}
		long gamesPlayed = userStatistic.getGamesPlayed() + 1;
		userStatistic.setGamesPlayed(gamesPlayed);
		UserStatisticsUtil.update(userStatistic);
		return userStatistic;
	}
}