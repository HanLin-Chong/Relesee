package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RankItem {
	private String ranklinesid;
	private String managersid;
	private	String usernumber;
	private String linesnumber;
	private String filesurl;
	private String states;
	private String isnewfiles;
	private String uploaddate;
	private String managerstype;
	
	public  RankItem(){
		ranklinesid=this.generateRankId();
	}
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
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
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
	public String getIsnewfiles() {
		return isnewfiles;
	}
	public void setIsnewfiles(String isnewfiles) {
		this.isnewfiles = isnewfiles;
	}
	public String getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}
	public String getManagerstype() {
		return managerstype;
	}
	public void setManagerstype(String managerstype) {
		this.managerstype = managerstype;
	}
	
	
	public String generateRankId(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateToString = "RK"+format.format(date).toString();
		return dateToString;
	}

}
