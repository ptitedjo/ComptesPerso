package info.kapable.app.ComptesPerso.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.kapable.app.ComptesPerso.pojo.Category;
import info.kapable.app.ComptesPerso.pojo.ThirdParty;
import info.kapable.app.ComptesPerso.service.CategoryService;

/**
 * This controller manipulate category
 * 
 * @author Mathieu GOULIN <mathieu.goulin@gadz.org>
 */
@RequestMapping("/category")
@RestController
public class CategoryController extends CrudController<Category> {

	private static Logger logger = Logger.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Override
    @RequestMapping(value="/categories", method = RequestMethod.GET)
	public List<Category> list(@RequestParam(value = "page", required=false, defaultValue = "1") int page) {
		logger.debug("Get all category");
		return this.categoryService.getAll(page, 10).getContent();
	}

	@Override
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Category get(@PathVariable("id") Long id) {
		logger.debug("Get category id=" + id);
		return this.categoryService.get(id);
	}

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public Category save(@RequestBody Category o) {
		logger.debug("Save category id=" + o.getId());
		return this.categoryService.save(o);
	}

	@RequestMapping(path="/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		logger.debug("delete category id=" + id);
		this.categoryService.remove(this.get(id));
	}
	
	@Override
    @RequestMapping(value="/search", method = RequestMethod.GET)
	public List<Category> search(@RequestParam(value = "label", required = false) String searchLabel) {
	    return null;
	}
}
