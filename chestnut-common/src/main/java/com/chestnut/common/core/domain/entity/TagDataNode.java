package com.chestnut.common.core.domain.entity;

import com.chestnut.common.annotation.Excel;
import com.chestnut.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 标签数据对象 tag_data_node
 *
 * @author chestnut
 * @date 2023-05-11
 */
@Data
public class TagDataNode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 节点值 price:金额,pic:图片,name:名称,info:介绍,original_price */
    @Excel(name = "节点值 price:金额,pic:图片,name:名称,info:介绍,original_price")
    private String nodeValue;

    /** 父菜单ID */
    @Excel(name = "父菜单ID")
    private Long parentId;

    /** 节点名称 */
    @Excel(name = "节点名称")
    private String nodeName;

    /** 标签类型（P图片 T文本） */
    @Excel(name = "标签类型（P图片 T文本）")
    private String nodeType;


    /** 子菜单 */
    private List<TagDataNode> children = new ArrayList<>();



}
