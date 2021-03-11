package dofusapi.com.dofusapi.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dofusapi.com.dofusapi.api.DofusClient;
import dofusapi.com.dofusapi.core.CharacterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/classe")
@RestController
public class ClassController
{
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private DofusClient dofusClient;

    @GetMapping
    public CharacterClass[] displayAllClasses() throws IOException
    {
        return dofusClient.getAllClasses();
    }
}
