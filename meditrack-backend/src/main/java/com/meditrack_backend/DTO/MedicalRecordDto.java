package com.meditrack_backend.DTO;

import lombok.Data;

@Data
public class MedicalRecordDto
{
    private String title;
    private RecordType recordType;
    private String description;
    private String fileUrl;
    private String doctorNote;
}
