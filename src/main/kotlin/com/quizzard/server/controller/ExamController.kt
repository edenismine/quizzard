package com.quizzard.server.controller

import com.quizzard.server.domain.Exam
import com.quizzard.server.domain.ExamForm
import com.quizzard.server.repository.ExamRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ExamController(val repository: ExamRepository) {
    private fun examOf(examForm: ExamForm) = Exam(name = examForm.name, questions = examForm.questions)

    @RequestMapping("/api/exam", method = [RequestMethod.GET])
    fun findAll(): List<Exam> = repository.findAll()

    @RequestMapping("/api/exam", method = [RequestMethod.POST])
    fun new(@RequestBody examForm: ExamForm) = repository.save(examOf(examForm))

    @RequestMapping("/api/exam/{id}", method = [RequestMethod.PUT])
    fun update(@RequestBody exam: Exam, @PathVariable id: String) = repository.save(exam.copy(id = UUID.fromString(id)))

    @RequestMapping("/api/exam/{id}", method = [RequestMethod.DELETE])
    fun delete(@PathVariable id: String) = repository.deleteById(UUID.fromString(id))
}
