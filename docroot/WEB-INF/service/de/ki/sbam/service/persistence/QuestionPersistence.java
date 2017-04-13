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

package de.ki.sbam.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import de.ki.sbam.exception.NoSuchQuestionException;
import de.ki.sbam.model.Question;

/**
 * The persistence interface for the question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see de.ki.sbam.service.persistence.impl.QuestionPersistenceImpl
 * @see QuestionUtil
 * @generated
 */
@ProviderType
public interface QuestionPersistence extends BasePersistence<Question> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuestionUtil} to access the question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the questions where category = &#63;.
	*
	* @param category the category
	* @return the matching questions
	*/
	public java.util.List<Question> findByCategory(java.lang.String category);

	/**
	* Returns a range of all the questions where category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @return the range of matching questions
	*/
	public java.util.List<Question> findByCategory(java.lang.String category,
		int start, int end);

	/**
	* Returns an ordered range of all the questions where category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching questions
	*/
	public java.util.List<Question> findByCategory(java.lang.String category,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator);

	/**
	* Returns an ordered range of all the questions where category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching questions
	*/
	public java.util.List<Question> findByCategory(java.lang.String category,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first question in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public Question findByCategory_First(java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException;

	/**
	* Returns the first question in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question, or <code>null</code> if a matching question could not be found
	*/
	public Question fetchByCategory_First(java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator);

	/**
	* Returns the last question in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public Question findByCategory_Last(java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException;

	/**
	* Returns the last question in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question, or <code>null</code> if a matching question could not be found
	*/
	public Question fetchByCategory_Last(java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator);

	/**
	* Returns the questions before and after the current question in the ordered set where category = &#63;.
	*
	* @param questionId the primary key of the current question
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question
	* @throws NoSuchQuestionException if a question with the primary key could not be found
	*/
	public Question[] findByCategory_PrevAndNext(long questionId,
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException;

	/**
	* Removes all the questions where category = &#63; from the database.
	*
	* @param category the category
	*/
	public void removeByCategory(java.lang.String category);

	/**
	* Returns the number of questions where category = &#63;.
	*
	* @param category the category
	* @return the number of matching questions
	*/
	public int countByCategory(java.lang.String category);

	/**
	* Returns all the questions where difficulty = &#63;.
	*
	* @param difficulty the difficulty
	* @return the matching questions
	*/
	public java.util.List<Question> findByDifficulty(int difficulty);

	/**
	* Returns a range of all the questions where difficulty = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param difficulty the difficulty
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @return the range of matching questions
	*/
	public java.util.List<Question> findByDifficulty(int difficulty, int start,
		int end);

	/**
	* Returns an ordered range of all the questions where difficulty = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param difficulty the difficulty
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching questions
	*/
	public java.util.List<Question> findByDifficulty(int difficulty, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator);

	/**
	* Returns an ordered range of all the questions where difficulty = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param difficulty the difficulty
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching questions
	*/
	public java.util.List<Question> findByDifficulty(int difficulty, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first question in the ordered set where difficulty = &#63;.
	*
	* @param difficulty the difficulty
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public Question findByDifficulty_First(int difficulty,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException;

	/**
	* Returns the first question in the ordered set where difficulty = &#63;.
	*
	* @param difficulty the difficulty
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question, or <code>null</code> if a matching question could not be found
	*/
	public Question fetchByDifficulty_First(int difficulty,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator);

	/**
	* Returns the last question in the ordered set where difficulty = &#63;.
	*
	* @param difficulty the difficulty
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public Question findByDifficulty_Last(int difficulty,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException;

	/**
	* Returns the last question in the ordered set where difficulty = &#63;.
	*
	* @param difficulty the difficulty
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question, or <code>null</code> if a matching question could not be found
	*/
	public Question fetchByDifficulty_Last(int difficulty,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator);

	/**
	* Returns the questions before and after the current question in the ordered set where difficulty = &#63;.
	*
	* @param questionId the primary key of the current question
	* @param difficulty the difficulty
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question
	* @throws NoSuchQuestionException if a question with the primary key could not be found
	*/
	public Question[] findByDifficulty_PrevAndNext(long questionId,
		int difficulty,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException;

	/**
	* Removes all the questions where difficulty = &#63; from the database.
	*
	* @param difficulty the difficulty
	*/
	public void removeByDifficulty(int difficulty);

	/**
	* Returns the number of questions where difficulty = &#63;.
	*
	* @param difficulty the difficulty
	* @return the number of matching questions
	*/
	public int countByDifficulty(int difficulty);

	/**
	* Returns the question where questionId = &#63; or throws a {@link NoSuchQuestionException} if it could not be found.
	*
	* @param questionId the question ID
	* @return the matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public Question findByQuestionId(long questionId)
		throws NoSuchQuestionException;

	/**
	* Returns the question where questionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param questionId the question ID
	* @return the matching question, or <code>null</code> if a matching question could not be found
	*/
	public Question fetchByQuestionId(long questionId);

	/**
	* Returns the question where questionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param questionId the question ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching question, or <code>null</code> if a matching question could not be found
	*/
	public Question fetchByQuestionId(long questionId, boolean retrieveFromCache);

	/**
	* Removes the question where questionId = &#63; from the database.
	*
	* @param questionId the question ID
	* @return the question that was removed
	*/
	public Question removeByQuestionId(long questionId)
		throws NoSuchQuestionException;

	/**
	* Returns the number of questions where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the number of matching questions
	*/
	public int countByQuestionId(long questionId);

	/**
	* Returns all the questions where category = &#63; and difficulty = &#63;.
	*
	* @param category the category
	* @param difficulty the difficulty
	* @return the matching questions
	*/
	public java.util.List<Question> findByCategoryAndDifficulty(
		java.lang.String category, int difficulty);

	/**
	* Returns a range of all the questions where category = &#63; and difficulty = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param difficulty the difficulty
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @return the range of matching questions
	*/
	public java.util.List<Question> findByCategoryAndDifficulty(
		java.lang.String category, int difficulty, int start, int end);

	/**
	* Returns an ordered range of all the questions where category = &#63; and difficulty = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param difficulty the difficulty
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching questions
	*/
	public java.util.List<Question> findByCategoryAndDifficulty(
		java.lang.String category, int difficulty, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator);

	/**
	* Returns an ordered range of all the questions where category = &#63; and difficulty = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param difficulty the difficulty
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching questions
	*/
	public java.util.List<Question> findByCategoryAndDifficulty(
		java.lang.String category, int difficulty, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first question in the ordered set where category = &#63; and difficulty = &#63;.
	*
	* @param category the category
	* @param difficulty the difficulty
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public Question findByCategoryAndDifficulty_First(
		java.lang.String category, int difficulty,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException;

	/**
	* Returns the first question in the ordered set where category = &#63; and difficulty = &#63;.
	*
	* @param category the category
	* @param difficulty the difficulty
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question, or <code>null</code> if a matching question could not be found
	*/
	public Question fetchByCategoryAndDifficulty_First(
		java.lang.String category, int difficulty,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator);

	/**
	* Returns the last question in the ordered set where category = &#63; and difficulty = &#63;.
	*
	* @param category the category
	* @param difficulty the difficulty
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public Question findByCategoryAndDifficulty_Last(
		java.lang.String category, int difficulty,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException;

	/**
	* Returns the last question in the ordered set where category = &#63; and difficulty = &#63;.
	*
	* @param category the category
	* @param difficulty the difficulty
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question, or <code>null</code> if a matching question could not be found
	*/
	public Question fetchByCategoryAndDifficulty_Last(
		java.lang.String category, int difficulty,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator);

	/**
	* Returns the questions before and after the current question in the ordered set where category = &#63; and difficulty = &#63;.
	*
	* @param questionId the primary key of the current question
	* @param category the category
	* @param difficulty the difficulty
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question
	* @throws NoSuchQuestionException if a question with the primary key could not be found
	*/
	public Question[] findByCategoryAndDifficulty_PrevAndNext(long questionId,
		java.lang.String category, int difficulty,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException;

	/**
	* Removes all the questions where category = &#63; and difficulty = &#63; from the database.
	*
	* @param category the category
	* @param difficulty the difficulty
	*/
	public void removeByCategoryAndDifficulty(java.lang.String category,
		int difficulty);

	/**
	* Returns the number of questions where category = &#63; and difficulty = &#63;.
	*
	* @param category the category
	* @param difficulty the difficulty
	* @return the number of matching questions
	*/
	public int countByCategoryAndDifficulty(java.lang.String category,
		int difficulty);

	/**
	* Caches the question in the entity cache if it is enabled.
	*
	* @param question the question
	*/
	public void cacheResult(Question question);

	/**
	* Caches the questions in the entity cache if it is enabled.
	*
	* @param questions the questions
	*/
	public void cacheResult(java.util.List<Question> questions);

	/**
	* Creates a new question with the primary key. Does not add the question to the database.
	*
	* @param questionId the primary key for the new question
	* @return the new question
	*/
	public Question create(long questionId);

	/**
	* Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the question
	* @return the question that was removed
	* @throws NoSuchQuestionException if a question with the primary key could not be found
	*/
	public Question remove(long questionId) throws NoSuchQuestionException;

	public Question updateImpl(Question question);

	/**
	* Returns the question with the primary key or throws a {@link NoSuchQuestionException} if it could not be found.
	*
	* @param questionId the primary key of the question
	* @return the question
	* @throws NoSuchQuestionException if a question with the primary key could not be found
	*/
	public Question findByPrimaryKey(long questionId)
		throws NoSuchQuestionException;

	/**
	* Returns the question with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionId the primary key of the question
	* @return the question, or <code>null</code> if a question with the primary key could not be found
	*/
	public Question fetchByPrimaryKey(long questionId);

	@Override
	public java.util.Map<java.io.Serializable, Question> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the questions.
	*
	* @return the questions
	*/
	public java.util.List<Question> findAll();

	/**
	* Returns a range of all the questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @return the range of questions
	*/
	public java.util.List<Question> findAll(int start, int end);

	/**
	* Returns an ordered range of all the questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of questions
	*/
	public java.util.List<Question> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator);

	/**
	* Returns an ordered range of all the questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of questions
	*/
	public java.util.List<Question> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Question> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the questions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of questions.
	*
	* @return the number of questions
	*/
	public int countAll();
}