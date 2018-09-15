package com.sinosoft.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sinosoft.demo.model.Project;

@Mapper
public interface ProjectDao {

	@Select("select count(*) from project where name like '%${name}%' and description like '%${description}%'")
	int getCount(@Param(value = "name") String name,
			@Param(value = "description") String description);

	@Select("select * from project where name like '%${name}%' and description like '%${description}%'   limit #{beginRow},#{pageSize}")
	List<Project> getList(@Param(value = "name") String name,
			@Param(value = "description") String description,
			@Param(value = "beginRow") int beginRow,
			@Param(value = "pageSize") int pageSize);

	@Select("select * from project where id=#{id}")
	Project getById(int id);

	@Insert("INSERT INTO project(name,description) VALUES(#{name}, #{description})")
	void insert(Project po);

	@Update("UPDATE project SET name=#{name},description=#{description} WHERE id =#{id}")
	void update(Project po);

	@Delete("DELETE FROM project WHERE id =#{id}")
	void delete(int id);

}