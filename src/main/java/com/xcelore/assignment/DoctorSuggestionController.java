package org.xcelore.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestions")
public class DoctorSuggestionController {
    @Autowired
    private DoctorSuggestionService suggestionService;

    @GetMapping("/{patientId}")
    public ResponseEntity<String> suggestDoctors(@PathVariable Long patientId) {
        String suggestions = suggestionService.suggestDoctors(patientId);
        return ResponseEntity.ok(suggestions);
    }
}