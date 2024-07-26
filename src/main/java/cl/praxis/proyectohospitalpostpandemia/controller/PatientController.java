package cl.praxis.proyectohospitalpostpandemia.controller;

import cl.praxis.proyectohospitalpostpandemia.ProyectoHospitalPostPandemiaApplication;
import cl.praxis.proyectohospitalpostpandemia.model.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class PatientController {

    private static final Logger logger = LoggerFactory.getLogger(ProyectoHospitalPostPandemiaApplication.class);

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String findAll(Model model) {
        logger.warn("Ejecutando findAll en controller");
        model.addAttribute("patients", patientService.findAll());
        return "patient";
    }
}
