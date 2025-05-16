package org.xcelore.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorSuggestionService {
    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private SymptomSpecialityMapper mapper;

    public String suggestDoctors(Long patientId) {
        Optional<Patient> patientOpt = patientService.findById(patientId);
        if (patientOpt.isEmpty()) {
            return "Patient not found";
        }

        Patient patient = patientOpt.get();
        String city = patient.getCity();
        String symptom = patient.getSymptom();

        if (!city.equalsIgnoreCase("Faridabad") && !city.equalsIgnoreCase("Noida") && !city.equalsIgnoreCase("Faridabad")) {
            return "We are still waiting to expand to your location";
        }

        String speciality = mapper.getSpeciality(symptom);
        if (speciality == null) {
            return "No speciality mapped for this symptom";
        }

        List<Doctor> doctors = doctorService.findByCityAndSpeciality(city, speciality);
        if (doctors.isEmpty()) {
            return "There isn't any doctor present at your location for your symptom";
        }

        StringBuilder result = new StringBuilder("Suggested Doctors:\n");
        for (Doctor doctor : doctors) {
            result.append("Dr. ").append(doctor.getName()).append(" (").append(doctor.getSpeciality()).append(")\n");
        }
        return result.toString();
    }
}