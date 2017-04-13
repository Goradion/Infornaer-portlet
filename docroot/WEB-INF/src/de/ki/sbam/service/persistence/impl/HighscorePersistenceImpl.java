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

import de.ki.sbam.exception.NoSuchHighscoreException;
import de.ki.sbam.model.Highscore;
import de.ki.sbam.model.impl.HighscoreImpl;
import de.ki.sbam.model.impl.HighscoreModelImpl;
import de.ki.sbam.service.persistence.HighscorePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the highscore service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see HighscorePersistence
 * @see de.ki.sbam.service.persistence.HighscoreUtil
 * @generated
 */
@ProviderType
public class HighscorePersistenceImpl extends BasePersistenceImpl<Highscore>
	implements HighscorePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HighscoreUtil} to access the highscore persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HighscoreImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
			HighscoreModelImpl.FINDER_CACHE_ENABLED, HighscoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
			HighscoreModelImpl.FINDER_CACHE_ENABLED, HighscoreImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
			HighscoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
			HighscoreModelImpl.FINDER_CACHE_ENABLED, HighscoreImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] { Long.class.getName() },
			HighscoreModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
			HighscoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the highscore where userId = &#63; or throws a {@link NoSuchHighscoreException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching highscore
	 * @throws NoSuchHighscoreException if a matching highscore could not be found
	 */
	@Override
	public Highscore findByUserId(long userId) throws NoSuchHighscoreException {
		Highscore highscore = fetchByUserId(userId);

		if (highscore == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchHighscoreException(msg.toString());
		}

		return highscore;
	}

	/**
	 * Returns the highscore where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching highscore, or <code>null</code> if a matching highscore could not be found
	 */
	@Override
	public Highscore fetchByUserId(long userId) {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the highscore where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching highscore, or <code>null</code> if a matching highscore could not be found
	 */
	@Override
	public Highscore fetchByUserId(long userId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result instanceof Highscore) {
			Highscore highscore = (Highscore)result;

			if ((userId != highscore.getUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_HIGHSCORE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<Highscore> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"HighscorePersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Highscore highscore = list.get(0);

					result = highscore;

					cacheResult(highscore);

					if ((highscore.getUserId() != userId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, highscore);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, finderArgs);

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
			return (Highscore)result;
		}
	}

	/**
	 * Removes the highscore where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the highscore that was removed
	 */
	@Override
	public Highscore removeByUserId(long userId)
		throws NoSuchHighscoreException {
		Highscore highscore = findByUserId(userId);

		return remove(highscore);
	}

	/**
	 * Returns the number of highscores where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching highscores
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HIGHSCORE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "highscore.userId = ?";

	public HighscorePersistenceImpl() {
		setModelClass(Highscore.class);
	}

	/**
	 * Caches the highscore in the entity cache if it is enabled.
	 *
	 * @param highscore the highscore
	 */
	@Override
	public void cacheResult(Highscore highscore) {
		entityCache.putResult(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
			HighscoreImpl.class, highscore.getPrimaryKey(), highscore);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { highscore.getUserId() }, highscore);

		highscore.resetOriginalValues();
	}

	/**
	 * Caches the highscores in the entity cache if it is enabled.
	 *
	 * @param highscores the highscores
	 */
	@Override
	public void cacheResult(List<Highscore> highscores) {
		for (Highscore highscore : highscores) {
			if (entityCache.getResult(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
						HighscoreImpl.class, highscore.getPrimaryKey()) == null) {
				cacheResult(highscore);
			}
			else {
				highscore.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all highscores.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HighscoreImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the highscore.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Highscore highscore) {
		entityCache.removeResult(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
			HighscoreImpl.class, highscore.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((HighscoreModelImpl)highscore);
	}

	@Override
	public void clearCache(List<Highscore> highscores) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Highscore highscore : highscores) {
			entityCache.removeResult(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
				HighscoreImpl.class, highscore.getPrimaryKey());

			clearUniqueFindersCache((HighscoreModelImpl)highscore);
		}
	}

	protected void cacheUniqueFindersCache(
		HighscoreModelImpl highscoreModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { highscoreModelImpl.getUserId() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_USERID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_USERID, args,
				highscoreModelImpl);
		}
		else {
			if ((highscoreModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { highscoreModelImpl.getUserId() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_USERID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_USERID, args,
					highscoreModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		HighscoreModelImpl highscoreModelImpl) {
		Object[] args = new Object[] { highscoreModelImpl.getUserId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

		if ((highscoreModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
			args = new Object[] { highscoreModelImpl.getOriginalUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
		}
	}

	/**
	 * Creates a new highscore with the primary key. Does not add the highscore to the database.
	 *
	 * @param userId the primary key for the new highscore
	 * @return the new highscore
	 */
	@Override
	public Highscore create(long userId) {
		Highscore highscore = new HighscoreImpl();

		highscore.setNew(true);
		highscore.setPrimaryKey(userId);

		return highscore;
	}

	/**
	 * Removes the highscore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the highscore
	 * @return the highscore that was removed
	 * @throws NoSuchHighscoreException if a highscore with the primary key could not be found
	 */
	@Override
	public Highscore remove(long userId) throws NoSuchHighscoreException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the highscore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the highscore
	 * @return the highscore that was removed
	 * @throws NoSuchHighscoreException if a highscore with the primary key could not be found
	 */
	@Override
	public Highscore remove(Serializable primaryKey)
		throws NoSuchHighscoreException {
		Session session = null;

		try {
			session = openSession();

			Highscore highscore = (Highscore)session.get(HighscoreImpl.class,
					primaryKey);

			if (highscore == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHighscoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(highscore);
		}
		catch (NoSuchHighscoreException nsee) {
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
	protected Highscore removeImpl(Highscore highscore) {
		highscore = toUnwrappedModel(highscore);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(highscore)) {
				highscore = (Highscore)session.get(HighscoreImpl.class,
						highscore.getPrimaryKeyObj());
			}

			if (highscore != null) {
				session.delete(highscore);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (highscore != null) {
			clearCache(highscore);
		}

		return highscore;
	}

	@Override
	public Highscore updateImpl(Highscore highscore) {
		highscore = toUnwrappedModel(highscore);

		boolean isNew = highscore.isNew();

		HighscoreModelImpl highscoreModelImpl = (HighscoreModelImpl)highscore;

		Session session = null;

		try {
			session = openSession();

			if (highscore.isNew()) {
				session.save(highscore);

				highscore.setNew(false);
			}
			else {
				highscore = (Highscore)session.merge(highscore);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HighscoreModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
			HighscoreImpl.class, highscore.getPrimaryKey(), highscore, false);

		clearUniqueFindersCache(highscoreModelImpl);
		cacheUniqueFindersCache(highscoreModelImpl, isNew);

		highscore.resetOriginalValues();

		return highscore;
	}

	protected Highscore toUnwrappedModel(Highscore highscore) {
		if (highscore instanceof HighscoreImpl) {
			return highscore;
		}

		HighscoreImpl highscoreImpl = new HighscoreImpl();

		highscoreImpl.setNew(highscore.isNew());
		highscoreImpl.setPrimaryKey(highscore.getPrimaryKey());

		highscoreImpl.setUserId(highscore.getUserId());
		highscoreImpl.setUserName(highscore.getUserName());
		highscoreImpl.setScore(highscore.getScore());

		return highscoreImpl;
	}

	/**
	 * Returns the highscore with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the highscore
	 * @return the highscore
	 * @throws NoSuchHighscoreException if a highscore with the primary key could not be found
	 */
	@Override
	public Highscore findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHighscoreException {
		Highscore highscore = fetchByPrimaryKey(primaryKey);

		if (highscore == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHighscoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return highscore;
	}

	/**
	 * Returns the highscore with the primary key or throws a {@link NoSuchHighscoreException} if it could not be found.
	 *
	 * @param userId the primary key of the highscore
	 * @return the highscore
	 * @throws NoSuchHighscoreException if a highscore with the primary key could not be found
	 */
	@Override
	public Highscore findByPrimaryKey(long userId)
		throws NoSuchHighscoreException {
		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the highscore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the highscore
	 * @return the highscore, or <code>null</code> if a highscore with the primary key could not be found
	 */
	@Override
	public Highscore fetchByPrimaryKey(Serializable primaryKey) {
		Highscore highscore = (Highscore)entityCache.getResult(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
				HighscoreImpl.class, primaryKey);

		if (highscore == _nullHighscore) {
			return null;
		}

		if (highscore == null) {
			Session session = null;

			try {
				session = openSession();

				highscore = (Highscore)session.get(HighscoreImpl.class,
						primaryKey);

				if (highscore != null) {
					cacheResult(highscore);
				}
				else {
					entityCache.putResult(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
						HighscoreImpl.class, primaryKey, _nullHighscore);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
					HighscoreImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return highscore;
	}

	/**
	 * Returns the highscore with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the highscore
	 * @return the highscore, or <code>null</code> if a highscore with the primary key could not be found
	 */
	@Override
	public Highscore fetchByPrimaryKey(long userId) {
		return fetchByPrimaryKey((Serializable)userId);
	}

	@Override
	public Map<Serializable, Highscore> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Highscore> map = new HashMap<Serializable, Highscore>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Highscore highscore = fetchByPrimaryKey(primaryKey);

			if (highscore != null) {
				map.put(primaryKey, highscore);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Highscore highscore = (Highscore)entityCache.getResult(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
					HighscoreImpl.class, primaryKey);

			if (highscore == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, highscore);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_HIGHSCORE_WHERE_PKS_IN);

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

			for (Highscore highscore : (List<Highscore>)q.list()) {
				map.put(highscore.getPrimaryKeyObj(), highscore);

				cacheResult(highscore);

				uncachedPrimaryKeys.remove(highscore.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(HighscoreModelImpl.ENTITY_CACHE_ENABLED,
					HighscoreImpl.class, primaryKey, _nullHighscore);
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
	 * Returns all the highscores.
	 *
	 * @return the highscores
	 */
	@Override
	public List<Highscore> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the highscores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HighscoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of highscores
	 * @param end the upper bound of the range of highscores (not inclusive)
	 * @return the range of highscores
	 */
	@Override
	public List<Highscore> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the highscores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HighscoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of highscores
	 * @param end the upper bound of the range of highscores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of highscores
	 */
	@Override
	public List<Highscore> findAll(int start, int end,
		OrderByComparator<Highscore> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the highscores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link HighscoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of highscores
	 * @param end the upper bound of the range of highscores (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of highscores
	 */
	@Override
	public List<Highscore> findAll(int start, int end,
		OrderByComparator<Highscore> orderByComparator,
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

		List<Highscore> list = null;

		if (retrieveFromCache) {
			list = (List<Highscore>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_HIGHSCORE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HIGHSCORE;

				if (pagination) {
					sql = sql.concat(HighscoreModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Highscore>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Highscore>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the highscores from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Highscore highscore : findAll()) {
			remove(highscore);
		}
	}

	/**
	 * Returns the number of highscores.
	 *
	 * @return the number of highscores
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_HIGHSCORE);

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
		return HighscoreModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the highscore persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(HighscoreImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_HIGHSCORE = "SELECT highscore FROM Highscore highscore";
	private static final String _SQL_SELECT_HIGHSCORE_WHERE_PKS_IN = "SELECT highscore FROM Highscore highscore WHERE userId IN (";
	private static final String _SQL_SELECT_HIGHSCORE_WHERE = "SELECT highscore FROM Highscore highscore WHERE ";
	private static final String _SQL_COUNT_HIGHSCORE = "SELECT COUNT(highscore) FROM Highscore highscore";
	private static final String _SQL_COUNT_HIGHSCORE_WHERE = "SELECT COUNT(highscore) FROM Highscore highscore WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "highscore.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Highscore exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Highscore exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(HighscorePersistenceImpl.class);
	private static final Highscore _nullHighscore = new HighscoreImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Highscore> toCacheModel() {
				return _nullHighscoreCacheModel;
			}
		};

	private static final CacheModel<Highscore> _nullHighscoreCacheModel = new CacheModel<Highscore>() {
			@Override
			public Highscore toEntityModel() {
				return _nullHighscore;
			}
		};
}