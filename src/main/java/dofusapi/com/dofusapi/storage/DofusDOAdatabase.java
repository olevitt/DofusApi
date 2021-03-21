package dofusapi.com.dofusapi.storage;

import dofusapi.com.dofusapi.core.CharacterClass;
import dofusapi.com.dofusapi.core.EquipmentClean;
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

    public Iterable<EquipmentClean> getMyEquipments()
    {
        return null;
    }

    public void insererEquipment(EquipmentClean equipmentClean)
    {
        equipmentRepository.save(equipmentClean);
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
