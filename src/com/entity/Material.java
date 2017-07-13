package com.entity;

/**
 * Material
 * com.entity
 *
 * @author xiaoyy
 * @Date 2017-07-13 上午9:17
 * The word 'impossible' is not in my dictionary.
 */
public class Material {

    int id;

    String materialName;

    String parentId;

    float calorie;

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for property 'materialName'.
     *
     * @return Value for property 'materialName'.
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * Setter for property 'materialName'.
     *
     * @param materialName Value to set for property 'materialName'.
     */
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    /**
     * Getter for property 'parentId'.
     *
     * @return Value for property 'parentId'.
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * Setter for property 'parentId'.
     *
     * @param parentId Value to set for property 'parentId'.
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * Getter for property 'calorie'.
     *
     * @return Value for property 'calorie'.
     */
    public float getCalorie() {
        return calorie;
    }

    /**
     * Setter for property 'calorie'.
     *
     * @param calorie Value to set for property 'calorie'.
     */
    public void setCalorie(float calorie) {
        this.calorie = calorie;
    }
}
