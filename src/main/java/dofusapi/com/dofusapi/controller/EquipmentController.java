package dofusapi.com.dofusapi.controller;

import dofusapi.com.dofusapi.api.DofusClient;
import dofusapi.com.dofusapi.core.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/equipment")
@RestController
public class EquipmentController
{
    @Autowired
    private DofusClient dofusClient;

    @GetMapping
    public Equipment[] displayAllEquipment()
    {
        return dofusClient.getAllEquipment();
    }
}
