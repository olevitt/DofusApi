package dofusapi.com.dofusapi.api;


import dofusapi.com.dofusapi.core.CharacterClass;

import java.io.IOException;

public interface DofusClient
{
    public CharacterClass[] getAllClasses() throws IOException;
}
