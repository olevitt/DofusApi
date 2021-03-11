package dofusapi.com.dofusapi.controller;

import dofusapi.com.dofusapi.api.DofusClient;
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
    public String displayAllClasses()
    {
        return dofusClient.getAllClasses();
    }
}
