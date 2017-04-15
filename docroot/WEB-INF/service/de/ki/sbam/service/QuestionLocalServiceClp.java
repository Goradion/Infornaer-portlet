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

package de.ki.sbam.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.InvokableLocalService;

/**
 * @author Alexander Mueller, Simon Bastian
 * @generated
 */
@ProviderType
public class QuestionLocalServiceClp implements QuestionLocalService {
	public QuestionLocalServiceClp(InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "getActionableDynamicQuery";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "dynamicQuery";

<<<<<<< HEAD
		_methodParameterTypes1 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long", "com.liferay.portal.kernel.model.User"
			};
=======
		_methodParameterTypes1 = new String[] {  };
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6

		_methodName2 = "getIndexableActionableDynamicQuery";

		_methodParameterTypes2 = new String[] {  };

		_methodName3 = "deletePersistedModel";

		_methodParameterTypes3 = new String[] {
				"com.liferay.portal.kernel.model.PersistedModel"
			};

		_methodName4 = "getPersistedModel";

		_methodParameterTypes4 = new String[] { "java.io.Serializable" };

		_methodName5 = "addQuestion";

		_methodParameterTypes5 = new String[] { "de.ki.sbam.model.Question" };

		_methodName6 = "addQuestion";

		_methodParameterTypes6 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "int", "com.liferay.portal.kernel.model.User"
			};

		_methodName7 = "createQuestion";

		_methodParameterTypes7 = new String[] { "long" };

		_methodName8 = "deleteQuestion";

		_methodParameterTypes8 = new String[] { "de.ki.sbam.model.Question" };

		_methodName9 = "deleteQuestion";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "fetchQuestion";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getQuestion";

		_methodParameterTypes11 = new String[] { "long" };

<<<<<<< HEAD
		_methodName13 = "findByCategoryAndDifficulty";

		_methodParameterTypes13 = new String[] { "long", "long" };

		_methodName14 = "getActionableDynamicQuery";
=======
		_methodName12 = "updateQuestion";

		_methodParameterTypes12 = new String[] { "de.ki.sbam.model.Question" };

		_methodName13 = "getQuestionsCount";
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6

		_methodParameterTypes13 = new String[] {  };

		_methodName15 = "getIndexableActionableDynamicQuery";

		_methodParameterTypes15 = new String[] {  };

<<<<<<< HEAD
		_methodName16 = "getOSGiServiceIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "getPersistedModel";

		_methodParameterTypes17 = new String[] { "java.io.Serializable" };

		_methodName18 = "getQuestion";

		_methodParameterTypes18 = new String[] { "long" };

		_methodName19 = "getQuestions";

		_methodParameterTypes19 = new String[] { "int", "int" };

		_methodName20 = "getQuestionsCount";

		_methodParameterTypes20 = new String[] {  };

		_methodName22 = "updateQuestion";

		_methodParameterTypes22 = new String[] { "de.ki.sbam.model.Question" };
=======
		_methodName16 = "dynamicQuery";

		_methodParameterTypes16 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName17 = "dynamicQuery";

		_methodParameterTypes17 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName18 = "dynamicQuery";

		_methodParameterTypes18 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName19 = "findByCategory";

		_methodParameterTypes19 = new String[] { "java.lang.String" };

		_methodName20 = "findByCategoryId";

		_methodParameterTypes20 = new String[] { "long" };

		_methodName21 = "findByDifficulty";

		_methodParameterTypes21 = new String[] { "int" };

		_methodName22 = "getQuestions";

		_methodParameterTypes22 = new String[] { "int", "int" };

		_methodName23 = "dynamicQueryCount";

		_methodParameterTypes23 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName24 = "dynamicQueryCount";

		_methodParameterTypes24 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery)ClpSerializer.translateOutput(returnObj);
	}

	@Override
<<<<<<< HEAD
	public de.ki.sbam.model.Question addQuestion(
		java.lang.String questionContent, java.lang.String answerA,
		java.lang.String answerB, java.lang.String answerC,
		java.lang.String answerD, java.lang.String rightAnswer,
		long categoryId, long difficultyId,
		com.liferay.portal.kernel.model.User user)
		throws com.liferay.portal.kernel.exception.NoSuchUserException {
=======
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
<<<<<<< HEAD
					_methodParameterTypes1,
					new Object[] {
						ClpSerializer.translateInput(questionContent),
						
					ClpSerializer.translateInput(answerA),
						
					ClpSerializer.translateInput(answerB),
						
					ClpSerializer.translateInput(answerC),
						
					ClpSerializer.translateInput(answerD),
						
					ClpSerializer.translateInput(rightAnswer),
						
					categoryId,
						
					difficultyId,
						
					ClpSerializer.translateInput(user)
					});
