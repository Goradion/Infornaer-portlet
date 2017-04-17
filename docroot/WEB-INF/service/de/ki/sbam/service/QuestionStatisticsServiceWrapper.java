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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link QuestionStatisticsService}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionStatisticsService
 * @generated
 */
@ProviderType
public class QuestionStatisticsServiceWrapper
	implements QuestionStatisticsService,
		ServiceWrapper<QuestionStatisticsService> {
	public QuestionStatisticsServiceWrapper(
		QuestionStatisticsService questionStatisticsService) {
		_questionStatisticsService = questionStatisticsService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _questionStatisticsService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _questionStatisticsService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public QuestionStatisticsService getWrappedService() {
		return _questionStatisticsService;
	}

	@Override
	public void setWrappedService(
		QuestionStatisticsService questionStatisticsService) {
		_questionStatisticsService = questionStatisticsService;
	}

	private QuestionStatisticsService _questionStatisticsService;
}