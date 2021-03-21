package dofusapi.com.dofusapi.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CharacterClass
{
    @Id
    @JsonProperty("_id")
    private int id;
    private int ankamaId;
    private String name;
    private int level;
    private String type;
    private String maleImg;
    private String femaleImg;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAnkamaId()
    {
        return ankamaId;
    }

    public void setAnkamaId(int ankamaId)
    {
        this.ankamaId = ankamaId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getMaleImg()
    {
        return maleImg;
    }

    public void setMaleImg(String maleImg)
    {
        this.maleImg = maleImg;
    }

    public String getFemaleImg()
    {
        return femaleImg;
    }

    public void setFemaleImg(String femaleImg)
    {
        this.femaleImg = femaleImg;
    }
}