
package com.chestnut.common.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *     通用基础字段实体：创建时间、创建人、修改时间、修改人，需要此通用字段的实体可继承此类，
 *     继承此类要求数据表有对应的字段
 * </p>
 *
 * @author yesk
 * @date 2020/3/10 16:02
 */
@Getter
@Setter
public class CommonEntity implements Serializable {

    /** 删除标志 */

    private String deleteFlag;

    /** 创建时间 */
    private Date createTime;

    /** 创建人 */
    private String createBy;

    /** 更新时间 */
    private Date updateTime;

    /** 更新人 */
    private String updateBy;
}
