package coeding.java.blog.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coeding.java.blog.Article;
import coeding.java.blog.DAO;

//method' rule like desgin for project
public class ArticleDAO implements DAO<Article>{
	
	private List<Article> storage;// in Memory->>>>> in FILE
	//private ArticleDAOFile;
	
	//what data type?
	
	// default constructor : must has
	public ArticleDAO() {
		storage = new ArrayList<Article>();
		System.out.println("created "+this.getClass().getName()); //Lấy thông tin class
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Article> select(Article arg) {// all articles
		// TODO Auto-generated method stub
		if(arg == null) {
			return new ArrayList<Article>(storage);//like clone
			//return storage.subList(0, 0);	//all return	
			//all return not will, .size() == 0
			//subList(0, 0); copied
			//list copied
		}
		List<Article> rs = new ArrayList<Article>();
		if(arg.getName() != null && !arg.getName().isEmpty()) {
			//.length > 0 not arg.getName().isEmpty()
			//searching name
			for(Article at : storage) {
				if(at.getName().equals(arg.getName().isEmpty())) {
					rs.add(at);// name is not unique dont break;
				}
			}
		}
		if(arg.getAid() != null) {///Type Long
			for (Article at : storage) {
				if(at.getAid() == arg.getAid()) {
					/**
					 *  1. Long is class not primitive, .equal()
					 *	but, wrapping (long) <- auto convert to long
					 *	2. at where save ?
					 *	if aid is unique( means dont duplicated )
					 */
					rs.add(at);
					break;
				}
			}
		}
		return rs;
	}

	@Override
	public void insert(Article arg) {//void không trả về giá trị
		// TODO Auto-generated method stub
		//--->	int lastIndex = storage.size()-1;
		//or
		// aid be auto increments when add
		arg.setAid((Long)(storage.size() + 1L));
		storage.add(arg);
//		System.err.println(storage);
	}

	@Override
	public void update(Article arg) {
		// TODO Auto-generated method stub
		
	}
}
