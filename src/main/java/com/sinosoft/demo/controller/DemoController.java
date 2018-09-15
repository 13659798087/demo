package com.sinosoft.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinosoft.demo.entity.QueryProject;
import com.sinosoft.demo.entity.QueryProjectResult;
import com.sinosoft.demo.model.Project;
import com.sinosoft.demo.services.ProjetcServices;

@Controller
@RequestMapping("/demo")
public class DemoController {
	private String ViewPath = "demo/";

	@Resource
	private ProjetcServices projectService;

	@RequestMapping("/list2")
	public String GetList2() {
		return ViewPath + "list";
	}


	@RequestMapping("/home")
	public String home() {
		return ViewPath + "home";
	}


	@RequestMapping("/list")
	public String GetList(QueryProject query, Model model) {
		QueryProjectResult result = new QueryProjectResult();
		result.setTotalCount(projectService.getCount(query.getName(),
				query.getDescription()));
		result.setCurrentPage(query.getCurrentPage() + 1);
		if(query.getCurrentPage()==1){

		}
		result.setProjects(projectService.GetList(query.getName(),
				query.getDescription(),
				query.getCurrentPage() * query.getPageSize(),
				query.getPageSize()));
		if(query.getCurrentPage()==0||query.getPageSize()==0){
			result.setProjects(projectService.GetList(query.getName(),
					query.getDescription(),
					query.getCurrentPage() * query.getPageSize(),
					5));
		}
		result.setName(query.getName());
		result.setDescription(query.getDescription());


		model.addAttribute("data", result);
		return ViewPath + "list";
	}

	@RequestMapping("/edit")
	public String GetProducts(Integer id, Model model) {
		Project p1 = new Project();
		if (id != null) {
			p1 = projectService.GetById(id);
		}
		model.addAttribute("project", p1);
		return ViewPath + "edit";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String Save(Project project, Model model) {
		if (project.getId() == null) {
			projectService.insert(project);
		} else {
			projectService.update(project);
		}
		return "redirect:list";
	}

	@RequestMapping("/del")
	public String del(Integer id, Model model) {
		projectService.delete(id);
		return "redirect:list";
	}

}
