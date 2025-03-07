package com.emm.just_chill.feat.financial.category.infrastructure

import com.emm.just_chill.feat.financial.category.application.CategoryCreator
import com.emm.just_chill.feat.financial.category.application.CategoryDeleter
import com.emm.just_chill.feat.financial.category.application.CategoryFetcher
import com.emm.just_chill.feat.financial.category.application.CategoryFinder
import com.emm.just_chill.feat.financial.category.domain.Category
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoriesController(
    private val categoryCreator: CategoryCreator,
    private val categoryDeleter: CategoryDeleter,
    private val categoryFinder: CategoryFinder,
    private val categoryFetcher: CategoryFetcher,
) {

    @GetMapping("/categories")
    fun fetch(): ResponseEntity<List<Category>> {
        val fetch: List<Category> = categoryFetcher.fetch()
        return ResponseEntity.status(HttpStatus.OK).body(fetch)
    }

    @PostMapping("/category/create")
    fun create(@RequestBody request: CategoryRequest): ResponseEntity<Category> {
        val category: Category = categoryCreator.create(request.name)
        return ResponseEntity.status(HttpStatus.CREATED).body(category)
    }

    @DeleteMapping("/category/delete/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Unit> {
        categoryDeleter.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun findByCategory(@PathVariable id: String): ResponseEntity<Category> {
        val categoryFound: Category = categoryFinder.findBy(id)
        return ResponseEntity.status(HttpStatus.OK).body(categoryFound)
    }
}