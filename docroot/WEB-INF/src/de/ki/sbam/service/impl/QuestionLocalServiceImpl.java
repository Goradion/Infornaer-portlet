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

import org.apache.commons.lang3.NotImplementedException;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;

import aQute.bnd.annotation.ProviderType;
import de.ki.sbam.exception.NoSuchQuestionException;
import de.ki.sbam.exception.NoSuchQuestionStatisticsException;
import de.ki.sbam.model.Question;
import de.ki.sbam.model.QuestionStatistics;
import de.ki.sbam.service.QuestionLocalServiceUtil;
import de.ki.sbam.service.base.QuestionLocalServiceBaseImpl;
import de.ki.sbam.service.persistence.QuestionUtil;

/**
 * The implementation of the question local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.ki.sbam.service.QuestionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Alexander Mueller
 * @see QuestionLocalServiceBaseImpl
 * @see de.ki.sbam.service.QuestionLocalServiceUtil
 */
@ProviderType
public class QuestionLocalServiceImpl extends QuestionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * de.ki.sbam.service.QuestionLocalServiceUtil} to access the question local
	 * service.
	 */

	/**
	 * Adds a Question
	 * 
	 * @param questionContent
	 *            the actual question as a sentence/string
	 * @param answerA
	 *            string for answer A
	 * @param answerB
	 *            string for answer B
	 * @param answerC
	 *            string for answer C
	 * @param answerD
	 *            string for answer D
	 * @param rightAnswer
	 *            the right answer (should be A || B || C || D)
	 * @param category
	 *            category to which this question belongs
	 * @param difficulty
	 *            difficulty of the question
	 * @param userId
	 *            id of the user who added the question
	 * @return the added Question
	 * @throws NoSuchUserException
	 */
	public Question addQuestion(String questionContent, String answerA, String answerB, String answerC, String answerD,
			String rightAnswer, long categoryId, long difficultyId, User user) throws NoSuchUserException {
		// ob ein Benutzer eine Frage hizuf�gen darf wird im Portal eingestellt
		long questionId = counterLocalService.increment();
		Question question = questionPersistence.create(questionId);
		question.setQuestionContent(questionContent);
		question.setAnswerA(answerA);
		question.setAnswerB(answerB);
		question.setAnswerC(answerC);
		question.setAnswerD(answerD);
		question.setRightAnswer(rightAnswer);
		question.setCategoryId_fk(categoryId);
		question.setDifficultyId_fk(difficultyId);
		question.setUserId(user.getUserId());
		QuestionStatistics questionStatistics = questionStatisticsPersistence.create(questionId);
		questionPersistence.update(question);
		questionStatisticsPersistence.update(questionStatistics);
		return question;
	}

	public Question removeQuestion(long questionId) {
		try {
			questionStatisticsPersistence.remove(questionId);
			return questionPersistence.remove(questionId);
		} catch (NoSuchQuestionException | NoSuchQuestionStatisticsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Question removeQuestion(Question question) {
		try {
			questionStatisticsPersistence.remove(question.getQuestionId());
			return questionPersistence.remove(question);
		} catch (NoSuchQuestionStatisticsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public List<Question> findByDifficulty(long difficulty) {
		return QuestionUtil.findByDifficulty(difficulty);
	}

	public List<Question> findByCategory(long categoryId) {
		return QuestionUtil.findByCategory(categoryId);
	}

	public List<Question> findByCategoryAndDifficulty(long categoryId, long difficultyId) {
		return questionPersistence.findByCategoryAndDifficulty(categoryId, difficultyId);
	}

}