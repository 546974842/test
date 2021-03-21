package vitily.com.tb_entity.adm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_adm_fields表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbAdmFields extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 后台用户id
     */
    private Integer adminId;

    /**
     * 表名：不要超过32字付
     */
    private String tableName;

    /**
     * 栏目id（标识）
     */
    private Integer columnId;

    /**
     * 字段名（别超过32字付）
     */
    private String fieldName;

    /**
     * 显示字段名
     */
    private String fieldShowName;

    /**
     * 显示宽度
     */
    private Integer rowWidth;

    /**
     * 是否可排序
     */
    private Integer sortable;

    /**
     * 取值字段名
     */
    private String fieldProperName;
    /**
     * 模板或者列序列
     */
    private String visibleTemplate;

    /**
     * 行分组
     */
    private Integer rowGroup;

    /**
     * 列分组
     */
    private Integer colGroup;

    /**
     * 定位：默认：no
     */
    private String fixed;

    /**
     * 后台用户id
     * [whh]@return admin_id 后台用户id
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * 后台用户id
     * @param adminId 后台用户id
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * 表名：不要超过32字付
     * [whh]@return table_name 表名：不要超过32字付
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 表名：不要超过32字付
     * @param tableName 表名：不要超过32字付
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 栏目id（标识）
     * [whh]@return column_id 栏目id（标识）
     */
    public Integer getColumnId() {
        return columnId;
    }

    /**
     * 栏目id（标识）
     * @param columnId 栏目id（标识）
     */
    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    /**
     * 字段名（别超过32字付）
     * [whh]@return field_name 字段名（别超过32字付）
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 字段名（别超过32字付）
     * @param fieldName 字段名（别超过32字付）
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * 显示字段名
     * [whh]@return field_show_name 显示字段名
     */
    public String getFieldShowName() {
        return fieldShowName;
    }

    /**
     * 显示字段名
     * @param fieldShowName 显示字段名
     */
    public void setFieldShowName(String fieldShowName) {
        this.fieldShowName = fieldShowName;
    }

    /**
     * 显示宽度
     * [whh]@return row_width 显示宽度
     */
    public Integer getRowWidth() {
        return rowWidth;
    }

    /**
     * 显示宽度
     * @param rowWidth 显示宽度
     */
    public void setRowWidth(Integer rowWidth) {
        this.rowWidth = rowWidth;
    }

    /**
     * 是否可排序
     * [whh]@return sortable 是否可排序
     */
    public Integer getSortable() {
        return sortable;
    }

    /**
     * 是否可排序
     * @param sortable 是否可排序
     */
    public void setSortable(Integer sortable) {
        this.sortable = sortable;
    }

    /**
     * 取值字段名
     * [whh]@return field_proper_name 取值字段名
     */
    public String getFieldProperName() {
        return fieldProperName;
    }

    /**
     * 取值字段名
     * @param fieldProperName 取值字段名
     */
    public void setFieldProperName(String fieldProperName) {
        this.fieldProperName = fieldProperName;
    }

    public String getVisibleTemplate() {
        return visibleTemplate;
    }

    public void setVisibleTemplate(String visibleTemplate) {
        this.visibleTemplate = visibleTemplate;
    }

    public Integer getRowGroup() {
        return rowGroup;
    }

    public void setRowGroup(Integer rowGroup) {
        this.rowGroup = rowGroup;
    }

    public Integer getColGroup() {
        return colGroup;
    }

    public void setColGroup(Integer colGroup) {
        this.colGroup = colGroup;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }
}