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

package de.ki.sbam.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import de.ki.sbam.model.Difficulty;
import de.ki.sbam.model.DifficultyModel;
import de.ki.sbam.model.DifficultySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Difficulty service. Represents a row in the &quot;sbam_Difficulty&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DifficultyModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DifficultyImpl}.
 * </p>
 *
 * @author Alexander Mueller, Simon Bastian
 * @see DifficultyImpl
 * @see Difficulty
 * @see DifficultyModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DifficultyModelImpl extends BaseModelImpl<Difficulty>
	implements DifficultyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a difficulty model instance should use the {@link Difficulty} interface instead.
	 */
	public static final String TABLE_NAME = "sbam_Difficulty";
	public static final Object[][] TABLE_COLUMNS = {
			{ "difficultyId", Types.BIGINT },
			{ "difficultyName", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("difficultyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("difficultyName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table sbam_Difficulty (difficultyId LONG not null primary key,difficultyName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table sbam_Difficulty";
	public static final String ORDER_BY_JPQL = " ORDER BY difficulty.difficultyId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY sbam_Difficulty.difficultyId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.de.ki.sbam.model.Difficulty"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.de.ki.sbam.model.Difficulty"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Difficulty toModel(DifficultySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Difficulty model = new DifficultyImpl();

		model.setDifficultyId(soapModel.getDifficultyId());
		model.setDifficultyName(soapModel.getDifficultyName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Difficulty> toModels(DifficultySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Difficulty> models = new ArrayList<Difficulty>(soapModels.length);

		for (DifficultySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.de.ki.sbam.model.Difficulty"));

	public DifficultyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _difficultyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDifficultyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _difficultyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Difficulty.class;
	}

	@Override
	public String getModelClassName() {
		return Difficulty.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("difficultyId", getDifficultyId());
		attributes.put("difficultyName", getDifficultyName());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long difficultyId = (Long)attributes.get("difficultyId");

		if (difficultyId != null) {
			setDifficultyId(difficultyId);
		}

		String difficultyName = (String)attributes.get("difficultyName");

		if (difficultyName != null) {
			setDifficultyName(difficultyName);
		}
	}

	@JSON
	@Override
	public long getDifficultyId() {
		return _difficultyId;
	}

	@Override
	public void setDifficultyId(long difficultyId) {
		_difficultyId = difficultyId;
	}

	@JSON
	@Override
	public String getDifficultyName() {
		if (_difficultyName == null) {
			return StringPool.BLANK;
		}
		else {
			return _difficultyName;
		}
	}

	@Override
	public void setDifficultyName(String difficultyName) {
		_difficultyName = difficultyName;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Difficulty.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Difficulty toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Difficulty)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DifficultyImpl difficultyImpl = new DifficultyImpl();

		difficultyImpl.setDifficultyId(getDifficultyId());
		difficultyImpl.setDifficultyName(getDifficultyName());

		difficultyImpl.resetOriginalValues();

		return difficultyImpl;
	}

	@Override
	public int compareTo(Difficulty difficulty) {
		long primaryKey = difficulty.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Difficulty)) {
			return false;
		}

		Difficulty difficulty = (Difficulty)obj;

		long primaryKey = difficulty.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Difficulty> toCacheModel() {
		DifficultyCacheModel difficultyCacheModel = new DifficultyCacheModel();

		difficultyCacheModel.difficultyId = getDifficultyId();

		difficultyCacheModel.difficultyName = getDifficultyName();

		String difficultyName = difficultyCacheModel.difficultyName;

		if ((difficultyName != null) && (difficultyName.length() == 0)) {
			difficultyCacheModel.difficultyName = null;
		}

		return difficultyCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{difficultyId=");
		sb.append(getDifficultyId());
		sb.append(", difficultyName=");
		sb.append(getDifficultyName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("de.ki.sbam.model.Difficulty");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>difficultyId</column-name><column-value><![CDATA[");
		sb.append(getDifficultyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>difficultyName</column-name><column-value><![CDATA[");
		sb.append(getDifficultyName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Difficulty.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Difficulty.class
		};
	private long _difficultyId;
	private String _difficultyName;
	private Difficulty _escapedModel;
}