package cl.praxis.proyectohospitalpostpandemia.model.service;

import cl.praxis.proyectohospitalpostpandemia.model.dto.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private List<Patient> patientsList;

    public PatientServiceImpl() {
        patientsList = new ArrayList<>();
        patientsList.add(new Patient(1, "12345678-1", "Juan", "Perez", "Calle Falsa 123", "987654321", "juan.perez@example.com", "15/03/1978", "Diabetes"));
        patientsList.add(new Patient(2, "13456789-2", "Maria", "Gomez", "Avenida Siempre Viva 456", "876543210", "maria.gomez@example.com", "22/07/1985", "Hipertensión"));
        patientsList.add(new Patient(3, "14567890-3", "Carlos", "Lopez", "Pasaje Sin Nombre 789", "765432109", "carlos.lopez@example.com", "05/11/1990", "Asma"));
        patientsList.add(new Patient(4, "15678901-4", "Ana", "Martinez", "Boulevard de los Sueños 321", "654321098", "ana.martinez@example.com", "30/01/1983", "Alergias"));
        patientsList.add(new Patient(5, "16789012-5", "Luis", "Rodriguez", "Calle del Sol 654", "543210987", "luis.rodriguez@example.com", "17/08/1975", "Problemas cardíacos"));
        patientsList.add(new Patient(6, "17890123-6", "Laura", "Fernandez", "Avenida del Parque 987", "432109876", "laura.fernandez@example.com", "12/12/1992", "Artritis"));
        patientsList.add(new Patient(7, "18901234-7", "Jose", "Garcia", "Calle de la Luna 1234", "321098765", "jose.garcia@example.com", "25/05/1988", "Obesidad"));
        patientsList.add(new Patient(8, "19012345-8", "Elena", "Hernandez", "Avenida del Mar 4321", "210987654", "elena.hernandez@example.com", "10/10/1981", "Migrañas"));
        patientsList.add(new Patient(9, "10123456-9", "Pedro", "Sanchez", "Calle de las Flores 567", "109876543", "pedro.sanchez@example.com", "18/02/1976", "Problemas renales"));
        patientsList.add(new Patient(10, "11234567-k", "Sofia", "Torres", "Pasaje del Bosque 789", "987654320", "sofia.torres@example.com", "08/04/1995", "Anemia"));
    }

    @Override
    public List<Patient> findAll() {
        return patientsList;
    }

    @Override
    public Patient findOne(int id) {
        return patientsList.stream().filter(patient -> patient.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean update(Patient patient) {
        return patientsList.add(patient);
    }

    @Override
    public boolean create(Patient patient) {
        Patient existingPatient = findOne(patient.getId());
        if (existingPatient != null) {
            existingPatient.setRut(patient.getRut());
            existingPatient.setName(patient.getName());
            existingPatient.setLastName(patient.getLastName());
            existingPatient.setAddress(patient.getAddress());
            existingPatient.setPhone(patient.getPhone());
            existingPatient.setEmail(patient.getEmail());
            existingPatient.setBirthDate(patient.getBirthDate());
            existingPatient.setMedicalHistory(patient.getMedicalHistory());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return patientsList.removeIf(patient -> patient.getId() == id);
    }
}
