package com.example.springstudy.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@Setter
public class JsonModel {

    private String name;
    private LocalDateTime dateTime;
}
