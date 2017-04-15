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
import com.liferay.portal.kernel.util.StringPool;

import de.ki.sbam.model.Question;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Question in entity cache.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see Question
 * @generated
 */
@ProviderType
public class QuestionCacheModel implements CacheModel<Question>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof QuestionCacheModel)) {
			return false;
		}

		QuestionCacheModel questionCacheModel = (QuestionCacheModel)obj;

		if (questionId == questionCacheModel.questionId) {
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
		StringBundler sb = new StringBundler(31);

		sb.append("{questionId=");
		sb.append(questionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", questionContent=");
		sb.append(questionContent);
		sb.append(", answerA=");
		sb.append(answerA);
		sb.append(", answerB=");
		sb.append(answerB);
		sb.append(", answerC=");
		sb.append(answerC);
		sb.append(", answerD=");
		sb.append(answerD);
		sb.append(", categoryId_fk=");
		sb.append(categoryId_fk);
		sb.append(", difficultyId_fk=");
		sb.append(difficultyId_fk);
		sb.append(", rightAnswer=");
		sb.append(rightAnswer);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Question toEntityModel() {
		QuestionImpl questionImpl = new QuestionImpl();

		questionImpl.setQuestionId(questionId);
		questionImpl.setGroupId(groupId);
		questionImpl.setCompanyId(companyId);
		questionImpl.setUserId(userId);

		if (userName == null) {
			questionImpl.setUserName(StringPool.BLANK);
		}
		else {
			questionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			questionImpl.setCreateDate(null);
		}
		else {
			questionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			questionImpl.setModifiedDate(null);
		}
		else {
			questionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (questionContent == null) {
			questionImpl.setQuestionContent(StringPool.BLANK);
		}
		else {
			questionImpl.setQuestionContent(questionContent);
		}

		if (answerA == null) {
			questionImpl.setAnswerA(StringPool.BLANK);
		}
		else {
			questionImpl.setAnswerA(answerA);
		}

		if (answerB == null) {
			questionImpl.setAnswerB(StringPool.BLANK);
		}
		else {
			questionImpl.setAnswerB(answerB);
		}

		if (answerC == null) {
			questionImpl.setAnswerC(StringPool.BLANK);
		}
		else {
			questionImpl.setAnswerC(answerC);
		}

		if (answerD == null) {
			questionImpl.setAnswerD(StringPool.BLANK);
		}
		else {
			questionImpl.setAnswerD(answerD);
		}

		questionImpl.setCategoryId_fk(categoryId_fk);
		questionImpl.setDifficultyId_fk(difficultyId_fk);

		if (rightAnswer == null) {
			questionImpl.setRightAnswer(StringPool.BLANK);
		}
		else {
			questionImpl.setRightAnswer(rightAnswer);
		}

		questionImpl.resetOriginalValues();

		return questionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		questionId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		questionContent = objectInput.readUTF();
		answerA = objectInput.readUTF();
		answerB = objectInput.readUTF();
		answerC = objectInput.readUTF();
		answerD = objectInput.readUTF();

		categoryId_fk = objectInput.readLong();

		difficultyId_fk = objectInput.readLong();
		rightAnswer = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(questionId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (questionContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(questionContent);
		}

		if (answerA == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answerA);
		}

		if (answerB == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answerB);
		}

		if (answerC == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answerC);
		}

		if (answerD == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answerD);
		}

		objectOutput.writeLong(categoryId_fk);

		objectOutput.writeLong(difficultyId_fk);

		if (rightAnswer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rightAnswer);
		}
	}

	public long questionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String questionContent;
	public String answerA;
	public String answerB;
	public String answerC;
	public String answerD;
	public long categoryId_fk;
	public long difficultyId_fk;
	public String rightAnswer;
}