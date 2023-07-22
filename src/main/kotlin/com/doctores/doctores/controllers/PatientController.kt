package com.doctores.doctores.controllers
import com.doctores.doctores.constants.*
import com.doctores.doctores.domains.entity.Patient
import com.doctores.doctores.domains.request.PatientRequest
import com.doctores.doctores.domains.responses.HealthCheckResponse
import com.doctores.doctores.domains.responses.PatientResponse
import com.doctores.doctores.services.PatientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
class PatientController {
    @Autowired
    private lateinit var patientService: PatientService

    @GetMapping(Patient)
    fun getAllPatients(): List<Patient> = patientService.getAllPatients()

    @PostMapping(CreatePatients)
    fun createPatient(
            @RequestBody @Validated request: PatientRequest
    ): PatientResponse = patientService.createPatient(request)

    @GetMapping(GetPatientById)
    fun getPatienttById(
            @PathVariable("id") id: Long
    ): List<Patient> = patientService.getPatientById(id)

    @PutMapping(UpdatePatient)
    fun updatePatient(): ResponseEntity<HealthCheckResponse> = ResponseEntity(HealthCheckResponse(), HttpStatus.OK)

    @DeleteMapping(DeletePatient)
    fun deletePatient(
            @PathVariable("id")id:Long
    ): Unit = patientService.deletePatientById(id)


}