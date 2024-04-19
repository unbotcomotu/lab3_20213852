package org.example.lab3_20213852.Controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.lab3_20213852.Repository.ClinicaRepository;
import org.example.lab3_20213852.Repository.OftalmologoRepository;
import org.example.lab3_20213852.Repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    final ClinicaRepository clinicaRepository;
    final OftalmologoRepository oftalmologoRepository;
    final PacienteRepository pacienteRepository;

    public HomeController(ClinicaRepository clinicaRepository,OftalmologoRepository oftalmologoRepository,PacienteRepository pacienteRepository){
        this.clinicaRepository=clinicaRepository;
        this.oftalmologoRepository=oftalmologoRepository;
        this.pacienteRepository=pacienteRepository;
    }
    @GetMapping("/clinicas")
    private String clinica(Model model){
        model.addAttribute("listaClinicas",clinicaRepository.findAll());
        return "clinicas";
    }

    @GetMapping("/clinicas/{nombreClinica}/oftalmologos")
    private String oftalmologosPorClinica(Model model,
                                          @PathVariable(value = "nombreClinica") String nombreClinica,
                                          @RequestParam(value = "id") Integer idClinica){
        model.addAttribute("listaOftalmologos",oftalmologoRepository.findAllByClinicaId(idClinica));
        model.addAttribute("nombreClinica",nombreClinica);
        return "oftalmologosPorClinica";
    }

    @GetMapping("clinicas/{nombreClinica}/pacientes")
    private String pacientesPorClinica(Model model,
                                       @PathVariable(value = "nombreClinica")String nombreClinica,
                                       @RequestParam(value = "id")Integer idClinica){
        model.addAttribute("listaPacientes",pacienteRepository.findAllByClinicaId(idClinica));
        model.addAttribute("nombreClinica",nombreClinica);
        return "pacientesPorClinica";
    }




    @GetMapping("/oftalmologos")
    private String oftalmologos(Model model){
        model.addAttribute("listaClinicas",clinicaRepository.findAll());
        model.addAttribute("listaOftalmologos",oftalmologoRepository.findAll());
        return "oftalmologos";
    }

    @GetMapping("/oftalmologos/{nombreOftalmologo}/pacientes")
    private String pacientesPorOftalmologo(Model model,
                                           @PathVariable(value = "nombreOftalmologo")String nombreOftalmologo,
                                           @RequestParam(value = "id")Integer idOftalmologo){
        model.addAttribute("listaPacientes",pacienteRepository.findAllByOftalmologoId(idOftalmologo));
        model.addAttribute("nombreOftalmologo",nombreOftalmologo);
        return "pacientesPorOftalmologo";
    }

    @GetMapping("/oftalmologos/{nombreOftalmologo}/pacientesPorAtenderse")
    private String pacientesPorOftalmologoPorAtenderse(Model model,
                                           @PathVariable(value = "nombreOftalmologo")String nombreOftalmologo,
                                           @RequestParam(value = "id")Integer idOftalmologo){
        model.addAttribute("listaPacientes",pacienteRepository.pacientesNoAtendidosPorOftalmologo(idOftalmologo));
        model.addAttribute("nombreOftalmologo",nombreOftalmologo);
        return "pacientesPorOftalmologoPorAtenderse";
    }

    @GetMapping("/pacientes")
    private String pacientes(Model model){
        model.addAttribute("listaClinicas",clinicaRepository.findAll());
        model.addAttribute("listaOftalmologos",oftalmologoRepository.findAll());
        model.addAttribute("listaPacientes",pacienteRepository.findAll());
        return "pacientes";
    }

    @GetMapping("/editarPaciente")
    private String editarPaciente(@RequestParam(value = "id") Integer idPaciente,Model model){
        model.addAttribute("paciente",pacienteRepository.findPacienteById(idPaciente));
        return "editarPaciente";
    }

    @PostMapping("/guardarPaciente")
    private String guardarPaciente(@RequestParam(value = "id")Integer idPaciente,
                                  @RequestParam(value = "numero") Integer numero){
        pacienteRepository.editarPaciente(numero,idPaciente);
        return "redirect:/pacientes";
    }

}

