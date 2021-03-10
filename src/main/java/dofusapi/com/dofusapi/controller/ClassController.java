package dofusapi.com.dofusapi.controller;

import dofusapi.com.dofusapi.apirequest.ClassRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassController
{
    @RequestMapping("/classes")
    public String displayAllClasses()
    {
        return new ClassRequest().getAllClasses();
    }
}
