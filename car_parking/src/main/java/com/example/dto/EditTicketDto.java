package com.example.dto;

public class EditTicketDto {
    private Long id;
    private Long floorId;
    private Long sectionId;
    private Long locationId;
    private String expiryDate;
    private Long ticketTypeId;

    public EditTicketDto() {
    }

    public EditTicketDto(Long id, Long floorId, Long sectionId, Long locationId, String expiryDate, Long ticketTypeId) {
        this.id = id;
        this.floorId = floorId;
        this.sectionId = sectionId;
        this.locationId = locationId;
        this.expiryDate = expiryDate;
        this.ticketTypeId = ticketTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getTicketTypeId() {
        return ticketTypeId;
    }

    public void setTicketTypeId(Long ticketTypeId) {
        this.ticketTypeId = ticketTypeId;
    }
}