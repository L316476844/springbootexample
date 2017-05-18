package org.jon.lv.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @Package org.jon.lv.dto.ValidateDTO
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/18 11:12
 * version V1.0.0
 */
public class ValidateDTO implements Serializable{
//    @size(min=3, max=20, message="用户名长度只能在3-20之间")
//    private String userName;
//    @size(min=6, max=20, message="密码长度只能在6-20之间")
//    private String pwd;
//    @pattern(regexp="[a-za-z0-9._%+-]+@[a-za-z0-9.-]+\\.[a-za-z]{2,4}", message="邮件格式错误")
//    private String email;
//    @Length(min = 5, max = 20, message = "用户名长度必须位于5到20之间")
//    private String uName;
//    @Email(message = "比如输入正确的邮箱")
//
//    @NotNull(message = "用户名称不能为空")
//
//    @Max(value = 100, message = "年龄不能大于100岁")
//
//    @Min(value= 18 ,message= "必须年满18岁！" )
//
//    @AssertTrue(message = "bln4 must is true")
//
//    @AssertFalse(message = "blnf must is falase")
//
//    @DecimalMax(value="100",message="decim最大值是100")
//
//    @DecimalMin(value="100",message="decim最小值是100")
//
//    @NotNull(message = "身份证不能为空")
//
//    @Pattern(regexp="^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message="身份证格式错误")
}
