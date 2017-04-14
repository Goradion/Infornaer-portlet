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

import de.ki.sbam.model.QuestionStatistics;

import java.util.List;

/**
 * The persistence utility for the question statistics service. This utility wraps {@link de.ki.sbam.service.persistence.impl.QuestionStatisticsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionStatisticsPersistence
 * @see de.ki.sbam.service.persistence.impl.QuestionStatisticsPersistenceImpl
 * @generated
 */
@ProviderType
public class QuestionStatisticsUtil {
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
	public static void clearCache(QuestionStatistics questionStatistics) {
		getPersistence().clearCache(questionStatistics);
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
	public static List<QuestionStatistics> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuestionStatistics> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuestionStatistics> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuestionStatistics> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuestionStatistics update(
		QuestionStatistics questionStatistics) {
		return getPersistence().update(questionStatistics);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuestionStatistics update(
		QuestionStatistics questionStatistics, ServiceContext serviceContext) {
		return getPersistence().update(questionStatistics, serviceContext);
	}

	/**
	* Caches the question statistics in the entity cache if it is enabled.
	*
	* @param questionStatistics the question statistics
	*/
	public static void cacheResult(QuestionStatistics questionStatistics) {
		getPersistence().cacheResult(questionStatistics);
	}

	/**
	* Caches the question statisticses in the entity cache if it is enabled.
	*
	* @param questionStatisticses the question statisticses
	*/
	public static void cacheResult(
		List<QuestionStatistics> questionStatisticses) {
		getPersistence().cacheResult(questionStatisticses);
	}

	/**
	* Creates a new question statistics with the primary key. Does not add the question statistics to the database.
	*
	* @param questionId the primary key for the new question statistics
	* @return the new question statistics
	*/
	public static QuestionStatistics create(long questionId) {
		return getPersistence().create(questionId);
	}

	/**
	* Removes the question statistics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the question statistics
	* @return the question statistics that was removed
	* @throws NoSuchQuestionStatisticsException if a question statistics with the primary key could not be found
	*/
	public static QuestionStatistics remove(long questionId)
		throws de.ki.sbam.exception.NoSuchQuestionStatisticsException {
		return getPersistence().remove(questionId);
	}

	public static QuestionStatistics updateImpl(
		QuestionStatistics questionStatistics) {
		return getPersistence().updateImpl(questionStatistics);
	}

	/**
	* Returns the question statistics with the primary key or throws a {@link NoSuchQuestionStatisticsException} if it could not be found.
	*
	* @param questionId the primary key of the question statistics
	* @return the question statistics
	* @throws NoSuchQuestionStatisticsException if a question statistics with the primary key could not be found
	*/
	public static QuestionStatistics findByPrimaryKey(long questionId)
		throws de.ki.sbam.exception.NoSuchQuestionStatisticsException {
		return getPersistence().findByPrimaryKey(questionId);
	}

	/**
	* Returns the question statistics with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionId the primary key of the question statistics
	* @return the question statistics, or <code>null</code> if a question statistics with the primary key could not be found
	*/
	public static QuestionStatistics fetchByPrimaryKey(long questionId) {
		return getPersistence().fetchByPrimaryKey(questionId);
	}

	public static java.util.Map<java.io.Serializable, QuestionStatistics> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the question statisticses.
	*
	* @return the question statisticses
	*/
	public static List<QuestionStatistics> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<QuestionStatistics> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<QuestionStatistics> findAll(int start, int end,
		OrderByComparator<QuestionStatistics> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<QuestionStatistics> findAll(int start, int end,
		OrderByComparator<QuestionStatistics> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the question statisticses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of question statisticses.
	*
	* @return the number of question statisticses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuestionStatisticsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (QuestionStatisticsPersistence)PortletBeanLocatorUtil.locate(de.ki.sbam.service.ClpSerializer.getServletContextName(),
					QuestionStatisticsPersistence.class.getName());

			ReferenceRegistry.registerReference(QuestionStatisticsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static QuestionStatisticsPersistence _persistence;
}