package com.filmland.assessment;

import com.filmland.assessment.Entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Iterable<Category> list() {
        return this.categoryService.findAll();
    }

    @PostMapping("new")
    public Category create(@RequestBody Category category) {
        return this.categoryService.create(category);
    }
}
