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

import de.ki.sbam.model.Question;

import java.util.List;

/**
 * The persistence utility for the question service. This utility wraps {@link de.ki.sbam.service.persistence.impl.QuestionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionPersistence
 * @see de.ki.sbam.service.persistence.impl.QuestionPersistenceImpl
 * @generated
 */
@ProviderType
public class QuestionUtil {
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
	public static void clearCache(Question question) {
		getPersistence().clearCache(question);
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
	public static List<Question> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Question> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Question> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Question> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Question update(Question question) {
		return getPersistence().update(question);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Question update(Question question,
		ServiceContext serviceContext) {
		return getPersistence().update(question, serviceContext);
	}

	/**
	* Returns all the questions where categoryId_fk = &#63;.
	*
	* @param categoryId_fk the category id_fk
	* @return the matching questions
	*/
	public static List<Question> findByCategory(long categoryId_fk) {
		return getPersistence().findByCategory(categoryId_fk);
	}

	/**
	* Returns a range of all the questions where categoryId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId_fk the category id_fk
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @return the range of matching questions
	*/
	public static List<Question> findByCategory(long categoryId_fk, int start,
		int end) {
		return getPersistence().findByCategory(categoryId_fk, start, end);
	}

	/**
	* Returns an ordered range of all the questions where categoryId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId_fk the category id_fk
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching questions
	*/
	public static List<Question> findByCategory(long categoryId_fk, int start,
		int end, OrderByComparator<Question> orderByComparator) {
		return getPersistence()
				   .findByCategory(categoryId_fk, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the questions where categoryId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId_fk the category id_fk
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching questions
	*/
	public static List<Question> findByCategory(long categoryId_fk, int start,
		int end, OrderByComparator<Question> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCategory(categoryId_fk, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first question in the ordered set where categoryId_fk = &#63;.
	*
	* @param categoryId_fk the category id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public static Question findByCategory_First(long categoryId_fk,
		OrderByComparator<Question> orderByComparator)
		throws de.ki.sbam.exception.NoSuchQuestionException {
		return getPersistence()
				   .findByCategory_First(categoryId_fk, orderByComparator);
	}

	/**
	* Returns the first question in the ordered set where categoryId_fk = &#63;.
	*
	* @param categoryId_fk the category id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question, or <code>null</code> if a matching question could not be found
	*/
	public static Question fetchByCategory_First(long categoryId_fk,
		OrderByComparator<Question> orderByComparator) {
		return getPersistence()
				   .fetchByCategory_First(categoryId_fk, orderByComparator);
	}

	/**
	* Returns the last question in the ordered set where categoryId_fk = &#63;.
	*
	* @param categoryId_fk the category id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public static Question findByCategory_Last(long categoryId_fk,
		OrderByComparator<Question> orderByComparator)
		throws de.ki.sbam.exception.NoSuchQuestionException {
		return getPersistence()
				   .findByCategory_Last(categoryId_fk, orderByComparator);
	}

	/**
	* Returns the last question in the ordered set where categoryId_fk = &#63;.
	*
	* @param categoryId_fk the category id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question, or <code>null</code> if a matching question could not be found
	*/
	public static Question fetchByCategory_Last(long categoryId_fk,
		OrderByComparator<Question> orderByComparator) {
		return getPersistence()
				   .fetchByCategory_Last(categoryId_fk, orderByComparator);
	}

	/**
	* Returns the questions before and after the current question in the ordered set where categoryId_fk = &#63;.
	*
	* @param questionId the primary key of the current question
	* @param categoryId_fk the category id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question
	* @throws NoSuchQuestionException if a question with the primary key could not be found
	*/
	public static Question[] findByCategory_PrevAndNext(long questionId,
		long categoryId_fk, OrderByComparator<Question> orderByComparator)
		throws de.ki.sbam.exception.NoSuchQuestionException {
		return getPersistence()
				   .findByCategory_PrevAndNext(questionId, categoryId_fk,
			orderByComparator);
	}

	/**
	* Removes all the questions where categoryId_fk = &#63; from the database.
	*
	* @param categoryId_fk the category id_fk
	*/
	public static void removeByCategory(long categoryId_fk) {
		getPersistence().removeByCategory(categoryId_fk);
	}

	/**
	* Returns the number of questions where categoryId_fk = &#63;.
	*
	* @param categoryId_fk the category id_fk
	* @return the number of matching questions
	*/
	public static int countByCategory(long categoryId_fk) {
		return getPersistence().countByCategory(categoryId_fk);
	}

	/**
	* Returns all the questions where difficultyId_fk = &#63;.
	*
	* @param difficultyId_fk the difficulty id_fk
	* @return the matching questions
	*/
	public static List<Question> findByDifficulty(long difficultyId_fk) {
		return getPersistence().findByDifficulty(difficultyId_fk);
	}

	/**
	* Returns a range of all the questions where difficultyId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param difficultyId_fk the difficulty id_fk
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @return the range of matching questions
	*/
	public static List<Question> findByDifficulty(long difficultyId_fk,
		int start, int end) {
		return getPersistence().findByDifficulty(difficultyId_fk, start, end);
	}

	/**
	* Returns an ordered range of all the questions where difficultyId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param difficultyId_fk the difficulty id_fk
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching questions
	*/
	public static List<Question> findByDifficulty(long difficultyId_fk,
		int start, int end, OrderByComparator<Question> orderByComparator) {
		return getPersistence()
				   .findByDifficulty(difficultyId_fk, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the questions where difficultyId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param difficultyId_fk the difficulty id_fk
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching questions
	*/
	public static List<Question> findByDifficulty(long difficultyId_fk,
		int start, int end, OrderByComparator<Question> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDifficulty(difficultyId_fk, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first question in the ordered set where difficultyId_fk = &#63;.
	*
	* @param difficultyId_fk the difficulty id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public static Question findByDifficulty_First(long difficultyId_fk,
		OrderByComparator<Question> orderByComparator)
		throws de.ki.sbam.exception.NoSuchQuestionException {
		return getPersistence()
				   .findByDifficulty_First(difficultyId_fk, orderByComparator);
	}

	/**
	* Returns the first question in the ordered set where difficultyId_fk = &#63;.
	*
	* @param difficultyId_fk the difficulty id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question, or <code>null</code> if a matching question could not be found
	*/
	public static Question fetchByDifficulty_First(long difficultyId_fk,
		OrderByComparator<Question> orderByComparator) {
		return getPersistence()
				   .fetchByDifficulty_First(difficultyId_fk, orderByComparator);
	}

	/**
	* Returns the last question in the ordered set where difficultyId_fk = &#63;.
	*
	* @param difficultyId_fk the difficulty id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public static Question findByDifficulty_Last(long difficultyId_fk,
		OrderByComparator<Question> orderByComparator)
		throws de.ki.sbam.exception.NoSuchQuestionException {
		return getPersistence()
				   .findByDifficulty_Last(difficultyId_fk, orderByComparator);
	}

	/**
	* Returns the last question in the ordered set where difficultyId_fk = &#63;.
	*
	* @param difficultyId_fk the difficulty id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question, or <code>null</code> if a matching question could not be found
	*/
	public static Question fetchByDifficulty_Last(long difficultyId_fk,
		OrderByComparator<Question> orderByComparator) {
		return getPersistence()
				   .fetchByDifficulty_Last(difficultyId_fk, orderByComparator);
	}

	/**
	* Returns the questions before and after the current question in the ordered set where difficultyId_fk = &#63;.
	*
	* @param questionId the primary key of the current question
	* @param difficultyId_fk the difficulty id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question
	* @throws NoSuchQuestionException if a question with the primary key could not be found
	*/
	public static Question[] findByDifficulty_PrevAndNext(long questionId,
		long difficultyId_fk, OrderByComparator<Question> orderByComparator)
		throws de.ki.sbam.exception.NoSuchQuestionException {
		return getPersistence()
				   .findByDifficulty_PrevAndNext(questionId, difficultyId_fk,
			orderByComparator);
	}

	/**
	* Removes all the questions where difficultyId_fk = &#63; from the database.
	*
	* @param difficultyId_fk the difficulty id_fk
	*/
	public static void removeByDifficulty(long difficultyId_fk) {
		getPersistence().removeByDifficulty(difficultyId_fk);
	}

	/**
	* Returns the number of questions where difficultyId_fk = &#63;.
	*
	* @param difficultyId_fk the difficulty id_fk
	* @return the number of matching questions
	*/
	public static int countByDifficulty(long difficultyId_fk) {
		return getPersistence().countByDifficulty(difficultyId_fk);
	}

	/**
	* Returns the question where questionId = &#63; or throws a {@link NoSuchQuestionException} if it could not be found.
	*
	* @param questionId the question ID
	* @return the matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public static Question findByQuestionId(long questionId)
		throws de.ki.sbam.exception.NoSuchQuestionException {
		return getPersistence().findByQuestionId(questionId);
	}

	/**
	* Returns the question where questionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param questionId the question ID
	* @return the matching question, or <code>null</code> if a matching question could not be found
	*/
	public static Question fetchByQuestionId(long questionId) {
		return getPersistence().fetchByQuestionId(questionId);
	}

	/**
	* Returns the question where questionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param questionId the question ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching question, or <code>null</code> if a matching question could not be found
	*/
	public static Question fetchByQuestionId(long questionId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByQuestionId(questionId, retrieveFromCache);
	}

	/**
	* Removes the question where questionId = &#63; from the database.
	*
	* @param questionId the question ID
	* @return the question that was removed
	*/
	public static Question removeByQuestionId(long questionId)
		throws de.ki.sbam.exception.NoSuchQuestionException {
		return getPersistence().removeByQuestionId(questionId);
	}

	/**
	* Returns the number of questions where questionId = &#63;.
	*
	* @param questionId the question ID
	* @return the number of matching questions
	*/
	public static int countByQuestionId(long questionId) {
		return getPersistence().countByQuestionId(questionId);
	}

	/**
	* Returns all the questions where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	*
	* @param categoryId_fk the category id_fk
	* @param difficultyId_fk the difficulty id_fk
	* @return the matching questions
	*/
	public static List<Question> findByCategoryAndDifficulty(
		long categoryId_fk, long difficultyId_fk) {
		return getPersistence()
				   .findByCategoryAndDifficulty(categoryId_fk, difficultyId_fk);
	}

	/**
	* Returns a range of all the questions where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId_fk the category id_fk
	* @param difficultyId_fk the difficulty id_fk
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @return the range of matching questions
	*/
	public static List<Question> findByCategoryAndDifficulty(
		long categoryId_fk, long difficultyId_fk, int start, int end) {
		return getPersistence()
				   .findByCategoryAndDifficulty(categoryId_fk, difficultyId_fk,
			start, end);
	}

	/**
	* Returns an ordered range of all the questions where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId_fk the category id_fk
	* @param difficultyId_fk the difficulty id_fk
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching questions
	*/
	public static List<Question> findByCategoryAndDifficulty(
		long categoryId_fk, long difficultyId_fk, int start, int end,
		OrderByComparator<Question> orderByComparator) {
		return getPersistence()
				   .findByCategoryAndDifficulty(categoryId_fk, difficultyId_fk,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the questions where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId_fk the category id_fk
	* @param difficultyId_fk the difficulty id_fk
	* @param start the lower bound of the range of questions
	* @param end the upper bound of the range of questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching questions
	*/
	public static List<Question> findByCategoryAndDifficulty(
		long categoryId_fk, long difficultyId_fk, int start, int end,
		OrderByComparator<Question> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByCategoryAndDifficulty(categoryId_fk, difficultyId_fk,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first question in the ordered set where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	*
	* @param categoryId_fk the category id_fk
	* @param difficultyId_fk the difficulty id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public static Question findByCategoryAndDifficulty_First(
		long categoryId_fk, long difficultyId_fk,
		OrderByComparator<Question> orderByComparator)
		throws de.ki.sbam.exception.NoSuchQuestionException {
		return getPersistence()
				   .findByCategoryAndDifficulty_First(categoryId_fk,
			difficultyId_fk, orderByComparator);
	}

	/**
	* Returns the first question in the ordered set where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	*
	* @param categoryId_fk the category id_fk
	* @param difficultyId_fk the difficulty id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching question, or <code>null</code> if a matching question could not be found
	*/
	public static Question fetchByCategoryAndDifficulty_First(
		long categoryId_fk, long difficultyId_fk,
		OrderByComparator<Question> orderByComparator) {
		return getPersistence()
				   .fetchByCategoryAndDifficulty_First(categoryId_fk,
			difficultyId_fk, orderByComparator);
	}

	/**
	* Returns the last question in the ordered set where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	*
	* @param categoryId_fk the category id_fk
	* @param difficultyId_fk the difficulty id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question
	* @throws NoSuchQuestionException if a matching question could not be found
	*/
	public static Question findByCategoryAndDifficulty_Last(
		long categoryId_fk, long difficultyId_fk,
		OrderByComparator<Question> orderByComparator)
		throws de.ki.sbam.exception.NoSuchQuestionException {
		return getPersistence()
				   .findByCategoryAndDifficulty_Last(categoryId_fk,
			difficultyId_fk, orderByComparator);
	}

	/**
	* Returns the last question in the ordered set where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	*
	* @param categoryId_fk the category id_fk
	* @param difficultyId_fk the difficulty id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching question, or <code>null</code> if a matching question could not be found
	*/
	public static Question fetchByCategoryAndDifficulty_Last(
		long categoryId_fk, long difficultyId_fk,
		OrderByComparator<Question> orderByComparator) {
		return getPersistence()
				   .fetchByCategoryAndDifficulty_Last(categoryId_fk,
			difficultyId_fk, orderByComparator);
	}

	/**
	* Returns the questions before and after the current question in the ordered set where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	*
	* @param questionId the primary key of the current question
	* @param categoryId_fk the category id_fk
	* @param difficultyId_fk the difficulty id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next question
	* @throws NoSuchQuestionException if a question with the primary key could not be found
	*/
	public static Question[] findByCategoryAndDifficulty_PrevAndNext(
		long questionId, long categoryId_fk, long difficultyId_fk,
		OrderByComparator<Question> orderByComparator)
		throws de.ki.sbam.exception.NoSuchQuestionException {
		return getPersistence()
				   .findByCategoryAndDifficulty_PrevAndNext(questionId,
			categoryId_fk, difficultyId_fk, orderByComparator);
	}

	/**
	* Removes all the questions where categoryId_fk = &#63; and difficultyId_fk = &#63; from the database.
	*
	* @param categoryId_fk the category id_fk
	* @param difficultyId_fk the difficulty id_fk
	*/
	public static void removeByCategoryAndDifficulty(long categoryId_fk,
		long difficultyId_fk) {
		getPersistence()
			.removeByCategoryAndDifficulty(categoryId_fk, difficultyId_fk);
	}

	/**
	* Returns the number of questions where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	*
	* @param categoryId_fk the category id_fk
	* @param difficultyId_fk the difficulty id_fk
	* @return the number of matching questions
	*/
	public static int countByCategoryAndDifficulty(long categoryId_fk,
		long difficultyId_fk) {
		return getPersistence()
				   .countByCategoryAndDifficulty(categoryId_fk, difficultyId_fk);
	}

	/**
	* Caches the question in the entity cache if it is enabled.
	*
	* @param question the question
	*/
	public static void cacheResult(Question question) {
		getPersistence().cacheResult(question);
	}

	/**
	* Caches the questions in the entity cache if it is enabled.
	*
	* @param questions the questions
	*/
	public static void cacheResult(List<Question> questions) {
		getPersistence().cacheResult(questions);
	}

	/**
	* Creates a new question with the primary key. Does not add the question to the database.
	*
	* @param questionId the primary key for the new question
	* @return the new question
	*/
	public static Question create(long questionId) {
		return getPersistence().create(questionId);
	}

	/**
	* Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the question
	* @return the question that was removed
	* @throws NoSuchQuestionException if a question with the primary key could not be found
	*/
	public static Question remove(long questionId)
		throws de.ki.sbam.exception.NoSuchQuestionException {
		return getPersistence().remove(questionId);
	}

	public static Question updateImpl(Question question) {
		return getPersistence().updateImpl(question);
	}

	/**
	* Returns the question with the primary key or throws a {@link NoSuchQuestionException} if it could not be found.
	*
	* @param questionId the primary key of the question
	* @return the question
	* @throws NoSuchQuestionException if a question with the primary key could not be found
	*/
	public static Question findByPrimaryKey(long questionId)
		throws de.ki.sbam.exception.NoSuchQuestionException {
		return getPersistence().findByPrimaryKey(questionId);
	}

	/**
	* Returns the question with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionId the primary key of the question
	* @return the question, or <code>null</code> if a question with the primary key could not be found
	*/
	public static Question fetchByPrimaryKey(long questionId) {
		return getPersistence().fetchByPrimaryKey(questionId);
	}

	public static java.util.Map<java.io.Serializable, Question> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the questions.
	*
	* @return the questions
	*/
	public static List<Question> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Question> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Question> findAll(int start, int end,
		OrderByComparator<Question> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Question> findAll(int start, int end,
		OrderByComparator<Question> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the questions from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of questions.
	*
	* @return the number of questions
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuestionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (QuestionPersistence)PortletBeanLocatorUtil.locate(de.ki.sbam.service.ClpSerializer.getServletContextName(),
					QuestionPersistence.class.getName());

			ReferenceRegistry.registerReference(QuestionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static QuestionPersistence _persistence;
}