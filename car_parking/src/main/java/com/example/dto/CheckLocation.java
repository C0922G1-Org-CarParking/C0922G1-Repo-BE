package com.example.dto;

public class CheckLocation {
    private long floorId;
    private long sectionId;
    private long name;

    public CheckLocation() {
    }

    public CheckLocation(long floorId, long sectionId, long name) {
        this.floorId = floorId;
        this.sectionId = sectionId;
        this.name = name;
    }

    public long getFloorId() {
        return floorId;
    }

    public void setFloorId(long floorId) {
        this.floorId = floorId;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }
}
