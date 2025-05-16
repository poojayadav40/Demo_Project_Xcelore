package org.xcelore.demo;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class SymptomSpecialityMapper {
    private final Map<String, String> symptomToSpecialityMap;

    public SymptomSpecialityMapper() {
        symptomToSpecialityMap = new HashMap<>();
        symptomToSpecialityMap.put("Arthritis", "Orthopaedic");
        symptomToSpecialityMap.put("Headache", "ENT");
        symptomToSpecialityMap.put("Ear pain", "ENT");
        symptomToSpecialityMap.put("Skin rash", "Dermatology");
        symptomToSpecialityMap.put("Chest pain", "Cardiology");
    }

    public String getSpeciality(String symptom) {
        return symptomToSpecialityMap.get(symptom);
    }
}