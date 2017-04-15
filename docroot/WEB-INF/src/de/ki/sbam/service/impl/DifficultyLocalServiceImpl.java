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
import de.ki.sbam.model.Difficulty;
import de.ki.sbam.service.base.DifficultyLocalServiceBaseImpl;
import de.ki.sbam.service.persistence.DifficultyUtil;

/**
 * The implementation of the difficulty local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.ki.sbam.service.DifficultyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Alexander Mueller
 * @see DifficultyLocalServiceBaseImpl
 * @see de.ki.sbam.service.DifficultyLocalServiceUtil
 */
@ProviderType
public class DifficultyLocalServiceImpl extends DifficultyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link de.ki.sbam.service.DifficultyLocalServiceUtil} to access the difficulty local service.
	 */
	
	public List<Difficulty> findAll(){
		return DifficultyUtil.findAll();
	}
}