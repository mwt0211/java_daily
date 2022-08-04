package com.tansun.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * program: java_daily
 * Created with IntelliJ IDEA.
 * Description:
 * User: mwt
 * Date: 2022/8/3 13:58
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private String description;
    private String typeof;
}
