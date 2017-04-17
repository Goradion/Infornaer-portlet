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

package de.ki.sbam.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserStatisticsLocalService}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see UserStatisticsLocalService
 * @generated
 */
@ProviderType
public class UserStatisticsLocalServiceWrapper
	implements UserStatisticsLocalService,
		ServiceWrapper<UserStatisticsLocalService> {
	public UserStatisticsLocalServiceWrapper(
		UserStatisticsLocalService userStatisticsLocalService) {
		_userStatisticsLocalService = userStatisticsLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _userStatisticsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userStatisticsLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _userStatisticsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userStatisticsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userStatisticsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the user statistics to the database. Also notifies the appropriate model listeners.
	*
	* @param userStatistics the user statistics
	* @return the user statistics that was added
	*/
	@Override
	public de.ki.sbam.model.UserStatistics addUserStatistics(
		de.ki.sbam.model.UserStatistics userStatistics) {
		return _userStatisticsLocalService.addUserStatistics(userStatistics);
	}

	/**
	* Creates a new user statistics with the primary key. Does not add the user statistics to the database.
	*
	* @param userId the primary key for the new user statistics
	* @return the new user statistics
	*/
	@Override
	public de.ki.sbam.model.UserStatistics createUserStatistics(long userId) {
		return _userStatisticsLocalService.createUserStatistics(userId);
	}

	/**
	* Deletes the user statistics from the database. Also notifies the appropriate model listeners.
	*
	* @param userStatistics the user statistics
	* @return the user statistics that was removed
	*/
	@Override
	public de.ki.sbam.model.UserStatistics deleteUserStatistics(
		de.ki.sbam.model.UserStatistics userStatistics) {
		return _userStatisticsLocalService.deleteUserStatistics(userStatistics);
	}

	/**
	* Deletes the user statistics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the user statistics
	* @return the user statistics that was removed
	* @throws PortalException if a user statistics with the primary key could not be found
	*/
	@Override
	public de.ki.sbam.model.UserStatistics deleteUserStatistics(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userStatisticsLocalService.deleteUserStatistics(userId);
	}

	@Override
	public de.ki.sbam.model.UserStatistics fetchUserStatistics(long userId) {
		return _userStatisticsLocalService.fetchUserStatistics(userId);
	}

	/**
	* Returns the user statistics with the primary key.
	*
	* @param userId the primary key of the user statistics
	* @return the user statistics
	* @throws PortalException if a user statistics with the primary key could not be found
	*/
	@Override
	public de.ki.sbam.model.UserStatistics getUserStatistics(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userStatisticsLocalService.getUserStatistics(userId);
	}

	/**
	* Updates the user statistics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userStatistics the user statistics
	* @return the user statistics that was updated
	*/
	@Override
	public de.ki.sbam.model.UserStatistics updateUserStatistics(
		de.ki.sbam.model.UserStatistics userStatistics) {
		return _userStatisticsLocalService.updateUserStatistics(userStatistics);
	}

	/**
	* Returns the number of user statisticses.
	*
	* @return the number of user statisticses
	*/
	@Override
	public int getUserStatisticsesCount() {
		return _userStatisticsLocalService.getUserStatisticsesCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userStatisticsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userStatisticsLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _userStatisticsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.UserStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _userStatisticsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.UserStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _userStatisticsLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the user statisticses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.UserStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user statisticses
	* @param end the upper bound of the range of user statisticses (not inclusive)
	* @return the range of user statisticses
	*/
	@Override
	public java.util.List<de.ki.sbam.model.UserStatistics> getUserStatisticses(
		int start, int end) {
		return _userStatisticsLocalService.getUserStatisticses(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _userStatisticsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _userStatisticsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public UserStatisticsLocalService getWrappedService() {
		return _userStatisticsLocalService;
	}

	@Override
	public void setWrappedService(
		UserStatisticsLocalService userStatisticsLocalService) {
		_userStatisticsLocalService = userStatisticsLocalService;
	}

	private UserStatisticsLocalService _userStatisticsLocalService;
}