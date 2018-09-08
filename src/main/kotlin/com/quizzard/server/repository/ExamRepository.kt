package com.quizzard.server.repository

import com.quizzard.server.domain.Exam
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ExamRepository : MongoRepository<Exam, UUID>
