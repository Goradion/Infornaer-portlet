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
 * Provides a wrapper for {@link QuestionService}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionService
 * @generated
 */
@ProviderType
public class QuestionServiceWrapper implements QuestionService,
	ServiceWrapper<QuestionService> {
	public QuestionServiceWrapper(QuestionService questionService) {
		_questionService = questionService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _questionService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _questionService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public QuestionService getWrappedService() {
		return _questionService;
	}

	@Override
	public void setWrappedService(QuestionService questionService) {
		_questionService = questionService;
	}

	private QuestionService _questionService;
}