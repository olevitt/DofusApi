package dofusapi.com.dofusapi.api;

import dofusapi.com.dofusapi.core.CharacterClass;
import dofusapi.com.dofusapi.core.Equipment;

public interface DofusClient
{
    public CharacterClass[] getAllClasses();
    public Equipment[] getAllEquipment();
}