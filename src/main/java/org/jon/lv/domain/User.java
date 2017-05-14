package org.jon.lv.domain;

import java.io.Serializable;

/**
 * @Package: org.jon.lv.domain.User.java
 * @Description: InnoDB free: 4096 kB
 * @Copyright: Copyright (c) 2017
 * All right reserved.
 * Author jon lv
 * @date 2017/05/12 15:24
 * version v1.0.0
 */
public class User implements Serializable{
    private Integer id;

    private String head;

    private String name;

    private String phone;

    private String picture;

    private Integer sex;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return head
     */
    public String getHead() {
        return head;
    }

    /**
     * @param head
     */
    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @Title toString
     * @Author jon lv
     * @Date 2017/05/12 15:24
     * @return java.lang.String
     * @throws []
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", head=").append(head);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", picture=").append(picture);
        sb.append(", sex=").append(sex);
        sb.append("]");
        return sb.toString();
    }
}