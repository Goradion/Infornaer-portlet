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
 * The extended model interface for the UserQuestion service. Represents a row in the &quot;sbam_UserQuestion&quot; database table, with each column mapped to a property of this class.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see UserQuestionModel
 * @see de.ki.sbam.model.impl.UserQuestionImpl
 * @see de.ki.sbam.model.impl.UserQuestionModelImpl
 * @generated
 */
@ImplementationClassName("de.ki.sbam.model.impl.UserQuestionImpl")
@ProviderType
public interface UserQuestion extends UserQuestionModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.ki.sbam.model.impl.UserQuestionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserQuestion, Long> QUESTION_ID_ACCESSOR = new Accessor<UserQuestion, Long>() {
			@Override
			public Long get(UserQuestion userQuestion) {
				return userQuestion.getQuestionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserQuestion> getTypeClass() {
				return UserQuestion.class;
			}
		};
}