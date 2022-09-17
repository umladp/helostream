package com.skysoft.mms.stream.msg;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyMessage implements java.io.Serializable {
    String name;
    String telephone;
    String address;
    String content;
}