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

package de.ki.sbam.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Difficulty service. Represents a row in the &quot;sbam_Difficulty&quot; database table, with each column mapped to a property of this class.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see DifficultyModel
 * @see de.ki.sbam.model.impl.DifficultyImpl
 * @see de.ki.sbam.model.impl.DifficultyModelImpl
 * @generated
 */
@ImplementationClassName("de.ki.sbam.model.impl.DifficultyImpl")
@ProviderType
public interface Difficulty extends DifficultyModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.ki.sbam.model.impl.DifficultyImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Difficulty, Long> DIFFICULTY_ID_ACCESSOR = new Accessor<Difficulty, Long>() {
			@Override
			public Long get(Difficulty difficulty) {
				return difficulty.getDifficultyId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Difficulty> getTypeClass() {
				return Difficulty.class;
			}
		};
}