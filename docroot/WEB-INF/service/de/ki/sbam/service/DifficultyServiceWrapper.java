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
 * Provides a wrapper for {@link DifficultyService}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see DifficultyService
 * @generated
 */
@ProviderType
public class DifficultyServiceWrapper implements DifficultyService,
	ServiceWrapper<DifficultyService> {
	public DifficultyServiceWrapper(DifficultyService difficultyService) {
		_difficultyService = difficultyService;
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _difficultyService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _difficultyService.getOSGiServiceIdentifier();
	}

	@Override
	public DifficultyService getWrappedService() {
		return _difficultyService;
	}

	@Override
	public void setWrappedService(DifficultyService difficultyService) {
		_difficultyService = difficultyService;
	}

	private DifficultyService _difficultyService;
}