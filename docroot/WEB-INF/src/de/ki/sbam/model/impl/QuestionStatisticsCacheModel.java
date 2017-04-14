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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import de.ki.sbam.model.QuestionStatistics;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing QuestionStatistics in entity cache.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionStatistics
 * @generated
 */
@ProviderType
public class QuestionStatisticsCacheModel implements CacheModel<QuestionStatistics>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuestionStatisticsCacheModel)) {
			return false;
		}

		QuestionStatisticsCacheModel questionStatisticsCacheModel = (QuestionStatisticsCacheModel)obj;

		if (questionId == questionStatisticsCacheModel.questionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, questionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{questionId=");
		sb.append(questionId);
		sb.append(", answered_a=");
		sb.append(answered_a);
		sb.append(", answered_b=");
		sb.append(answered_b);
		sb.append(", answered_c=");
		sb.append(answered_c);
		sb.append(", answered_d=");
		sb.append(answered_d);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuestionStatistics toEntityModel() {
		QuestionStatisticsImpl questionStatisticsImpl = new QuestionStatisticsImpl();

		questionStatisticsImpl.setQuestionId(questionId);
		questionStatisticsImpl.setAnswered_a(answered_a);
		questionStatisticsImpl.setAnswered_b(answered_b);
		questionStatisticsImpl.setAnswered_c(answered_c);
		questionStatisticsImpl.setAnswered_d(answered_d);

		questionStatisticsImpl.resetOriginalValues();

		return questionStatisticsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		questionId = objectInput.readLong();

		answered_a = objectInput.readLong();

		answered_b = objectInput.readLong();

		answered_c = objectInput.readLong();

		answered_d = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(questionId);

		objectOutput.writeLong(answered_a);

		objectOutput.writeLong(answered_b);

		objectOutput.writeLong(answered_c);

		objectOutput.writeLong(answered_d);
	}

	public long questionId;
	public long answered_a;
	public long answered_b;
	public long answered_c;
	public long answered_d;
}