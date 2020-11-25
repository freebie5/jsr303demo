package org.sy.jsr303demo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.sy.jsr303demo.valid.AddGroup;
import org.sy.jsr303demo.valid.ListValue;
import org.sy.jsr303demo.valid.UpdateGroup;
import org.sy.jsr303demo.valid.UpdateStatusGroup;

import javax.validation.constraints.*;

@Data
public class TestEntity {

    @NotNull(message = "修改必须指定id",groups = {UpdateGroup.class})
    @Null(message = "新增不能指定id",groups = {AddGroup.class})
    private Long id;

    /**
     * 名称
     */
    @NotBlank(message = "品牌名必须提交", groups = {AddGroup.class,UpdateGroup.class})
    private String name;
    /**
     * logo图片url地址
     */
    @NotBlank(groups = {AddGroup.class})
    @URL(message = "logo必须是一个合法的url地址", groups={AddGroup.class,UpdateGroup.class})
    private String logo;

    /**
     * 介绍
     */
    private String descript;

    /**
     * 显示状态[0-不显示；1-显示]
     */
    @NotNull(groups = {AddGroup.class, UpdateStatusGroup.class})
    @ListValue(vals={0,1}, groups = {AddGroup.class, UpdateStatusGroup.class})
    private Integer showStatus;

    /**
     * 检索首字母
     */
    @NotEmpty(groups={AddGroup.class})
    @Pattern(regexp="^[a-zA-Z]$",message = "检索首字母必须是一个字母", groups={AddGroup.class,UpdateGroup.class})
    private String firstLetter;

    /**
     * 排序
     */
    @NotNull(groups={AddGroup.class})
    @Min(value = 0,message = "排序必须大于等于0", groups={AddGroup.class,UpdateGroup.class})
    private Integer sort;

}
