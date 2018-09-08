package com.quizzard.server.controller

import com.quizzard.server.domain.Exam
import com.quizzard.server.repository.ExamRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
class ExamController(val repository: ExamRepository) {

    @RequestMapping("/api/exam", method = [RequestMethod.GET])
    fun findAll() =  repository.findAll()

    @RequestMapping("/api/exam", method = [RequestMethod.POST])
    fun update(@RequestBody exam : Exam) =  repository.save(exam)
}
