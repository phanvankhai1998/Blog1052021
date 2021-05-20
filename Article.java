package coeding.java.blog;

import java.util.Date;

/**
 * 
 * has info about book
 * 
 * 	make getter, setter
 * 		tính đóng gói	encapsulation
 * 
 *  blog contents Modeling and Relation <- R DBMS
 * */
public class Article {
	/**
	 * Access Modifier : private public protected (default)
	 * field have to be private
	 * method public
	 * private: ngăn class bên ngoài sd
	 * field static đều mang một giá trị
	 * */
    private Long aid;
    private String title;
    private String content;
    private String name;
    private Date wdate;
	public Article() {}
	
	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	//make clone method as Constructor
	//Copy constructor		khi tạo constructor thì default biến mất
	public Article(Article arg) {
		
		// this mean new instance
//		this.seq = arg.getSeq();
//		this.title = arg.getTitle();
//		this.writerName = arg.getWriterName();
//		this.content = arg.getContent();
	}
	
	// has all argument for fields
	// constructor using Fields
	public Article(Long aid, String title, String content, String name, Date wdate) {
		super();
		this.aid = aid;
		this.title = title;
		this.content = content;
		this.name = name;
		this.wdate = wdate;
	}
	//khi ko sd constructor
//	public Article copyTo(Article arg) {
//		Article article = new Article();
//		article.setSeq(arg.getSeq());
//		article.setTitle(arg.getTitle());;
//		article.setWriterName(arg.getWriterName());;
//		article.setContent(arg.getContent());
//		return article;
//	}
	
	// Article 모델 Copy
	public void CopyData(Article param) {
		this.aid = param.getAid();
        this.title = param.getTitle();
        this.content = param.getContent();
        this.name = param.getName();
        this.wdate = param.getWdate();
	}

	// alt+shift+s > generate Getter/Setter

	@Override
	public String toString() {
		return "Article [aid=" + aid + ", title=" + title + ", content=" + content + ", name=" + name + ", wdate="
				+ wdate + "]";
	}

	
	
}