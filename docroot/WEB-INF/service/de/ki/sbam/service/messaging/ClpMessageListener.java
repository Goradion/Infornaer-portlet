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

package de.ki.sbam.service.messaging;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import de.ki.sbam.service.CategoryLocalServiceUtil;
import de.ki.sbam.service.CategoryServiceUtil;
import de.ki.sbam.service.ClpSerializer;
import de.ki.sbam.service.DifficultyLocalServiceUtil;
import de.ki.sbam.service.DifficultyServiceUtil;
import de.ki.sbam.service.HighscoreLocalServiceUtil;
import de.ki.sbam.service.HighscoreServiceUtil;
import de.ki.sbam.service.QuestionLocalServiceUtil;
import de.ki.sbam.service.QuestionServiceUtil;
import de.ki.sbam.service.UserQuestionLocalServiceUtil;
import de.ki.sbam.service.UserQuestionServiceUtil;
import de.ki.sbam.service.UserStatisticsLocalServiceUtil;
import de.ki.sbam.service.UserStatisticsServiceUtil;

/**
 * @author Alexander Mueller, Simon Bastian
 */
@ProviderType
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			CategoryLocalServiceUtil.clearService();

			CategoryServiceUtil.clearService();
			DifficultyLocalServiceUtil.clearService();

			DifficultyServiceUtil.clearService();
			HighscoreLocalServiceUtil.clearService();

			HighscoreServiceUtil.clearService();
			QuestionLocalServiceUtil.clearService();

			QuestionServiceUtil.clearService();
			UserQuestionLocalServiceUtil.clearService();

			UserQuestionServiceUtil.clearService();
			UserStatisticsLocalServiceUtil.clearService();

			UserStatisticsServiceUtil.clearService();
		}
	}
}