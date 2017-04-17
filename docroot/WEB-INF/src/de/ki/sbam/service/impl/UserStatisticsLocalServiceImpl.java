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

import aQute.bnd.annotation.ProviderType;

import de.ki.sbam.service.base.UserStatisticsLocalServiceBaseImpl;

/**
 * The implementation of the user statistics local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.ki.sbam.service.UserStatisticsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Alexander Mueller
 * @see UserStatisticsLocalServiceBaseImpl
 * @see de.ki.sbam.service.UserStatisticsLocalServiceUtil
 */
@ProviderType
public class UserStatisticsLocalServiceImpl
	extends UserStatisticsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link de.ki.sbam.service.UserStatisticsLocalServiceUtil} to access the user statistics local service.
	 */
}