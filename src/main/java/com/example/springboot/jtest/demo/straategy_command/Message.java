package com.example.springboot.jtest.demo.straategy_command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private String distributionType;
    private String content;
    private String to;

}
