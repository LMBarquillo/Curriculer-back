package com.lmbarquillo.curriculer.models;

import com.lmbarquillo.curriculer.entities.Sector;

public class SectorModel {
    private Long id;
    private String sector;

    public SectorModel() {
    }

    public SectorModel(Long id, String sector) {
        this.id = id;
        this.sector = sector;
    }

    public static SectorModel from(Sector entity) {
        return new SectorModel(entity.getId(), entity.getSector());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}
