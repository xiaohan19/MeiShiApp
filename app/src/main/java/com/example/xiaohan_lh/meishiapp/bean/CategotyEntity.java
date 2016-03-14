package com.example.xiaohan_lh.meishiapp.bean;

/**
 * Created by xiaohan-lh on 16/3/10.
 */
public class CategotyEntity {

    /**
     * id : 1
     * name : 热门
     * icon : http://mvimg10.meitudata.com/55ef949c90ad58565.png
     * color : ff7e51
     * type : 1
     * has_content_rank : 0
     * has_banner : 0
     * index : 0
     */

    private int id;
    private String name;
    private String icon;
    private String color;
    private int type;
    private int has_content_rank;
    private int has_banner;
    private int index;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setHas_content_rank(int has_content_rank) {
        this.has_content_rank = has_content_rank;
    }

    public void setHas_banner(int has_banner) {
        this.has_banner = has_banner;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getColor() {
        return color;
    }

    public int getType() {
        return type;
    }

    public int getHas_content_rank() {
        return has_content_rank;
    }

    public int getHas_banner() {
        return has_banner;
    }

    public int getIndex() {
        return index;
    }
}
