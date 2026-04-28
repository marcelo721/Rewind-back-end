package com.marcelo721.rewind_back_end.Adapters.outBound.external.BooksProvider.mapper;

public class GoogleBookItem {

    private String id;
    private VolumeInfo volumeInfo;

    public String getId() { return id; }
    public VolumeInfo getVolumeInfo() { return volumeInfo; }

    public void setId(String id) { this.id = id; }
    public void setVolumeInfo(VolumeInfo volumeInfo) { this.volumeInfo = volumeInfo; }
}
