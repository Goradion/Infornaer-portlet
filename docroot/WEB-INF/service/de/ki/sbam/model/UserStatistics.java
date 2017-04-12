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
 * The extended model interface for the UserStatistics service. Represents a row in the &quot;sbam_UserStatistics&quot; database table, with each column mapped to a property of this class.
 *
 * @author Alexander Mueller
 * @see UserStatisticsModel
 * @see de.ki.sbam.model.impl.UserStatisticsImpl
 * @see de.ki.sbam.model.impl.UserStatisticsModelImpl
 * @generated
 */
@ImplementationClassName("de.ki.sbam.model.impl.UserStatisticsImpl")
@ProviderType
public interface UserStatistics extends UserStatisticsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.ki.sbam.model.impl.UserStatisticsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserStatistics, Long> USER_ID_ACCESSOR = new Accessor<UserStatistics, Long>() {
			@Override
			public Long get(UserStatistics userStatistics) {
				return userStatistics.getUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserStatistics> getTypeClass() {
				return UserStatistics.class;
			}
		};
}