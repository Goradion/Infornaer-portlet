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

package de.ki.sbam.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import de.ki.sbam.exception.NoSuchUserQuestionException;
import de.ki.sbam.model.UserQuestion;
import de.ki.sbam.model.impl.UserQuestionImpl;
import de.ki.sbam.model.impl.UserQuestionModelImpl;
import de.ki.sbam.service.persistence.UserQuestionPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the user question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller
 * @see UserQuestionPersistence
 * @see de.ki.sbam.service.persistence.UserQuestionUtil
 * @generated
 */
@ProviderType
public class UserQuestionPersistenceImpl extends BasePersistenceImpl<UserQuestion>
	implements UserQuestionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserQuestionUtil} to access the user question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserQuestionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
			UserQuestionModelImpl.FINDER_CACHE_ENABLED, UserQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
			UserQuestionModelImpl.FINDER_CACHE_ENABLED, UserQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
			UserQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CATEGORY = new FinderPath(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
			UserQuestionModelImpl.FINDER_CACHE_ENABLED, UserQuestionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCategory",
			new String[] { String.class.getName() },
			UserQuestionModelImpl.CATEGORY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
			UserQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { String.class.getName() });

	/**
	 * Returns the user question where category = &#63; or throws a {@link NoSuchUserQuestionException} if it could not be found.
	 *
	 * @param category the category
	 * @return the matching user question
	 * @throws NoSuchUserQuestionException if a matching user question could not be found
	 */
	@Override
	public UserQuestion findByCategory(String category)
		throws NoSuchUserQuestionException {
		UserQuestion userQuestion = fetchByCategory(category);

		if (userQuestion == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("category=");
			msg.append(category);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserQuestionException(msg.toString());
		}

		return userQuestion;
	}

	/**
	 * Returns the user question where category = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param category the category
	 * @return the matching user question, or <code>null</code> if a matching user question could not be found
	 */
	@Override
	public UserQuestion fetchByCategory(String category) {
		return fetchByCategory(category, true);
	}

	/**
	 * Returns the user question where category = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param category the category
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user question, or <code>null</code> if a matching user question could not be found
	 */
	@Override
	public UserQuestion fetchByCategory(String category,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { category };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_CATEGORY,
					finderArgs, this);
		}

		if (result instanceof UserQuestion) {
			UserQuestion userQuestion = (UserQuestion)result;

			if (!Objects.equals(category, userQuestion.getCategory())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERQUESTION_WHERE);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategory) {
					qPos.add(category);
				}

				List<UserQuestion> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_CATEGORY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserQuestionPersistenceImpl.fetchByCategory(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserQuestion userQuestion = list.get(0);

					result = userQuestion;

					cacheResult(userQuestion);

					if ((userQuestion.getCategory() == null) ||
							!userQuestion.getCategory().equals(category)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_CATEGORY,
							finderArgs, userQuestion);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_CATEGORY,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserQuestion)result;
		}
	}

	/**
	 * Removes the user question where category = &#63; from the database.
	 *
	 * @param category the category
	 * @return the user question that was removed
	 */
	@Override
	public UserQuestion removeByCategory(String category)
		throws NoSuchUserQuestionException {
		UserQuestion userQuestion = findByCategory(category);

		return remove(userQuestion);
	}

	/**
	 * Returns the number of user questions where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching user questions
	 */
	@Override
	public int countByCategory(String category) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY;

		Object[] finderArgs = new Object[] { category };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERQUESTION_WHERE);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategory) {
					qPos.add(category);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_1 = "userQuestion.category IS NULL";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_2 = "userQuestion.category = ?";
	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_3 = "(userQuestion.category IS NULL OR userQuestion.category = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_DIFFICULTY = new FinderPath(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
			UserQuestionModelImpl.FINDER_CACHE_ENABLED, UserQuestionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDifficulty",
			new String[] { Integer.class.getName() },
			UserQuestionModelImpl.DIFFICULTY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DIFFICULTY = new FinderPath(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
			UserQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDifficulty",
			new String[] { Integer.class.getName() });

	/**
	 * Returns the user question where difficulty = &#63; or throws a {@link NoSuchUserQuestionException} if it could not be found.
	 *
	 * @param difficulty the difficulty
	 * @return the matching user question
	 * @throws NoSuchUserQuestionException if a matching user question could not be found
	 */
	@Override
	public UserQuestion findByDifficulty(int difficulty)
		throws NoSuchUserQuestionException {
		UserQuestion userQuestion = fetchByDifficulty(difficulty);

		if (userQuestion == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("difficulty=");
			msg.append(difficulty);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchUserQuestionException(msg.toString());
		}

		return userQuestion;
	}

	/**
	 * Returns the user question where difficulty = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param difficulty the difficulty
	 * @return the matching user question, or <code>null</code> if a matching user question could not be found
	 */
	@Override
	public UserQuestion fetchByDifficulty(int difficulty) {
		return fetchByDifficulty(difficulty, true);
	}

	/**
	 * Returns the user question where difficulty = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param difficulty the difficulty
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user question, or <code>null</code> if a matching user question could not be found
	 */
	@Override
	public UserQuestion fetchByDifficulty(int difficulty,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { difficulty };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_DIFFICULTY,
					finderArgs, this);
		}

		if (result instanceof UserQuestion) {
			UserQuestion userQuestion = (UserQuestion)result;

			if ((difficulty != userQuestion.getDifficulty())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERQUESTION_WHERE);

			query.append(_FINDER_COLUMN_DIFFICULTY_DIFFICULTY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(difficulty);

				List<UserQuestion> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_DIFFICULTY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserQuestionPersistenceImpl.fetchByDifficulty(int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserQuestion userQuestion = list.get(0);

					result = userQuestion;

					cacheResult(userQuestion);

					if ((userQuestion.getDifficulty() != difficulty)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_DIFFICULTY,
							finderArgs, userQuestion);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_DIFFICULTY,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserQuestion)result;
		}
	}

	/**
	 * Removes the user question where difficulty = &#63; from the database.
	 *
	 * @param difficulty the difficulty
	 * @return the user question that was removed
	 */
	@Override
	public UserQuestion removeByDifficulty(int difficulty)
		throws NoSuchUserQuestionException {
		UserQuestion userQuestion = findByDifficulty(difficulty);

		return remove(userQuestion);
	}

	/**
	 * Returns the number of user questions where difficulty = &#63;.
	 *
	 * @param difficulty the difficulty
	 * @return the number of matching user questions
	 */
	@Override
	public int countByDifficulty(int difficulty) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DIFFICULTY;

		Object[] finderArgs = new Object[] { difficulty };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERQUESTION_WHERE);

			query.append(_FINDER_COLUMN_DIFFICULTY_DIFFICULTY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(difficulty);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DIFFICULTY_DIFFICULTY_2 = "userQuestion.difficulty = ?";

	public UserQuestionPersistenceImpl() {
		setModelClass(UserQuestion.class);
	}

	/**
	 * Caches the user question in the entity cache if it is enabled.
	 *
	 * @param userQuestion the user question
	 */
	@Override
	public void cacheResult(UserQuestion userQuestion) {
		entityCache.putResult(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
			UserQuestionImpl.class, userQuestion.getPrimaryKey(), userQuestion);

		finderCache.putResult(FINDER_PATH_FETCH_BY_CATEGORY,
			new Object[] { userQuestion.getCategory() }, userQuestion);

		finderCache.putResult(FINDER_PATH_FETCH_BY_DIFFICULTY,
			new Object[] { userQuestion.getDifficulty() }, userQuestion);

		userQuestion.resetOriginalValues();
	}

	/**
	 * Caches the user questions in the entity cache if it is enabled.
	 *
	 * @param userQuestions the user questions
	 */
	@Override
	public void cacheResult(List<UserQuestion> userQuestions) {
		for (UserQuestion userQuestion : userQuestions) {
			if (entityCache.getResult(
						UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
						UserQuestionImpl.class, userQuestion.getPrimaryKey()) == null) {
				cacheResult(userQuestion);
			}
			else {
				userQuestion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user questions.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserQuestionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user question.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserQuestion userQuestion) {
		entityCache.removeResult(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
			UserQuestionImpl.class, userQuestion.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((UserQuestionModelImpl)userQuestion);
	}

	@Override
	public void clearCache(List<UserQuestion> userQuestions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserQuestion userQuestion : userQuestions) {
			entityCache.removeResult(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
				UserQuestionImpl.class, userQuestion.getPrimaryKey());

			clearUniqueFindersCache((UserQuestionModelImpl)userQuestion);
		}
	}

	protected void cacheUniqueFindersCache(
		UserQuestionModelImpl userQuestionModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { userQuestionModelImpl.getCategory() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_CATEGORY, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_CATEGORY, args,
				userQuestionModelImpl);

			args = new Object[] { userQuestionModelImpl.getDifficulty() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_DIFFICULTY, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_DIFFICULTY, args,
				userQuestionModelImpl);
		}
		else {
			if ((userQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { userQuestionModelImpl.getCategory() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_CATEGORY, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_CATEGORY, args,
					userQuestionModelImpl);
			}

			if ((userQuestionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DIFFICULTY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userQuestionModelImpl.getDifficulty()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_DIFFICULTY, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_DIFFICULTY, args,
					userQuestionModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		UserQuestionModelImpl userQuestionModelImpl) {
		Object[] args = new Object[] { userQuestionModelImpl.getCategory() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_CATEGORY, args);

		if ((userQuestionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CATEGORY.getColumnBitmask()) != 0) {
			args = new Object[] { userQuestionModelImpl.getOriginalCategory() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CATEGORY, args);
		}

		args = new Object[] { userQuestionModelImpl.getDifficulty() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_DIFFICULTY, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_DIFFICULTY, args);

		if ((userQuestionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DIFFICULTY.getColumnBitmask()) != 0) {
			args = new Object[] { userQuestionModelImpl.getOriginalDifficulty() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DIFFICULTY, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_DIFFICULTY, args);
		}
	}

	/**
	 * Creates a new user question with the primary key. Does not add the user question to the database.
	 *
	 * @param questionId the primary key for the new user question
	 * @return the new user question
	 */
	@Override
	public UserQuestion create(long questionId) {
		UserQuestion userQuestion = new UserQuestionImpl();

		userQuestion.setNew(true);
		userQuestion.setPrimaryKey(questionId);

		return userQuestion;
	}

	/**
	 * Removes the user question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionId the primary key of the user question
	 * @return the user question that was removed
	 * @throws NoSuchUserQuestionException if a user question with the primary key could not be found
	 */
	@Override
	public UserQuestion remove(long questionId)
		throws NoSuchUserQuestionException {
		return remove((Serializable)questionId);
	}

	/**
	 * Removes the user question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user question
	 * @return the user question that was removed
	 * @throws NoSuchUserQuestionException if a user question with the primary key could not be found
	 */
	@Override
	public UserQuestion remove(Serializable primaryKey)
		throws NoSuchUserQuestionException {
		Session session = null;

		try {
			session = openSession();

			UserQuestion userQuestion = (UserQuestion)session.get(UserQuestionImpl.class,
					primaryKey);

			if (userQuestion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userQuestion);
		}
		catch (NoSuchUserQuestionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserQuestion removeImpl(UserQuestion userQuestion) {
		userQuestion = toUnwrappedModel(userQuestion);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userQuestion)) {
				userQuestion = (UserQuestion)session.get(UserQuestionImpl.class,
						userQuestion.getPrimaryKeyObj());
			}

			if (userQuestion != null) {
				session.delete(userQuestion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userQuestion != null) {
			clearCache(userQuestion);
		}

		return userQuestion;
	}

	@Override
	public UserQuestion updateImpl(UserQuestion userQuestion) {
		userQuestion = toUnwrappedModel(userQuestion);

		boolean isNew = userQuestion.isNew();

		UserQuestionModelImpl userQuestionModelImpl = (UserQuestionModelImpl)userQuestion;

		Session session = null;

		try {
			session = openSession();

			if (userQuestion.isNew()) {
				session.save(userQuestion);

				userQuestion.setNew(false);
			}
			else {
				userQuestion = (UserQuestion)session.merge(userQuestion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserQuestionModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
			UserQuestionImpl.class, userQuestion.getPrimaryKey(), userQuestion,
			false);

		clearUniqueFindersCache(userQuestionModelImpl);
		cacheUniqueFindersCache(userQuestionModelImpl, isNew);

		userQuestion.resetOriginalValues();

		return userQuestion;
	}

	protected UserQuestion toUnwrappedModel(UserQuestion userQuestion) {
		if (userQuestion instanceof UserQuestionImpl) {
			return userQuestion;
		}

		UserQuestionImpl userQuestionImpl = new UserQuestionImpl();

		userQuestionImpl.setNew(userQuestion.isNew());
		userQuestionImpl.setPrimaryKey(userQuestion.getPrimaryKey());

		userQuestionImpl.setUserId(userQuestion.getUserId());
		userQuestionImpl.setUserName(userQuestion.getUserName());
		userQuestionImpl.setQuestionId(userQuestion.getQuestionId());
		userQuestionImpl.setQuestion(userQuestion.getQuestion());
		userQuestionImpl.setAnswerA(userQuestion.getAnswerA());
		userQuestionImpl.setAnswerB(userQuestion.getAnswerB());
		userQuestionImpl.setAnswerC(userQuestion.getAnswerC());
		userQuestionImpl.setAnswerD(userQuestion.getAnswerD());
		userQuestionImpl.setCategory(userQuestion.getCategory());
		userQuestionImpl.setDifficulty(userQuestion.getDifficulty());
		userQuestionImpl.setRightAnswer(userQuestion.getRightAnswer());

		return userQuestionImpl;
	}

	/**
	 * Returns the user question with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user question
	 * @return the user question
	 * @throws NoSuchUserQuestionException if a user question with the primary key could not be found
	 */
	@Override
	public UserQuestion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserQuestionException {
		UserQuestion userQuestion = fetchByPrimaryKey(primaryKey);

		if (userQuestion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userQuestion;
	}

	/**
	 * Returns the user question with the primary key or throws a {@link NoSuchUserQuestionException} if it could not be found.
	 *
	 * @param questionId the primary key of the user question
	 * @return the user question
	 * @throws NoSuchUserQuestionException if a user question with the primary key could not be found
	 */
	@Override
	public UserQuestion findByPrimaryKey(long questionId)
		throws NoSuchUserQuestionException {
		return findByPrimaryKey((Serializable)questionId);
	}

	/**
	 * Returns the user question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user question
	 * @return the user question, or <code>null</code> if a user question with the primary key could not be found
	 */
	@Override
	public UserQuestion fetchByPrimaryKey(Serializable primaryKey) {
		UserQuestion userQuestion = (UserQuestion)entityCache.getResult(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
				UserQuestionImpl.class, primaryKey);

		if (userQuestion == _nullUserQuestion) {
			return null;
		}

		if (userQuestion == null) {
			Session session = null;

			try {
				session = openSession();

				userQuestion = (UserQuestion)session.get(UserQuestionImpl.class,
						primaryKey);

				if (userQuestion != null) {
					cacheResult(userQuestion);
				}
				else {
					entityCache.putResult(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
						UserQuestionImpl.class, primaryKey, _nullUserQuestion);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
					UserQuestionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userQuestion;
	}

	/**
	 * Returns the user question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionId the primary key of the user question
	 * @return the user question, or <code>null</code> if a user question with the primary key could not be found
	 */
	@Override
	public UserQuestion fetchByPrimaryKey(long questionId) {
		return fetchByPrimaryKey((Serializable)questionId);
	}

	@Override
	public Map<Serializable, UserQuestion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserQuestion> map = new HashMap<Serializable, UserQuestion>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserQuestion userQuestion = fetchByPrimaryKey(primaryKey);

			if (userQuestion != null) {
				map.put(primaryKey, userQuestion);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			UserQuestion userQuestion = (UserQuestion)entityCache.getResult(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
					UserQuestionImpl.class, primaryKey);

			if (userQuestion == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, userQuestion);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERQUESTION_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (UserQuestion userQuestion : (List<UserQuestion>)q.list()) {
				map.put(userQuestion.getPrimaryKeyObj(), userQuestion);

				cacheResult(userQuestion);

				uncachedPrimaryKeys.remove(userQuestion.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserQuestionModelImpl.ENTITY_CACHE_ENABLED,
					UserQuestionImpl.class, primaryKey, _nullUserQuestion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the user questions.
	 *
	 * @return the user questions
	 */
	@Override
	public List<UserQuestion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user questions
	 * @param end the upper bound of the range of user questions (not inclusive)
	 * @return the range of user questions
	 */
	@Override
	public List<UserQuestion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user questions
	 * @param end the upper bound of the range of user questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user questions
	 */
	@Override
	public List<UserQuestion> findAll(int start, int end,
		OrderByComparator<UserQuestion> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user questions
	 * @param end the upper bound of the range of user questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user questions
	 */
	@Override
	public List<UserQuestion> findAll(int start, int end,
		OrderByComparator<UserQuestion> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<UserQuestion> list = null;

		if (retrieveFromCache) {
			list = (List<UserQuestion>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERQUESTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERQUESTION;

				if (pagination) {
					sql = sql.concat(UserQuestionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserQuestion>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserQuestion>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user questions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserQuestion userQuestion : findAll()) {
			remove(userQuestion);
		}
	}

	/**
	 * Returns the number of user questions.
	 *
	 * @return the number of user questions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERQUESTION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserQuestionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user question persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserQuestionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_USERQUESTION = "SELECT userQuestion FROM UserQuestion userQuestion";
	private static final String _SQL_SELECT_USERQUESTION_WHERE_PKS_IN = "SELECT userQuestion FROM UserQuestion userQuestion WHERE questionId IN (";
	private static final String _SQL_SELECT_USERQUESTION_WHERE = "SELECT userQuestion FROM UserQuestion userQuestion WHERE ";
	private static final String _SQL_COUNT_USERQUESTION = "SELECT COUNT(userQuestion) FROM UserQuestion userQuestion";
	private static final String _SQL_COUNT_USERQUESTION_WHERE = "SELECT COUNT(userQuestion) FROM UserQuestion userQuestion WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userQuestion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserQuestion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserQuestion exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UserQuestionPersistenceImpl.class);
	private static final UserQuestion _nullUserQuestion = new UserQuestionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserQuestion> toCacheModel() {
				return _nullUserQuestionCacheModel;
			}
		};

	private static final CacheModel<UserQuestion> _nullUserQuestionCacheModel = new CacheModel<UserQuestion>() {
			@Override
			public UserQuestion toEntityModel() {
				return _nullUserQuestion;
			}
		};
}