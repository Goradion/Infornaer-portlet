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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import de.ki.sbam.model.UserQuestion;

import java.util.List;

/**
 * The persistence utility for the user question service. This utility wraps {@link de.ki.sbam.service.persistence.impl.UserQuestionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller
 * @see UserQuestionPersistence
 * @see de.ki.sbam.service.persistence.impl.UserQuestionPersistenceImpl
 * @generated
 */
@ProviderType
public class UserQuestionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(UserQuestion userQuestion) {
		getPersistence().clearCache(userQuestion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserQuestion> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserQuestion update(UserQuestion userQuestion) {
		return getPersistence().update(userQuestion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserQuestion update(UserQuestion userQuestion,
		ServiceContext serviceContext) {
		return getPersistence().update(userQuestion, serviceContext);
	}

	/**
	* Returns the user question where category = &#63; or throws a {@link NoSuchUserQuestionException} if it could not be found.
	*
	* @param category the category
	* @return the matching user question
	* @throws NoSuchUserQuestionException if a matching user question could not be found
	*/
	public static UserQuestion findByCategory(java.lang.String category)
		throws de.ki.sbam.exception.NoSuchUserQuestionException {
		return getPersistence().findByCategory(category);
	}

	/**
	* Returns the user question where category = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param category the category
	* @return the matching user question, or <code>null</code> if a matching user question could not be found
	*/
	public static UserQuestion fetchByCategory(java.lang.String category) {
		return getPersistence().fetchByCategory(category);
	}

	/**
	* Returns the user question where category = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param category the category
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user question, or <code>null</code> if a matching user question could not be found
	*/
	public static UserQuestion fetchByCategory(java.lang.String category,
		boolean retrieveFromCache) {
		return getPersistence().fetchByCategory(category, retrieveFromCache);
	}

	/**
	* Removes the user question where category = &#63; from the database.
	*
	* @param category the category
	* @return the user question that was removed
	*/
	public static UserQuestion removeByCategory(java.lang.String category)
		throws de.ki.sbam.exception.NoSuchUserQuestionException {
		return getPersistence().removeByCategory(category);
	}

	/**
	* Returns the number of user questions where category = &#63;.
	*
	* @param category the category
	* @return the number of matching user questions
	*/
	public static int countByCategory(java.lang.String category) {
		return getPersistence().countByCategory(category);
	}

	/**
	* Returns the user question where difficulty = &#63; or throws a {@link NoSuchUserQuestionException} if it could not be found.
	*
	* @param difficulty the difficulty
	* @return the matching user question
	* @throws NoSuchUserQuestionException if a matching user question could not be found
	*/
	public static UserQuestion findByDifficulty(int difficulty)
		throws de.ki.sbam.exception.NoSuchUserQuestionException {
		return getPersistence().findByDifficulty(difficulty);
	}

	/**
	* Returns the user question where difficulty = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param difficulty the difficulty
	* @return the matching user question, or <code>null</code> if a matching user question could not be found
	*/
	public static UserQuestion fetchByDifficulty(int difficulty) {
		return getPersistence().fetchByDifficulty(difficulty);
	}

	/**
	* Returns the user question where difficulty = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param difficulty the difficulty
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user question, or <code>null</code> if a matching user question could not be found
	*/
	public static UserQuestion fetchByDifficulty(int difficulty,
		boolean retrieveFromCache) {
		return getPersistence().fetchByDifficulty(difficulty, retrieveFromCache);
	}

	/**
	* Removes the user question where difficulty = &#63; from the database.
	*
	* @param difficulty the difficulty
	* @return the user question that was removed
	*/
	public static UserQuestion removeByDifficulty(int difficulty)
		throws de.ki.sbam.exception.NoSuchUserQuestionException {
		return getPersistence().removeByDifficulty(difficulty);
	}

	/**
	* Returns the number of user questions where difficulty = &#63;.
	*
	* @param difficulty the difficulty
	* @return the number of matching user questions
	*/
	public static int countByDifficulty(int difficulty) {
		return getPersistence().countByDifficulty(difficulty);
	}

	/**
	* Caches the user question in the entity cache if it is enabled.
	*
	* @param userQuestion the user question
	*/
	public static void cacheResult(UserQuestion userQuestion) {
		getPersistence().cacheResult(userQuestion);
	}

	/**
	* Caches the user questions in the entity cache if it is enabled.
	*
	* @param userQuestions the user questions
	*/
	public static void cacheResult(List<UserQuestion> userQuestions) {
		getPersistence().cacheResult(userQuestions);
	}

	/**
	* Creates a new user question with the primary key. Does not add the user question to the database.
	*
	* @param questionId the primary key for the new user question
	* @return the new user question
	*/
	public static UserQuestion create(long questionId) {
		return getPersistence().create(questionId);
	}

	/**
	* Removes the user question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the user question
	* @return the user question that was removed
	* @throws NoSuchUserQuestionException if a user question with the primary key could not be found
	*/
	public static UserQuestion remove(long questionId)
		throws de.ki.sbam.exception.NoSuchUserQuestionException {
		return getPersistence().remove(questionId);
	}

	public static UserQuestion updateImpl(UserQuestion userQuestion) {
		return getPersistence().updateImpl(userQuestion);
	}

	/**
	* Returns the user question with the primary key or throws a {@link NoSuchUserQuestionException} if it could not be found.
	*
	* @param questionId the primary key of the user question
	* @return the user question
	* @throws NoSuchUserQuestionException if a user question with the primary key could not be found
	*/
	public static UserQuestion findByPrimaryKey(long questionId)
		throws de.ki.sbam.exception.NoSuchUserQuestionException {
		return getPersistence().findByPrimaryKey(questionId);
	}

	/**
	* Returns the user question with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionId the primary key of the user question
	* @return the user question, or <code>null</code> if a user question with the primary key could not be found
	*/
	public static UserQuestion fetchByPrimaryKey(long questionId) {
		return getPersistence().fetchByPrimaryKey(questionId);
	}

	public static java.util.Map<java.io.Serializable, UserQuestion> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user questions.
	*
	* @return the user questions
	*/
	public static List<UserQuestion> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<UserQuestion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<UserQuestion> findAll(int start, int end,
		OrderByComparator<UserQuestion> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<UserQuestion> findAll(int start, int end,
		OrderByComparator<UserQuestion> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user questions from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user questions.
	*
	* @return the number of user questions
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserQuestionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserQuestionPersistence)PortletBeanLocatorUtil.locate(de.ki.sbam.service.ClpSerializer.getServletContextName(),
					UserQuestionPersistence.class.getName());

			ReferenceRegistry.registerReference(UserQuestionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static UserQuestionPersistence _persistence;
}