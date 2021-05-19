package coeding.java.blog;

//method' rule like desgin for project
public interface ArticleDAO {
		//what data type?
	
		// TODO Auto-generated method stub
		public void insert(Article vo);	//void không trả về giá trị
		public void update(Article vo);
		public void delete(int d);
		
		public Article[] select();			//// all articles
		public Article[] selectBy(Article vo);
		public Article selectOne(String key);
}
