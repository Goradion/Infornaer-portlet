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

import de.ki.sbam.exception.NoSuchUserStatisticsException;
import de.ki.sbam.model.UserStatistics;
import de.ki.sbam.model.impl.UserStatisticsImpl;
import de.ki.sbam.model.impl.UserStatisticsModelImpl;
import de.ki.sbam.service.persistence.UserStatisticsPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the user statistics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller
 * @see UserStatisticsPersistence
 * @see de.ki.sbam.service.persistence.UserStatisticsUtil
 * @generated
 */
@ProviderType
public class UserStatisticsPersistenceImpl extends BasePersistenceImpl<UserStatistics>
	implements UserStatisticsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserStatisticsUtil} to access the user statistics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserStatisticsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			UserStatisticsModelImpl.FINDER_CACHE_ENABLED,
			UserStatisticsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			UserStatisticsModelImpl.FINDER_CACHE_ENABLED,
			UserStatisticsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			UserStatisticsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public UserStatisticsPersistenceImpl() {
		setModelClass(UserStatistics.class);
	}

	/**
	 * Caches the user statistics in the entity cache if it is enabled.
	 *
	 * @param userStatistics the user statistics
	 */
	@Override
	public void cacheResult(UserStatistics userStatistics) {
		entityCache.putResult(UserStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			UserStatisticsImpl.class, userStatistics.getPrimaryKey(),
			userStatistics);

		userStatistics.resetOriginalValues();
	}

	/**
	 * Caches the user statisticses in the entity cache if it is enabled.
	 *
	 * @param userStatisticses the user statisticses
	 */
	@Override
	public void cacheResult(List<UserStatistics> userStatisticses) {
		for (UserStatistics userStatistics : userStatisticses) {
			if (entityCache.getResult(
						UserStatisticsModelImpl.ENTITY_CACHE_ENABLED,
						UserStatisticsImpl.class, userStatistics.getPrimaryKey()) == null) {
				cacheResult(userStatistics);
			}
			else {
				userStatistics.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user statisticses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserStatisticsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user statistics.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserStatistics userStatistics) {
		entityCache.removeResult(UserStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			UserStatisticsImpl.class, userStatistics.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserStatistics> userStatisticses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserStatistics userStatistics : userStatisticses) {
			entityCache.removeResult(UserStatisticsModelImpl.ENTITY_CACHE_ENABLED,
				UserStatisticsImpl.class, userStatistics.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user statistics with the primary key. Does not add the user statistics to the database.
	 *
	 * @param userId the primary key for the new user statistics
	 * @return the new user statistics
	 */
	@Override
	public UserStatistics create(long userId) {
		UserStatistics userStatistics = new UserStatisticsImpl();

		userStatistics.setNew(true);
		userStatistics.setPrimaryKey(userId);

		return userStatistics;
	}

	/**
	 * Removes the user statistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the user statistics
	 * @return the user statistics that was removed
	 * @throws NoSuchUserStatisticsException if a user statistics with the primary key could not be found
	 */
	@Override
	public UserStatistics remove(long userId)
		throws NoSuchUserStatisticsException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the user statistics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user statistics
	 * @return the user statistics that was removed
	 * @throws NoSuchUserStatisticsException if a user statistics with the primary key could not be found
	 */
	@Override
	public UserStatistics remove(Serializable primaryKey)
		throws NoSuchUserStatisticsException {
		Session session = null;

		try {
			session = openSession();

			UserStatistics userStatistics = (UserStatistics)session.get(UserStatisticsImpl.class,
					primaryKey);

			if (userStatistics == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserStatisticsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userStatistics);
		}
		catch (NoSuchUserStatisticsException nsee) {
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
	protected UserStatistics removeImpl(UserStatistics userStatistics) {
		userStatistics = toUnwrappedModel(userStatistics);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userStatistics)) {
				userStatistics = (UserStatistics)session.get(UserStatisticsImpl.class,
						userStatistics.getPrimaryKeyObj());
			}

			if (userStatistics != null) {
				session.delete(userStatistics);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userStatistics != null) {
			clearCache(userStatistics);
		}

		return userStatistics;
	}

	@Override
	public UserStatistics updateImpl(UserStatistics userStatistics) {
		userStatistics = toUnwrappedModel(userStatistics);

		boolean isNew = userStatistics.isNew();

		Session session = null;

		try {
			session = openSession();

			if (userStatistics.isNew()) {
				session.save(userStatistics);

				userStatistics.setNew(false);
			}
			else {
				userStatistics = (UserStatistics)session.merge(userStatistics);
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

		entityCache.putResult(UserStatisticsModelImpl.ENTITY_CACHE_ENABLED,
			UserStatisticsImpl.class, userStatistics.getPrimaryKey(),
			userStatistics, false);

		userStatistics.resetOriginalValues();

		return userStatistics;
	}

	protected UserStatistics toUnwrappedModel(UserStatistics userStatistics) {
		if (userStatistics instanceof UserStatisticsImpl) {
			return userStatistics;
		}

		UserStatisticsImpl userStatisticsImpl = new UserStatisticsImpl();

		userStatisticsImpl.setNew(userStatistics.isNew());
		userStatisticsImpl.setPrimaryKey(userStatistics.getPrimaryKey());

		userStatisticsImpl.setUserId(userStatistics.getUserId());
		userStatisticsImpl.setGamesWon(userStatistics.getGamesWon());
		userStatisticsImpl.setGamesLost(userStatistics.getGamesLost());
		userStatisticsImpl.setRightAnswers(userStatistics.getRightAnswers());
		userStatisticsImpl.setWrongAnswers(userStatistics.getWrongAnswers());

		return userStatisticsImpl;
	}

	/**
	 * Returns the user statistics with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user statistics
	 * @return the user statistics
	 * @throws NoSuchUserStatisticsException if a user statistics with the primary key could not be found
	 */
	@Override
	public UserStatistics findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserStatisticsException {
		UserStatistics userStatistics = fetchByPrimaryKey(primaryKey);

		if (userStatistics == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserStatisticsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userStatistics;
	}

	/**
	 * Returns the user statistics with the primary key or throws a {@link NoSuchUserStatisticsException} if it could not be found.
	 *
	 * @param userId the primary key of the user statistics
	 * @return the user statistics
	 * @throws NoSuchUserStatisticsException if a user statistics with the primary key could not be found
	 */
	@Override
	public UserStatistics findByPrimaryKey(long userId)
		throws NoSuchUserStatisticsException {
		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the user statistics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user statistics
	 * @return the user statistics, or <code>null</code> if a user statistics with the primary key could not be found
	 */
	@Override
	public UserStatistics fetchByPrimaryKey(Serializable primaryKey) {
		UserStatistics userStatistics = (UserStatistics)entityCache.getResult(UserStatisticsModelImpl.ENTITY_CACHE_ENABLED,
				UserStatisticsImpl.class, primaryKey);

		if (userStatistics == _nullUserStatistics) {
			return null;
		}

		if (userStatistics == null) {
			Session session = null;

			try {
				session = openSession();

				userStatistics = (UserStatistics)session.get(UserStatisticsImpl.class,
						primaryKey);

				if (userStatistics != null) {
					cacheResult(userStatistics);
				}
				else {
					entityCache.putResult(UserStatisticsModelImpl.ENTITY_CACHE_ENABLED,
						UserStatisticsImpl.class, primaryKey,
						_nullUserStatistics);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserStatisticsModelImpl.ENTITY_CACHE_ENABLED,
					UserStatisticsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userStatistics;
	}

	/**
	 * Returns the user statistics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the user statistics
	 * @return the user statistics, or <code>null</code> if a user statistics with the primary key could not be found
	 */
	@Override
	public UserStatistics fetchByPrimaryKey(long userId) {
		return fetchByPrimaryKey((Serializable)userId);
	}

	@Override
	public Map<Serializable, UserStatistics> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserStatistics> map = new HashMap<Serializable, UserStatistics>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserStatistics userStatistics = fetchByPrimaryKey(primaryKey);

			if (userStatistics != null) {
				map.put(primaryKey, userStatistics);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			UserStatistics userStatistics = (UserStatistics)entityCache.getResult(UserStatisticsModelImpl.ENTITY_CACHE_ENABLED,
					UserStatisticsImpl.class, primaryKey);

			if (userStatistics == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, userStatistics);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERSTATISTICS_WHERE_PKS_IN);

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

			for (UserStatistics userStatistics : (List<UserStatistics>)q.list()) {
				map.put(userStatistics.getPrimaryKeyObj(), userStatistics);

				cacheResult(userStatistics);

				uncachedPrimaryKeys.remove(userStatistics.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserStatisticsModelImpl.ENTITY_CACHE_ENABLED,
					UserStatisticsImpl.class, primaryKey, _nullUserStatistics);
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
	 * Returns all the user statisticses.
	 *
	 * @return the user statisticses
	 */
	@Override
	public List<UserStatistics> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user statisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user statisticses
	 * @param end the upper bound of the range of user statisticses (not inclusive)
	 * @return the range of user statisticses
	 */
	@Override
	public List<UserStatistics> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user statisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user statisticses
	 * @param end the upper bound of the range of user statisticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user statisticses
	 */
	@Override
	public List<UserStatistics> findAll(int start, int end,
		OrderByComparator<UserStatistics> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user statisticses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserStatisticsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user statisticses
	 * @param end the upper bound of the range of user statisticses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of user statisticses
	 */
	@Override
	public List<UserStatistics> findAll(int start, int end,
		OrderByComparator<UserStatistics> orderByComparator,
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

		List<UserStatistics> list = null;

		if (retrieveFromCache) {
			list = (List<UserStatistics>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERSTATISTICS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERSTATISTICS;

				if (pagination) {
					sql = sql.concat(UserStatisticsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserStatistics>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserStatistics>)QueryUtil.list(q,
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
	 * Removes all the user statisticses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserStatistics userStatistics : findAll()) {
			remove(userStatistics);
		}
	}

	/**
	 * Returns the number of user statisticses.
	 *
	 * @return the number of user statisticses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERSTATISTICS);

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
		return UserStatisticsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user statistics persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserStatisticsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_USERSTATISTICS = "SELECT userStatistics FROM UserStatistics userStatistics";
	private static final String _SQL_SELECT_USERSTATISTICS_WHERE_PKS_IN = "SELECT userStatistics FROM UserStatistics userStatistics WHERE userId IN (";
	private static final String _SQL_COUNT_USERSTATISTICS = "SELECT COUNT(userStatistics) FROM UserStatistics userStatistics";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userStatistics.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserStatistics exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(UserStatisticsPersistenceImpl.class);
	private static final UserStatistics _nullUserStatistics = new UserStatisticsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserStatistics> toCacheModel() {
				return _nullUserStatisticsCacheModel;
			}
		};

	private static final CacheModel<UserStatistics> _nullUserStatisticsCacheModel =
		new CacheModel<UserStatistics>() {
			@Override
			public UserStatistics toEntityModel() {
				return _nullUserStatistics;
			}
		};
}