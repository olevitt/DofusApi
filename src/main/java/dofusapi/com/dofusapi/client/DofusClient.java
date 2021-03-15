package dofusapi.com.dofusapi.client;

import dofusapi.com.dofusapi.core.CharacterClass;
import dofusapi.com.dofusapi.core.Equipment;

public interface DofusClient
{
    public CharacterClass[] getAllClasses();
    public Equipment[] getAllEquipment();
}