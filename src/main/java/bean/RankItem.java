package bean;

/**
 * 
 * @author JinFeng
 * 排队的单个项目表，相对应的数据为RankLines中的一行数据
 */
public class RankItem {
	// 队列项目编号
	private String ranklinesid;
	//  对应的管理员编号
	private String managersid;
	//在队列中对应的排队位置
	private String linesnumber;
	// 文件的相对位置
	private String filesurl;
	// 项目审核的状态
	private String states;
	// 是否为最新的文件
	private boolean isnewfiles;
	//  文件上传的日期
	private String uploaddate;
	
	// 当前项目处理的日期
	private String resultDate;
	//管理员的类型
	private String managertype;
	public String getRanklinesid() {
		return ranklinesid;
	}
	public void setRanklinesid(String ranklinesid) {
		this.ranklinesid = ranklinesid;
	}
	public String getManagersid() {
		return managersid;
	}
	public void setManagersid(String managersid) {
		this.managersid = managersid;
	}
	public String getLinesnumber() {
		return linesnumber;
	}
	public void setLinesnumber(String linesnumber) {
		this.linesnumber = linesnumber;
	}
	public String getFilesurl() {
		return filesurl;
	}
	public void setFilesurl(String filesurl) {
		this.filesurl = filesurl;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public boolean isIsnewfiles() {
		return isnewfiles;
	}
	// 是否文件为最新的文件，当为最新的文件的时候即为true
	public void setIsnewfiles(int i) {
		if(i==0){
			this.isnewfiles=true;
		}else{
		    isnewfiles = false;
		}
	}
	public String getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}
	public String getResultDate() {
		return resultDate;
	}
	public void setResultDate(String resultDate) {
		this.resultDate = resultDate;
	}
	public String getManagertype() {
		return managertype;
	}
	public void setManagertype(String managertype) {
		this.managertype = managertype;
	}
	
}
