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
	private String content;
	// alt+shift+s > generate Getter/Setter
}