package com.subodh.hospital.dto;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
public class TestDetailsDto implements Serializable {
    private Long Id;
    private String name;
    private Date date;
    private Long doctor_id;
}
