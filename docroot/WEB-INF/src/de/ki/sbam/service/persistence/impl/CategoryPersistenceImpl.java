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
import com.liferay.portal.kernel.util.Validator;

import de.ki.sbam.exception.NoSuchCategoryException;
import de.ki.sbam.model.Category;
import de.ki.sbam.model.impl.CategoryImpl;
import de.ki.sbam.model.impl.CategoryModelImpl;
import de.ki.sbam.service.persistence.CategoryPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see CategoryPersistence
 * @see de.ki.sbam.service.persistence.CategoryUtil
 * @generated
 */
@ProviderType
public class CategoryPersistenceImpl extends BasePersistenceImpl<Category>
	implements CategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CategoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CATEGORYNAME = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCategoryName",
			new String[] { String.class.getName() },
			CategoryModelImpl.CATEGORYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYNAME = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryName",
			new String[] { String.class.getName() });

	/**
	 * Returns the category where categoryName = &#63; or throws a {@link NoSuchCategoryException} if it could not be found.
	 *
	 * @param categoryName the category name
	 * @return the matching category
	 * @throws NoSuchCategoryException if a matching category could not be found
	 */
	@Override
	public Category findByCategoryName(String categoryName)
		throws NoSuchCategoryException {
		Category category = fetchByCategoryName(categoryName);

		if (category == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryName=");
			msg.append(categoryName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCategoryException(msg.toString());
		}

		return category;
	}

	/**
	 * Returns the category where categoryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param categoryName the category name
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByCategoryName(String categoryName) {
		return fetchByCategoryName(categoryName, true);
	}

	/**
	 * Returns the category where categoryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryName the category name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching category, or <code>null</code> if a matching category could not be found
	 */
	@Override
	public Category fetchByCategoryName(String categoryName,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { categoryName };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
					finderArgs, this);
		}

		if (result instanceof Category) {
			Category category = (Category)result;

			if (!Validator.equals(categoryName, category.getCategoryName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CATEGORY_WHERE);

			boolean bindCategoryName = false;

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
			}
			else if (categoryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategoryName) {
					qPos.add(categoryName);
				}

				List<Category> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CategoryPersistenceImpl.fetchByCategoryName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Category category = list.get(0);

					result = category;

					cacheResult(category);

					if ((category.getCategoryName() == null) ||
							!category.getCategoryName().equals(categoryName)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
							finderArgs, category);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
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
			return (Category)result;
		}
	}

	/**
	 * Removes the category where categoryName = &#63; from the database.
	 *
	 * @param categoryName the category name
	 * @return the category that was removed
	 */
	@Override
	public Category removeByCategoryName(String categoryName)
		throws NoSuchCategoryException {
		Category category = findByCategoryName(categoryName);

		return remove(category);
	}

	/**
	 * Returns the number of categories where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the number of matching categories
	 */
	@Override
	public int countByCategoryName(String categoryName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYNAME;

		Object[] finderArgs = new Object[] { categoryName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATEGORY_WHERE);

			boolean bindCategoryName = false;

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
			}
			else if (categoryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
			}
			else {
				bindCategoryName = true;

				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategoryName) {
					qPos.add(categoryName);
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

	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1 = "category.categoryName IS NULL";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2 = "category.categoryName = ?";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3 = "(category.categoryName IS NULL OR category.categoryName = '')";

	public CategoryPersistenceImpl() {
		setModelClass(Category.class);
	}

	/**
	 * Caches the category in the entity cache if it is enabled.
	 *
	 * @param category the category
	 */
	@Override
	public void cacheResult(Category category) {
		entityCache.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryImpl.class, category.getPrimaryKey(), category);

		finderCache.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME,
			new Object[] { category.getCategoryName() }, category);

		category.resetOriginalValues();
	}

	/**
	 * Caches the categories in the entity cache if it is enabled.
	 *
	 * @param categories the categories
	 */
	@Override
	public void cacheResult(List<Category> categories) {
		for (Category category : categories) {
			if (entityCache.getResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
						CategoryImpl.class, category.getPrimaryKey()) == null) {
				cacheResult(category);
			}
			else {
				category.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all categories.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the category.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Category category) {
		entityCache.removeResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryImpl.class, category.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CategoryModelImpl)category);
	}

	@Override
	public void clearCache(List<Category> categories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Category category : categories) {
			entityCache.removeResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
				CategoryImpl.class, category.getPrimaryKey());

			clearUniqueFindersCache((CategoryModelImpl)category);
		}
	}

	protected void cacheUniqueFindersCache(
		CategoryModelImpl categoryModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { categoryModelImpl.getCategoryName() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_CATEGORYNAME, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME, args,
				categoryModelImpl);
		}
		else {
			if ((categoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CATEGORYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { categoryModelImpl.getCategoryName() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_CATEGORYNAME, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAME, args,
					categoryModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(CategoryModelImpl categoryModelImpl) {
		Object[] args = new Object[] { categoryModelImpl.getCategoryName() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_CATEGORYNAME, args);

		if ((categoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CATEGORYNAME.getColumnBitmask()) != 0) {
			args = new Object[] { categoryModelImpl.getOriginalCategoryName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CATEGORYNAME, args);
		}
	}

	/**
	 * Creates a new category with the primary key. Does not add the category to the database.
	 *
	 * @param categoryId the primary key for the new category
	 * @return the new category
	 */
	@Override
	public Category create(long categoryId) {
		Category category = new CategoryImpl();

		category.setNew(true);
		category.setPrimaryKey(categoryId);

		return category;
	}

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category that was removed
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category remove(long categoryId) throws NoSuchCategoryException {
		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the category
	 * @return the category that was removed
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category remove(Serializable primaryKey)
		throws NoSuchCategoryException {
		Session session = null;

		try {
			session = openSession();

			Category category = (Category)session.get(CategoryImpl.class,
					primaryKey);

			if (category == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(category);
		}
		catch (NoSuchCategoryException nsee) {
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
	protected Category removeImpl(Category category) {
		category = toUnwrappedModel(category);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(category)) {
				category = (Category)session.get(CategoryImpl.class,
						category.getPrimaryKeyObj());
			}

			if (category != null) {
				session.delete(category);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (category != null) {
			clearCache(category);
		}

		return category;
	}

	@Override
	public Category updateImpl(Category category) {
		category = toUnwrappedModel(category);

		boolean isNew = category.isNew();

		CategoryModelImpl categoryModelImpl = (CategoryModelImpl)category;

		Session session = null;

		try {
			session = openSession();

			if (category.isNew()) {
				session.save(category);

				category.setNew(false);
			}
			else {
				category = (Category)session.merge(category);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryImpl.class, category.getPrimaryKey(), category, false);

		clearUniqueFindersCache(categoryModelImpl);
		cacheUniqueFindersCache(categoryModelImpl, isNew);

		category.resetOriginalValues();

		return category;
	}

	protected Category toUnwrappedModel(Category category) {
		if (category instanceof CategoryImpl) {
			return category;
		}

		CategoryImpl categoryImpl = new CategoryImpl();

		categoryImpl.setNew(category.isNew());
		categoryImpl.setPrimaryKey(category.getPrimaryKey());

		categoryImpl.setCategoryId(category.getCategoryId());
		categoryImpl.setCategoryName(category.getCategoryName());

		return categoryImpl;
	}

	/**
	 * Returns the category with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the category
	 * @return the category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCategoryException {
		Category category = fetchByPrimaryKey(primaryKey);

		if (category == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return category;
	}

	/**
	 * Returns the category with the primary key or throws a {@link NoSuchCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category
	 * @throws NoSuchCategoryException if a category with the primary key could not be found
	 */
	@Override
	public Category findByPrimaryKey(long categoryId)
		throws NoSuchCategoryException {
		return findByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns the category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the category
	 * @return the category, or <code>null</code> if a category with the primary key could not be found
	 */
	@Override
	public Category fetchByPrimaryKey(Serializable primaryKey) {
		Category category = (Category)entityCache.getResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
				CategoryImpl.class, primaryKey);

		if (category == _nullCategory) {
			return null;
		}

		if (category == null) {
			Session session = null;

			try {
				session = openSession();

				category = (Category)session.get(CategoryImpl.class, primaryKey);

				if (category != null) {
					cacheResult(category);
				}
				else {
					entityCache.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
						CategoryImpl.class, primaryKey, _nullCategory);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
					CategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return category;
	}

	/**
	 * Returns the category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category
	 * @return the category, or <code>null</code> if a category with the primary key could not be found
	 */
	@Override
	public Category fetchByPrimaryKey(long categoryId) {
		return fetchByPrimaryKey((Serializable)categoryId);
	}

	@Override
	public Map<Serializable, Category> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Category> map = new HashMap<Serializable, Category>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Category category = fetchByPrimaryKey(primaryKey);

			if (category != null) {
				map.put(primaryKey, category);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Category category = (Category)entityCache.getResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
					CategoryImpl.class, primaryKey);

			if (category == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, category);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CATEGORY_WHERE_PKS_IN);

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

			for (Category category : (List<Category>)q.list()) {
				map.put(category.getPrimaryKeyObj(), category);

				cacheResult(category);

				uncachedPrimaryKeys.remove(category.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
					CategoryImpl.class, primaryKey, _nullCategory);
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
	 * Returns all the categories.
	 *
	 * @return the categories
	 */
	@Override
	public List<Category> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @return the range of categories
	 */
	@Override
	public List<Category> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of categories
	 */
	@Override
	public List<Category> findAll(int start, int end,
		OrderByComparator<Category> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of categories
	 * @param end the upper bound of the range of categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of categories
	 */
	@Override
	public List<Category> findAll(int start, int end,
		OrderByComparator<Category> orderByComparator, boolean retrieveFromCache) {
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

		List<Category> list = null;

		if (retrieveFromCache) {
			list = (List<Category>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORY;

				if (pagination) {
					sql = sql.concat(CategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Category>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Category>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Category category : findAll()) {
			remove(category);
		}
	}

	/**
	 * Returns the number of categories.
	 *
	 * @return the number of categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CATEGORY);

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
		return CategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the category persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CategoryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_CATEGORY = "SELECT category FROM Category category";
	private static final String _SQL_SELECT_CATEGORY_WHERE_PKS_IN = "SELECT category FROM Category category WHERE categoryId IN (";
	private static final String _SQL_SELECT_CATEGORY_WHERE = "SELECT category FROM Category category WHERE ";
	private static final String _SQL_COUNT_CATEGORY = "SELECT COUNT(category) FROM Category category";
	private static final String _SQL_COUNT_CATEGORY_WHERE = "SELECT COUNT(category) FROM Category category WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "category.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Category exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Category exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CategoryPersistenceImpl.class);
	private static final Category _nullCategory = new CategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Category> toCacheModel() {
				return _nullCategoryCacheModel;
			}
		};

	private static final CacheModel<Category> _nullCategoryCacheModel = new CacheModel<Category>() {
			@Override
			public Category toEntityModel() {
				return _nullCategory;
			}
		};
}