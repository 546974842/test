package vitily.com.other_entity;

import java.io.Serializable;

import vitily.com.consts.OpenStateDesc;
import vitily.com.consts.RecordLogDesc;

public class ApiUriInfo implements Serializable{
	 public ApiUriInfo(){
         transfers = 0L;
	 }
	 /**
	  * 
	  */
	 private static final long serialVersionUID = 1L;
	 private long id;
	 private String uri;
	 private int open = OpenStateDesc.不开放.getValue();
	 private Long transfers;
	 private int recordLog = RecordLogDesc.记录.getValue();
	 public long getId() {
	         return id;
	 } 
	public void setId(long id) {
        this.id = id;
	}
	public String getUri() {
	        return uri;
	}
	public void setUri(String uri) {
	        this.uri = uri;
	}
	public int getOpen() {
	        return open;
	}
	public void setOpen(int open) {
        this.open = open;
	}
	public Long getTransfers() {
	        return transfers;
	}
	public void setTransfers(Long transfers) {
	        this.transfers = transfers;
	}
	public int getRecordLog() {
	        return recordLog;
	}
	public void setRecordLog(int recordLog) {
	        this.recordLog = recordLog;
	}
}
