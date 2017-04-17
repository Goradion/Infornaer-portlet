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

import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import de.ki.sbam.exception.NoSuchQuestionException;
import de.ki.sbam.model.Question;
import de.ki.sbam.model.impl.QuestionImpl;
import de.ki.sbam.model.impl.QuestionModelImpl;
import de.ki.sbam.service.persistence.QuestionPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see QuestionPersistence
 * @see de.ki.sbam.service.persistence.QuestionUtil
 * @generated
 */
@ProviderType
public class QuestionPersistenceImpl extends BasePersistenceImpl<Question>
	implements QuestionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link QuestionUtil} to access the question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = QuestionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY =
		new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] { Long.class.getName() },
			QuestionModelImpl.CATEGORYID_FK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORY = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the questions where categoryId_fk = &#63;.
	 *
	 * @param categoryId_fk the category id_fk
	 * @return the matching questions
	 */
	@Override
	public List<Question> findByCategory(long categoryId_fk) {
		return findByCategory(categoryId_fk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the questions where categoryId_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId_fk the category id_fk
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of matching questions
	 */
	@Override
	public List<Question> findByCategory(long categoryId_fk, int start, int end) {
		return findByCategory(categoryId_fk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the questions where categoryId_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId_fk the category id_fk
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching questions
	 */
	@Override
	public List<Question> findByCategory(long categoryId_fk, int start,
		int end, OrderByComparator<Question> orderByComparator) {
		return findByCategory(categoryId_fk, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the questions where categoryId_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId_fk the category id_fk
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching questions
	 */
	@Override
	public List<Question> findByCategory(long categoryId_fk, int start,
		int end, OrderByComparator<Question> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] { categoryId_fk };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORY;
			finderArgs = new Object[] {
					categoryId_fk,
					
					start, end, orderByComparator
				};
		}

		List<Question> list = null;

		if (retrieveFromCache) {
			list = (List<Question>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Question question : list) {
					if ((categoryId_fk != question.getCategoryId_fk())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_QUESTION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_FK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(QuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId_fk);

				if (!pagination) {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first question in the ordered set where categoryId_fk = &#63;.
	 *
	 * @param categoryId_fk the category id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question
	 * @throws NoSuchQuestionException if a matching question could not be found
	 */
	@Override
	public Question findByCategory_First(long categoryId_fk,
		OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException {
		Question question = fetchByCategory_First(categoryId_fk,
				orderByComparator);

		if (question != null) {
			return question;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId_fk=");
		msg.append(categoryId_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionException(msg.toString());
	}

	/**
	 * Returns the first question in the ordered set where categoryId_fk = &#63;.
	 *
	 * @param categoryId_fk the category id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public Question fetchByCategory_First(long categoryId_fk,
		OrderByComparator<Question> orderByComparator) {
		List<Question> list = findByCategory(categoryId_fk, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last question in the ordered set where categoryId_fk = &#63;.
	 *
	 * @param categoryId_fk the category id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question
	 * @throws NoSuchQuestionException if a matching question could not be found
	 */
	@Override
	public Question findByCategory_Last(long categoryId_fk,
		OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException {
		Question question = fetchByCategory_Last(categoryId_fk,
				orderByComparator);

		if (question != null) {
			return question;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId_fk=");
		msg.append(categoryId_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionException(msg.toString());
	}

	/**
	 * Returns the last question in the ordered set where categoryId_fk = &#63;.
	 *
	 * @param categoryId_fk the category id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public Question fetchByCategory_Last(long categoryId_fk,
		OrderByComparator<Question> orderByComparator) {
		int count = countByCategory(categoryId_fk);

		if (count == 0) {
			return null;
		}

		List<Question> list = findByCategory(categoryId_fk, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the questions before and after the current question in the ordered set where categoryId_fk = &#63;.
	 *
	 * @param questionId the primary key of the current question
	 * @param categoryId_fk the category id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next question
	 * @throws NoSuchQuestionException if a question with the primary key could not be found
	 */
	@Override
	public Question[] findByCategory_PrevAndNext(long questionId,
		long categoryId_fk, OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException {
		Question question = findByPrimaryKey(questionId);

		Session session = null;

		try {
			session = openSession();

			Question[] array = new QuestionImpl[3];

			array[0] = getByCategory_PrevAndNext(session, question,
					categoryId_fk, orderByComparator, true);

			array[1] = question;

			array[2] = getByCategory_PrevAndNext(session, question,
					categoryId_fk, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Question getByCategory_PrevAndNext(Session session,
		Question question, long categoryId_fk,
		OrderByComparator<Question> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUESTION_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_FK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(QuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId_fk);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(question);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Question> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the questions where categoryId_fk = &#63; from the database.
	 *
	 * @param categoryId_fk the category id_fk
	 */
	@Override
	public void removeByCategory(long categoryId_fk) {
		for (Question question : findByCategory(categoryId_fk,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(question);
		}
	}

	/**
	 * Returns the number of questions where categoryId_fk = &#63;.
	 *
	 * @param categoryId_fk the category id_fk
	 * @return the number of matching questions
	 */
	@Override
	public int countByCategory(long categoryId_fk) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORY;

		Object[] finderArgs = new Object[] { categoryId_fk };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUESTION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_FK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId_fk);

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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_FK_2 = "question.categoryId_fk = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DIFFICULTY =
		new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDifficulty",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIFFICULTY =
		new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDifficulty",
			new String[] { Long.class.getName() },
			QuestionModelImpl.DIFFICULTYID_FK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DIFFICULTY = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDifficulty",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the questions where difficultyId_fk = &#63;.
	 *
	 * @param difficultyId_fk the difficulty id_fk
	 * @return the matching questions
	 */
	@Override
	public List<Question> findByDifficulty(long difficultyId_fk) {
		return findByDifficulty(difficultyId_fk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the questions where difficultyId_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param difficultyId_fk the difficulty id_fk
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of matching questions
	 */
	@Override
	public List<Question> findByDifficulty(long difficultyId_fk, int start,
		int end) {
		return findByDifficulty(difficultyId_fk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the questions where difficultyId_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param difficultyId_fk the difficulty id_fk
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching questions
	 */
	@Override
	public List<Question> findByDifficulty(long difficultyId_fk, int start,
		int end, OrderByComparator<Question> orderByComparator) {
		return findByDifficulty(difficultyId_fk, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the questions where difficultyId_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param difficultyId_fk the difficulty id_fk
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching questions
	 */
	@Override
	public List<Question> findByDifficulty(long difficultyId_fk, int start,
		int end, OrderByComparator<Question> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIFFICULTY;
			finderArgs = new Object[] { difficultyId_fk };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DIFFICULTY;
			finderArgs = new Object[] {
					difficultyId_fk,
					
					start, end, orderByComparator
				};
		}

		List<Question> list = null;

		if (retrieveFromCache) {
			list = (List<Question>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Question question : list) {
					if ((difficultyId_fk != question.getDifficultyId_fk())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_QUESTION_WHERE);

			query.append(_FINDER_COLUMN_DIFFICULTY_DIFFICULTYID_FK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(QuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(difficultyId_fk);

				if (!pagination) {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first question in the ordered set where difficultyId_fk = &#63;.
	 *
	 * @param difficultyId_fk the difficulty id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question
	 * @throws NoSuchQuestionException if a matching question could not be found
	 */
	@Override
	public Question findByDifficulty_First(long difficultyId_fk,
		OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException {
		Question question = fetchByDifficulty_First(difficultyId_fk,
				orderByComparator);

		if (question != null) {
			return question;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("difficultyId_fk=");
		msg.append(difficultyId_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionException(msg.toString());
	}

	/**
	 * Returns the first question in the ordered set where difficultyId_fk = &#63;.
	 *
	 * @param difficultyId_fk the difficulty id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public Question fetchByDifficulty_First(long difficultyId_fk,
		OrderByComparator<Question> orderByComparator) {
		List<Question> list = findByDifficulty(difficultyId_fk, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last question in the ordered set where difficultyId_fk = &#63;.
	 *
	 * @param difficultyId_fk the difficulty id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question
	 * @throws NoSuchQuestionException if a matching question could not be found
	 */
	@Override
	public Question findByDifficulty_Last(long difficultyId_fk,
		OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException {
		Question question = fetchByDifficulty_Last(difficultyId_fk,
				orderByComparator);

		if (question != null) {
			return question;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("difficultyId_fk=");
		msg.append(difficultyId_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionException(msg.toString());
	}

	/**
	 * Returns the last question in the ordered set where difficultyId_fk = &#63;.
	 *
	 * @param difficultyId_fk the difficulty id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public Question fetchByDifficulty_Last(long difficultyId_fk,
		OrderByComparator<Question> orderByComparator) {
		int count = countByDifficulty(difficultyId_fk);

		if (count == 0) {
			return null;
		}

		List<Question> list = findByDifficulty(difficultyId_fk, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the questions before and after the current question in the ordered set where difficultyId_fk = &#63;.
	 *
	 * @param questionId the primary key of the current question
	 * @param difficultyId_fk the difficulty id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next question
	 * @throws NoSuchQuestionException if a question with the primary key could not be found
	 */
	@Override
	public Question[] findByDifficulty_PrevAndNext(long questionId,
		long difficultyId_fk, OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException {
		Question question = findByPrimaryKey(questionId);

		Session session = null;

		try {
			session = openSession();

			Question[] array = new QuestionImpl[3];

			array[0] = getByDifficulty_PrevAndNext(session, question,
					difficultyId_fk, orderByComparator, true);

			array[1] = question;

			array[2] = getByDifficulty_PrevAndNext(session, question,
					difficultyId_fk, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Question getByDifficulty_PrevAndNext(Session session,
		Question question, long difficultyId_fk,
		OrderByComparator<Question> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUESTION_WHERE);

		query.append(_FINDER_COLUMN_DIFFICULTY_DIFFICULTYID_FK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(QuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(difficultyId_fk);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(question);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Question> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the questions where difficultyId_fk = &#63; from the database.
	 *
	 * @param difficultyId_fk the difficulty id_fk
	 */
	@Override
	public void removeByDifficulty(long difficultyId_fk) {
		for (Question question : findByDifficulty(difficultyId_fk,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(question);
		}
	}

	/**
	 * Returns the number of questions where difficultyId_fk = &#63;.
	 *
	 * @param difficultyId_fk the difficulty id_fk
	 * @return the number of matching questions
	 */
	@Override
	public int countByDifficulty(long difficultyId_fk) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DIFFICULTY;

		Object[] finderArgs = new Object[] { difficultyId_fk };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUESTION_WHERE);

			query.append(_FINDER_COLUMN_DIFFICULTY_DIFFICULTYID_FK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(difficultyId_fk);

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

	private static final String _FINDER_COLUMN_DIFFICULTY_DIFFICULTYID_FK_2 = "question.difficultyId_fk = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_QUESTIONID = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByQuestionId",
			new String[] { Long.class.getName() },
			QuestionModelImpl.QUESTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_QUESTIONID = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByQuestionId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the question where questionId = &#63; or throws a {@link NoSuchQuestionException} if it could not be found.
	 *
	 * @param questionId the question ID
	 * @return the matching question
	 * @throws NoSuchQuestionException if a matching question could not be found
	 */
	@Override
	public Question findByQuestionId(long questionId)
		throws NoSuchQuestionException {
		Question question = fetchByQuestionId(questionId);

		if (question == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("questionId=");
			msg.append(questionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchQuestionException(msg.toString());
		}

		return question;
	}

	/**
	 * Returns the question where questionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param questionId the question ID
	 * @return the matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public Question fetchByQuestionId(long questionId) {
		return fetchByQuestionId(questionId, true);
	}

	/**
	 * Returns the question where questionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param questionId the question ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public Question fetchByQuestionId(long questionId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { questionId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_QUESTIONID,
					finderArgs, this);
		}

		if (result instanceof Question) {
			Question question = (Question)result;

			if ((questionId != question.getQuestionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_QUESTION_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				List<Question> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_QUESTIONID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"QuestionPersistenceImpl.fetchByQuestionId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Question question = list.get(0);

					result = question;

					cacheResult(question);

					if ((question.getQuestionId() != questionId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_QUESTIONID,
							finderArgs, question);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_QUESTIONID,
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
			return (Question)result;
		}
	}

	/**
	 * Removes the question where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 * @return the question that was removed
	 */
	@Override
	public Question removeByQuestionId(long questionId)
		throws NoSuchQuestionException {
		Question question = findByQuestionId(questionId);

		return remove(question);
	}

	/**
	 * Returns the number of questions where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching questions
	 */
	@Override
	public int countByQuestionId(long questionId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_QUESTIONID;

		Object[] finderArgs = new Object[] { questionId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUESTION_WHERE);

			query.append(_FINDER_COLUMN_QUESTIONID_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

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

	private static final String _FINDER_COLUMN_QUESTIONID_QUESTIONID_2 = "question.questionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDDIFFICULTY =
		new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategoryAndDifficulty",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDDIFFICULTY =
		new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, QuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryAndDifficulty",
			new String[] { Long.class.getName(), Long.class.getName() },
			QuestionModelImpl.CATEGORYID_FK_COLUMN_BITMASK |
			QuestionModelImpl.DIFFICULTYID_FK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYANDDIFFICULTY = new FinderPath(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryAndDifficulty",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the questions where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	 *
	 * @param categoryId_fk the category id_fk
	 * @param difficultyId_fk the difficulty id_fk
	 * @return the matching questions
	 */
	@Override
	public List<Question> findByCategoryAndDifficulty(long categoryId_fk,
		long difficultyId_fk) {
		return findByCategoryAndDifficulty(categoryId_fk, difficultyId_fk,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the questions where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId_fk the category id_fk
	 * @param difficultyId_fk the difficulty id_fk
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of matching questions
	 */
	@Override
	public List<Question> findByCategoryAndDifficulty(long categoryId_fk,
		long difficultyId_fk, int start, int end) {
		return findByCategoryAndDifficulty(categoryId_fk, difficultyId_fk,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the questions where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId_fk the category id_fk
	 * @param difficultyId_fk the difficulty id_fk
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching questions
	 */
	@Override
	public List<Question> findByCategoryAndDifficulty(long categoryId_fk,
		long difficultyId_fk, int start, int end,
		OrderByComparator<Question> orderByComparator) {
		return findByCategoryAndDifficulty(categoryId_fk, difficultyId_fk,
			start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the questions where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId_fk the category id_fk
	 * @param difficultyId_fk the difficulty id_fk
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching questions
	 */
	@Override
	public List<Question> findByCategoryAndDifficulty(long categoryId_fk,
		long difficultyId_fk, int start, int end,
		OrderByComparator<Question> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDDIFFICULTY;
			finderArgs = new Object[] { categoryId_fk, difficultyId_fk };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYANDDIFFICULTY;
			finderArgs = new Object[] {
					categoryId_fk, difficultyId_fk,
					
					start, end, orderByComparator
				};
		}

		List<Question> list = null;

		if (retrieveFromCache) {
			list = (List<Question>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Question question : list) {
					if ((categoryId_fk != question.getCategoryId_fk()) ||
							(difficultyId_fk != question.getDifficultyId_fk())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_QUESTION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDDIFFICULTY_CATEGORYID_FK_2);

			query.append(_FINDER_COLUMN_CATEGORYANDDIFFICULTY_DIFFICULTYID_FK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(QuestionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId_fk);

				qPos.add(difficultyId_fk);

				if (!pagination) {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first question in the ordered set where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	 *
	 * @param categoryId_fk the category id_fk
	 * @param difficultyId_fk the difficulty id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question
	 * @throws NoSuchQuestionException if a matching question could not be found
	 */
	@Override
	public Question findByCategoryAndDifficulty_First(long categoryId_fk,
		long difficultyId_fk, OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException {
		Question question = fetchByCategoryAndDifficulty_First(categoryId_fk,
				difficultyId_fk, orderByComparator);

		if (question != null) {
			return question;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId_fk=");
		msg.append(categoryId_fk);

		msg.append(", difficultyId_fk=");
		msg.append(difficultyId_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionException(msg.toString());
	}

	/**
	 * Returns the first question in the ordered set where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	 *
	 * @param categoryId_fk the category id_fk
	 * @param difficultyId_fk the difficulty id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public Question fetchByCategoryAndDifficulty_First(long categoryId_fk,
		long difficultyId_fk, OrderByComparator<Question> orderByComparator) {
		List<Question> list = findByCategoryAndDifficulty(categoryId_fk,
				difficultyId_fk, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last question in the ordered set where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	 *
	 * @param categoryId_fk the category id_fk
	 * @param difficultyId_fk the difficulty id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question
	 * @throws NoSuchQuestionException if a matching question could not be found
	 */
	@Override
	public Question findByCategoryAndDifficulty_Last(long categoryId_fk,
		long difficultyId_fk, OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException {
		Question question = fetchByCategoryAndDifficulty_Last(categoryId_fk,
				difficultyId_fk, orderByComparator);

		if (question != null) {
			return question;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId_fk=");
		msg.append(categoryId_fk);

		msg.append(", difficultyId_fk=");
		msg.append(difficultyId_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchQuestionException(msg.toString());
	}

	/**
	 * Returns the last question in the ordered set where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	 *
	 * @param categoryId_fk the category id_fk
	 * @param difficultyId_fk the difficulty id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching question, or <code>null</code> if a matching question could not be found
	 */
	@Override
	public Question fetchByCategoryAndDifficulty_Last(long categoryId_fk,
		long difficultyId_fk, OrderByComparator<Question> orderByComparator) {
		int count = countByCategoryAndDifficulty(categoryId_fk, difficultyId_fk);

		if (count == 0) {
			return null;
		}

		List<Question> list = findByCategoryAndDifficulty(categoryId_fk,
				difficultyId_fk, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the questions before and after the current question in the ordered set where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	 *
	 * @param questionId the primary key of the current question
	 * @param categoryId_fk the category id_fk
	 * @param difficultyId_fk the difficulty id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next question
	 * @throws NoSuchQuestionException if a question with the primary key could not be found
	 */
	@Override
	public Question[] findByCategoryAndDifficulty_PrevAndNext(long questionId,
		long categoryId_fk, long difficultyId_fk,
		OrderByComparator<Question> orderByComparator)
		throws NoSuchQuestionException {
		Question question = findByPrimaryKey(questionId);

		Session session = null;

		try {
			session = openSession();

			Question[] array = new QuestionImpl[3];

			array[0] = getByCategoryAndDifficulty_PrevAndNext(session,
					question, categoryId_fk, difficultyId_fk,
					orderByComparator, true);

			array[1] = question;

			array[2] = getByCategoryAndDifficulty_PrevAndNext(session,
					question, categoryId_fk, difficultyId_fk,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Question getByCategoryAndDifficulty_PrevAndNext(Session session,
		Question question, long categoryId_fk, long difficultyId_fk,
		OrderByComparator<Question> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_QUESTION_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYANDDIFFICULTY_CATEGORYID_FK_2);

		query.append(_FINDER_COLUMN_CATEGORYANDDIFFICULTY_DIFFICULTYID_FK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(QuestionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId_fk);

		qPos.add(difficultyId_fk);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(question);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Question> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the questions where categoryId_fk = &#63; and difficultyId_fk = &#63; from the database.
	 *
	 * @param categoryId_fk the category id_fk
	 * @param difficultyId_fk the difficulty id_fk
	 */
	@Override
	public void removeByCategoryAndDifficulty(long categoryId_fk,
		long difficultyId_fk) {
		for (Question question : findByCategoryAndDifficulty(categoryId_fk,
				difficultyId_fk, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(question);
		}
	}

	/**
	 * Returns the number of questions where categoryId_fk = &#63; and difficultyId_fk = &#63;.
	 *
	 * @param categoryId_fk the category id_fk
	 * @param difficultyId_fk the difficulty id_fk
	 * @return the number of matching questions
	 */
	@Override
	public int countByCategoryAndDifficulty(long categoryId_fk,
		long difficultyId_fk) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYANDDIFFICULTY;

		Object[] finderArgs = new Object[] { categoryId_fk, difficultyId_fk };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_QUESTION_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYANDDIFFICULTY_CATEGORYID_FK_2);

			query.append(_FINDER_COLUMN_CATEGORYANDDIFFICULTY_DIFFICULTYID_FK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId_fk);

				qPos.add(difficultyId_fk);

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

	private static final String _FINDER_COLUMN_CATEGORYANDDIFFICULTY_CATEGORYID_FK_2 =
		"question.categoryId_fk = ? AND ";
	private static final String _FINDER_COLUMN_CATEGORYANDDIFFICULTY_DIFFICULTYID_FK_2 =
		"question.difficultyId_fk = ?";

	public QuestionPersistenceImpl() {
		setModelClass(Question.class);
	}

	/**
	 * Caches the question in the entity cache if it is enabled.
	 *
	 * @param question the question
	 */
	@Override
	public void cacheResult(Question question) {
		entityCache.putResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionImpl.class, question.getPrimaryKey(), question);

		finderCache.putResult(FINDER_PATH_FETCH_BY_QUESTIONID,
			new Object[] { question.getQuestionId() }, question);

		question.resetOriginalValues();
	}

	/**
	 * Caches the questions in the entity cache if it is enabled.
	 *
	 * @param questions the questions
	 */
	@Override
	public void cacheResult(List<Question> questions) {
		for (Question question : questions) {
			if (entityCache.getResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
						QuestionImpl.class, question.getPrimaryKey()) == null) {
				cacheResult(question);
			}
			else {
				question.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all questions.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(QuestionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the question.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Question question) {
		entityCache.removeResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionImpl.class, question.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((QuestionModelImpl)question);
	}

	@Override
	public void clearCache(List<Question> questions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Question question : questions) {
			entityCache.removeResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
				QuestionImpl.class, question.getPrimaryKey());

			clearUniqueFindersCache((QuestionModelImpl)question);
		}
	}

	protected void cacheUniqueFindersCache(
		QuestionModelImpl questionModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { questionModelImpl.getQuestionId() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_QUESTIONID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_QUESTIONID, args,
				questionModelImpl);
		}
		else {
			if ((questionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_QUESTIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { questionModelImpl.getQuestionId() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_QUESTIONID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_QUESTIONID, args,
					questionModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(QuestionModelImpl questionModelImpl) {
		Object[] args = new Object[] { questionModelImpl.getQuestionId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_QUESTIONID, args);

		if ((questionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_QUESTIONID.getColumnBitmask()) != 0) {
			args = new Object[] { questionModelImpl.getOriginalQuestionId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_QUESTIONID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_QUESTIONID, args);
		}
	}

	/**
	 * Creates a new question with the primary key. Does not add the question to the database.
	 *
	 * @param questionId the primary key for the new question
	 * @return the new question
	 */
	@Override
	public Question create(long questionId) {
		Question question = new QuestionImpl();

		question.setNew(true);
		question.setPrimaryKey(questionId);

		question.setCompanyId(companyProvider.getCompanyId());

		return question;
	}

	/**
	 * Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionId the primary key of the question
	 * @return the question that was removed
	 * @throws NoSuchQuestionException if a question with the primary key could not be found
	 */
	@Override
	public Question remove(long questionId) throws NoSuchQuestionException {
		return remove((Serializable)questionId);
	}

	/**
	 * Removes the question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the question
	 * @return the question that was removed
	 * @throws NoSuchQuestionException if a question with the primary key could not be found
	 */
	@Override
	public Question remove(Serializable primaryKey)
		throws NoSuchQuestionException {
		Session session = null;

		try {
			session = openSession();

			Question question = (Question)session.get(QuestionImpl.class,
					primaryKey);

			if (question == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(question);
		}
		catch (NoSuchQuestionException nsee) {
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
	protected Question removeImpl(Question question) {
		question = toUnwrappedModel(question);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(question)) {
				question = (Question)session.get(QuestionImpl.class,
						question.getPrimaryKeyObj());
			}

			if (question != null) {
				session.delete(question);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (question != null) {
			clearCache(question);
		}

		return question;
	}

	@Override
	public Question updateImpl(Question question) {
		question = toUnwrappedModel(question);

		boolean isNew = question.isNew();

		QuestionModelImpl questionModelImpl = (QuestionModelImpl)question;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (question.getCreateDate() == null)) {
			if (serviceContext == null) {
				question.setCreateDate(now);
			}
			else {
				question.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!questionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				question.setModifiedDate(now);
			}
			else {
				question.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (question.isNew()) {
				session.save(question);

				question.setNew(false);
			}
			else {
				question = (Question)session.merge(question);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !QuestionModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((questionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						questionModelImpl.getOriginalCategoryId_fk()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);

				args = new Object[] { questionModelImpl.getCategoryId_fk() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORY,
					args);
			}

			if ((questionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIFFICULTY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						questionModelImpl.getOriginalDifficultyId_fk()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIFFICULTY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIFFICULTY,
					args);

				args = new Object[] { questionModelImpl.getDifficultyId_fk() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DIFFICULTY, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DIFFICULTY,
					args);
			}

			if ((questionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDDIFFICULTY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						questionModelImpl.getOriginalCategoryId_fk(),
						questionModelImpl.getOriginalDifficultyId_fk()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDDIFFICULTY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDDIFFICULTY,
					args);

				args = new Object[] {
						questionModelImpl.getCategoryId_fk(),
						questionModelImpl.getDifficultyId_fk()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CATEGORYANDDIFFICULTY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYANDDIFFICULTY,
					args);
			}
		}

		entityCache.putResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
			QuestionImpl.class, question.getPrimaryKey(), question, false);

		clearUniqueFindersCache(questionModelImpl);
		cacheUniqueFindersCache(questionModelImpl, isNew);

		question.resetOriginalValues();

		return question;
	}

	protected Question toUnwrappedModel(Question question) {
		if (question instanceof QuestionImpl) {
			return question;
		}

		QuestionImpl questionImpl = new QuestionImpl();

		questionImpl.setNew(question.isNew());
		questionImpl.setPrimaryKey(question.getPrimaryKey());

		questionImpl.setQuestionId(question.getQuestionId());
		questionImpl.setGroupId(question.getGroupId());
		questionImpl.setCompanyId(question.getCompanyId());
		questionImpl.setUserId(question.getUserId());
		questionImpl.setUserName(question.getUserName());
		questionImpl.setCreateDate(question.getCreateDate());
		questionImpl.setModifiedDate(question.getModifiedDate());
		questionImpl.setQuestionContent(question.getQuestionContent());
		questionImpl.setAnswerA(question.getAnswerA());
		questionImpl.setAnswerB(question.getAnswerB());
		questionImpl.setAnswerC(question.getAnswerC());
		questionImpl.setAnswerD(question.getAnswerD());
		questionImpl.setCategoryId_fk(question.getCategoryId_fk());
		questionImpl.setDifficultyId_fk(question.getDifficultyId_fk());
		questionImpl.setRightAnswer(question.getRightAnswer());

		return questionImpl;
	}

	/**
	 * Returns the question with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the question
	 * @return the question
	 * @throws NoSuchQuestionException if a question with the primary key could not be found
	 */
	@Override
	public Question findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuestionException {
		Question question = fetchByPrimaryKey(primaryKey);

		if (question == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return question;
	}

	/**
	 * Returns the question with the primary key or throws a {@link NoSuchQuestionException} if it could not be found.
	 *
	 * @param questionId the primary key of the question
	 * @return the question
	 * @throws NoSuchQuestionException if a question with the primary key could not be found
	 */
	@Override
	public Question findByPrimaryKey(long questionId)
		throws NoSuchQuestionException {
		return findByPrimaryKey((Serializable)questionId);
	}

	/**
	 * Returns the question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the question
	 * @return the question, or <code>null</code> if a question with the primary key could not be found
	 */
	@Override
	public Question fetchByPrimaryKey(Serializable primaryKey) {
		Question question = (Question)entityCache.getResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
				QuestionImpl.class, primaryKey);

		if (question == _nullQuestion) {
			return null;
		}

		if (question == null) {
			Session session = null;

			try {
				session = openSession();

				question = (Question)session.get(QuestionImpl.class, primaryKey);

				if (question != null) {
					cacheResult(question);
				}
				else {
					entityCache.putResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
						QuestionImpl.class, primaryKey, _nullQuestion);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
					QuestionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return question;
	}

	/**
	 * Returns the question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionId the primary key of the question
	 * @return the question, or <code>null</code> if a question with the primary key could not be found
	 */
	@Override
	public Question fetchByPrimaryKey(long questionId) {
		return fetchByPrimaryKey((Serializable)questionId);
	}

	@Override
	public Map<Serializable, Question> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Question> map = new HashMap<Serializable, Question>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Question question = fetchByPrimaryKey(primaryKey);

			if (question != null) {
				map.put(primaryKey, question);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Question question = (Question)entityCache.getResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
					QuestionImpl.class, primaryKey);

			if (question == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, question);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_QUESTION_WHERE_PKS_IN);

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

			for (Question question : (List<Question>)q.list()) {
				map.put(question.getPrimaryKeyObj(), question);

				cacheResult(question);

				uncachedPrimaryKeys.remove(question.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(QuestionModelImpl.ENTITY_CACHE_ENABLED,
					QuestionImpl.class, primaryKey, _nullQuestion);
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
	 * Returns all the questions.
	 *
	 * @return the questions
	 */
	@Override
	public List<Question> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @return the range of questions
	 */
	@Override
	public List<Question> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of questions
	 */
	@Override
	public List<Question> findAll(int start, int end,
		OrderByComparator<Question> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link QuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of questions
	 * @param end the upper bound of the range of questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of questions
	 */
	@Override
	public List<Question> findAll(int start, int end,
		OrderByComparator<Question> orderByComparator, boolean retrieveFromCache) {
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

		List<Question> list = null;

		if (retrieveFromCache) {
			list = (List<Question>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_QUESTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUESTION;

				if (pagination) {
					sql = sql.concat(QuestionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Question>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the questions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Question question : findAll()) {
			remove(question);
		}
	}

	/**
	 * Returns the number of questions.
	 *
	 * @return the number of questions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUESTION);

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
		return QuestionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the question persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(QuestionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_QUESTION = "SELECT question FROM Question question";
	private static final String _SQL_SELECT_QUESTION_WHERE_PKS_IN = "SELECT question FROM Question question WHERE questionId IN (";
	private static final String _SQL_SELECT_QUESTION_WHERE = "SELECT question FROM Question question WHERE ";
	private static final String _SQL_COUNT_QUESTION = "SELECT COUNT(question) FROM Question question";
	private static final String _SQL_COUNT_QUESTION_WHERE = "SELECT COUNT(question) FROM Question question WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "question.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Question exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Question exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(QuestionPersistenceImpl.class);
	private static final Question _nullQuestion = new QuestionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Question> toCacheModel() {
				return _nullQuestionCacheModel;
			}
		};

	private static final CacheModel<Question> _nullQuestionCacheModel = new CacheModel<Question>() {
			@Override
			public Question toEntityModel() {
				return _nullQuestion;
			}
		};
}