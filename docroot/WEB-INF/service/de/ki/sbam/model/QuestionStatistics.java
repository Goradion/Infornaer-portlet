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
 * The extended model interface for the QuestionStatistics service. Represents a row in the &quot;sbam_QuestionStatistics&quot; database table, with each column mapped to a property of this class.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionStatisticsModel
 * @see de.ki.sbam.model.impl.QuestionStatisticsImpl
 * @see de.ki.sbam.model.impl.QuestionStatisticsModelImpl
 * @generated
 */
@ImplementationClassName("de.ki.sbam.model.impl.QuestionStatisticsImpl")
@ProviderType
public interface QuestionStatistics extends QuestionStatisticsModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.ki.sbam.model.impl.QuestionStatisticsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<QuestionStatistics, Long> QUESTION_ID_ACCESSOR = new Accessor<QuestionStatistics, Long>() {
			@Override
			public Long get(QuestionStatistics questionStatistics) {
				return questionStatistics.getQuestionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<QuestionStatistics> getTypeClass() {
				return QuestionStatistics.class;
			}
		};
}