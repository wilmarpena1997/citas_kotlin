package com.doctores.doctores.constants

const val HEALTH_CHECK = "/health-check"

const val ApiV1 = "/api/v1"
const val Doctor = "$ApiV1/doctors"
const val Appointment = "$ApiV1/appointments"
const val Patient = "$ApiV1/patients"

// Doctors
const val CreateDoctors = "$Doctor/create"
const val GetDoctorById = "$Doctor/get/{id}"
const val UpdateDoctor = "$Doctor/update/{id}"
const val DeleteDoctor = "$Doctor/delete/{id}"

// Appointment
const val CreateAppointments = "$Appointment/create"
const val GetAppointmentById = "$Appointment/{id}"
const val UpdateAppointment = "$Appointment/{id}"
const val DeleteAppointment = "$Appointment/{id}"


// Patients
const val CreatePatients = "$Patient/create"
const val GetPatientById = "$Patient/{id}"
const val UpdatePatient = "$Patient/{id}"
const val DeletePatient = "$Patient/delete/{id}"