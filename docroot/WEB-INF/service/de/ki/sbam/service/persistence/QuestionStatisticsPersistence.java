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

import de.ki.sbam.exception.NoSuchQuestionStatisticsException;
import de.ki.sbam.model.QuestionStatistics;

/**
 * The persistence interface for the question statistics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see de.ki.sbam.service.persistence.impl.QuestionStatisticsPersistenceImpl
 * @see QuestionStatisticsUtil
 * @generated
 */
@ProviderType
public interface QuestionStatisticsPersistence extends BasePersistence<QuestionStatistics> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuestionStatisticsUtil} to access the question statistics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the question statistics in the entity cache if it is enabled.
	*
	* @param questionStatistics the question statistics
	*/
	public void cacheResult(QuestionStatistics questionStatistics);

	/**
	* Caches the question statisticses in the entity cache if it is enabled.
	*
	* @param questionStatisticses the question statisticses
	*/
	public void cacheResult(
		java.util.List<QuestionStatistics> questionStatisticses);

	/**
	* Creates a new question statistics with the primary key. Does not add the question statistics to the database.
	*
	* @param questionId the primary key for the new question statistics
	* @return the new question statistics
	*/
	public QuestionStatistics create(long questionId);

	/**
	* Removes the question statistics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the question statistics
	* @return the question statistics that was removed
	* @throws NoSuchQuestionStatisticsException if a question statistics with the primary key could not be found
	*/
	public QuestionStatistics remove(long questionId)
		throws NoSuchQuestionStatisticsException;

	public QuestionStatistics updateImpl(QuestionStatistics questionStatistics);

	/**
	* Returns the question statistics with the primary key or throws a {@link NoSuchQuestionStatisticsException} if it could not be found.
	*
	* @param questionId the primary key of the question statistics
	* @return the question statistics
	* @throws NoSuchQuestionStatisticsException if a question statistics with the primary key could not be found
	*/
	public QuestionStatistics findByPrimaryKey(long questionId)
		throws NoSuchQuestionStatisticsException;

	/**
	* Returns the question statistics with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionId the primary key of the question statistics
	* @return the question statistics, or <code>null</code> if a question statistics with the primary key could not be found
	*/
	public QuestionStatistics fetchByPrimaryKey(long questionId);

	@Override
	public java.util.Map<java.io.Serializable, QuestionStatistics> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the question statisticses.
	*
	* @return the question statisticses
	*/
	public java.util.List<QuestionStatistics> findAll();

	/**
	* Returns a range of all the question statisticses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question statisticses
	* @param end the upper bound of the range of question statisticses (not inclusive)
	* @return the range of question statisticses
	*/
	public java.util.List<QuestionStatistics> findAll(int start, int end);

	/**
	* Returns an ordered range of all the question statisticses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question statisticses
	* @param end the upper bound of the range of question statisticses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of question statisticses
	*/
	public java.util.List<QuestionStatistics> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionStatistics> orderByComparator);

	/**
	* Returns an ordered range of all the question statisticses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question statisticses
	* @param end the upper bound of the range of question statisticses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of question statisticses
	*/
	public java.util.List<QuestionStatistics> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuestionStatistics> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the question statisticses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of question statisticses.
	*
	* @return the number of question statisticses
	*/
	public int countAll();
}