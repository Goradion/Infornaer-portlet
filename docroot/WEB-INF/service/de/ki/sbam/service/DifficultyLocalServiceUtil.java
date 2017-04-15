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
 * Provides the local service utility for Difficulty. This utility wraps
 * {@link de.ki.sbam.service.impl.DifficultyLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see DifficultyLocalService
 * @see de.ki.sbam.service.base.DifficultyLocalServiceBaseImpl
 * @see de.ki.sbam.service.impl.DifficultyLocalServiceImpl
 * @generated
 */
@ProviderType
public class DifficultyLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.ki.sbam.service.impl.DifficultyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the difficulty to the database. Also notifies the appropriate model listeners.
	*
	* @param difficulty the difficulty
	* @return the difficulty that was added
	*/
	public static de.ki.sbam.model.Difficulty addDifficulty(
		de.ki.sbam.model.Difficulty difficulty) {
		return getService().addDifficulty(difficulty);
	}

	/**
	* Creates a new difficulty with the primary key. Does not add the difficulty to the database.
	*
	* @param difficultyId the primary key for the new difficulty
	* @return the new difficulty
	*/
	public static de.ki.sbam.model.Difficulty createDifficulty(
		long difficultyId) {
		return getService().createDifficulty(difficultyId);
	}

	/**
	* Deletes the difficulty from the database. Also notifies the appropriate model listeners.
	*
	* @param difficulty the difficulty
	* @return the difficulty that was removed
	*/
	public static de.ki.sbam.model.Difficulty deleteDifficulty(
		de.ki.sbam.model.Difficulty difficulty) {
		return getService().deleteDifficulty(difficulty);
	}

	/**
	* Deletes the difficulty with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param difficultyId the primary key of the difficulty
	* @return the difficulty that was removed
	* @throws PortalException if a difficulty with the primary key could not be found
	*/
	public static de.ki.sbam.model.Difficulty deleteDifficulty(
		long difficultyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteDifficulty(difficultyId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.DifficultyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.DifficultyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static de.ki.sbam.model.Difficulty fetchDifficulty(long difficultyId) {
		return getService().fetchDifficulty(difficultyId);
	}

	public static java.util.List<de.ki.sbam.model.Difficulty> findAll() {
		return getService().findAll();
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns a range of all the difficulties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.DifficultyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of difficulties
	* @param end the upper bound of the range of difficulties (not inclusive)
	* @return the range of difficulties
	*/
	public static java.util.List<de.ki.sbam.model.Difficulty> getDifficulties(
		int start, int end) {
		return getService().getDifficulties(start, end);
	}

	/**
	* Returns the number of difficulties.
	*
	* @return the number of difficulties
	*/
	public static int getDifficultiesCount() {
		return getService().getDifficultiesCount();
	}

	/**
	* Returns the difficulty with the primary key.
	*
	* @param difficultyId the primary key of the difficulty
	* @return the difficulty
	* @throws PortalException if a difficulty with the primary key could not be found
	*/
	public static de.ki.sbam.model.Difficulty getDifficulty(long difficultyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getDifficulty(difficultyId);
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

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Updates the difficulty in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param difficulty the difficulty
	* @return the difficulty that was updated
	*/
	public static de.ki.sbam.model.Difficulty updateDifficulty(
		de.ki.sbam.model.Difficulty difficulty) {
		return getService().updateDifficulty(difficulty);
	}

	public static void clearService() {
		_service = null;
	}

	public static DifficultyLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DifficultyLocalService.class.getName());

			if (invokableLocalService instanceof DifficultyLocalService) {
				_service = (DifficultyLocalService)invokableLocalService;
			}
			else {
				_service = new DifficultyLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DifficultyLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static DifficultyLocalService _service;
}