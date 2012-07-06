package org.mule.dto;

/**
 * Created with IntelliJ IDEA.
 * User: germnsolis
 * Date: 7/6/12
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomDTO {

    private Integer id;
    private String name;

    public CustomDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
