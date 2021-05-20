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
		return null;
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
