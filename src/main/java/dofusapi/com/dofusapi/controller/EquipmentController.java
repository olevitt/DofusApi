package dofusapi.com.dofusapi.controller;

import dofusapi.com.dofusapi.client.DofusClient;
import dofusapi.com.dofusapi.core.EquipmentClean;
import dofusapi.com.dofusapi.storage.DofusDOA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/equipment")
@RestController
public class EquipmentController
{
    @Autowired
    private DofusClient dofusClient;

    @Autowired
    private DofusDOA dofusDOA;

    @GetMapping
    public EquipmentClean[] displayAllEquipment()
    {
        return dofusClient.getAllEquipment();
    }

    @PostMapping(value = "/create")
    public String createEquipment()
    {
        this.EquipmentCache();
        return "working";
    }

    public void EquipmentCache()
    {
        EquipmentClean[] equipmentCleans =   dofusClient.getAllEquipment();
        for(EquipmentClean equipmentClean : equipmentCleans)
        {
            dofusDOA.insererEquipment(equipmentClean);
        }
    }
}