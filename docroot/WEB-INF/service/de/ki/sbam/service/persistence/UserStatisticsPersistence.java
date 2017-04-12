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

import de.ki.sbam.exception.NoSuchUserStatisticsException;
import de.ki.sbam.model.UserStatistics;

/**
 * The persistence interface for the user statistics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller
 * @see de.ki.sbam.service.persistence.impl.UserStatisticsPersistenceImpl
 * @see UserStatisticsUtil
 * @generated
 */
@ProviderType
public interface UserStatisticsPersistence extends BasePersistence<UserStatistics> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserStatisticsUtil} to access the user statistics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user statistics in the entity cache if it is enabled.
	*
	* @param userStatistics the user statistics
	*/
	public void cacheResult(UserStatistics userStatistics);

	/**
	* Caches the user statisticses in the entity cache if it is enabled.
	*
	* @param userStatisticses the user statisticses
	*/
	public void cacheResult(java.util.List<UserStatistics> userStatisticses);

	/**
	* Creates a new user statistics with the primary key. Does not add the user statistics to the database.
	*
	* @param userId the primary key for the new user statistics
	* @return the new user statistics
	*/
	public UserStatistics create(long userId);

	/**
	* Removes the user statistics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the user statistics
	* @return the user statistics that was removed
	* @throws NoSuchUserStatisticsException if a user statistics with the primary key could not be found
	*/
	public UserStatistics remove(long userId)
		throws NoSuchUserStatisticsException;

	public UserStatistics updateImpl(UserStatistics userStatistics);

	/**
	* Returns the user statistics with the primary key or throws a {@link NoSuchUserStatisticsException} if it could not be found.
	*
	* @param userId the primary key of the user statistics
	* @return the user statistics
	* @throws NoSuchUserStatisticsException if a user statistics with the primary key could not be found
	*/
	public UserStatistics findByPrimaryKey(long userId)
		throws NoSuchUserStatisticsException;

	/**
	* Returns the user statistics with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the user statistics
	* @return the user statistics, or <code>null</code> if a user statistics with the primary key could not be found
	*/
	public UserStatistics fetchByPrimaryKey(long userId);

	@Override
	public java.util.Map<java.io.Serializable, UserStatistics> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user statisticses.
	*
	* @return the user statisticses
	*/
	public java.util.List<UserStatistics> findAll();

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
	public java.util.List<UserStatistics> findAll(int start, int end);

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
	public java.util.List<UserStatistics> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserStatistics> orderByComparator);

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
	public java.util.List<UserStatistics> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserStatistics> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user statisticses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user statisticses.
	*
	* @return the number of user statisticses
	*/
	public int countAll();
}