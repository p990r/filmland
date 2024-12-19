package com.filmland.assessment.entity;

import com.filmland.assessment.Entity.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void getName() {
        Category category = getCategory();
        assertEquals("test", category.getName());
    }

    @Test
    void getAvailableContent() {
        Category category = getCategory();
        assertEquals(1, category.getAvailableContent());
    }

    @Test
    void getPrice() {
        Category category = getCategory();
        assertEquals(1.0, category.getPrice());
    }

    Category getCategory() {
        return new Category("test", 1, 1.0);
    }
}
