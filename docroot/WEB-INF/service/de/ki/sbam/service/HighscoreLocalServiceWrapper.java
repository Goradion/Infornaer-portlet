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
 * Provides a wrapper for {@link HighscoreLocalService}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see HighscoreLocalService
 * @generated
 */
@ProviderType
public class HighscoreLocalServiceWrapper implements HighscoreLocalService,
	ServiceWrapper<HighscoreLocalService> {
	public HighscoreLocalServiceWrapper(
		HighscoreLocalService highscoreLocalService) {
		_highscoreLocalService = highscoreLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _highscoreLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _highscoreLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _highscoreLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _highscoreLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _highscoreLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the highscore to the database. Also notifies the appropriate model listeners.
	*
	* @param highscore the highscore
	* @return the highscore that was added
	*/
	@Override
	public de.ki.sbam.model.Highscore addHighscore(
		de.ki.sbam.model.Highscore highscore) {
		return _highscoreLocalService.addHighscore(highscore);
	}

	/**
	* Creates a new highscore with the primary key. Does not add the highscore to the database.
	*
	* @param userId the primary key for the new highscore
	* @return the new highscore
	*/
	@Override
	public de.ki.sbam.model.Highscore createHighscore(long userId) {
		return _highscoreLocalService.createHighscore(userId);
	}

	/**
	* Deletes the highscore from the database. Also notifies the appropriate model listeners.
	*
	* @param highscore the highscore
	* @return the highscore that was removed
	*/
	@Override
	public de.ki.sbam.model.Highscore deleteHighscore(
		de.ki.sbam.model.Highscore highscore) {
		return _highscoreLocalService.deleteHighscore(highscore);
	}

	/**
	* Deletes the highscore with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the highscore
	* @return the highscore that was removed
	* @throws PortalException if a highscore with the primary key could not be found
	*/
	@Override
	public de.ki.sbam.model.Highscore deleteHighscore(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _highscoreLocalService.deleteHighscore(userId);
	}

	@Override
	public de.ki.sbam.model.Highscore fetchHighscore(long userId) {
		return _highscoreLocalService.fetchHighscore(userId);
	}

	/**
	* Returns the highscore with the primary key.
	*
	* @param userId the primary key of the highscore
	* @return the highscore
	* @throws PortalException if a highscore with the primary key could not be found
	*/
	@Override
	public de.ki.sbam.model.Highscore getHighscore(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _highscoreLocalService.getHighscore(userId);
	}

	/**
	* Updates the highscore in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param highscore the highscore
	* @return the highscore that was updated
	*/
	@Override
	public de.ki.sbam.model.Highscore updateHighscore(
		de.ki.sbam.model.Highscore highscore) {
		return _highscoreLocalService.updateHighscore(highscore);
	}

	/**
	* Returns the number of highscores.
	*
	* @return the number of highscores
	*/
	@Override
	public int getHighscoresCount() {
		return _highscoreLocalService.getHighscoresCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _highscoreLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _highscoreLocalService.getOSGiServiceIdentifier();
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
		return _highscoreLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.HighscoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _highscoreLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.HighscoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _highscoreLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the highscores.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.HighscoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of highscores
	* @param end the upper bound of the range of highscores (not inclusive)
	* @return the range of highscores
	*/
	@Override
	public java.util.List<de.ki.sbam.model.Highscore> getHighscores(int start,
		int end) {
		return _highscoreLocalService.getHighscores(start, end);
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
		return _highscoreLocalService.dynamicQueryCount(dynamicQuery);
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
		return _highscoreLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public HighscoreLocalService getWrappedService() {
		return _highscoreLocalService;
	}

	@Override
	public void setWrappedService(HighscoreLocalService highscoreLocalService) {
		_highscoreLocalService = highscoreLocalService;
	}

	private HighscoreLocalService _highscoreLocalService;
}