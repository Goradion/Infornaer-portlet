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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.service.InvokableLocalService;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the local service utility for UserStatistics. This utility wraps
 * {@link de.ki.sbam.service.impl.UserStatisticsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see UserStatisticsLocalService
 * @see de.ki.sbam.service.base.UserStatisticsLocalServiceBaseImpl
 * @see de.ki.sbam.service.impl.UserStatisticsLocalServiceImpl
 * @generated
 */
@ProviderType
public class UserStatisticsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.ki.sbam.service.impl.UserStatisticsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static de.ki.sbam.model.UserStatistics addPlayedGame(long userId) {
		return getService().addPlayedGame(userId);
	}

	public static de.ki.sbam.model.UserStatistics addRightAnswer(long userId) {
		return getService().addRightAnswer(userId);
	}

	/**
	* Adds the user statistics to the database. Also notifies the appropriate model listeners.
	*
	* @param userStatistics the user statistics
	* @return the user statistics that was added
	*/
	public static de.ki.sbam.model.UserStatistics addUserStatistics(
		de.ki.sbam.model.UserStatistics userStatistics) {
		return getService().addUserStatistics(userStatistics);
	}

	public static de.ki.sbam.model.UserStatistics addWonGame(long userId) {
		return getService().addWonGame(userId);
	}

	public static de.ki.sbam.model.UserStatistics addWrongAnswer(long userId) {
		return getService().addWrongAnswer(userId);
	}

	/**
	* Creates a new user statistics with the primary key. Does not add the user statistics to the database.
	*
	* @param userId the primary key for the new user statistics
	* @return the new user statistics
	*/
	public static de.ki.sbam.model.UserStatistics createUserStatistics(
		long userId) {
		return getService().createUserStatistics(userId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the user statistics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the user statistics
	* @return the user statistics that was removed
	* @throws PortalException if a user statistics with the primary key could not be found
	*/
	public static de.ki.sbam.model.UserStatistics deleteUserStatistics(
		long userId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteUserStatistics(userId);
	}

	/**
	* Deletes the user statistics from the database. Also notifies the appropriate model listeners.
	*
	* @param userStatistics the user statistics
	* @return the user statistics that was removed
	*/
	public static de.ki.sbam.model.UserStatistics deleteUserStatistics(
		de.ki.sbam.model.UserStatistics userStatistics) {
		return getService().deleteUserStatistics(userStatistics);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static de.ki.sbam.model.UserStatistics fetchUserStatistics(
		long userId) {
		return getService().fetchUserStatistics(userId);
	}

	public static java.util.List<de.ki.sbam.model.UserStatistics> findAll() {
		return getService().findAll();
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the user statistics with the primary key.
	*
	* @param userId the primary key of the user statistics
	* @return the user statistics
	* @throws PortalException if a user statistics with the primary key could not be found
	*/
	public static de.ki.sbam.model.UserStatistics getUserStatistics(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserStatistics(userId);
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
	public static java.util.List<de.ki.sbam.model.UserStatistics> getUserStatisticses(
		int start, int end) {
		return getService().getUserStatisticses(start, end);
	}

	/**
	* Returns the number of user statisticses.
	*
	* @return the number of user statisticses
	*/
	public static int getUserStatisticsesCount() {
		return getService().getUserStatisticsesCount();
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Updates the user statistics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userStatistics the user statistics
	* @return the user statistics that was updated
	*/
	public static de.ki.sbam.model.UserStatistics updateUserStatistics(
		de.ki.sbam.model.UserStatistics userStatistics) {
		return getService().updateUserStatistics(userStatistics);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserStatisticsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserStatisticsLocalService.class.getName());

			if (invokableLocalService instanceof UserStatisticsLocalService) {
				_service = (UserStatisticsLocalService)invokableLocalService;
			}
			else {
				_service = new UserStatisticsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserStatisticsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static UserStatisticsLocalService _service;
}