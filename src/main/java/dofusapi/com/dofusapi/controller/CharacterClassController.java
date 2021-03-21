package dofusapi.com.dofusapi.controller;

import dofusapi.com.dofusapi.client.DofusClient;
import dofusapi.com.dofusapi.core.CharacterClass;
import dofusapi.com.dofusapi.core.Equipment;
import dofusapi.com.dofusapi.storage.DofusDOA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/classe")
@RestController
public class CharacterClassController
{
    @Autowired
    private DofusClient dofusClient;

    @Autowired
    private DofusDOA dofusDOA;

    @GetMapping
    public CharacterClass[] displayAllCharacterClasses()
    {
        return dofusClient.getAllClasses();
    }

    @PostMapping(value = "/create")
    public String createCharacterClasse()
    {
        /*Equipment equipmentTest = new Equipment();
        equipmentTest.setId(5);
        equipmentTest.setName("equipment test");
        equipmentTest.setLevel(116);
        dofusDOA.insererEquipment(equipmentTest);
        DofusClientCache dofusClientCache = new DofusClientCache();*/
        this.CharacterClasseCache();
        return "working";
    }

    public void CharacterClasseCache()
    {
        CharacterClass[] characterClasses =   dofusClient.getAllClasses();
        for(CharacterClass characterClass : characterClasses)
        {
            dofusDOA.insererCharacterClass(characterClass);
        }
    }
}