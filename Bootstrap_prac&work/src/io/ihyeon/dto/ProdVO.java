package io.ihyeon.dto;

public class ProdVO {
	private String prodId;
	private String prodName;
	private String prodPicture;
	private int prodSale;
	private String prodDetail;
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdPicture() {
		return prodPicture;
	}
	public void setProdPicture(String prodPicture) {
		this.prodPicture = prodPicture;
	}
	public int getProdSale() {
		return prodSale;
	}
	public void setProdSale(int prodSale) {
		this.prodSale = prodSale;
	}
	public String getProdDetail() {
		return prodDetail;
	}
	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}
	@Override
	public String toString() {
		return "ProdVO [prodId=" + prodId + ", prodName=" + prodName + ", prodPicture=" + prodPicture + ", prodSale="
				+ prodSale + ", prodDetail=" + prodDetail + "]";
	}
	
}
