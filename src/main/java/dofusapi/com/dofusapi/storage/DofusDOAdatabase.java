package dofusapi.com.dofusapi.storage;

import dofusapi.com.dofusapi.core.CharacterClass;
import dofusapi.com.dofusapi.core.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "storagemode", havingValue = "database")
public class DofusDOAdatabase implements DofusDOA{

    @Value("${connectionURL}")
    private String connectionURL;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private CharacterClassRepository characterClassRepository;

    public String getConnectionURL()
    {
        return connectionURL;
    }

    public void setConnectionURL(String connectionURL)
    {
        this.connectionURL = connectionURL;
    }

    public Iterable<Equipment> getMyEquipments()
    {
        return null;
    }

    public void insererEquipment(Equipment equipment)
    {
        equipmentRepository.save(equipment);
    }

    public Iterable<CharacterClass> getMyPCharacterClasses()
    {
        return null;
    }

    public void insererCharacterClass(CharacterClass characterClass)
    {
        characterClassRepository.save(characterClass);
    }
}
