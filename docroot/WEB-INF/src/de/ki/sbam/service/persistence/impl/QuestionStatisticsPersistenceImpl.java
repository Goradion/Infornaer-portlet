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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import de.ki.sbam.exception.NoSuchQuestionStatisticsException;
import de.ki.sbam.model.QuestionStatistics;
import de.ki.sbam.model.impl.QuestionStatisticsImpl;
import de.ki.sbam.model.impl.QuestionStatisticsModelImpl;
import de.ki.sbam.service.persistence.QuestionStatisticsPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the question statistics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionStatisticsPersistence
 * @see de.ki.sbam.service.persistence.QuestionStatisticsUtil
 * @generated
 */
@ProviderType
public class QuestionStatisticsPersistenceImpl extends BasePersistenceImpl<QuestionStatistics>
	implements QuestionStatisticsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QuestionStatisticsUtil} to access the question statistics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QuestionStatisticsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QuestionStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			QuestionStatisticsModelImpl.FINDER_CACHE_ENABLED,
			QuestionStatisticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QuestionStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			QuestionStatisticsModelImpl.FINDER_CACHE_ENABLED,
			QuestionStatisticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuestionStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			QuestionStatisticsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public QuestionStatisticsPersistenceImpl() {
		setModelClass(QuestionStatistics.class);
	}

	/**
	 * Caches the question statistics in the entity cache if it is enabled.
	 *
	 * @param questionStatistics the question statistics
	 */
	@Override
	public void cacheResult(QuestionStatistics questionStatistics) {
		entityCache.putResult(QuestionStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			QuestionStatisticsImpl.class, questionStatistics.getPrimaryKey(),
			questionStatistics);

		questionStatistics.resetOriginalValues();
	}

	/**
	 * Caches the question statisticses in the entity cache if it is enabled.
	 *
	 * @param questionStatisticses the question statisticses
	 */
	@Override
	public void cacheResult(List<QuestionStatistics> questionStatisticses) {
		for (QuestionStatistics questionStatistics : questionStatisticses) {
			if (entityCache.getResult(
						QuestionStatisticsModelImpl.ENTITY_CACHE_ENABLED,
						QuestionStatisticsImpl.class,
						questionStatistics.getPrimaryKey()) == null) {
				cacheResult(questionStatistics);
			}
			else {
				questionStatistics.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all question statisticses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(QuestionStatisticsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the question statistics.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuestionStatistics questionStatistics) {
		entityCache.removeResult(QuestionStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			QuestionStatisticsImpl.class, questionStatistics.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<QuestionStatistics> questionStatisticses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (QuestionStatistics questionStatistics : questionStatisticses) {
			entityCache.removeResult(QuestionStatisticsModelImpl.ENTITY_CACHE_ENABLED,
				QuestionStatisticsImpl.class, questionStatistics.getPrimaryKey());
		}
	}

	/**
	 * Creates a new question statistics with the primary key. Does not add the question statistics to the database.
	 *
	 * @param questionId the primary key for the new question statistics
	 * @return the new question statistics
	 */
	@Override
	public QuestionStatistics create(long questionId) {
		QuestionStatistics questionStatistics = new QuestionStatisticsImpl();

		questionStatistics.setNew(true);
		questionStatistics.setPrimaryKey(questionId);

		return questionStatistics;
	}

	/**
	 * Removes the question statistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionId the primary key of the question statistics
	 * @return the question statistics that was removed
	 * @throws NoSuchQuestionStatisticsException if a question statistics with the primary key could not be found
	 */
	@Override
	public QuestionStatistics remove(long questionId)
		throws NoSuchQuestionStatisticsException {
		return remove((Serializable)questionId);
	}

	/**
	 * Removes the question statistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the question statistics
	 * @return the question statistics that was removed
	 * @throws NoSuchQuestionStatisticsException if a question statistics with the primary key could not be found
	 */
	@Override
	public QuestionStatistics remove(Serializable primaryKey)
		throws NoSuchQuestionStatisticsException {
		Session session = null;

		try {
			session = openSession();

			QuestionStatistics questionStatistics = (QuestionStatistics)session.get(QuestionStatisticsImpl.class,
					primaryKey);

			if (questionStatistics == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionStatisticsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(questionStatistics);
		}
		catch (NoSuchQuestionStatisticsException nsee) {
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
	protected QuestionStatistics removeImpl(
		QuestionStatistics questionStatistics) {
		questionStatistics = toUnwrappedModel(questionStatistics);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(questionStatistics)) {
				questionStatistics = (QuestionStatistics)session.get(QuestionStatisticsImpl.class,
						questionStatistics.getPrimaryKeyObj());
			}

			if (questionStatistics != null) {
				session.delete(questionStatistics);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (questionStatistics != null) {
			clearCache(questionStatistics);
		}

		return questionStatistics;
	}

	@Override
	public QuestionStatistics updateImpl(QuestionStatistics questionStatistics) {
		questionStatistics = toUnwrappedModel(questionStatistics);

		boolean isNew = questionStatistics.isNew();

		Session session = null;

		try {
			session = openSession();

			if (questionStatistics.isNew()) {
				session.save(questionStatistics);

				questionStatistics.setNew(false);
			}
			else {
				questionStatistics = (QuestionStatistics)session.merge(questionStatistics);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(QuestionStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			QuestionStatisticsImpl.class, questionStatistics.getPrimaryKey(),
			questionStatistics, false);

		questionStatistics.resetOriginalValues();

		return questionStatistics;
	}

	protected QuestionStatistics toUnwrappedModel(
		QuestionStatistics questionStatistics) {
		if (questionStatistics instanceof QuestionStatisticsImpl) {
			return questionStatistics;
		}

		QuestionStatisticsImpl questionStatisticsImpl = new QuestionStatisticsImpl();

		questionStatisticsImpl.setNew(questionStatistics.isNew());
		questionStatisticsImpl.setPrimaryKey(questionStatistics.getPrimaryKey());

		questionStatisticsImpl.setQuestionId(questionStatistics.getQuestionId());
		questionStatisticsImpl.setAnswered_a(questionStatistics.getAnswered_a());
		questionStatisticsImpl.setAnswered_b(questionStatistics.getAnswered_b());
		questionStatisticsImpl.setAnswered_c(questionStatistics.getAnswered_c());
		questionStatisticsImpl.setAnswered_d(questionStatistics.getAnswered_d());

		return questionStatisticsImpl;
	}

	/**
	 * Returns the question statistics with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the question statistics
	 * @return the question statistics
	 * @throws NoSuchQuestionStatisticsException if a question statistics with the primary key could not be found
	 */
	@Override
	public QuestionStatistics findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuestionStatisticsException {
		QuestionStatistics questionStatistics = fetchByPrimaryKey(primaryKey);

		if (questionStatistics == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuestionStatisticsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return questionStatistics;
	}

	/**
	 * Returns the question statistics with the primary key or throws a {@link NoSuchQuestionStatisticsException} if it could not be found.
	 *
	 * @param questionId the primary key of the question statistics
	 * @return the question statistics
	 * @throws NoSuchQuestionStatisticsException if a question statistics with the primary key could not be found
	 */
	@Override
	public QuestionStatistics findByPrimaryKey(long questionId)
		throws NoSuchQuestionStatisticsException {
		return findByPrimaryKey((Serializable)questionId);
	}

	/**
	 * Returns the question statistics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the question statistics
	 * @return the question statistics, or <code>null</code> if a question statistics with the primary key could not be found
	 */
	@Override
	public QuestionStatistics fetchByPrimaryKey(Serializable primaryKey) {
		QuestionStatistics questionStatistics = (QuestionStatistics)entityCache.getResult(QuestionStatisticsModelImpl.ENTITY_CACHE_ENABLED,
				QuestionStatisticsImpl.class, primaryKey);

		if (questionStatistics == _nullQuestionStatistics) {
			return null;
		}

		if (questionStatistics == null) {
			Session session = null;

			try {
				session = openSession();

				questionStatistics = (QuestionStatistics)session.get(QuestionStatisticsImpl.class,
						primaryKey);

				if (questionStatistics != null) {
					cacheResult(questionStatistics);
				}
				else {
					entityCache.putResult(QuestionStatisticsModelImpl.ENTITY_CACHE_ENABLED,
						QuestionStatisticsImpl.class, primaryKey,
						_nullQuestionStatistics);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(QuestionStatisticsModelImpl.ENTITY_CACHE_ENABLED,
					QuestionStatisticsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return questionStatistics;
	}

	/**
	 * Returns the question statistics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionId the primary key of the question statistics
	 * @return the question statistics, or <code>null</code> if a question statistics with the primary key could not be found
	 */
	@Override
	public QuestionStatistics fetchByPrimaryKey(long questionId) {
		return fetchByPrimaryKey((Serializable)questionId);
	}

	@Override
	public Map<Serializable, QuestionStatistics> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, QuestionStatistics> map = new HashMap<Serializable, QuestionStatistics>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			QuestionStatistics questionStatistics = fetchByPrimaryKey(primaryKey);

			if (questionStatistics != null) {
				map.put(primaryKey, questionStatistics);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			QuestionStatistics questionStatistics = (QuestionStatistics)entityCache.getResult(QuestionStatisticsModelImpl.ENTITY_CACHE_ENABLED,
					QuestionStatisticsImpl.class, primaryKey);

			if (questionStatistics == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, questionStatistics);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_QUESTIONSTATISTICS_WHERE_PKS_IN);

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

			for (QuestionStatistics questionStatistics : (List<QuestionStatistics>)q.list()) {
				map.put(questionStatistics.getPrimaryKeyObj(),
					questionStatistics);

				cacheResult(questionStatistics);

				uncachedPrimaryKeys.remove(questionStatistics.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(QuestionStatisticsModelImpl.ENTITY_CACHE_ENABLED,
					QuestionStatisticsImpl.class, primaryKey,
					_nullQuestionStatistics);
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
	 * Returns all the question statisticses.
	 *
	 * @return the question statisticses
	 */
	@Override
	public List<QuestionStatistics> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the question statisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of question statisticses
	 * @param end the upper bound of the range of question statisticses (not inclusive)
	 * @return the range of question statisticses
	 */
	@Override
	public List<QuestionStatistics> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the question statisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of question statisticses
	 * @param end the upper bound of the range of question statisticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of question statisticses
	 */
	@Override
	public List<QuestionStatistics> findAll(int start, int end,
		OrderByComparator<QuestionStatistics> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the question statisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of question statisticses
	 * @param end the upper bound of the range of question statisticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of question statisticses
	 */
	@Override
	public List<QuestionStatistics> findAll(int start, int end,
		OrderByComparator<QuestionStatistics> orderByComparator,
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

		List<QuestionStatistics> list = null;

		if (retrieveFromCache) {
			list = (List<QuestionStatistics>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_QUESTIONSTATISTICS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTIONSTATISTICS;

				if (pagination) {
					sql = sql.concat(QuestionStatisticsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<QuestionStatistics>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<QuestionStatistics>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the question statisticses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuestionStatistics questionStatistics : findAll()) {
			remove(questionStatistics);
		}
	}

	/**
	 * Returns the number of question statisticses.
	 *
	 * @return the number of question statisticses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUESTIONSTATISTICS);

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
		return QuestionStatisticsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the question statistics persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(QuestionStatisticsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_QUESTIONSTATISTICS = "SELECT questionStatistics FROM QuestionStatistics questionStatistics";
	private static final String _SQL_SELECT_QUESTIONSTATISTICS_WHERE_PKS_IN = "SELECT questionStatistics FROM QuestionStatistics questionStatistics WHERE questionId IN (";
	private static final String _SQL_COUNT_QUESTIONSTATISTICS = "SELECT COUNT(questionStatistics) FROM QuestionStatistics questionStatistics";
	private static final String _ORDER_BY_ENTITY_ALIAS = "questionStatistics.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No QuestionStatistics exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(QuestionStatisticsPersistenceImpl.class);
	private static final QuestionStatistics _nullQuestionStatistics = new QuestionStatisticsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<QuestionStatistics> toCacheModel() {
				return _nullQuestionStatisticsCacheModel;
			}
		};

	private static final CacheModel<QuestionStatistics> _nullQuestionStatisticsCacheModel =
		new CacheModel<QuestionStatistics>() {
			@Override
			public QuestionStatistics toEntityModel() {
				return _nullQuestionStatistics;
			}
		};
}