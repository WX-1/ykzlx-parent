package com.dubbo.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`t_order`")
public class Order implements Serializable {
    @Id
    @Column(name = "`oid`")
    private Integer oid;

    @Column(name = "`oname`")
    private String oname;

    @Column(name = "`price`")
    private String price;

    private static final long serialVersionUID = 1L;

    /**
     * @return oid
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * @param oid
     */
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    /**
     * @return oname
     */
    public String getOname() {
        return oname;
    }

    /**
     * @param oname
     */
    public void setOname(String oname) {
        this.oname = oname == null ? null : oname.trim();
    }

    /**
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }
}