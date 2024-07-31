package cl.praxis.proyectohospitalpostpandemia.models.service;

import cl.praxis.proyectohospitalpostpandemia.models.dto.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAll();
    Patient findOne(int id);
    boolean update(Patient patient);
    boolean create(Patient patient);
    boolean delete(int id);
    List<Patient> search(String query);
}
