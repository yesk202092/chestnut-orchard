package com.chestnut.common.core.page;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yesk
 */
@Data
public class PageBO {

    @NotNull(message = "页码不能为空")
    private Integer current;
    @NotNull(message = "当前展示条数不能为空")
    private Integer size;

    private Integer offset;

    private Integer total;

    public void setSize(Integer size) {
        this.size = size > 10 ? 10 : size;
    }

    public Integer getOffset() {
        return (current - 1) * size;
    }

    public PageBO() {
        this.current = 1;
        this.size = 10;
    }
}
