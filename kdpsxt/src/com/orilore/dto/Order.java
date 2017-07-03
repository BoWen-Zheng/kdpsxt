package com.orilore.dto;

public class Order {
	private String OrderCode;
	private String ShipperCode;
	private String LogisticCode;
	private String OriginCode;
	private String DestinatioCode;
	private String KDNOrderCode;
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public String getShipperCode() {
		return ShipperCode;
	}
	public void setShipperCode(String shipperCode) {
		ShipperCode = shipperCode;
	}
	public String getLogisticCode() {
		return LogisticCode;
	}
	public void setLogisticCode(String logisticCode) {
		LogisticCode = logisticCode;
	}
	public String getOriginCode() {
		return OriginCode;
	}
	public void setOriginCode(String originCode) {
		OriginCode = originCode;
	}
	public String getDestinatioCode() {
		return DestinatioCode;
	}
	public void setDestinatioCode(String destinatioCode) {
		DestinatioCode = destinatioCode;
	}
	public String getKDNOrderCode() {
		return KDNOrderCode;
	}
	public void setKDNOrderCode(String kDNOrderCode) {
		KDNOrderCode = kDNOrderCode;
	}
}
