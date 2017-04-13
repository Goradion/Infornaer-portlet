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
 * Provides a wrapper for {@link UserQuestionLocalService}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see UserQuestionLocalService
 * @generated
 */
@ProviderType
public class UserQuestionLocalServiceWrapper implements UserQuestionLocalService,
	ServiceWrapper<UserQuestionLocalService> {
	public UserQuestionLocalServiceWrapper(
		UserQuestionLocalService userQuestionLocalService) {
		_userQuestionLocalService = userQuestionLocalService;
	}

	/**
	* Adds the user question to the database. Also notifies the appropriate model listeners.
	*
	* @param userQuestion the user question
	* @return the user question that was added
	*/
	@Override
	public de.ki.sbam.model.UserQuestion addUserQuestion(
		de.ki.sbam.model.UserQuestion userQuestion) {
		return _userQuestionLocalService.addUserQuestion(userQuestion);
	}

	/**
	* Creates a new user question with the primary key. Does not add the user question to the database.
	*
	* @param questionId the primary key for the new user question
	* @return the new user question
	*/
	@Override
	public de.ki.sbam.model.UserQuestion createUserQuestion(long questionId) {
		return _userQuestionLocalService.createUserQuestion(questionId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userQuestionLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the user question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the user question
	* @return the user question that was removed
	* @throws PortalException if a user question with the primary key could not be found
	*/
	@Override
	public de.ki.sbam.model.UserQuestion deleteUserQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userQuestionLocalService.deleteUserQuestion(questionId);
	}

	/**
	* Deletes the user question from the database. Also notifies the appropriate model listeners.
	*
	* @param userQuestion the user question
	* @return the user question that was removed
	*/
	@Override
	public de.ki.sbam.model.UserQuestion deleteUserQuestion(
		de.ki.sbam.model.UserQuestion userQuestion) {
		return _userQuestionLocalService.deleteUserQuestion(userQuestion);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userQuestionLocalService.dynamicQuery();
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
		return _userQuestionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.UserQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userQuestionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.UserQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userQuestionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _userQuestionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userQuestionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.ki.sbam.model.UserQuestion fetchUserQuestion(long questionId) {
		return _userQuestionLocalService.fetchUserQuestion(questionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _userQuestionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _userQuestionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userQuestionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userQuestionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the user question with the primary key.
	*
	* @param questionId the primary key of the user question
	* @return the user question
	* @throws PortalException if a user question with the primary key could not be found
	*/
	@Override
	public de.ki.sbam.model.UserQuestion getUserQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userQuestionLocalService.getUserQuestion(questionId);
	}

	/**
	* Returns a range of all the user questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.UserQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user questions
	* @param end the upper bound of the range of user questions (not inclusive)
	* @return the range of user questions
	*/
	@Override
	public java.util.List<de.ki.sbam.model.UserQuestion> getUserQuestions(
		int start, int end) {
		return _userQuestionLocalService.getUserQuestions(start, end);
	}

	/**
	* Returns the number of user questions.
	*
	* @return the number of user questions
	*/
	@Override
	public int getUserQuestionsCount() {
		return _userQuestionLocalService.getUserQuestionsCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userQuestionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Updates the user question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userQuestion the user question
	* @return the user question that was updated
	*/
	@Override
	public de.ki.sbam.model.UserQuestion updateUserQuestion(
		de.ki.sbam.model.UserQuestion userQuestion) {
		return _userQuestionLocalService.updateUserQuestion(userQuestion);
	}

	@Override
	public UserQuestionLocalService getWrappedService() {
		return _userQuestionLocalService;
	}

	@Override
	public void setWrappedService(
		UserQuestionLocalService userQuestionLocalService) {
		_userQuestionLocalService = userQuestionLocalService;
	}

	private UserQuestionLocalService _userQuestionLocalService;
}