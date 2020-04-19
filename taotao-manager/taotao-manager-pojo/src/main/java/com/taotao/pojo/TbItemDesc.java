package com.taotao.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbItemDesc  extends BasePojo implements Serializable{
    private Long itemId;

    private String itemDesc;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

	@Override
	public String toString() {
		return "TbItemDesc [itemId=" + itemId + ", itemDesc=" + itemDesc + ", update=" + this.getUpdated() + ", create=" + this.getCreated() + "]";
	}
    
    
}