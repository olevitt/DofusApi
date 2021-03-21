package dofusapi.com.dofusapi.client;

import dofusapi.com.dofusapi.core.CharacterClass;
import dofusapi.com.dofusapi.core.EquipmentClean;

public interface DofusClient
{
    public CharacterClass[] getAllClasses();
    public EquipmentClean[] getAllEquipment();
}