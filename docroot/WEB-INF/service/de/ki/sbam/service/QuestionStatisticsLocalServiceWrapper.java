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
 * Provides a wrapper for {@link QuestionStatisticsLocalService}.
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionStatisticsLocalService
 * @generated
 */
@ProviderType
public class QuestionStatisticsLocalServiceWrapper
	implements QuestionStatisticsLocalService,
		ServiceWrapper<QuestionStatisticsLocalService> {
	public QuestionStatisticsLocalServiceWrapper(
		QuestionStatisticsLocalService questionStatisticsLocalService) {
		_questionStatisticsLocalService = questionStatisticsLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _questionStatisticsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _questionStatisticsLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _questionStatisticsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionStatisticsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionStatisticsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public de.ki.sbam.model.QuestionStatistics addAnswer(long questionId,
		java.lang.String answer) {
		return _questionStatisticsLocalService.addAnswer(questionId, answer);
	}

	/**
	* Adds the question statistics to the database. Also notifies the appropriate model listeners.
	*
	* @param questionStatistics the question statistics
	* @return the question statistics that was added
	*/
	@Override
	public de.ki.sbam.model.QuestionStatistics addQuestionStatistics(
		de.ki.sbam.model.QuestionStatistics questionStatistics) {
		return _questionStatisticsLocalService.addQuestionStatistics(questionStatistics);
	}

	/**
	* Creates a new question statistics with the primary key. Does not add the question statistics to the database.
	*
	* @param questionId the primary key for the new question statistics
	* @return the new question statistics
	*/
	@Override
	public de.ki.sbam.model.QuestionStatistics createQuestionStatistics(
		long questionId) {
		return _questionStatisticsLocalService.createQuestionStatistics(questionId);
	}

	/**
	* Deletes the question statistics from the database. Also notifies the appropriate model listeners.
	*
	* @param questionStatistics the question statistics
	* @return the question statistics that was removed
	*/
	@Override
	public de.ki.sbam.model.QuestionStatistics deleteQuestionStatistics(
		de.ki.sbam.model.QuestionStatistics questionStatistics) {
		return _questionStatisticsLocalService.deleteQuestionStatistics(questionStatistics);
	}

	/**
	* Deletes the question statistics with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the question statistics
	* @return the question statistics that was removed
	* @throws PortalException if a question statistics with the primary key could not be found
	*/
	@Override
	public de.ki.sbam.model.QuestionStatistics deleteQuestionStatistics(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionStatisticsLocalService.deleteQuestionStatistics(questionId);
	}

	@Override
	public de.ki.sbam.model.QuestionStatistics fetchQuestionStatistics(
		long questionId) {
		return _questionStatisticsLocalService.fetchQuestionStatistics(questionId);
	}

	/**
	* Returns the question statistics with the primary key.
	*
	* @param questionId the primary key of the question statistics
	* @return the question statistics
	* @throws PortalException if a question statistics with the primary key could not be found
	*/
	@Override
	public de.ki.sbam.model.QuestionStatistics getQuestionStatistics(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _questionStatisticsLocalService.getQuestionStatistics(questionId);
	}

	/**
	* Updates the question statistics in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param questionStatistics the question statistics
	* @return the question statistics that was updated
	*/
	@Override
	public de.ki.sbam.model.QuestionStatistics updateQuestionStatistics(
		de.ki.sbam.model.QuestionStatistics questionStatistics) {
		return _questionStatisticsLocalService.updateQuestionStatistics(questionStatistics);
	}

	/**
	* Returns the number of question statisticses.
	*
	* @return the number of question statisticses
	*/
	@Override
	public int getQuestionStatisticsesCount() {
		return _questionStatisticsLocalService.getQuestionStatisticsesCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _questionStatisticsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _questionStatisticsLocalService.getOSGiServiceIdentifier();
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
		return _questionStatisticsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.QuestionStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _questionStatisticsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.QuestionStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _questionStatisticsLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the question statisticses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.QuestionStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of question statisticses
	* @param end the upper bound of the range of question statisticses (not inclusive)
	* @return the range of question statisticses
	*/
	@Override
	public java.util.List<de.ki.sbam.model.QuestionStatistics> getQuestionStatisticses(
		int start, int end) {
		return _questionStatisticsLocalService.getQuestionStatisticses(start,
			end);
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
		return _questionStatisticsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _questionStatisticsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public QuestionStatisticsLocalService getWrappedService() {
		return _questionStatisticsLocalService;
	}

	@Override
	public void setWrappedService(
		QuestionStatisticsLocalService questionStatisticsLocalService) {
		_questionStatisticsLocalService = questionStatisticsLocalService;
	}

	private QuestionStatisticsLocalService _questionStatisticsLocalService;
}