package dofusapi.com.dofusapi.controller;

import dofusapi.com.dofusapi.client.DofusClient;
import dofusapi.com.dofusapi.core.CharacterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/classe")
@RestController
public class ClassController
{
    @Autowired
    private DofusClient dofusClient;

    @GetMapping
    public CharacterClass[] displayAllClasses()
    {
        return dofusClient.getAllClasses();
    }
}