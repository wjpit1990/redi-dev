package com.redimybase.manager.flowable.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.redimybase.framework.mybatis.id.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author vim
 * @since 2018-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_flow_form")
public class FlowFormEntity extends IdEntity<String> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 表单key
     */
    @TableField("form_key")
    private String formKey;

    /**
     * 表单类型(暂时弃用)
     */
    @TableField("type")
    private Integer type;

    /**
     * 节点ID
     */
    @TableField("node_id")
    private String nodeId;


    /**
     * 发起人是否可见(0:否,1:是)
     */
    @TableField("initiator_view")
    private Integer initiatorView;


    /**
     * 审批人是否可见(0:否,1:是)
     */
    @TableField("approver_view")
    private Integer approverView;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public class Type {
        public static final int DEFAULT = 0;
    }
}
