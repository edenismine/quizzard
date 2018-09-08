package com.quizzard.server.configuration

import com.quizzard.server.domain.Answer
import com.quizzard.server.domain.Exam
import com.quizzard.server.domain.Question
import com.quizzard.server.repository.ExamRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class InitDB{

    @Bean
    fun init(examRepository: ExamRepository ): CommandLineRunner {

        return CommandLineRunner {
            examRepository.save(Exam(UUID.randomUUID(), "Prueba", listOf(Question(1, "Test question", listOf(Answer(1, "test answer", true))))))
        }
    }
}
