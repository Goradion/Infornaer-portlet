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

package de.ki.sbam.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import de.ki.sbam.model.Category;

import java.util.List;

/**
 * The persistence utility for the category service. This utility wraps {@link de.ki.sbam.service.persistence.impl.CategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see CategoryPersistence
 * @see de.ki.sbam.service.persistence.impl.CategoryPersistenceImpl
 * @generated
 */
@ProviderType
public class CategoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Category category) {
		getPersistence().clearCache(category);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Category> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Category> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Category update(Category category) {
		return getPersistence().update(category);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Category update(Category category,
		ServiceContext serviceContext) {
		return getPersistence().update(category, serviceContext);
	}

	/**
	* Returns the category where categoryName = &#63; or throws a {@link NoSuchCategoryException} if it could not be found.
	*
	* @param categoryName the category name
	* @return the matching category
	* @throws NoSuchCategoryException if a matching category could not be found
	*/
	public static Category findByCategoryName(java.lang.String categoryName)
		throws de.ki.sbam.exception.NoSuchCategoryException {
		return getPersistence().findByCategoryName(categoryName);
	}

	/**
	* Returns the category where categoryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param categoryName the category name
	* @return the matching category, or <code>null</code> if a matching category could not be found
	*/
	public static Category fetchByCategoryName(java.lang.String categoryName) {
		return getPersistence().fetchByCategoryName(categoryName);
	}

	/**
	* Returns the category where categoryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param categoryName the category name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching category, or <code>null</code> if a matching category could not be found
	*/
	public static Category fetchByCategoryName(java.lang.String categoryName,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByCategoryName(categoryName, retrieveFromCache);
	}

	/**
	* Removes the category where categoryName = &#63; from the database.
	*
	* @param categoryName the category name
	* @return the category that was removed
	*/
	public static Category removeByCategoryName(java.lang.String categoryName)
		throws de.ki.sbam.exception.NoSuchCategoryException {
		return getPersistence().removeByCategoryName(categoryName);
	}

	/**
	* Returns the number of categories where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @return the number of matching categories
	*/
	public static int countByCategoryName(java.lang.String categoryName) {
		return getPersistence().countByCategoryName(categoryName);
	}

	/**
	* Returns all the categories where unlocked = &#63;.
	*
	* @param unlocked the unlocked
	* @return the matching categories
	*/
	public static List<Category> findByUnlocked(boolean unlocked) {
		return getPersistence().findByUnlocked(unlocked);
	}

	/**
	* Returns a range of all the categories where unlocked = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unlocked the unlocked
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @return the range of matching categories
	*/
	public static List<Category> findByUnlocked(boolean unlocked, int start,
		int end) {
		return getPersistence().findByUnlocked(unlocked, start, end);
	}

	/**
	* Returns an ordered range of all the categories where unlocked = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unlocked the unlocked
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching categories
	*/
	public static List<Category> findByUnlocked(boolean unlocked, int start,
		int end, OrderByComparator<Category> orderByComparator) {
		return getPersistence()
				   .findByUnlocked(unlocked, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the categories where unlocked = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unlocked the unlocked
	* @param start the lower bound of the range of categories
	* @param end the upper bound of the range of categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching categories
	*/
	public static List<Category> findByUnlocked(boolean unlocked, int start,
		int end, OrderByComparator<Category> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUnlocked(unlocked, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first category in the ordered set where unlocked = &#63;.
	*
	* @param unlocked the unlocked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category
	* @throws NoSuchCategoryException if a matching category could not be found
	*/
	public static Category findByUnlocked_First(boolean unlocked,
		OrderByComparator<Category> orderByComparator)
		throws de.ki.sbam.exception.NoSuchCategoryException {
		return getPersistence().findByUnlocked_First(unlocked, orderByComparator);
	}

	/**
	* Returns the first category in the ordered set where unlocked = &#63;.
	*
	* @param unlocked the unlocked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category, or <code>null</code> if a matching category could not be found
	*/
	public static Category fetchByUnlocked_First(boolean unlocked,
		OrderByComparator<Category> orderByComparator) {
		return getPersistence()
				   .fetchByUnlocked_First(unlocked, orderByComparator);
	}

	/**
	* Returns the last category in the ordered set where unlocked = &#63;.
	*
	* @param unlocked the unlocked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category
	* @throws NoSuchCategoryException if a matching category could not be found
	*/
	public static Category findByUnlocked_Last(boolean unlocked,
		OrderByComparator<Category> orderByComparator)
		throws de.ki.sbam.exception.NoSuchCategoryException {
		return getPersistence().findByUnlocked_Last(unlocked, orderByComparator);
	}

	/**
	* Returns the last category in the ordered set where unlocked = &#63;.
	*
	* @param unlocked the unlocked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category, or <code>null</code> if a matching category could not be found
	*/
	public static Category fetchByUnlocked_Last(boolean unlocked,
		OrderByComparator<Category> orderByComparator) {
		return getPersistence().fetchByUnlocked_Last(unlocked, orderByComparator);
	}

	/**
	* Returns the categories before and after the current category in the ordered set where unlocked = &#63;.
	*
	* @param categoryId the primary key of the current category
	* @param unlocked the unlocked
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category
	* @throws NoSuchCategoryException if a category with the primary key could not be found
	*/
	public static Category[] findByUnlocked_PrevAndNext(long categoryId,
		boolean unlocked, OrderByComparator<Category> orderByComparator)
		throws de.ki.sbam.exception.NoSuchCategoryException {
		return getPersistence()
				   .findByUnlocked_PrevAndNext(categoryId, unlocked,
			orderByComparator);
	}

	/**
	* Removes all the categories where unlocked = &#63; from the database.
	*
	* @param unlocked the unlocked
	*/
	public static void removeByUnlocked(boolean unlocked) {
		getPersistence().removeByUnlocked(unlocked);
	}

	/**
	* Returns the number of categories where unlocked = &#63;.
	*
	* @param unlocked the unlocked
	* @return the number of matching categories
	*/
	public static int countByUnlocked(boolean unlocked) {
		return getPersistence().countByUnlocked(unlocked);
	}

	/**
	* Caches the category in the entity cache if it is enabled.
	*
	* @param category the category
	*/
	public static void cacheResult(Category category) {
		getPersistence().cacheResult(category);
	}

	/**
	* Caches the categories in the entity cache if it is enabled.
	*
	* @param categories the categories
	*/
	public static void cacheResult(List<Category> categories) {
		getPersistence().cacheResult(categories);
	}

	/**
	* Creates a new category with the primary key. Does not add the category to the database.
	*
	* @param categoryId the primary key for the new category
	* @return the new category
	*/
	public static Category create(long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the category
	* @return the category that was removed
	* @throws NoSuchCategoryException if a category with the primary key could not be found
	*/
	public static Category remove(long categoryId)
		throws de.ki.sbam.exception.NoSuchCategoryException {
		return getPersistence().remove(categoryId);
	}

	public static Category updateImpl(Category category) {
		return getPersistence().updateImpl(category);
	}

	/**
	* Returns the category with the primary key or throws a {@link NoSuchCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category
	* @throws NoSuchCategoryException if a category with the primary key could not be found
	*/
	public static Category findByPrimaryKey(long categoryId)
		throws de.ki.sbam.exception.NoSuchCategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category, or <code>null</code> if a category with the primary key could not be found
	*/
	public static Category fetchByPrimaryKey(long categoryId) {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	public static java.util.Map<java.io.Serializable, Category> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the categories.
	*
	* @return the categories
	*/
	public static List<Category> findAll() {
		return getPersistence().findAll();
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
	public static List<Category> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Category> findAll(int start, int end,
		OrderByComparator<Category> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Category> findAll(int start, int end,
		OrderByComparator<Category> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the categories from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of categories.
	*
	* @return the number of categories
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CategoryPersistence)PortletBeanLocatorUtil.locate(de.ki.sbam.service.ClpSerializer.getServletContextName(),
					CategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(CategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static CategoryPersistence _persistence;
}