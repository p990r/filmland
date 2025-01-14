package com.filmland.assessment;

import com.filmland.assessment.Entity.Category;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    void findAll() {
        when(categoryRepository.findAll()).thenReturn(getCategories());
        List<Category> list = Lists.newArrayList(categoryService.findAll());
        assertEquals(1, list.size());
    }

    @Test
    void create() {
        Category category = getCategory();
        when(categoryRepository.save(any())).thenReturn(category);

        // When
        Category saved = categoryRepository.save(category);

        // Then
        verify(categoryRepository).save(category);

        assertEquals(category, saved);
    }

    @Test
    void findCategoryByName() {
        Category category = getCategory();
        when(categoryRepository.findByName(any())).thenReturn(Optional.of(category));

        Optional<Category> saved = categoryRepository.findByName("test");

        assertEquals(category, saved.get());
    }

    Category getCategory() {
        return new Category("test", 1, 0.5);
    }

    List<Category> getCategories() {
        return Lists.newArrayList(getCategory());
    }
}