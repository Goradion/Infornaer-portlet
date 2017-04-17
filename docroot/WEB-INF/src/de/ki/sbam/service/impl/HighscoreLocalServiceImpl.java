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

import com.liferay.portal.kernel.model.User;

import aQute.bnd.annotation.ProviderType;
import de.ki.sbam.exception.NoSuchHighscoreException;
import de.ki.sbam.model.Highscore;
import de.ki.sbam.service.HighscoreLocalServiceUtil;
import de.ki.sbam.service.base.HighscoreLocalServiceBaseImpl;
import de.ki.sbam.service.persistence.HighscorePersistence;
import de.ki.sbam.service.persistence.HighscoreUtil;

/**
 * The implementation of the highscore local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.ki.sbam.service.HighscoreLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Alexander Mueller
 * @see HighscoreLocalServiceBaseImpl
 * @see de.ki.sbam.service.HighscoreLocalServiceUtil
 */
@ProviderType
public class HighscoreLocalServiceImpl extends HighscoreLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * de.ki.sbam.service.HighscoreLocalServiceUtil} to access the highscore
	 * local service.
	 */

	public Highscore addHighscore(long score, User user) {
		Highscore hs = highscorePersistence.fetchByUserId(user.getUserId());
		if (hs != null) {
			if (hs.getScore() < score) {
				hs.setScore(score);
				highscorePersistence.update(hs);
				return hs;
			} else {
				return hs;
			}
		} else {
			hs = highscorePersistence.create(user.getUserId());
			hs.setScore(score);
			hs.setUserName(user.getFullName());
			highscorePersistence.update(hs);
			return hs;
		}
	}
}