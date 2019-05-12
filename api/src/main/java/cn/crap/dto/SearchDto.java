package cn.crap.dto;

import cn.crap.enu.TableId;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class SearchDto extends BaseDTO{
	@Setter
	private String title; // 标题，参与分词

    @Setter
	private String content;// 参与搜索的类容：简介、备注、参数等的组合 或 搜索到的结果（高亮显示）

    @Getter
    @Setter
	private boolean open = true; // 是否开放搜索，false表示只能登录才能搜索

    @Setter
	private String custom; // 接口url，文件url等，不需要分词，需要建立索引，各个类型自定义数据

    @Getter
    @Setter
    private Date createTime;// 时间，不参与分词搜索

	/**
	 * 不存储至索引文件中
     * href: 前端页面地址
     * useHref: 用户登陆后的后端地址
	 * createTimeStr: 时间
	 */
    @Getter
    @Setter
	private String href;

    @Getter
    @Setter
	private String createTimeStr;

    @Getter
    @Setter
	private String useDetailHref;

    public SearchDto(){}
	public SearchDto(String projectId, String moduleId, String id, String title, TableId tableId,
                     String content, String custom, boolean open, Date createTime){
        setId(id);
        setProjectId(projectId);
        setModuleId(moduleId);
        setTableId(tableId.getId());

        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.custom = custom;
        this.open = open;
	}
	public SearchDto(String id){
        setId(id);
	}
	
	public String getTitle() {
		return (title == null ? "" : title);
	}

	public String getContent() {
        return (content == null ? "" : content);
    }

    @Override
	public String getModuleId() {
        return (super.getModuleId() == null ? "" : super.getModuleId());
	}

	public String getCustom() {
        return (custom == null ? "" : custom);
	}

	public String getTableName(){
        return TableId.getByValue(getTableId()).getTableName();
    }
}
