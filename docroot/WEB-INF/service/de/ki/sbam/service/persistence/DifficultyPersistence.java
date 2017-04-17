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

import de.ki.sbam.exception.NoSuchDifficultyException;
import de.ki.sbam.model.Difficulty;

/**
 * The persistence interface for the difficulty service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see de.ki.sbam.service.persistence.impl.DifficultyPersistenceImpl
 * @see DifficultyUtil
 * @generated
 */
@ProviderType
public interface DifficultyPersistence extends BasePersistence<Difficulty> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DifficultyUtil} to access the difficulty persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the difficulty where score = &#63; or throws a {@link NoSuchDifficultyException} if it could not be found.
	*
	* @param score the score
	* @return the matching difficulty
	* @throws NoSuchDifficultyException if a matching difficulty could not be found
	*/
	public Difficulty findByScore(int score) throws NoSuchDifficultyException;

	/**
	* Returns the difficulty where score = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param score the score
	* @return the matching difficulty, or <code>null</code> if a matching difficulty could not be found
	*/
	public Difficulty fetchByScore(int score);

	/**
	* Returns the difficulty where score = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param score the score
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching difficulty, or <code>null</code> if a matching difficulty could not be found
	*/
	public Difficulty fetchByScore(int score, boolean retrieveFromCache);

	/**
	* Removes the difficulty where score = &#63; from the database.
	*
	* @param score the score
	* @return the difficulty that was removed
	*/
	public Difficulty removeByScore(int score) throws NoSuchDifficultyException;

	/**
	* Returns the number of difficulties where score = &#63;.
	*
	* @param score the score
	* @return the number of matching difficulties
	*/
	public int countByScore(int score);

	/**
	* Caches the difficulty in the entity cache if it is enabled.
	*
	* @param difficulty the difficulty
	*/
	public void cacheResult(Difficulty difficulty);

	/**
	* Caches the difficulties in the entity cache if it is enabled.
	*
	* @param difficulties the difficulties
	*/
	public void cacheResult(java.util.List<Difficulty> difficulties);

	/**
	* Creates a new difficulty with the primary key. Does not add the difficulty to the database.
	*
	* @param score the primary key for the new difficulty
	* @return the new difficulty
	*/
	public Difficulty create(int score);

	/**
	* Removes the difficulty with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param score the primary key of the difficulty
	* @return the difficulty that was removed
	* @throws NoSuchDifficultyException if a difficulty with the primary key could not be found
	*/
	public Difficulty remove(int score) throws NoSuchDifficultyException;

	public Difficulty updateImpl(Difficulty difficulty);

	/**
	* Returns the difficulty with the primary key or throws a {@link NoSuchDifficultyException} if it could not be found.
	*
	* @param score the primary key of the difficulty
	* @return the difficulty
	* @throws NoSuchDifficultyException if a difficulty with the primary key could not be found
	*/
	public Difficulty findByPrimaryKey(int score)
		throws NoSuchDifficultyException;

	/**
	* Returns the difficulty with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param score the primary key of the difficulty
	* @return the difficulty, or <code>null</code> if a difficulty with the primary key could not be found
	*/
	public Difficulty fetchByPrimaryKey(int score);

	@Override
	public java.util.Map<java.io.Serializable, Difficulty> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the difficulties.
	*
	* @return the difficulties
	*/
	public java.util.List<Difficulty> findAll();

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
	public java.util.List<Difficulty> findAll(int start, int end);

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
	public java.util.List<Difficulty> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Difficulty> orderByComparator);

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
	public java.util.List<Difficulty> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Difficulty> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the difficulties from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of difficulties.
	*
	* @return the number of difficulties
	*/
	public int countAll();
}