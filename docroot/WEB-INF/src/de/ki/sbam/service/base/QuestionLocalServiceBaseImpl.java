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

package de.ki.sbam.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import de.ki.sbam.model.Question;
import de.ki.sbam.service.QuestionLocalService;
import de.ki.sbam.service.persistence.CategoryPersistence;
import de.ki.sbam.service.persistence.DifficultyPersistence;
import de.ki.sbam.service.persistence.HighscorePersistence;
import de.ki.sbam.service.persistence.QuestionPersistence;
import de.ki.sbam.service.persistence.UserQuestionPersistence;
import de.ki.sbam.service.persistence.UserStatisticsPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the question local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link de.ki.sbam.service.impl.QuestionLocalServiceImpl}.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see de.ki.sbam.service.impl.QuestionLocalServiceImpl
 * @see de.ki.sbam.service.QuestionLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class QuestionLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements QuestionLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link de.ki.sbam.service.QuestionLocalServiceUtil} to access the question local service.
	 */

	/**
	 * Adds the question to the database. Also notifies the appropriate model listeners.
	 *
	 * @param question the question
	 * @return the question that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Question addQuestion(Question question) {
		question.setNew(true);

		return questionPersistence.update(question);
	}

	/**
	 * Creates a new question with the primary key. Does not add the question to the database.
	 *
	 * @param questionId the primary key for the new question
	 * @return the new question
	 */
	@Override
	public Question createQuestion(long questionId) {
		return questionPersistence.create(questionId);
	}

	/**
	 * Deletes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionId the primary key of the question
	 * @return the question that was removed
	 * @throws PortalException if a question with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Question deleteQuestion(long questionId) throws PortalException {
		return questionPersistence.remove(questionId);
	}

	/**
	 * Deletes the question from the database. Also notifies the appropriate model listeners.
	 *
	 * @param question the question
	 * @return the question that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Question deleteQuestion(Question question) {
		return questionPersistence.remove(question);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Question.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return questionPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return questionPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return questionPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return questionPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return questionPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Question fetchQuestion(long questionId) {
		return questionPersistence.fetchByPrimaryKey(questionId);
	}

	/**
	 * Returns the question with the primary key.
	 *
	 * @param questionId the primary key of the question
	 * @return the question
	 * @throws PortalException if a question with the primary key could not be found
	 */
	@Override
	public Question getQuestion(long questionId) throws PortalException {
		return questionPersistence.findByPrimaryKey(questionId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(de.ki.sbam.service.QuestionLocalServiceUtil.getService());
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Question.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("questionId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(de.ki.sbam.service.QuestionLocalServiceUtil.getService());
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Question.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("questionId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(de.ki.sbam.service.QuestionLocalServiceUtil.getService());
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Question.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("questionId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return questionLocalService.deleteQuestion((Question)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return questionPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbam.model.impl.QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of questions
	 */
	@Override
	public List<Question> getQuestions(int start, int end) {
		return questionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of questions.
	 *
	 * @return the number of questions
	 */
	@Override
	public int getQuestionsCount() {
		return questionPersistence.countAll();
	}

	/**
	 * Updates the question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param question the question
	 * @return the question that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Question updateQuestion(Question question) {
		return questionPersistence.update(question);
	}

	/**
	 * Returns the category local service.
	 *
	 * @return the category local service
	 */
	public de.ki.sbam.service.CategoryLocalService getCategoryLocalService() {
		return categoryLocalService;
	}

	/**
	 * Sets the category local service.
	 *
	 * @param categoryLocalService the category local service
	 */
	public void setCategoryLocalService(
		de.ki.sbam.service.CategoryLocalService categoryLocalService) {
		this.categoryLocalService = categoryLocalService;
	}

	/**
	 * Returns the category persistence.
	 *
	 * @return the category persistence
	 */
	public CategoryPersistence getCategoryPersistence() {
		return categoryPersistence;
	}

	/**
	 * Sets the category persistence.
	 *
	 * @param categoryPersistence the category persistence
	 */
	public void setCategoryPersistence(CategoryPersistence categoryPersistence) {
		this.categoryPersistence = categoryPersistence;
	}

	/**
	 * Returns the difficulty local service.
	 *
	 * @return the difficulty local service
	 */
	public de.ki.sbam.service.DifficultyLocalService getDifficultyLocalService() {
		return difficultyLocalService;
	}

	/**
	 * Sets the difficulty local service.
	 *
	 * @param difficultyLocalService the difficulty local service
	 */
	public void setDifficultyLocalService(
		de.ki.sbam.service.DifficultyLocalService difficultyLocalService) {
		this.difficultyLocalService = difficultyLocalService;
	}

	/**
	 * Returns the difficulty persistence.
	 *
	 * @return the difficulty persistence
	 */
	public DifficultyPersistence getDifficultyPersistence() {
		return difficultyPersistence;
	}

	/**
	 * Sets the difficulty persistence.
	 *
	 * @param difficultyPersistence the difficulty persistence
	 */
	public void setDifficultyPersistence(
		DifficultyPersistence difficultyPersistence) {
		this.difficultyPersistence = difficultyPersistence;
	}

	/**
	 * Returns the highscore local service.
	 *
	 * @return the highscore local service
	 */
	public de.ki.sbam.service.HighscoreLocalService getHighscoreLocalService() {
		return highscoreLocalService;
	}

	/**
	 * Sets the highscore local service.
	 *
	 * @param highscoreLocalService the highscore local service
	 */
	public void setHighscoreLocalService(
		de.ki.sbam.service.HighscoreLocalService highscoreLocalService) {
		this.highscoreLocalService = highscoreLocalService;
	}

	/**
	 * Returns the highscore persistence.
	 *
	 * @return the highscore persistence
	 */
	public HighscorePersistence getHighscorePersistence() {
		return highscorePersistence;
	}

	/**
	 * Sets the highscore persistence.
	 *
	 * @param highscorePersistence the highscore persistence
	 */
	public void setHighscorePersistence(
		HighscorePersistence highscorePersistence) {
		this.highscorePersistence = highscorePersistence;
	}

	/**
	 * Returns the question local service.
	 *
	 * @return the question local service
	 */
	public QuestionLocalService getQuestionLocalService() {
		return questionLocalService;
	}

	/**
	 * Sets the question local service.
	 *
	 * @param questionLocalService the question local service
	 */
	public void setQuestionLocalService(
		QuestionLocalService questionLocalService) {
		this.questionLocalService = questionLocalService;
	}

	/**
	 * Returns the question persistence.
	 *
	 * @return the question persistence
	 */
	public QuestionPersistence getQuestionPersistence() {
		return questionPersistence;
	}

	/**
	 * Sets the question persistence.
	 *
	 * @param questionPersistence the question persistence
	 */
	public void setQuestionPersistence(QuestionPersistence questionPersistence) {
		this.questionPersistence = questionPersistence;
	}

	/**
	 * Returns the user question local service.
	 *
	 * @return the user question local service
	 */
	public de.ki.sbam.service.UserQuestionLocalService getUserQuestionLocalService() {
		return userQuestionLocalService;
	}

	/**
	 * Sets the user question local service.
	 *
	 * @param userQuestionLocalService the user question local service
	 */
	public void setUserQuestionLocalService(
		de.ki.sbam.service.UserQuestionLocalService userQuestionLocalService) {
		this.userQuestionLocalService = userQuestionLocalService;
	}

	/**
	 * Returns the user question persistence.
	 *
	 * @return the user question persistence
	 */
	public UserQuestionPersistence getUserQuestionPersistence() {
		return userQuestionPersistence;
	}

	/**
	 * Sets the user question persistence.
	 *
	 * @param userQuestionPersistence the user question persistence
	 */
	public void setUserQuestionPersistence(
		UserQuestionPersistence userQuestionPersistence) {
		this.userQuestionPersistence = userQuestionPersistence;
	}

	/**
	 * Returns the user statistics local service.
	 *
	 * @return the user statistics local service
	 */
	public de.ki.sbam.service.UserStatisticsLocalService getUserStatisticsLocalService() {
		return userStatisticsLocalService;
	}

	/**
	 * Sets the user statistics local service.
	 *
	 * @param userStatisticsLocalService the user statistics local service
	 */
	public void setUserStatisticsLocalService(
		de.ki.sbam.service.UserStatisticsLocalService userStatisticsLocalService) {
		this.userStatisticsLocalService = userStatisticsLocalService;
	}

	/**
	 * Returns the user statistics persistence.
	 *
	 * @return the user statistics persistence
	 */
	public UserStatisticsPersistence getUserStatisticsPersistence() {
		return userStatisticsPersistence;
	}

	/**
	 * Sets the user statistics persistence.
	 *
	 * @param userStatisticsPersistence the user statistics persistence
	 */
	public void setUserStatisticsPersistence(
		UserStatisticsPersistence userStatisticsPersistence) {
		this.userStatisticsPersistence = userStatisticsPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("de.ki.sbam.model.Question",
			questionLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"de.ki.sbam.model.Question");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return QuestionLocalService.class.getName();
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Question.class;
	}

	protected String getModelClassName() {
		return Question.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = questionPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = de.ki.sbam.service.CategoryLocalService.class)
	protected de.ki.sbam.service.CategoryLocalService categoryLocalService;
	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = de.ki.sbam.service.DifficultyLocalService.class)
	protected de.ki.sbam.service.DifficultyLocalService difficultyLocalService;
	@BeanReference(type = DifficultyPersistence.class)
	protected DifficultyPersistence difficultyPersistence;
	@BeanReference(type = de.ki.sbam.service.HighscoreLocalService.class)
	protected de.ki.sbam.service.HighscoreLocalService highscoreLocalService;
	@BeanReference(type = HighscorePersistence.class)
	protected HighscorePersistence highscorePersistence;
	@BeanReference(type = de.ki.sbam.service.QuestionLocalService.class)
	protected QuestionLocalService questionLocalService;
	@BeanReference(type = QuestionPersistence.class)
	protected QuestionPersistence questionPersistence;
	@BeanReference(type = de.ki.sbam.service.UserQuestionLocalService.class)
	protected de.ki.sbam.service.UserQuestionLocalService userQuestionLocalService;
	@BeanReference(type = UserQuestionPersistence.class)
	protected UserQuestionPersistence userQuestionPersistence;
	@BeanReference(type = de.ki.sbam.service.UserStatisticsLocalService.class)
	protected de.ki.sbam.service.UserStatisticsLocalService userStatisticsLocalService;
	@BeanReference(type = UserStatisticsPersistence.class)
	protected UserStatisticsPersistence userStatisticsPersistence;
	@BeanReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private ClassLoader _classLoader;
	private QuestionLocalServiceClpInvoker _clpInvoker = new QuestionLocalServiceClpInvoker();
}