package com.filmland.assessment.entity;

import com.filmland.assessment.Entity.Category;
import com.filmland.assessment.TestModels;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    @Test
    void getName() {
        Category category = TestModels.getCategory();
        assertEquals("test", category.getName());
    }

    @Test
    void getAvailableContent() {
        Category category = TestModels.getCategory();
        assertEquals(1, category.getAvailableContent());
    }

    @Test
    void getPrice() {
        Category category = TestModels.getCategory();
        assertEquals(0.5, category.getPrice());
    }
}
