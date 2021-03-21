package dofusapi.com.dofusapi.controller;

import dofusapi.com.dofusapi.client.DofusClient;
import dofusapi.com.dofusapi.core.Equipment;
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
    public Equipment[] displayAllEquipment()
    {
        return dofusClient.getAllEquipment();
    }

    @PostMapping(value = "/create")
    public String createEquipment()
    {
        /*Equipment equipmentTest = new Equipment();
        equipmentTest.setId(5);
        equipmentTest.setName("equipment test");
        equipmentTest.setLevel(116);
        dofusDOA.insererEquipment(equipmentTest);
        DofusClientCache dofusClientCache = new DofusClientCache();*/
        this.EquipmentCache();
        return "working";
    }

    public void EquipmentCache()
    {
        Equipment[] equipments =   dofusClient.getAllEquipment();
        for(Equipment equipment : equipments)
        {
            dofusDOA.insererEquipment(equipment);
        }
    }
}