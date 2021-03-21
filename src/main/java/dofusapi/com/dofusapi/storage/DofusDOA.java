package dofusapi.com.dofusapi.storage;

import dofusapi.com.dofusapi.core.CharacterClass;
import dofusapi.com.dofusapi.core.Equipment;

public interface DofusDOA
{
    public Iterable<CharacterClass> getMyPCharacterClasses();
    public void insererCharacterClass(CharacterClass characterClass);

    public Iterable<Equipment> getMyEquipments();
    public void insererEquipment(Equipment equipment);
}
