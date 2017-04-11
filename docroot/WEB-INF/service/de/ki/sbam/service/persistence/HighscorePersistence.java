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

import de.ki.sbam.exception.NoSuchHighscoreException;
import de.ki.sbam.model.Highscore;

/**
 * The persistence interface for the highscore service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller
 * @see de.ki.sbam.service.persistence.impl.HighscorePersistenceImpl
 * @see HighscoreUtil
 * @generated
 */
@ProviderType
public interface HighscorePersistence extends BasePersistence<Highscore> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HighscoreUtil} to access the highscore persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the highscore where userId = &#63; or throws a {@link NoSuchHighscoreException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching highscore
	* @throws NoSuchHighscoreException if a matching highscore could not be found
	*/
	public Highscore findByUserId(long userId) throws NoSuchHighscoreException;

	/**
	* Returns the highscore where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching highscore, or <code>null</code> if a matching highscore could not be found
	*/
	public Highscore fetchByUserId(long userId);

	/**
	* Returns the highscore where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching highscore, or <code>null</code> if a matching highscore could not be found
	*/
	public Highscore fetchByUserId(long userId, boolean retrieveFromCache);

	/**
	* Removes the highscore where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the highscore that was removed
	*/
	public Highscore removeByUserId(long userId)
		throws NoSuchHighscoreException;

	/**
	* Returns the number of highscores where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching highscores
	*/
	public int countByUserId(long userId);

	/**
	* Caches the highscore in the entity cache if it is enabled.
	*
	* @param highscore the highscore
	*/
	public void cacheResult(Highscore highscore);

	/**
	* Caches the highscores in the entity cache if it is enabled.
	*
	* @param highscores the highscores
	*/
	public void cacheResult(java.util.List<Highscore> highscores);

	/**
	* Creates a new highscore with the primary key. Does not add the highscore to the database.
	*
	* @param userId the primary key for the new highscore
	* @return the new highscore
	*/
	public Highscore create(long userId);

	/**
	* Removes the highscore with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the highscore
	* @return the highscore that was removed
	* @throws NoSuchHighscoreException if a highscore with the primary key could not be found
	*/
	public Highscore remove(long userId) throws NoSuchHighscoreException;

	public Highscore updateImpl(Highscore highscore);

	/**
	* Returns the highscore with the primary key or throws a {@link NoSuchHighscoreException} if it could not be found.
	*
	* @param userId the primary key of the highscore
	* @return the highscore
	* @throws NoSuchHighscoreException if a highscore with the primary key could not be found
	*/
	public Highscore findByPrimaryKey(long userId)
		throws NoSuchHighscoreException;

	/**
	* Returns the highscore with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the highscore
	* @return the highscore, or <code>null</code> if a highscore with the primary key could not be found
	*/
	public Highscore fetchByPrimaryKey(long userId);

	@Override
	public java.util.Map<java.io.Serializable, Highscore> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the highscores.
	*
	* @return the highscores
	*/
	public java.util.List<Highscore> findAll();

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
	public java.util.List<Highscore> findAll(int start, int end);

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
	public java.util.List<Highscore> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Highscore> orderByComparator);

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
	public java.util.List<Highscore> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Highscore> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the highscores from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of highscores.
	*
	* @return the number of highscores
	*/
	public int countAll();
}