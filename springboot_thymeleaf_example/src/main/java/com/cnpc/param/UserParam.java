package com.cnpc.param;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class UserParam {
    private long id;
    @NotEmpty(message="姓名不能为空")
    private String userName;
    @NotEmpty(message="密码不能为空")
    @Length(min=6,message="密码长度不能小于6位")
    private String passWord;
    @Max(value = 100, message = "年龄不能大于100岁")
    @Min(value= 18 ,message= "必须年满18岁！" )
    private int age;
}
