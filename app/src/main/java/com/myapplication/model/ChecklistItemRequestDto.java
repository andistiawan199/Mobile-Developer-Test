package com.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class ChecklistItemRequestDto {
    @SerializedName("checklistId")
    private int checklistId;

    @SerializedName("itemName")
    private String itemName;

    public int getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(int checklistId) {
        this.checklistId = checklistId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
