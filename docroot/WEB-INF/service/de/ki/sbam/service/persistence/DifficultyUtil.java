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

import de.ki.sbam.model.Difficulty;

import java.util.List;

/**
 * The persistence utility for the difficulty service. This utility wraps {@link de.ki.sbam.service.persistence.impl.DifficultyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see DifficultyPersistence
 * @see de.ki.sbam.service.persistence.impl.DifficultyPersistenceImpl
 * @generated
 */
@ProviderType
public class DifficultyUtil {
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
	public static void clearCache(Difficulty difficulty) {
		getPersistence().clearCache(difficulty);
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
	public static List<Difficulty> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Difficulty> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Difficulty> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Difficulty> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Difficulty update(Difficulty difficulty) {
		return getPersistence().update(difficulty);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Difficulty update(Difficulty difficulty,
		ServiceContext serviceContext) {
		return getPersistence().update(difficulty, serviceContext);
	}

	/**
	* Returns the difficulty where score = &#63; or throws a {@link NoSuchDifficultyException} if it could not be found.
	*
	* @param score the score
	* @return the matching difficulty
	* @throws NoSuchDifficultyException if a matching difficulty could not be found
	*/
	public static Difficulty findByScore(int score)
		throws de.ki.sbam.exception.NoSuchDifficultyException {
		return getPersistence().findByScore(score);
	}

	/**
	* Returns the difficulty where score = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param score the score
	* @return the matching difficulty, or <code>null</code> if a matching difficulty could not be found
	*/
	public static Difficulty fetchByScore(int score) {
		return getPersistence().fetchByScore(score);
	}

	/**
	* Returns the difficulty where score = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param score the score
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching difficulty, or <code>null</code> if a matching difficulty could not be found
	*/
	public static Difficulty fetchByScore(int score, boolean retrieveFromCache) {
		return getPersistence().fetchByScore(score, retrieveFromCache);
	}

	/**
	* Removes the difficulty where score = &#63; from the database.
	*
	* @param score the score
	* @return the difficulty that was removed
	*/
	public static Difficulty removeByScore(int score)
		throws de.ki.sbam.exception.NoSuchDifficultyException {
		return getPersistence().removeByScore(score);
	}

	/**
	* Returns the number of difficulties where score = &#63;.
	*
	* @param score the score
	* @return the number of matching difficulties
	*/
	public static int countByScore(int score) {
		return getPersistence().countByScore(score);
	}

	/**
	* Caches the difficulty in the entity cache if it is enabled.
	*
	* @param difficulty the difficulty
	*/
	public static void cacheResult(Difficulty difficulty) {
		getPersistence().cacheResult(difficulty);
	}

	/**
	* Caches the difficulties in the entity cache if it is enabled.
	*
	* @param difficulties the difficulties
	*/
	public static void cacheResult(List<Difficulty> difficulties) {
		getPersistence().cacheResult(difficulties);
	}

	/**
	* Creates a new difficulty with the primary key. Does not add the difficulty to the database.
	*
	* @param score the primary key for the new difficulty
	* @return the new difficulty
	*/
	public static Difficulty create(int score) {
		return getPersistence().create(score);
	}

	/**
	* Removes the difficulty with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param score the primary key of the difficulty
	* @return the difficulty that was removed
	* @throws NoSuchDifficultyException if a difficulty with the primary key could not be found
	*/
	public static Difficulty remove(int score)
		throws de.ki.sbam.exception.NoSuchDifficultyException {
		return getPersistence().remove(score);
	}

	public static Difficulty updateImpl(Difficulty difficulty) {
		return getPersistence().updateImpl(difficulty);
	}

	/**
	* Returns the difficulty with the primary key or throws a {@link NoSuchDifficultyException} if it could not be found.
	*
	* @param score the primary key of the difficulty
	* @return the difficulty
	* @throws NoSuchDifficultyException if a difficulty with the primary key could not be found
	*/
	public static Difficulty findByPrimaryKey(int score)
		throws de.ki.sbam.exception.NoSuchDifficultyException {
		return getPersistence().findByPrimaryKey(score);
	}

	/**
	* Returns the difficulty with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param score the primary key of the difficulty
	* @return the difficulty, or <code>null</code> if a difficulty with the primary key could not be found
	*/
	public static Difficulty fetchByPrimaryKey(int score) {
		return getPersistence().fetchByPrimaryKey(score);
	}

	public static java.util.Map<java.io.Serializable, Difficulty> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the difficulties.
	*
	* @return the difficulties
	*/
	public static List<Difficulty> findAll() {
		return getPersistence().findAll();
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
	public static List<Difficulty> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Difficulty> findAll(int start, int end,
		OrderByComparator<Difficulty> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Difficulty> findAll(int start, int end,
		OrderByComparator<Difficulty> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the difficulties from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of difficulties.
	*
	* @return the number of difficulties
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DifficultyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DifficultyPersistence)PortletBeanLocatorUtil.locate(de.ki.sbam.service.ClpSerializer.getServletContextName(),
					DifficultyPersistence.class.getName());

			ReferenceRegistry.registerReference(DifficultyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static DifficultyPersistence _persistence;
}