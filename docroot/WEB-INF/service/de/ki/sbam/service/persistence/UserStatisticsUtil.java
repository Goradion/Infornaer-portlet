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

import de.ki.sbam.model.UserStatistics;

import java.util.List;

/**
 * The persistence utility for the user statistics service. This utility wraps {@link de.ki.sbam.service.persistence.impl.UserStatisticsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see UserStatisticsPersistence
 * @see de.ki.sbam.service.persistence.impl.UserStatisticsPersistenceImpl
 * @generated
 */
@ProviderType
public class UserStatisticsUtil {
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
	public static void clearCache(UserStatistics userStatistics) {
		getPersistence().clearCache(userStatistics);
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
	public static List<UserStatistics> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserStatistics> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserStatistics> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserStatistics> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserStatistics update(UserStatistics userStatistics) {
		return getPersistence().update(userStatistics);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserStatistics update(UserStatistics userStatistics,
		ServiceContext serviceContext) {
		return getPersistence().update(userStatistics, serviceContext);
	}

	/**
	* Caches the user statistics in the entity cache if it is enabled.
	*
	* @param userStatistics the user statistics
	*/
	public static void cacheResult(UserStatistics userStatistics) {
		getPersistence().cacheResult(userStatistics);
	}

	/**
	* Caches the user statisticses in the entity cache if it is enabled.
	*
	* @param userStatisticses the user statisticses
	*/
	public static void cacheResult(List<UserStatistics> userStatisticses) {
		getPersistence().cacheResult(userStatisticses);
	}

	/**
	* Creates a new user statistics with the primary key. Does not add the user statistics to the database.
	*
	* @param userId the primary key for the new user statistics
	* @return the new user statistics
	*/
	public static UserStatistics create(long userId) {
		return getPersistence().create(userId);
	}

	/**
	* Removes the user statistics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the user statistics
	* @return the user statistics that was removed
	* @throws NoSuchUserStatisticsException if a user statistics with the primary key could not be found
	*/
	public static UserStatistics remove(long userId)
		throws de.ki.sbam.exception.NoSuchUserStatisticsException {
		return getPersistence().remove(userId);
	}

	public static UserStatistics updateImpl(UserStatistics userStatistics) {
		return getPersistence().updateImpl(userStatistics);
	}

	/**
	* Returns the user statistics with the primary key or throws a {@link NoSuchUserStatisticsException} if it could not be found.
	*
	* @param userId the primary key of the user statistics
	* @return the user statistics
	* @throws NoSuchUserStatisticsException if a user statistics with the primary key could not be found
	*/
	public static UserStatistics findByPrimaryKey(long userId)
		throws de.ki.sbam.exception.NoSuchUserStatisticsException {
		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	* Returns the user statistics with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the user statistics
	* @return the user statistics, or <code>null</code> if a user statistics with the primary key could not be found
	*/
	public static UserStatistics fetchByPrimaryKey(long userId) {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	public static java.util.Map<java.io.Serializable, UserStatistics> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user statisticses.
	*
	* @return the user statisticses
	*/
	public static List<UserStatistics> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user statisticses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user statisticses
	* @param end the upper bound of the range of user statisticses (not inclusive)
	* @return the range of user statisticses
	*/
	public static List<UserStatistics> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user statisticses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user statisticses
	* @param end the upper bound of the range of user statisticses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user statisticses
	*/
	public static List<UserStatistics> findAll(int start, int end,
		OrderByComparator<UserStatistics> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user statisticses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user statisticses
	* @param end the upper bound of the range of user statisticses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user statisticses
	*/
	public static List<UserStatistics> findAll(int start, int end,
		OrderByComparator<UserStatistics> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user statisticses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user statisticses.
	*
	* @return the number of user statisticses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserStatisticsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserStatisticsPersistence)PortletBeanLocatorUtil.locate(de.ki.sbam.service.ClpSerializer.getServletContextName(),
					UserStatisticsPersistence.class.getName());

			ReferenceRegistry.registerReference(UserStatisticsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static UserStatisticsPersistence _persistence;
}