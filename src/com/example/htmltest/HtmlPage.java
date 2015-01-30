package com.example.htmltest;

public enum HtmlPage {
	
	intro("Intro Page", "intro.html"),
	intronew("Intro New", "percent/intronew.html"),
	intropercent("Intro Percent", "percent/intro.html"),
	trial("Trial", "percent/trial.html");
	
	private String title;
	private String page;
	
	HtmlPage(String title, String page) {
		this.title = title;
		this.page = page;
	}
	
	@Override
	public String toString() {
		return title;
	}
	
	public String getTitle() {
		return title;
	}

	public String getPage() {
		return page;
	}

	public static HtmlPage getValueByName(String item) {
		
		for (HtmlPage t : HtmlPage.values()) {
			if (t.page.equalsIgnoreCase(item))
				return t;
		}
		
		return null;
	}

	public static HtmlPage getByOrdinal(int ord) {
		return HtmlPage.values()[ord];
	}

}
