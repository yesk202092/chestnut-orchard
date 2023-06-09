package com.chestnut.system.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.chestnut.common.core.domain.TreeSelect;
import com.chestnut.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chestnut.system.mapper.TagDataNodeMapper;
import com.chestnut.common.core.domain.entity.TagDataNode;
import com.chestnut.system.service.ITagDataNodeService;

/**
 * 标签数据Service业务层处理
 *
 * @author chestnut
 * @date 2023-05-11
 */
@Service
public class TagDataNodeServiceImpl implements ITagDataNodeService {
    @Autowired
    private TagDataNodeMapper tagDataNodeMapper;

    /**
     * 查询标签数据
     *
     * @param id 标签数据主键
     * @return 标签数据
     */
    @Override
    public TagDataNode selectTagDataNodeById(Long id) {
        return tagDataNodeMapper.selectTagDataNodeById(id);
    }

    /**
     * 查询标签数据列表
     *
     * @param tagDataNode 标签数据
     * @return 标签数据
     */
    @Override
    public List<TagDataNode> selectTagDataNodeList(TagDataNode tagDataNode) {
        return tagDataNodeMapper.selectTagDataNodeList(tagDataNode);
    }

    @Override
    public List<TreeSelect> buildMenuTreeSelect(List<TagDataNode> menus) {
        List<TagDataNode> menuTrees = buildMenuTree(menus);
        return menuTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    @Override
    public List<TagDataNode> buildMenuTree(List<TagDataNode> menus) {
        List<TagDataNode> returnList = new ArrayList<>();
        List<Long> tempList = menus.stream().map(TagDataNode::getId).collect(Collectors.toList());
        for (Iterator<TagDataNode> iterator = menus.iterator(); iterator.hasNext(); ) {
            TagDataNode menu = iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(menu.getParentId())) {
                recursionFn(menus, menu);
                returnList.add(menu);
            }
        }
        if (returnList.isEmpty()) {
            returnList = menus;
        }
        return returnList;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<TagDataNode> list, TagDataNode t) {
        return getChildList(list, t).size() > 0;
    }

    /**
     * 得到子节点列表
     */
    private List<TagDataNode> getChildList(List<TagDataNode> list, TagDataNode t) {
        List<TagDataNode> tlist = new ArrayList<>();
        Iterator<TagDataNode> it = list.iterator();
        while (it.hasNext()) {
            TagDataNode n = (TagDataNode) it.next();
            if (n.getParentId().longValue() == t.getId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 递归列表
     *
     * @param list 分类表
     * @param t    子节点
     */
    private void recursionFn(List<TagDataNode> list, TagDataNode t) {
        // 得到子节点列表
        List<TagDataNode> childList = getChildList(list, t);
        t.setChildren(childList);
        for (TagDataNode tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 新增标签数据
     *
     * @param tagDataNode 标签数据
     * @return 结果
     */
    @Override
    public int insertTagDataNode(TagDataNode tagDataNode) {
        tagDataNode.setCreateTime(DateUtils.getNowDate());
        return tagDataNodeMapper.insertTagDataNode(tagDataNode);
    }

    /**
     * 修改标签数据
     *
     * @param tagDataNode 标签数据
     * @return 结果
     */
    @Override
    public int updateTagDataNode(TagDataNode tagDataNode) {
        tagDataNode.setUpdateTime(DateUtils.getNowDate());
        return tagDataNodeMapper.updateTagDataNode(tagDataNode);
    }

    /**
     * 批量删除标签数据
     *
     * @param ids 需要删除的标签数据主键
     * @return 结果
     */
    @Override
    public int deleteTagDataNodeByIds(Long[] ids) {
        return tagDataNodeMapper.deleteTagDataNodeByIds(ids);
    }

    /**
     * 删除标签数据信息
     *
     * @param id 标签数据主键
     * @return 结果
     */
    @Override
    public int deleteTagDataNodeById(Long id) {
        return tagDataNodeMapper.deleteTagDataNodeById(id);
    }
}
