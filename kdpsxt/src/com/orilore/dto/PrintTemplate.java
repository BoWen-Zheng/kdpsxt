package com.orilore.dto;

public class PrintTemplate {
	private String EBusinessID;
	private String Success;
	private Order Order;
	private String Reason;
	private String ResultCode;
	private String PrintTemplate;
	public String getEBusinessID() {
		return EBusinessID;
	}
	public void setEBusinessID(String eBusinessID) {
		EBusinessID = eBusinessID;
	}
	public String getSuccess() {
		return Success;
	}
	public void setSuccess(String success) {
		Success = success;
	}
	public Order getOrder() {
		return Order;
	}
	public void setOrder(Order order) {
		Order = order;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getResultCode() {
		return ResultCode;
	}
	public void setResultCode(String resultCode) {
		ResultCode = resultCode;
	}
	public String getPrintTemplate() {
		return PrintTemplate;
	}
	public void setPrintTemplate(String printTemplate) {
		PrintTemplate = printTemplate;
	}
}
