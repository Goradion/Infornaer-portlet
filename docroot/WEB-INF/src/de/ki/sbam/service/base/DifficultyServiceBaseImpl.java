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

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;

import de.ki.sbam.model.Difficulty;
import de.ki.sbam.service.DifficultyService;
import de.ki.sbam.service.persistence.CategoryPersistence;
import de.ki.sbam.service.persistence.DifficultyPersistence;
import de.ki.sbam.service.persistence.HighscorePersistence;
import de.ki.sbam.service.persistence.QuestionPersistence;
import de.ki.sbam.service.persistence.QuestionStatisticsPersistence;
import de.ki.sbam.service.persistence.UserStatisticsPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the difficulty remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link de.ki.sbam.service.impl.DifficultyServiceImpl}.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see de.ki.sbam.service.impl.DifficultyServiceImpl
 * @see de.ki.sbam.service.DifficultyServiceUtil
 * @generated
 */
public abstract class DifficultyServiceBaseImpl extends BaseServiceImpl
	implements DifficultyService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link de.ki.sbam.service.DifficultyServiceUtil} to access the difficulty remote service.
	 */

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
	 * Returns the category remote service.
	 *
	 * @return the category remote service
	 */
	public de.ki.sbam.service.CategoryService getCategoryService() {
		return categoryService;
	}

	/**
	 * Sets the category remote service.
	 *
	 * @param categoryService the category remote service
	 */
	public void setCategoryService(
		de.ki.sbam.service.CategoryService categoryService) {
		this.categoryService = categoryService;
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
	 * Returns the difficulty remote service.
	 *
	 * @return the difficulty remote service
	 */
	public DifficultyService getDifficultyService() {
		return difficultyService;
	}

	/**
	 * Sets the difficulty remote service.
	 *
	 * @param difficultyService the difficulty remote service
	 */
	public void setDifficultyService(DifficultyService difficultyService) {
		this.difficultyService = difficultyService;
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
	 * Returns the highscore remote service.
	 *
	 * @return the highscore remote service
	 */
	public de.ki.sbam.service.HighscoreService getHighscoreService() {
		return highscoreService;
	}

	/**
	 * Sets the highscore remote service.
	 *
	 * @param highscoreService the highscore remote service
	 */
	public void setHighscoreService(
		de.ki.sbam.service.HighscoreService highscoreService) {
		this.highscoreService = highscoreService;
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
	public de.ki.sbam.service.QuestionLocalService getQuestionLocalService() {
		return questionLocalService;
	}

	/**
	 * Sets the question local service.
	 *
	 * @param questionLocalService the question local service
	 */
	public void setQuestionLocalService(
		de.ki.sbam.service.QuestionLocalService questionLocalService) {
		this.questionLocalService = questionLocalService;
	}

	/**
	 * Returns the question remote service.
	 *
	 * @return the question remote service
	 */
	public de.ki.sbam.service.QuestionService getQuestionService() {
		return questionService;
	}

	/**
	 * Sets the question remote service.
	 *
	 * @param questionService the question remote service
	 */
	public void setQuestionService(
		de.ki.sbam.service.QuestionService questionService) {
		this.questionService = questionService;
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
	 * Returns the question statistics local service.
	 *
	 * @return the question statistics local service
	 */
	public de.ki.sbam.service.QuestionStatisticsLocalService getQuestionStatisticsLocalService() {
		return questionStatisticsLocalService;
	}

	/**
	 * Sets the question statistics local service.
	 *
	 * @param questionStatisticsLocalService the question statistics local service
	 */
	public void setQuestionStatisticsLocalService(
		de.ki.sbam.service.QuestionStatisticsLocalService questionStatisticsLocalService) {
		this.questionStatisticsLocalService = questionStatisticsLocalService;
	}

	/**
	 * Returns the question statistics remote service.
	 *
	 * @return the question statistics remote service
	 */
	public de.ki.sbam.service.QuestionStatisticsService getQuestionStatisticsService() {
		return questionStatisticsService;
	}

	/**
	 * Sets the question statistics remote service.
	 *
	 * @param questionStatisticsService the question statistics remote service
	 */
	public void setQuestionStatisticsService(
		de.ki.sbam.service.QuestionStatisticsService questionStatisticsService) {
		this.questionStatisticsService = questionStatisticsService;
	}

	/**
	 * Returns the question statistics persistence.
	 *
	 * @return the question statistics persistence
	 */
	public QuestionStatisticsPersistence getQuestionStatisticsPersistence() {
		return questionStatisticsPersistence;
	}

	/**
	 * Sets the question statistics persistence.
	 *
	 * @param questionStatisticsPersistence the question statistics persistence
	 */
	public void setQuestionStatisticsPersistence(
		QuestionStatisticsPersistence questionStatisticsPersistence) {
		this.questionStatisticsPersistence = questionStatisticsPersistence;
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
	 * Returns the user statistics remote service.
	 *
	 * @return the user statistics remote service
	 */
	public de.ki.sbam.service.UserStatisticsService getUserStatisticsService() {
		return userStatisticsService;
	}

	/**
	 * Sets the user statistics remote service.
	 *
	 * @param userStatisticsService the user statistics remote service
	 */
	public void setUserStatisticsService(
		de.ki.sbam.service.UserStatisticsService userStatisticsService) {
		this.userStatisticsService = userStatisticsService;
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
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
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
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
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
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DifficultyService.class.getName();
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
		return Difficulty.class;
	}

	protected String getModelClassName() {
		return Difficulty.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = difficultyPersistence.getDataSource();

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
	@BeanReference(type = de.ki.sbam.service.CategoryService.class)
	protected de.ki.sbam.service.CategoryService categoryService;
	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = de.ki.sbam.service.DifficultyLocalService.class)
	protected de.ki.sbam.service.DifficultyLocalService difficultyLocalService;
	@BeanReference(type = DifficultyService.class)
	protected DifficultyService difficultyService;
	@BeanReference(type = DifficultyPersistence.class)
	protected DifficultyPersistence difficultyPersistence;
	@BeanReference(type = de.ki.sbam.service.HighscoreLocalService.class)
	protected de.ki.sbam.service.HighscoreLocalService highscoreLocalService;
	@BeanReference(type = de.ki.sbam.service.HighscoreService.class)
	protected de.ki.sbam.service.HighscoreService highscoreService;
	@BeanReference(type = HighscorePersistence.class)
	protected HighscorePersistence highscorePersistence;
	@BeanReference(type = de.ki.sbam.service.QuestionLocalService.class)
	protected de.ki.sbam.service.QuestionLocalService questionLocalService;
	@BeanReference(type = de.ki.sbam.service.QuestionService.class)
	protected de.ki.sbam.service.QuestionService questionService;
	@BeanReference(type = QuestionPersistence.class)
	protected QuestionPersistence questionPersistence;
	@BeanReference(type = de.ki.sbam.service.QuestionStatisticsLocalService.class)
	protected de.ki.sbam.service.QuestionStatisticsLocalService questionStatisticsLocalService;
	@BeanReference(type = de.ki.sbam.service.QuestionStatisticsService.class)
	protected de.ki.sbam.service.QuestionStatisticsService questionStatisticsService;
	@BeanReference(type = QuestionStatisticsPersistence.class)
	protected QuestionStatisticsPersistence questionStatisticsPersistence;
	@BeanReference(type = de.ki.sbam.service.UserStatisticsLocalService.class)
	protected de.ki.sbam.service.UserStatisticsLocalService userStatisticsLocalService;
	@BeanReference(type = de.ki.sbam.service.UserStatisticsService.class)
	protected de.ki.sbam.service.UserStatisticsService userStatisticsService;
	@BeanReference(type = UserStatisticsPersistence.class)
	protected UserStatisticsPersistence userStatisticsPersistence;
	@BeanReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private ClassLoader _classLoader;
	private DifficultyServiceClpInvoker _clpInvoker = new DifficultyServiceClpInvoker();
}