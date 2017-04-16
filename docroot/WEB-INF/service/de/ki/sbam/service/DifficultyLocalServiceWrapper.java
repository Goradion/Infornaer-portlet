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
 * Provides a wrapper for {@link DifficultyLocalService}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see DifficultyLocalService
 * @generated
 */
@ProviderType
public class DifficultyLocalServiceWrapper implements DifficultyLocalService,
	ServiceWrapper<DifficultyLocalService> {
	public DifficultyLocalServiceWrapper(
		DifficultyLocalService difficultyLocalService) {
		_difficultyLocalService = difficultyLocalService;
	}

	@Override
	public de.ki.sbam.model.Difficulty addDifficultry(int score,
		boolean guaranteed) {
		return _difficultyLocalService.addDifficultry(score, guaranteed);
	}

	/**
	* Adds the difficulty to the database. Also notifies the appropriate model listeners.
	*
	* @param difficulty the difficulty
	* @return the difficulty that was added
	*/
	@Override
	public de.ki.sbam.model.Difficulty addDifficulty(
		de.ki.sbam.model.Difficulty difficulty) {
		return _difficultyLocalService.addDifficulty(difficulty);
	}

	/**
	* Creates a new difficulty with the primary key. Does not add the difficulty to the database.
	*
	* @param score the primary key for the new difficulty
	* @return the new difficulty
	*/
	@Override
	public de.ki.sbam.model.Difficulty createDifficulty(int score) {
		return _difficultyLocalService.createDifficulty(score);
	}

	/**
	* Deletes the difficulty from the database. Also notifies the appropriate model listeners.
	*
	* @param difficulty the difficulty
	* @return the difficulty that was removed
	*/
	@Override
	public de.ki.sbam.model.Difficulty deleteDifficulty(
		de.ki.sbam.model.Difficulty difficulty) {
		return _difficultyLocalService.deleteDifficulty(difficulty);
	}

	/**
	* Deletes the difficulty with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param score the primary key of the difficulty
	* @return the difficulty that was removed
	* @throws PortalException if a difficulty with the primary key could not be found
	*/
	@Override
	public de.ki.sbam.model.Difficulty deleteDifficulty(int score)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _difficultyLocalService.deleteDifficulty(score);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _difficultyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _difficultyLocalService.dynamicQuery();
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
		return _difficultyLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _difficultyLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _difficultyLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _difficultyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _difficultyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.ki.sbam.model.Difficulty fetchDifficulty(int score) {
		return _difficultyLocalService.fetchDifficulty(score);
	}

	@Override
	public java.util.List<de.ki.sbam.model.Difficulty> findAll() {
		return _difficultyLocalService.findAll();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _difficultyLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List<de.ki.sbam.model.Difficulty> getDifficulties(
		int start, int end) {
		return _difficultyLocalService.getDifficulties(start, end);
	}

	/**
	* Returns the number of difficulties.
	*
	* @return the number of difficulties
	*/
	@Override
	public int getDifficultiesCount() {
		return _difficultyLocalService.getDifficultiesCount();
	}

	/**
	* Returns the difficulty with the primary key.
	*
	* @param score the primary key of the difficulty
	* @return the difficulty
	* @throws PortalException if a difficulty with the primary key could not be found
	*/
	@Override
	public de.ki.sbam.model.Difficulty getDifficulty(int score)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _difficultyLocalService.getDifficulty(score);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _difficultyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _difficultyLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _difficultyLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _difficultyLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Updates the difficulty in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param difficulty the difficulty
	* @return the difficulty that was updated
	*/
	@Override
	public de.ki.sbam.model.Difficulty updateDifficulty(
		de.ki.sbam.model.Difficulty difficulty) {
		return _difficultyLocalService.updateDifficulty(difficulty);
	}

	@Override
	public DifficultyLocalService getWrappedService() {
		return _difficultyLocalService;
	}

	@Override
	public void setWrappedService(DifficultyLocalService difficultyLocalService) {
		_difficultyLocalService = difficultyLocalService;
	}

	private DifficultyLocalService _difficultyLocalService;
}