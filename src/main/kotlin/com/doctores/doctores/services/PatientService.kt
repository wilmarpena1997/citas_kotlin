package com.doctores.doctores.services


import com.doctores.doctores.domains.entity.Patient
import com.doctores.doctores.domains.request.PatientRequest
import com.doctores.doctores.domains.responses.PatientResponse
import com.doctores.doctores.repositories.PatientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class PatientService {
    @Autowired
    private lateinit var patientRepository: PatientRepository

    fun createPatient(request: PatientRequest): PatientResponse{
        val pat = patientRepository.save(
                Patient(
                        nombre = request.nombre,
                        apellido = request.apellido,
                        identificacion = request.identificacion,
                        telefono = request.telefono,
                )
        )
        return PatientResponse(
                idPaciente = 1,
                nombre = request.nombre,
                apellido = request.apellido,
                identificacion = request.identificacion,
                telefono = request.telefono,
                created_at = Instant.now(),
        )
    }

    fun getAllPatients(): List<Patient>{
        var response = patientRepository.findAll()
        return response
    }

    fun getPatientById(id:Long): List<Patient>{
        var patient = patientRepository.getPatientById(id)
        return patient
    }

    fun deletePatientById(id:Long):Unit{
        var delete = patientRepository.deletePatientById(id)
    }

}