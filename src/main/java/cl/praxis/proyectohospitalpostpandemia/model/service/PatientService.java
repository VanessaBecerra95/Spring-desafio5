package cl.praxis.proyectohospitalpostpandemia.model.service;

import cl.praxis.proyectohospitalpostpandemia.model.dto.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAll();
    Patient findOne(int id);
    boolean update(Patient patient);
    boolean create(Patient patient);
    boolean delete(int id);
}
