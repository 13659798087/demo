package com.sinosoft.demo.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinosoft.demo.dao.ProjectDao;
import com.sinosoft.demo.model.Project;

@Service
public class ProjetcServices {
	@Resource
	private ProjectDao projectDao;

	public List<Project> GetList(String name, String description, int beginRow,
			int pageSize) {
		return projectDao.getList(name, description, beginRow, pageSize);
	}

	public int getCount(String name, String description) {
		return projectDao.getCount(name, description);
	}

	public Project GetById(int id) {
		return projectDao.getById(id);
	}

	public void insert(Project po) {
		projectDao.insert(po);
	}

	public void update(Project po) {
		projectDao.update(po);
	}

	public void delete(int id) {
		projectDao.delete(id);
	}

}
