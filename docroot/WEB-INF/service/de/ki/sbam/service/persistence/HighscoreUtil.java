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

import de.ki.sbam.model.Highscore;

import java.util.List;

/**
 * The persistence utility for the highscore service. This utility wraps {@link de.ki.sbam.service.persistence.impl.HighscorePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller
 * @see HighscorePersistence
 * @see de.ki.sbam.service.persistence.impl.HighscorePersistenceImpl
 * @generated
 */
@ProviderType
public class HighscoreUtil {
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
	public static void clearCache(Highscore highscore) {
		getPersistence().clearCache(highscore);
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
	public static List<Highscore> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Highscore> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Highscore> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Highscore> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Highscore update(Highscore highscore) {
		return getPersistence().update(highscore);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Highscore update(Highscore highscore,
		ServiceContext serviceContext) {
		return getPersistence().update(highscore, serviceContext);
	}

	/**
	* Returns the highscore where userId = &#63; or throws a {@link NoSuchHighscoreException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching highscore
	* @throws NoSuchHighscoreException if a matching highscore could not be found
	*/
	public static Highscore findByUserId(long userId)
		throws de.ki.sbam.exception.NoSuchHighscoreException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns the highscore where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching highscore, or <code>null</code> if a matching highscore could not be found
	*/
	public static Highscore fetchByUserId(long userId) {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	* Returns the highscore where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching highscore, or <code>null</code> if a matching highscore could not be found
	*/
	public static Highscore fetchByUserId(long userId, boolean retrieveFromCache) {
		return getPersistence().fetchByUserId(userId, retrieveFromCache);
	}

	/**
	* Removes the highscore where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the highscore that was removed
	*/
	public static Highscore removeByUserId(long userId)
		throws de.ki.sbam.exception.NoSuchHighscoreException {
		return getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of highscores where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching highscores
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the highscore in the entity cache if it is enabled.
	*
	* @param highscore the highscore
	*/
	public static void cacheResult(Highscore highscore) {
		getPersistence().cacheResult(highscore);
	}

	/**
	* Caches the highscores in the entity cache if it is enabled.
	*
	* @param highscores the highscores
	*/
	public static void cacheResult(List<Highscore> highscores) {
		getPersistence().cacheResult(highscores);
	}

	/**
	* Creates a new highscore with the primary key. Does not add the highscore to the database.
	*
	* @param userId the primary key for the new highscore
	* @return the new highscore
	*/
	public static Highscore create(long userId) {
		return getPersistence().create(userId);
	}

	/**
	* Removes the highscore with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the highscore
	* @return the highscore that was removed
	* @throws NoSuchHighscoreException if a highscore with the primary key could not be found
	*/
	public static Highscore remove(long userId)
		throws de.ki.sbam.exception.NoSuchHighscoreException {
		return getPersistence().remove(userId);
	}

	public static Highscore updateImpl(Highscore highscore) {
		return getPersistence().updateImpl(highscore);
	}

	/**
	* Returns the highscore with the primary key or throws a {@link NoSuchHighscoreException} if it could not be found.
	*
	* @param userId the primary key of the highscore
	* @return the highscore
	* @throws NoSuchHighscoreException if a highscore with the primary key could not be found
	*/
	public static Highscore findByPrimaryKey(long userId)
		throws de.ki.sbam.exception.NoSuchHighscoreException {
		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	* Returns the highscore with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the highscore
	* @return the highscore, or <code>null</code> if a highscore with the primary key could not be found
	*/
	public static Highscore fetchByPrimaryKey(long userId) {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	public static java.util.Map<java.io.Serializable, Highscore> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the highscores.
	*
	* @return the highscores
	*/
	public static List<Highscore> findAll() {
		return getPersistence().findAll();
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
	public static List<Highscore> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Highscore> findAll(int start, int end,
		OrderByComparator<Highscore> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Highscore> findAll(int start, int end,
		OrderByComparator<Highscore> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the highscores from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of highscores.
	*
	* @return the number of highscores
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HighscorePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HighscorePersistence)PortletBeanLocatorUtil.locate(de.ki.sbam.service.ClpSerializer.getServletContextName(),
					HighscorePersistence.class.getName());

			ReferenceRegistry.registerReference(HighscoreUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static HighscorePersistence _persistence;
}