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

import de.ki.sbam.model.UserQuestion;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserQuestion in entity cache.
 *
 * @author Alexander Mueller
 * @see UserQuestion
 * @generated
 */
@ProviderType
public class UserQuestionCacheModel implements CacheModel<UserQuestion>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserQuestionCacheModel)) {
			return false;
		}

		UserQuestionCacheModel userQuestionCacheModel = (UserQuestionCacheModel)obj;

		if (questionId == userQuestionCacheModel.questionId) {
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
		StringBundler sb = new StringBundler(23);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append(", question=");
		sb.append(question);
		sb.append(", answerA=");
		sb.append(answerA);
		sb.append(", answerB=");
		sb.append(answerB);
		sb.append(", answerC=");
		sb.append(answerC);
		sb.append(", answerD=");
		sb.append(answerD);
		sb.append(", category=");
		sb.append(category);
		sb.append(", difficulty=");
		sb.append(difficulty);
		sb.append(", rightAnswer=");
		sb.append(rightAnswer);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserQuestion toEntityModel() {
		UserQuestionImpl userQuestionImpl = new UserQuestionImpl();

		userQuestionImpl.setUserId(userId);

		if (userName == null) {
			userQuestionImpl.setUserName(StringPool.BLANK);
		}
		else {
			userQuestionImpl.setUserName(userName);
		}

		userQuestionImpl.setQuestionId(questionId);

		if (question == null) {
			userQuestionImpl.setQuestion(StringPool.BLANK);
		}
		else {
			userQuestionImpl.setQuestion(question);
		}

		if (answerA == null) {
			userQuestionImpl.setAnswerA(StringPool.BLANK);
		}
		else {
			userQuestionImpl.setAnswerA(answerA);
		}

		if (answerB == null) {
			userQuestionImpl.setAnswerB(StringPool.BLANK);
		}
		else {
			userQuestionImpl.setAnswerB(answerB);
		}

		if (answerC == null) {
			userQuestionImpl.setAnswerC(StringPool.BLANK);
		}
		else {
			userQuestionImpl.setAnswerC(answerC);
		}

		if (answerD == null) {
			userQuestionImpl.setAnswerD(StringPool.BLANK);
		}
		else {
			userQuestionImpl.setAnswerD(answerD);
		}

		if (category == null) {
			userQuestionImpl.setCategory(StringPool.BLANK);
		}
		else {
			userQuestionImpl.setCategory(category);
		}

		userQuestionImpl.setDifficulty(difficulty);

		if (rightAnswer == null) {
			userQuestionImpl.setRightAnswer(StringPool.BLANK);
		}
		else {
			userQuestionImpl.setRightAnswer(rightAnswer);
		}

		userQuestionImpl.resetOriginalValues();

		return userQuestionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		questionId = objectInput.readLong();
		question = objectInput.readUTF();
		answerA = objectInput.readUTF();
		answerB = objectInput.readUTF();
		answerC = objectInput.readUTF();
		answerD = objectInput.readUTF();
		category = objectInput.readUTF();

		difficulty = objectInput.readInt();
		rightAnswer = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(questionId);

		if (question == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question);
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

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		objectOutput.writeInt(difficulty);

		if (rightAnswer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rightAnswer);
		}
	}

	public long userId;
	public String userName;
	public long questionId;
	public String question;
	public String answerA;
	public String answerB;
	public String answerC;
	public String answerD;
	public String category;
	public int difficulty;
	public String rightAnswer;
}