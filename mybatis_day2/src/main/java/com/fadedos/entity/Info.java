package com.fadedos.entity;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/2/1
 */
public class Info {
    private Integer id;
    private String cardno; //身份证号
    private String address; //地址

    public Info() {
    }

    public Info(Integer id, String cardno, String address) {
        this.id = id;
        this.cardno = cardno;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", cardno='" + cardno + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
