package com.chestnut.system.service;

import java.util.List;

import com.chestnut.common.core.domain.TreeSelect;
import com.chestnut.common.core.domain.entity.TagDataNode;

/**
 * 标签数据Service接口
 *
 * @author chestnut
 * @date 2023-05-11
 */
public interface ITagDataNodeService
{
    /**
     * 查询标签数据
     *
     * @param id 标签数据主键
     * @return 标签数据
     */
    public TagDataNode selectTagDataNodeById(Long id);

    /**
     * 查询标签数据列表
     *
     * @param tagDataNode 标签数据
     * @return 标签数据集合
     */
    public List<TagDataNode> selectTagDataNodeList(TagDataNode tagDataNode);
    /**
     * 构建前端所需要下拉树结构
     *
     * @param menus 菜单列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildMenuTreeSelect(List<TagDataNode> menus);

    /**
     * 构建前端所需要树结构
     *
     * @param menus 菜单列表
     * @return 树结构列表
     */
    public List<TagDataNode> buildMenuTree(List<TagDataNode> menus);
    /**
     * 新增标签数据
     *
     * @param tagDataNode 标签数据
     * @return 结果
     */
    public int insertTagDataNode(TagDataNode tagDataNode);

    /**
     * 修改标签数据
     *
     * @param tagDataNode 标签数据
     * @return 结果
     */
    public int updateTagDataNode(TagDataNode tagDataNode);

    /**
     * 批量删除标签数据
     *
     * @param ids 需要删除的标签数据主键集合
     * @return 结果
     */
    public int deleteTagDataNodeByIds(Long[] ids);

    /**
     * 删除标签数据信息
     *
     * @param id 标签数据主键
     * @return 结果
     */
    public int deleteTagDataNodeById(Long id);
}
