package com.example.momentouno.service

import com.example.momentouno.model.Assistant
import com.example.momentouno.model.Conference
import com.example.momentouno.repository.AssistantRepository
import com.example.momentouno.repository.ConferenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class ConferenceService {
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun list(): List<Conference> {
        return conferenceRepository.findAll()
    }

    fun save(conference: Conference): Conference {
        return conferenceRepository.save(conference)
    }
}
@Service
class AssistantService {

    @Autowired
    lateinit var assistantRepository: AssistantRepository

    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun saveAssistant(assistant: Assistant): Assistant {
        val conferenceId = assistant.conference?.id

        val conference = conferenceRepository.findById(conferenceId)

        if (conference != null) {
            return assistantRepository.save(assistant)
        } else {
            throw EntityNotFoundException("La conferencia con ID $conferenceId no existe.")
        }
    }
}



