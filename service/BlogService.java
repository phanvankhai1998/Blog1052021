package coeding.java.blog.service;
import java.util.List;

import coeding.java.blog.Article;
import coeding.java.blog.impl.ArticleDAO;

public class BlogService {
	private ArticleDAO dao;

	public BlogService() {
		dao = new ArticleDAO();
		System.out.println("Create Blog Service : " + this.getClass().getName());
	}
	
	public List<Article> getList() {
		// TODO Auto-generated method stub
		return dao.select(null);		// pass to null
	}

	public Article getActicle(String idx) {
		// TODO Auto-generated method stub
		Article vo = new Article();
		//type converting
		vo.setAid(Long.parseLong(idx));
		// vo.name = null; String
		// List<> != null and .size() == 0, have no elements
		return (dao.select(vo).size() > 0) ?
				dao.select(vo).get(0) : null;
		// OOP use Chainning( return . return . return ......> )
		//	is Reference ?
		//	has Reference ?
		//	has value and length
		// 	how to convert Type when use .(dot) operator 
	}

	public List<Article> getListByName(Article vo) {
		// TODO Auto-generated method stub
		return dao.select(vo);			
	}

	public void save(Article article) {
		// TODO Auto-generated method stub
		dao.insert(article);
	}
}
