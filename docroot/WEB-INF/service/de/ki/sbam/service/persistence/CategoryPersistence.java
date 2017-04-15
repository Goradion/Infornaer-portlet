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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import de.ki.sbam.exception.NoSuchCategoryException;
import de.ki.sbam.model.Category;

/**
 * The persistence interface for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see de.ki.sbam.service.persistence.impl.CategoryPersistenceImpl
 * @see CategoryUtil
 * @generated
 */
@ProviderType
public interface CategoryPersistence extends BasePersistence<Category> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the category where categoryName = &#63; or throws a {@link NoSuchCategoryException} if it could not be found.
	*
	* @param categoryName the category name
	* @return the matching category
	* @throws NoSuchCategoryException if a matching category could not be found
	*/
	public Category findByCategoryName(java.lang.String categoryName)
		throws NoSuchCategoryException;

	/**
	* Returns the category where categoryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param categoryName the category name
	* @return the matching category, or <code>null</code> if a matching category could not be found
	*/
	public Category fetchByCategoryName(java.lang.String categoryName);

	/**
	* Returns the category where categoryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param categoryName the category name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching category, or <code>null</code> if a matching category could not be found
	*/
	public Category fetchByCategoryName(java.lang.String categoryName,
		boolean retrieveFromCache);

	/**
	* Removes the category where categoryName = &#63; from the database.
	*
	* @param categoryName the category name
	* @return the category that was removed
	*/
	public Category removeByCategoryName(java.lang.String categoryName)
		throws NoSuchCategoryException;

	/**
	* Returns the number of categories where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @return the number of matching categories
	*/
	public int countByCategoryName(java.lang.String categoryName);

	/**
	* Caches the category in the entity cache if it is enabled.
	*
	* @param category the category
	*/
	public void cacheResult(Category category);

	/**
	* Caches the categories in the entity cache if it is enabled.
	*
	* @param categories the categories
	*/
	public void cacheResult(java.util.List<Category> categories);

	/**
	* Creates a new category with the primary key. Does not add the category to the database.
	*
	* @param categoryId the primary key for the new category
	* @return the new category
	*/
	public Category create(long categoryId);

	/**
	* Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the category
	* @return the category that was removed
	* @throws NoSuchCategoryException if a category with the primary key could not be found
	*/
	public Category remove(long categoryId) throws NoSuchCategoryException;

	public Category updateImpl(Category category);

	/**
	* Returns the category with the primary key or throws a {@link NoSuchCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category
	* @throws NoSuchCategoryException if a category with the primary key could not be found
	*/
	public Category findByPrimaryKey(long categoryId)
		throws NoSuchCategoryException;

	/**
	* Returns the category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the category
	* @return the category, or <code>null</code> if a category with the primary key could not be found
	*/
	public Category fetchByPrimaryKey(long categoryId);

	@Override
	public java.util.Map<java.io.Serializable, Category> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the categories.
	*
	* @return the categories
	*/
	public java.util.List<Category> findAll();

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
	public java.util.List<Category> findAll(int start, int end);

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
	public java.util.List<Category> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category> orderByComparator);

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
	public java.util.List<Category> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Category> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the categories from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of categories.
	*
	* @return the number of categories
	*/
	public int countAll();
}