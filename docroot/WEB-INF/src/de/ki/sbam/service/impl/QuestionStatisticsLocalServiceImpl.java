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

import java.io.Serializable;

import aQute.bnd.annotation.ProviderType;
import de.ki.sbam.model.QuestionStatistics;
import de.ki.sbam.service.QuestionServiceUtil;
import de.ki.sbam.service.base.QuestionStatisticsLocalServiceBaseImpl;

/**
 * The implementation of the question statistics local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.ki.sbam.service.QuestionStatisticsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionStatisticsLocalServiceBaseImpl
 * @see de.ki.sbam.service.QuestionStatisticsLocalServiceUtil
 */
@ProviderType
public class QuestionStatisticsLocalServiceImpl extends QuestionStatisticsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * de.ki.sbam.service.QuestionStatisticsLocalServiceUtil} to access the
	 * question statistics local service.
	 */
	public QuestionStatistics addAnswer(long questionId, String answer) {
		QuestionStatistics questionStats = questionStatisticsPersistence.fetchByPrimaryKey(questionId);
		if (questionStats != null) {
			switch (answer) {
			case "A":
				long answered_a = questionStats.getAnswered_a() + 1;
				questionStats.setAnswered_a(answered_a);
				break;
			case "B":
				long answered_b = questionStats.getAnswered_b() + 1;
				questionStats.setAnswered_b(answered_b);
				break;
			case "C":
				long answered_c = questionStats.getAnswered_c() + 1;
				questionStats.setAnswered_c(answered_c);
				break;
			case "D":
				long answered_d = questionStats.getAnswered_d() + 1;
				questionStats.setAnswered_d(answered_d);
				break;
			default:
				System.out.println("invalid answer:" + answer); //TODO
				break;
			}
			questionStatisticsPersistence.update(questionStats);
		}
		return questionStats;
	}
}