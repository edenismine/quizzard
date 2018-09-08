package com.quizzard.server.controller

import com.quizzard.server.domain.Exam
import com.quizzard.server.domain.Question
import com.quizzard.server.repository.ExamRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class ExamController(val repository: ExamRepository) {
    @RequestMapping("/api/exam", method = [RequestMethod.GET])
    fun findAll(): List<Exam> = repository.findAll()

    @RequestMapping("/api/exam", method = [RequestMethod.POST])
    fun new(@RequestParam name: String, @RequestParam questions: List<Question>) =
            repository.save(Exam(name = name, questions = questions))

    @RequestMapping("/api/exam/{id}", method = [RequestMethod.PUT])
    fun update(@RequestBody exam: Exam, @RequestParam id: UUID) = repository.save(exam.copy(id = id))

    @RequestMapping("/api/exam/{id}", method = [RequestMethod.DELETE])
    fun delete(@RequestParam id: UUID) = repository.deleteById(id)
}
