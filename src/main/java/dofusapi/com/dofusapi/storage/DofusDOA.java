package dofusapi.com.dofusapi.storage;

import dofusapi.com.dofusapi.core.CharacterClass;
import dofusapi.com.dofusapi.core.EquipmentClean;

public interface DofusDOA
{
    public Iterable<CharacterClass> getMyPCharacterClasses();
    public void insererCharacterClass(CharacterClass characterClass);

    public Iterable<EquipmentClean> getMyEquipments();
    public void insererEquipment(EquipmentClean equipmentClean);
}
