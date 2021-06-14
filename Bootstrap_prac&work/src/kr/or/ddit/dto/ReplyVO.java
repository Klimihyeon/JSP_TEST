package kr.or.ddit.dto;

import java.util.Date;

public class ReplyVO {
	private int rno       ;
	private int pno       ;
	private String replyer   ;
	private String replytext ;
	private Date regdate   ;
	private Date updatedate;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "ReplyVO [pno=" + pno + ", regdate=" + regdate + ", replyer=" + replyer + ", replytext=" + replytext
				+ ", rno=" + rno + ", updatedate=" + updatedate + "]";
	}

}
