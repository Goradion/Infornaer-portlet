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

import de.ki.sbam.exception.NoSuchDifficultyException;
import de.ki.sbam.model.Difficulty;
import de.ki.sbam.model.impl.DifficultyImpl;
import de.ki.sbam.model.impl.DifficultyModelImpl;
import de.ki.sbam.service.persistence.DifficultyPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the difficulty service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see DifficultyPersistence
 * @see de.ki.sbam.service.persistence.DifficultyUtil
 * @generated
 */
@ProviderType
public class DifficultyPersistenceImpl extends BasePersistenceImpl<Difficulty>
	implements DifficultyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DifficultyUtil} to access the difficulty persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DifficultyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
			DifficultyModelImpl.FINDER_CACHE_ENABLED, DifficultyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
			DifficultyModelImpl.FINDER_CACHE_ENABLED, DifficultyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
			DifficultyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_SCORE = new FinderPath(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
			DifficultyModelImpl.FINDER_CACHE_ENABLED, DifficultyImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByScore",
			new String[] { Long.class.getName() },
			DifficultyModelImpl.SCORE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCORE = new FinderPath(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
			DifficultyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByScore",
			new String[] { Long.class.getName() });

	/**
	 * Returns the difficulty where score = &#63; or throws a {@link NoSuchDifficultyException} if it could not be found.
	 *
	 * @param score the score
	 * @return the matching difficulty
	 * @throws NoSuchDifficultyException if a matching difficulty could not be found
	 */
	@Override
	public Difficulty findByScore(long score) throws NoSuchDifficultyException {
		Difficulty difficulty = fetchByScore(score);

		if (difficulty == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("score=");
			msg.append(score);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDifficultyException(msg.toString());
		}

		return difficulty;
	}

	/**
	 * Returns the difficulty where score = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param score the score
	 * @return the matching difficulty, or <code>null</code> if a matching difficulty could not be found
	 */
	@Override
	public Difficulty fetchByScore(long score) {
		return fetchByScore(score, true);
	}

	/**
	 * Returns the difficulty where score = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param score the score
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching difficulty, or <code>null</code> if a matching difficulty could not be found
	 */
	@Override
	public Difficulty fetchByScore(long score, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { score };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_SCORE,
					finderArgs, this);
		}

		if (result instanceof Difficulty) {
			Difficulty difficulty = (Difficulty)result;

			if ((score != difficulty.getScore())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DIFFICULTY_WHERE);

			query.append(_FINDER_COLUMN_SCORE_SCORE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(score);

				List<Difficulty> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_SCORE,
						finderArgs, list);
				}
				else {
					Difficulty difficulty = list.get(0);

					result = difficulty;

					cacheResult(difficulty);

					if ((difficulty.getScore() != score)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_SCORE,
							finderArgs, difficulty);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_SCORE, finderArgs);

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
			return (Difficulty)result;
		}
	}

	/**
	 * Removes the difficulty where score = &#63; from the database.
	 *
	 * @param score the score
	 * @return the difficulty that was removed
	 */
	@Override
	public Difficulty removeByScore(long score)
		throws NoSuchDifficultyException {
		Difficulty difficulty = findByScore(score);

		return remove(difficulty);
	}

	/**
	 * Returns the number of difficulties where score = &#63;.
	 *
	 * @param score the score
	 * @return the number of matching difficulties
	 */
	@Override
	public int countByScore(long score) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCORE;

		Object[] finderArgs = new Object[] { score };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DIFFICULTY_WHERE);

			query.append(_FINDER_COLUMN_SCORE_SCORE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(score);

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

	private static final String _FINDER_COLUMN_SCORE_SCORE_2 = "difficulty.score = ?";

	public DifficultyPersistenceImpl() {
		setModelClass(Difficulty.class);
	}

	/**
	 * Caches the difficulty in the entity cache if it is enabled.
	 *
	 * @param difficulty the difficulty
	 */
	@Override
	public void cacheResult(Difficulty difficulty) {
		entityCache.putResult(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
			DifficultyImpl.class, difficulty.getPrimaryKey(), difficulty);

		finderCache.putResult(FINDER_PATH_FETCH_BY_SCORE,
			new Object[] { difficulty.getScore() }, difficulty);

		difficulty.resetOriginalValues();
	}

	/**
	 * Caches the difficulties in the entity cache if it is enabled.
	 *
	 * @param difficulties the difficulties
	 */
	@Override
	public void cacheResult(List<Difficulty> difficulties) {
		for (Difficulty difficulty : difficulties) {
			if (entityCache.getResult(
						DifficultyModelImpl.ENTITY_CACHE_ENABLED,
						DifficultyImpl.class, difficulty.getPrimaryKey()) == null) {
				cacheResult(difficulty);
			}
			else {
				difficulty.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all difficulties.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DifficultyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the difficulty.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Difficulty difficulty) {
		entityCache.removeResult(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
			DifficultyImpl.class, difficulty.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DifficultyModelImpl)difficulty);
	}

	@Override
	public void clearCache(List<Difficulty> difficulties) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Difficulty difficulty : difficulties) {
			entityCache.removeResult(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
				DifficultyImpl.class, difficulty.getPrimaryKey());

			clearUniqueFindersCache((DifficultyModelImpl)difficulty);
		}
	}

	protected void cacheUniqueFindersCache(
		DifficultyModelImpl difficultyModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { difficultyModelImpl.getScore() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_SCORE, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_SCORE, args,
				difficultyModelImpl);
		}
		else {
			if ((difficultyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SCORE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { difficultyModelImpl.getScore() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_SCORE, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_SCORE, args,
					difficultyModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		DifficultyModelImpl difficultyModelImpl) {
		Object[] args = new Object[] { difficultyModelImpl.getScore() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_SCORE, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_SCORE, args);

		if ((difficultyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SCORE.getColumnBitmask()) != 0) {
			args = new Object[] { difficultyModelImpl.getOriginalScore() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SCORE, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SCORE, args);
		}
	}

	/**
	 * Creates a new difficulty with the primary key. Does not add the difficulty to the database.
	 *
	 * @param score the primary key for the new difficulty
	 * @return the new difficulty
	 */
	@Override
	public Difficulty create(long score) {
		Difficulty difficulty = new DifficultyImpl();

		difficulty.setNew(true);
		difficulty.setPrimaryKey(score);

		return difficulty;
	}

	/**
	 * Removes the difficulty with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param score the primary key of the difficulty
	 * @return the difficulty that was removed
	 * @throws NoSuchDifficultyException if a difficulty with the primary key could not be found
	 */
	@Override
	public Difficulty remove(long score) throws NoSuchDifficultyException {
		return remove((Serializable)score);
	}

	/**
	 * Removes the difficulty with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the difficulty
	 * @return the difficulty that was removed
	 * @throws NoSuchDifficultyException if a difficulty with the primary key could not be found
	 */
	@Override
	public Difficulty remove(Serializable primaryKey)
		throws NoSuchDifficultyException {
		Session session = null;

		try {
			session = openSession();

			Difficulty difficulty = (Difficulty)session.get(DifficultyImpl.class,
					primaryKey);

			if (difficulty == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDifficultyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(difficulty);
		}
		catch (NoSuchDifficultyException nsee) {
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
	protected Difficulty removeImpl(Difficulty difficulty) {
		difficulty = toUnwrappedModel(difficulty);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(difficulty)) {
				difficulty = (Difficulty)session.get(DifficultyImpl.class,
						difficulty.getPrimaryKeyObj());
			}

			if (difficulty != null) {
				session.delete(difficulty);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (difficulty != null) {
			clearCache(difficulty);
		}

		return difficulty;
	}

	@Override
	public Difficulty updateImpl(Difficulty difficulty) {
		difficulty = toUnwrappedModel(difficulty);

		boolean isNew = difficulty.isNew();

		DifficultyModelImpl difficultyModelImpl = (DifficultyModelImpl)difficulty;

		Session session = null;

		try {
			session = openSession();

			if (difficulty.isNew()) {
				session.save(difficulty);

				difficulty.setNew(false);
			}
			else {
				difficulty = (Difficulty)session.merge(difficulty);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DifficultyModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
			DifficultyImpl.class, difficulty.getPrimaryKey(), difficulty, false);

		clearUniqueFindersCache(difficultyModelImpl);
		cacheUniqueFindersCache(difficultyModelImpl, isNew);

		difficulty.resetOriginalValues();

		return difficulty;
	}

	protected Difficulty toUnwrappedModel(Difficulty difficulty) {
		if (difficulty instanceof DifficultyImpl) {
			return difficulty;
		}

		DifficultyImpl difficultyImpl = new DifficultyImpl();

		difficultyImpl.setNew(difficulty.isNew());
		difficultyImpl.setPrimaryKey(difficulty.getPrimaryKey());

		difficultyImpl.setGuaranteed(difficulty.isGuaranteed());
		difficultyImpl.setScore(difficulty.getScore());

		return difficultyImpl;
	}

	/**
	 * Returns the difficulty with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the difficulty
	 * @return the difficulty
	 * @throws NoSuchDifficultyException if a difficulty with the primary key could not be found
	 */
	@Override
	public Difficulty findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDifficultyException {
		Difficulty difficulty = fetchByPrimaryKey(primaryKey);

		if (difficulty == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDifficultyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return difficulty;
	}

	/**
	 * Returns the difficulty with the primary key or throws a {@link NoSuchDifficultyException} if it could not be found.
	 *
	 * @param score the primary key of the difficulty
	 * @return the difficulty
	 * @throws NoSuchDifficultyException if a difficulty with the primary key could not be found
	 */
	@Override
	public Difficulty findByPrimaryKey(long score)
		throws NoSuchDifficultyException {
		return findByPrimaryKey((Serializable)score);
	}

	/**
	 * Returns the difficulty with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the difficulty
	 * @return the difficulty, or <code>null</code> if a difficulty with the primary key could not be found
	 */
	@Override
	public Difficulty fetchByPrimaryKey(Serializable primaryKey) {
		Difficulty difficulty = (Difficulty)entityCache.getResult(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
				DifficultyImpl.class, primaryKey);

		if (difficulty == _nullDifficulty) {
			return null;
		}

		if (difficulty == null) {
			Session session = null;

			try {
				session = openSession();

				difficulty = (Difficulty)session.get(DifficultyImpl.class,
						primaryKey);

				if (difficulty != null) {
					cacheResult(difficulty);
				}
				else {
					entityCache.putResult(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
						DifficultyImpl.class, primaryKey, _nullDifficulty);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
					DifficultyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return difficulty;
	}

	/**
	 * Returns the difficulty with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param score the primary key of the difficulty
	 * @return the difficulty, or <code>null</code> if a difficulty with the primary key could not be found
	 */
	@Override
	public Difficulty fetchByPrimaryKey(long score) {
		return fetchByPrimaryKey((Serializable)score);
	}

	@Override
	public Map<Serializable, Difficulty> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Difficulty> map = new HashMap<Serializable, Difficulty>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Difficulty difficulty = fetchByPrimaryKey(primaryKey);

			if (difficulty != null) {
				map.put(primaryKey, difficulty);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Difficulty difficulty = (Difficulty)entityCache.getResult(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
					DifficultyImpl.class, primaryKey);

			if (difficulty == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, difficulty);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DIFFICULTY_WHERE_PKS_IN);

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

			for (Difficulty difficulty : (List<Difficulty>)q.list()) {
				map.put(difficulty.getPrimaryKeyObj(), difficulty);

				cacheResult(difficulty);

				uncachedPrimaryKeys.remove(difficulty.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DifficultyModelImpl.ENTITY_CACHE_ENABLED,
					DifficultyImpl.class, primaryKey, _nullDifficulty);
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
	 * Returns all the difficulties.
	 *
	 * @return the difficulties
	 */
	@Override
	public List<Difficulty> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the difficulties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DifficultyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of difficulties
	 * @param end the upper bound of the range of difficulties (not inclusive)
	 * @return the range of difficulties
	 */
	@Override
	public List<Difficulty> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the difficulties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DifficultyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of difficulties
	 * @param end the upper bound of the range of difficulties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of difficulties
	 */
	@Override
	public List<Difficulty> findAll(int start, int end,
		OrderByComparator<Difficulty> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the difficulties.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DifficultyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of difficulties
	 * @param end the upper bound of the range of difficulties (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of difficulties
	 */
	@Override
	public List<Difficulty> findAll(int start, int end,
		OrderByComparator<Difficulty> orderByComparator,
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

		List<Difficulty> list = null;

		if (retrieveFromCache) {
			list = (List<Difficulty>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DIFFICULTY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DIFFICULTY;

				if (pagination) {
					sql = sql.concat(DifficultyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Difficulty>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Difficulty>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the difficulties from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Difficulty difficulty : findAll()) {
			remove(difficulty);
		}
	}

	/**
	 * Returns the number of difficulties.
	 *
	 * @return the number of difficulties
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DIFFICULTY);

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
		return DifficultyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the difficulty persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DifficultyImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_DIFFICULTY = "SELECT difficulty FROM Difficulty difficulty";
	private static final String _SQL_SELECT_DIFFICULTY_WHERE_PKS_IN = "SELECT difficulty FROM Difficulty difficulty WHERE score IN (";
	private static final String _SQL_SELECT_DIFFICULTY_WHERE = "SELECT difficulty FROM Difficulty difficulty WHERE ";
	private static final String _SQL_COUNT_DIFFICULTY = "SELECT COUNT(difficulty) FROM Difficulty difficulty";
	private static final String _SQL_COUNT_DIFFICULTY_WHERE = "SELECT COUNT(difficulty) FROM Difficulty difficulty WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "difficulty.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Difficulty exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Difficulty exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DifficultyPersistenceImpl.class);
	private static final Difficulty _nullDifficulty = new DifficultyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Difficulty> toCacheModel() {
				return _nullDifficultyCacheModel;
			}
		};

	private static final CacheModel<Difficulty> _nullDifficultyCacheModel = new CacheModel<Difficulty>() {
			@Override
			public Difficulty toEntityModel() {
				return _nullDifficulty;
			}
		};
}