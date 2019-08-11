package com.cnik;

public class Params {
	
	private String pageName="pagename=ASP.brief_default_result_aspx";
	
	private String isinEn="&isinEn=1";
	
	private String dbPrefix="&dbPrefix=SCDB";
	
	private String dbCatalog="&dbCatalog=中国学术文献网络出版总库";
	
	private String ConfigFile="&ConfigFile=SCDBINDEX.xml";
	
	private String rs="&research=off";
	
	private String t="&t=";
	
	private String k_V;
	
	private String KeyValue="&keyValue="+k_V;
	
	private String S="&S=1";
	
	private String sort="&sorttype=";
	
	private String url;

	/*
	 搜索请求 按被引 
	 private String sorttype="(被引频次,'INTEGER')+desc";
	 private String DisplayMode="listmode";
	 
	 相关度
	 
	 private String		DisplayMode="listmode";
	 private String		sorttype="(FFD,'RANK')+desc";
	 private String		queryid="13";
	 
	 发表时间：
	 
	 private String     sorttype: (发表时间,'TIME') desc
     private String     DisplayMode: listmode
	 
	 
	 下载频次
	 
	 
	 DisplayMode: listmode
	 sorttype: (下载频次,'INTEGER') desc
 	 queryid: 2
	 
	 */
	
	
	public String getUrl() {
		url=this.url+this.pageName+this.isinEn+
				this.dbPrefix+this.dbCatalog+
				this.ConfigFile+this.rs+this.t
				+this.KeyValue+this.S+this.sort;
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getK_V() {
		return k_V;
	}

	public void setK_V(String k_V) {
		this.k_V = k_V;
	}
	
	
	
	
	
}
