package dofusapi.com.dofusapi.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EquipmentFromClient {

    private int id;
    private int ankamaId;
    private String name;
    private int level;
    private String type;
    private String imgUrl;
    private List<Map<String, Object>> statistics;
    private String[] conditions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnkamaId() {
        return ankamaId;
    }

    public void setAnkamaId(int ankamaId) {
        this.ankamaId = ankamaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Map<String, Object>> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Map<String, Object>> statistics) {
        this.statistics = statistics;
    }

    public String[] getConditions() {
        return conditions;
    }

    public void setConditions(String[] conditions) {
        this.conditions = conditions;
    }

    //array loop-> map
}
