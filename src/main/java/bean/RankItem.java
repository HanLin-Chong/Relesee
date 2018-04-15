package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RankItem {
	private String ranklinesid;
	private String customerid;
	private String managerid;
	private String lineNumber;
	private String filesurl;
	private String state;
	private String uploaddate;
	private String isnewfiles;
	private String customertype;
	private String texts;
	
	public String getRanklinesid() {
		return ranklinesid;
	}



	public void setRanklinesid(String ranklinesid) {
		this.ranklinesid = ranklinesid;
	}



	public String getCustomerid() {
		return customerid;
	}



	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}



	public String getManagerid() {
		return managerid;
	}



	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}



	public String getLineNumber() {
		return lineNumber;
	}



	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}



	public String getFilesurl() {
		return filesurl;
	}



	public void setFilesurl(String filesurl) {
		this.filesurl = filesurl;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getUploaddate() {
		return uploaddate;
	}



	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}



	public String getIsnewfiles() {
		return isnewfiles;
	}



	public void setIsnewfiles(String isnewfiles) {
		this.isnewfiles = isnewfiles;
	}



	public String getCustomertype() {
		return customertype;
	}



	public void setCustomertype(String customertype) {
		this.customertype = customertype;
	}



	public String getTexts() {
		return texts;
	}



	public void setTexts(String texts) {
		this.texts = texts;
	}



	public String generateRankId(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateToString = "RK"+format.format(date).toString();
		return dateToString;
	}

}
