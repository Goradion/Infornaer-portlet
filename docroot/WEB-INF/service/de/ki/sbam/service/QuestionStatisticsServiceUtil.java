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

package de.ki.sbam.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.service.InvokableService;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the remote service utility for QuestionStatistics. This utility wraps
 * {@link de.ki.sbam.service.impl.QuestionStatisticsServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionStatisticsService
 * @see de.ki.sbam.service.base.QuestionStatisticsServiceBaseImpl
 * @see de.ki.sbam.service.impl.QuestionStatisticsServiceImpl
 * @generated
 */
@ProviderType
public class QuestionStatisticsServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.ki.sbam.service.impl.QuestionStatisticsServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static QuestionStatisticsService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					QuestionStatisticsService.class.getName());

			if (invokableService instanceof QuestionStatisticsService) {
				_service = (QuestionStatisticsService)invokableService;
			}
			else {
				_service = new QuestionStatisticsServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(QuestionStatisticsServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static QuestionStatisticsService _service;
}