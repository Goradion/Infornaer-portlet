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

package de.ki.sbam.model.impl;

import aQute.bnd.annotation.ProviderType;

import de.ki.sbam.model.Question;
import de.ki.sbam.service.QuestionLocalServiceUtil;

/**
 * The extended model base implementation for the Question service. Represents a row in the &quot;sbam_Question&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link QuestionImpl}.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionImpl
 * @see Question
 * @generated
 */
@ProviderType
public abstract class QuestionBaseImpl extends QuestionModelImpl
	implements Question {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a question model instance should use the {@link Question} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			QuestionLocalServiceUtil.addQuestion(this);
		}
		else {
			QuestionLocalServiceUtil.updateQuestion(this);
		}
	}
}