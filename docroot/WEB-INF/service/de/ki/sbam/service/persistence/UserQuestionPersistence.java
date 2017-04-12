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

import de.ki.sbam.exception.NoSuchUserQuestionException;
import de.ki.sbam.model.UserQuestion;

/**
 * The persistence interface for the user question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller
 * @see de.ki.sbam.service.persistence.impl.UserQuestionPersistenceImpl
 * @see UserQuestionUtil
 * @generated
 */
@ProviderType
public interface UserQuestionPersistence extends BasePersistence<UserQuestion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserQuestionUtil} to access the user question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the user question where category = &#63; or throws a {@link NoSuchUserQuestionException} if it could not be found.
	*
	* @param category the category
	* @return the matching user question
	* @throws NoSuchUserQuestionException if a matching user question could not be found
	*/
	public UserQuestion findByCategory(java.lang.String category)
		throws NoSuchUserQuestionException;

	/**
	* Returns the user question where category = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param category the category
	* @return the matching user question, or <code>null</code> if a matching user question could not be found
	*/
	public UserQuestion fetchByCategory(java.lang.String category);

	/**
	* Returns the user question where category = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param category the category
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user question, or <code>null</code> if a matching user question could not be found
	*/
	public UserQuestion fetchByCategory(java.lang.String category,
		boolean retrieveFromCache);

	/**
	* Removes the user question where category = &#63; from the database.
	*
	* @param category the category
	* @return the user question that was removed
	*/
	public UserQuestion removeByCategory(java.lang.String category)
		throws NoSuchUserQuestionException;

	/**
	* Returns the number of user questions where category = &#63;.
	*
	* @param category the category
	* @return the number of matching user questions
	*/
	public int countByCategory(java.lang.String category);

	/**
	* Returns the user question where difficulty = &#63; or throws a {@link NoSuchUserQuestionException} if it could not be found.
	*
	* @param difficulty the difficulty
	* @return the matching user question
	* @throws NoSuchUserQuestionException if a matching user question could not be found
	*/
	public UserQuestion findByDifficulty(int difficulty)
		throws NoSuchUserQuestionException;

	/**
	* Returns the user question where difficulty = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param difficulty the difficulty
	* @return the matching user question, or <code>null</code> if a matching user question could not be found
	*/
	public UserQuestion fetchByDifficulty(int difficulty);

	/**
	* Returns the user question where difficulty = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param difficulty the difficulty
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user question, or <code>null</code> if a matching user question could not be found
	*/
	public UserQuestion fetchByDifficulty(int difficulty,
		boolean retrieveFromCache);

	/**
	* Removes the user question where difficulty = &#63; from the database.
	*
	* @param difficulty the difficulty
	* @return the user question that was removed
	*/
	public UserQuestion removeByDifficulty(int difficulty)
		throws NoSuchUserQuestionException;

	/**
	* Returns the number of user questions where difficulty = &#63;.
	*
	* @param difficulty the difficulty
	* @return the number of matching user questions
	*/
	public int countByDifficulty(int difficulty);

	/**
	* Caches the user question in the entity cache if it is enabled.
	*
	* @param userQuestion the user question
	*/
	public void cacheResult(UserQuestion userQuestion);

	/**
	* Caches the user questions in the entity cache if it is enabled.
	*
	* @param userQuestions the user questions
	*/
	public void cacheResult(java.util.List<UserQuestion> userQuestions);

	/**
	* Creates a new user question with the primary key. Does not add the user question to the database.
	*
	* @param questionId the primary key for the new user question
	* @return the new user question
	*/
	public UserQuestion create(long questionId);

	/**
	* Removes the user question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the user question
	* @return the user question that was removed
	* @throws NoSuchUserQuestionException if a user question with the primary key could not be found
	*/
	public UserQuestion remove(long questionId)
		throws NoSuchUserQuestionException;

	public UserQuestion updateImpl(UserQuestion userQuestion);

	/**
	* Returns the user question with the primary key or throws a {@link NoSuchUserQuestionException} if it could not be found.
	*
	* @param questionId the primary key of the user question
	* @return the user question
	* @throws NoSuchUserQuestionException if a user question with the primary key could not be found
	*/
	public UserQuestion findByPrimaryKey(long questionId)
		throws NoSuchUserQuestionException;

	/**
	* Returns the user question with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionId the primary key of the user question
	* @return the user question, or <code>null</code> if a user question with the primary key could not be found
	*/
	public UserQuestion fetchByPrimaryKey(long questionId);

	@Override
	public java.util.Map<java.io.Serializable, UserQuestion> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user questions.
	*
	* @return the user questions
	*/
	public java.util.List<UserQuestion> findAll();

	/**
	* Returns a range of all the user questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user questions
	* @param end the upper bound of the range of user questions (not inclusive)
	* @return the range of user questions
	*/
	public java.util.List<UserQuestion> findAll(int start, int end);

	/**
	* Returns an ordered range of all the user questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user questions
	* @param end the upper bound of the range of user questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user questions
	*/
	public java.util.List<UserQuestion> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserQuestion> orderByComparator);

	/**
	* Returns an ordered range of all the user questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user questions
	* @param end the upper bound of the range of user questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user questions
	*/
	public java.util.List<UserQuestion> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserQuestion> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user questions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user questions.
	*
	* @return the number of user questions
	*/
	public int countAll();
}