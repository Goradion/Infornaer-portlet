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

import de.ki.sbam.model.UserQuestion;
import de.ki.sbam.service.UserQuestionService;
import de.ki.sbam.service.persistence.CategoryPersistence;
import de.ki.sbam.service.persistence.DifficultyPersistence;
import de.ki.sbam.service.persistence.HighscorePersistence;
import de.ki.sbam.service.persistence.QuestionPersistence;
import de.ki.sbam.service.persistence.UserQuestionPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the user question remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link de.ki.sbam.service.impl.UserQuestionServiceImpl}.
 * </p>
 *
 * @author Alexander Mueller
 * @see de.ki.sbam.service.impl.UserQuestionServiceImpl
 * @see de.ki.sbam.service.UserQuestionServiceUtil
 * @generated
 */
public abstract class UserQuestionServiceBaseImpl extends BaseServiceImpl
	implements UserQuestionService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link de.ki.sbam.service.UserQuestionServiceUtil} to access the user question remote service.
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
	public de.ki.sbam.service.DifficultyService getDifficultyService() {
		return difficultyService;
	}

	/**
	 * Sets the difficulty remote service.
	 *
	 * @param difficultyService the difficulty remote service
	 */
	public void setDifficultyService(
		de.ki.sbam.service.DifficultyService difficultyService) {
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
	 * Returns the user question remote service.
	 *
	 * @return the user question remote service
	 */
	public UserQuestionService getUserQuestionService() {
		return userQuestionService;
	}

	/**
	 * Sets the user question remote service.
	 *
	 * @param userQuestionService the user question remote service
	 */
	public void setUserQuestionService(UserQuestionService userQuestionService) {
		this.userQuestionService = userQuestionService;
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
		return UserQuestionService.class.getName();
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
		return UserQuestion.class;
	}

	protected String getModelClassName() {
		return UserQuestion.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = userQuestionPersistence.getDataSource();

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
	@BeanReference(type = de.ki.sbam.service.DifficultyService.class)
	protected de.ki.sbam.service.DifficultyService difficultyService;
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
	@BeanReference(type = de.ki.sbam.service.UserQuestionLocalService.class)
	protected de.ki.sbam.service.UserQuestionLocalService userQuestionLocalService;
	@BeanReference(type = de.ki.sbam.service.UserQuestionService.class)
	protected UserQuestionService userQuestionService;
	@BeanReference(type = UserQuestionPersistence.class)
	protected UserQuestionPersistence userQuestionPersistence;
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
	private UserQuestionServiceClpInvoker _clpInvoker = new UserQuestionServiceClpInvoker();
}