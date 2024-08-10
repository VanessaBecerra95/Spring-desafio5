package cl.praxis.proyectohospitalpostpandemia.controllers;

import cl.praxis.proyectohospitalpostpandemia.HPP;
import cl.praxis.proyectohospitalpostpandemia.models.dto.Patient;
import cl.praxis.proyectohospitalpostpandemia.models.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//controller class
@Controller
@RequestMapping("/patients")
public class PatientController {

    private static final Logger logger = LoggerFactory.getLogger(HPP.class);

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

    @GetMapping("/new")
    public ModelAndView create(){
        return new ModelAndView("newPatient");
    }

    @PostMapping("/new")
    public String save(@ModelAttribute Patient patient){
        boolean result = patientService.create(patient);
        if (result) {
            logger.info("El paciente ha sido creado correctamente");
        } else {
            logger.error("Error al crear al paciente");
        }
        return "redirect:/patients";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("patient", patientService.findOne(id));
        return "editPatient";
    }

    @PostMapping
    public String update(@ModelAttribute Patient patient){
        boolean result = patientService.update(patient);
        if (result) {
            logger.info("El paciente ha sido actualizado correctamente");
        } else {
            logger.error("Error al actualizar al paciente");
        }
        return "redirect:/patients";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id){
        boolean result = patientService.delete(id);
        if (result) {
            logger.info("El paciente ha sido eliminado correctamente");
        } else {
            logger.error("Error al eliminar al paciente");
        }
        return "redirect:/patients";
    }

    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        logger.info("Buscando pacientes con query: " + query);
        model.addAttribute("patients", patientService.search(query));
        return "patient";
    }
}
