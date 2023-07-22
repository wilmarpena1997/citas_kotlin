package com.doctores.doctores.services

import ch.qos.logback.core.net.SyslogOutputStream
import com.doctores.doctores.domains.request.CreateDoctorRequest
import com.doctores.doctores.domains.responses.CreateDoctorResponse
import com.doctores.doctores.repositories.DoctorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import com.doctores.doctores.domains.entity.Doctor
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException

@Service
class DoctorService {
    @Autowired
    private lateinit var doctorRepository: DoctorRepository

    // Dejemoslo Quieto
    fun createDoctor(request: CreateDoctorRequest): CreateDoctorResponse {
        val doctor = doctorRepository.save(
                Doctor(
                        nombre = request.nombre,
                        apellido = request.apellido,
                        especialidad = request.especialidad,
                        correo = request.correo,
                        consultorio = request.consultorio,
                )
        )
        return CreateDoctorResponse(
                idDoctor = 1,
                nombre = request.nombre,
                apellido = request.apellido,
                especialidad = request.especialidad,
                correo = request.correo,
                consultorio = request.consultorio,
                createAt = Instant.now()
        )
    }

    // Dejemoslo quieto
    fun getAllDoctors(): List<Doctor> {
        var response = doctorRepository.findAll()
        return response
    }

    // Dejemoslo Quieto
    fun getDoctorById(id: Long): List<Doctor> {
        var doctor = doctorRepository.getByDoctorId(id)

        return doctor

    }

  /*  fun updateDoctor(id: Long, request: CreateDoctorRequest ): CreateDoctorResponse {


    }*/

    fun deleteDoctor(id: Long): Unit{
        doctorRepository.deleteDoctorByIdDoctor(id)

    }


}