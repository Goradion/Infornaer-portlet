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

package de.ki.sbam.service.impl;

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import de.ki.sbam.exception.NoSuchCategoryException;
import de.ki.sbam.model.Category;
import de.ki.sbam.model.Question;
import de.ki.sbam.service.base.CategoryLocalServiceBaseImpl;
import de.ki.sbam.service.persistence.CategoryUtil;

/**
 * The implementation of the category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.ki.sbam.service.CategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Alexander Mueller
 * @see CategoryLocalServiceBaseImpl
 * @see de.ki.sbam.service.CategoryLocalServiceUtil
 */
@ProviderType
public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.liferay.sample.service.CategoryLocalServiceUtil} to access the
	 * category local service.
	 */
	/**
	 * Adds a category
	 * 
	 * @param categoryName
	 *            name for added category
	 * @return Category category added
	 */
	public Category addCategory(String categoryName) {
		Category category = categoryPersistence.fetchByCategoryName(categoryName);
		if (category == null) {
			long categoryId = counterLocalService.increment();
			category = categoryPersistence.create(categoryId);
			category.setCategoryName(categoryName);
			categoryPersistence.update(category);
			category.setUnlocked(false);
		}

		return category;
	}

	/**
	 * Edits a category.
	 * 
	 * @param categoryId
	 *            id of the category to edit
	 * @param categoryName_new
	 *            new name of the edited category
	 * @param unlocked 
	 * @return
	 */
	public Category editCategory(long categoryId, String categoryName_new, boolean unlocked) {
		Category category = categoryPersistence.fetchByPrimaryKey(categoryId);
		category.setCategoryName(categoryName_new);
		category.setUnlocked(unlocked);
		categoryPersistence.update(category);
		return category;
	}

	/**
	 * Deletes category
	 * 
	 * @param categoryId
	 *            id of the category to delete
	 * @param serviceContext
	 * @return Category category deleted
	 * @throws NoSuchCategoryException
	 */
	public Category deleteCategory(long categoryId) throws NoSuchCategoryException {
		questionPersistence.removeByCategory(categoryId);
		return categoryPersistence.remove(categoryId);
	}

	/**
	 * Deletes category
	 * 
	 * @param category
	 *            category to be deleted
	 * @param serviceContext
	 * @return Category deleted category
	 */
	public Category deleteCategory(Category category) {
		questionPersistence.removeByCategory(category.getCategoryId());
		return categoryPersistence.remove(category);
	}

	public void deleteAllCategories() {
		questionPersistence.removeAll();
		CategoryUtil.removeAll();
	}

	public Category getCategoryByName(String categoryName) throws NoSuchCategoryException {
		return CategoryUtil.findByCategoryName(categoryName);
	}

	public List<Category> findAll() {
		return CategoryUtil.findAll();
	}
	
	public List<Category> findUnlocked(){
		return CategoryUtil.findByUnlocked(true);
	}
}