package com.subodh.intergrationservice.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
   private String subject; 
   private String body;
   private String to;
   private String from;
}

