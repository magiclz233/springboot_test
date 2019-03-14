package com.cnpc.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

@Data
public class User {


    private Integer id;

    @NotEmpty(message = "姓名不能为空")
    private String name;

    private String sex;

    @Range(max = 120,min = 0,message = "年龄必须在0~120岁之中!")
    private Integer age;
    }
