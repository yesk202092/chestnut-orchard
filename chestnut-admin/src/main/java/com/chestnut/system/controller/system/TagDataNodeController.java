package com.chestnut.system.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.chestnut.common.core.domain.entity.SysMenu;
import com.chestnut.common.core.domain.entity.TagDataNode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chestnut.common.annotation.Log;
import com.chestnut.common.core.controller.BaseController;
import com.chestnut.common.core.domain.AjaxResult;
import com.chestnut.common.enums.BusinessType;
import com.chestnut.system.service.ITagDataNodeService;
import com.chestnut.common.utils.poi.ExcelUtil;
import com.chestnut.common.core.page.TableDataInfo;

/**
 * 标签数据Controller
 *
 * @author chestnut
 * @date 2023-05-11
 */
@RestController
@RequestMapping("/system/node")
public class TagDataNodeController extends BaseController {
    @Autowired
    private ITagDataNodeService tagDataNodeService;

    /**
     * 查询标签数据列表
     */
    @PreAuthorize("@ss.hasPermi('system:node:list')")
    @GetMapping("/list")
    public AjaxResult list(TagDataNode tagDataNode) {
        List<TagDataNode> list = tagDataNodeService.selectTagDataNodeList(tagDataNode);
        return success(list);
    }

    /**
     * 获取菜单下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(TagDataNode tagDataNode) {
        List<TagDataNode> list = tagDataNodeService.selectTagDataNodeList(tagDataNode);
        return success(tagDataNodeService.buildMenuTreeSelect(list));
    }

    /**
     * 加载对应角色菜单列表树
     */
    @GetMapping(value = "/roleMenuTreeselect/{id}")
    public AjaxResult roleMenuTreeselect(@PathVariable("id") Long id) {
        TagDataNode tagDataNode = new TagDataNode();
        tagDataNode.setParentId(id);
        List<TagDataNode> list = tagDataNodeService.selectTagDataNodeList(tagDataNode);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("menus", tagDataNodeService.buildMenuTreeSelect(list));
        return ajax;
    }

    /**
     * 获取标签数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:node:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tagDataNodeService.selectTagDataNodeById(id));
    }

    /**
     * 新增标签数据
     */
    @PreAuthorize("@ss.hasPermi('system:node:add')")
    @Log(title = "标签数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TagDataNode tagDataNode) {
        return toAjax(tagDataNodeService.insertTagDataNode(tagDataNode));
    }

    /**
     * 修改标签数据
     */
    @PreAuthorize("@ss.hasPermi('system:node:edit')")
    @Log(title = "标签数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TagDataNode tagDataNode) {
        return toAjax(tagDataNodeService.updateTagDataNode(tagDataNode));
    }

    /**
     * 删除标签数据
     */
    @PreAuthorize("@ss.hasPermi('system:node:remove')")
    @Log(title = "标签数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tagDataNodeService.deleteTagDataNodeByIds(ids));
    }
}
