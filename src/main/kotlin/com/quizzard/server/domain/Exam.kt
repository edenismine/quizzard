package com.quizzard.server.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Exam(@Id val id: UUID = UUID.randomUUID(), val name: String, val questions: List<Question>)

data class Question(val id : Int, val question: String, val answers: List<Answer> )

data class Answer(val id: Int, val answer: String, val isValid: Boolean)