package com.chestnut.system.mapper;

import com.chestnut.common.core.domain.entity.TagDataNode;

import java.util.List;

/**
 * 标签数据Mapper接口
 *
 * @author chestnut
 * @date 2023-05-11
 */
public interface TagDataNodeMapper
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
     * 删除标签数据
     *
     * @param id 标签数据主键
     * @return 结果
     */
    public int deleteTagDataNodeById(Long id);

    /**
     * 批量删除标签数据
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTagDataNodeByIds(Long[] ids);
}
