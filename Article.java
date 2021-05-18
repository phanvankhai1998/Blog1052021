package coeding.java.blog;

/**
 * 
 * has info about book
 * 
 * 	make getter, setter
 * 		tính đóng gói	encapsulation
 * */
public class Article {
	// Access Modifier : private public protected (default)
	// field have to be private
	// method public
	//private: ngăn class bên ngoài sd
	//field static đều mang một giá trị
	private long seq;
	private String title;
	private String writerName;
	private String content;
	public Article() {
		
	}
	// Copy Constructor 
	public Article(Article arg) {
		// this mean new instance
		this.seq = arg.getSeq();
		this.title = arg.getTitle();
		this.writerName = arg.getWriterName();
		this.content = arg.getContent();
	}
	// has all argument for fields
	// constructor using Fields
	public Article(long seq, String title, String writerName, String content) {
		super();
		this.seq = seq;
		this.title = title;
		this.writerName = writerName;
		this.content = content;
	}
	public Article copyTo(Article arg) {
		Article article = new Article();
		article.setSeq(arg.getSeq());
		article.setTitle(arg.getTitle());;
		article.setWriterName(arg.getWriterName());;
		article.setContent(arg.getContent());
		return article;
	}
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	// alt+shift+s > generate Getter/Setter
}