=======
					_methodParameterTypes1, new Object[] {  });
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.dao.orm.DynamicQuery)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(persistedModel) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] { ClpSerializer.translateInput(primaryKeyObj) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public de.ki.sbam.model.Question addQuestion(
		de.ki.sbam.model.Question question) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(question) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (de.ki.sbam.model.Question)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public de.ki.sbam.model.Question addQuestion(
		java.lang.String questionContent, java.lang.String answerA,
		java.lang.String answerB, java.lang.String answerC,
		java.lang.String answerD, java.lang.String rightAnswer,
		long categoryId, int difficulty,
		com.liferay.portal.kernel.model.User user)
		throws com.liferay.portal.kernel.exception.NoSuchUserException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(questionContent),
						
					ClpSerializer.translateInput(answerA),
						
					ClpSerializer.translateInput(answerB),
						
					ClpSerializer.translateInput(answerC),
						
					ClpSerializer.translateInput(answerD),
						
					ClpSerializer.translateInput(rightAnswer),
						
					categoryId,
						
					difficulty,
						
					ClpSerializer.translateInput(user)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.NoSuchUserException) {
				throw (com.liferay.portal.kernel.exception.NoSuchUserException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (de.ki.sbam.model.Question)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public de.ki.sbam.model.Question createQuestion(long questionId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7, new Object[] { questionId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (de.ki.sbam.model.Question)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public de.ki.sbam.model.Question deleteQuestion(
		de.ki.sbam.model.Question question) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] { ClpSerializer.translateInput(question) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (de.ki.sbam.model.Question)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public de.ki.sbam.model.Question deleteQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9, new Object[] { questionId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (de.ki.sbam.model.Question)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public de.ki.sbam.model.Question fetchQuestion(long questionId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10, new Object[] { questionId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (de.ki.sbam.model.Question)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public de.ki.sbam.model.Question getQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11, new Object[] { questionId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (de.ki.sbam.model.Question)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public de.ki.sbam.model.Question updateQuestion(
		de.ki.sbam.model.Question question) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] { ClpSerializer.translateInput(question) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (de.ki.sbam.model.Question)ClpSerializer.translateOutput(returnObj);
	}

	@Override
<<<<<<< HEAD
	public java.util.List<de.ki.sbam.model.Question> findByCategoryAndDifficulty(
		long categoryId, long difficultyId) {
=======
	public int getQuestionsCount() {
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13,
					new Object[] { categoryId, difficultyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

<<<<<<< HEAD
		return (java.util.List<de.ki.sbam.model.Question>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
=======
		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.lang.String getOSGiServiceIdentifier() {
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

<<<<<<< HEAD
		return (com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
=======
		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName16,
					_methodParameterTypes16,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

<<<<<<< HEAD
		return (com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName16,
					_methodParameterTypes16, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
=======
		return (java.util.List<T>)ClpSerializer.translateOutput(returnObj);
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6
	}

	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName17,
					_methodParameterTypes17,
<<<<<<< HEAD
					new Object[] { ClpSerializer.translateInput(primaryKeyObj) });
=======
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end
					});
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<T>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName18,
					_methodParameterTypes18,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<T>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<de.ki.sbam.model.Question> findByCategory(
		java.lang.String category) {
		Object returnObj = null;

		try {
<<<<<<< HEAD
			returnObj = _invokableLocalService.invokeMethod(_methodName18,
					_methodParameterTypes18, new Object[] { questionId });
=======
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] { ClpSerializer.translateInput(category) });
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<de.ki.sbam.model.Question>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<de.ki.sbam.model.Question> findByCategoryId(
		long categoryId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20, new Object[] { categoryId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<de.ki.sbam.model.Question>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<de.ki.sbam.model.Question> findByDifficulty(
		int difficulty) {
		Object returnObj = null;

		try {
<<<<<<< HEAD
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19, new Object[] { start, end });
=======
			returnObj = _invokableLocalService.invokeMethod(_methodName21,
					_methodParameterTypes21, new Object[] { difficulty });
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<de.ki.sbam.model.Question>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<de.ki.sbam.model.Question> getQuestions(int start,
		int end) {
		Object returnObj = null;

		try {
<<<<<<< HEAD
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20, new Object[] {  });
=======
			returnObj = _invokableLocalService.invokeMethod(_methodName22,
					_methodParameterTypes22, new Object[] { start, end });
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<de.ki.sbam.model.Question>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		Object returnObj = null;

		try {
<<<<<<< HEAD
			returnObj = _invokableLocalService.invokeMethod(_methodName22,
					_methodParameterTypes22,
					new Object[] { ClpSerializer.translateInput(question) });
=======
			returnObj = _invokableLocalService.invokeMethod(_methodName24,
					_methodParameterTypes24,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					ClpSerializer.translateInput(projection)
					});
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	private InvokableLocalService _invokableLocalService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
<<<<<<< HEAD
	private String _methodName22;
	private String[] _methodParameterTypes22;
=======
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
>>>>>>> 4efe1569ec40cba279a2c58de988bd69fc9b59d6
}