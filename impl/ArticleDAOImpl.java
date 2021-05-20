package coeding.java.blog.impl;

import java.io.File;
import java.util.List;

import coeding.java.blog.Article;
import coeding.java.blog.DAO;

/**
 * Model role
 * DAO : Data Access Object
 * implement CRUD for Article
 */
public class ArticleDAOImpl implements DAO<Article> {
		//what data type?
		private Article[] list;	
		private int seq;
		/**
		 *  method' rule like desgin for project
		 * 	default contructor
		 *	public dinh ko co kieu tra ve
		 */ 
		
		public ArticleDAOImpl() {
			list = new Article[10];	//length fixed 10
		}

		public Article[] getAll() {
			// private field "list"
			// can't be change by other class
			// broken means of private
			System.out.println(list + "\nIn DAO------------");
			return list.clone();// method of Array
		}

		public boolean save(Article article) {
			// TODO Auto-generated method stub
			//list[?] = article;
			//how to add, index ++
			// System.out.println(article);
			// if(seq < list.length) {
			// list[seq] = article; //need index of array
			// ++seq;//ArrayIndexOutOfBounds
			// }
			System.out.println("This Save in DAO:\n" + article);
			boolean result = false;
			if(seq < list.length) {
				list[seq] = article;
				++seq;
				result = true;
			}
			return result;
		}

		//Get Article
		public Article getArticle(int idx) {
			// TODO Auto-generated method stub
			Article origin = list[idx];		//cách 2
			if(origin != null) {
				//origin copied to rt		//is Exits ? // WHYYYYYY?
				Article rt = new Article(origin);	//origin -> rt
//				rt.setSeq(origin.getSeq());
//				rt.setTitle(origin.getTitle());
//				rt.setWriterName(origin.getWriterName());
//				rt.setContent(origin.getContent());
				return rt;	// copied instance //sao chep art qua rt
			}
			return null;
			
//			//cách 1
//			Article origin = list[idx];
//			//kiểm tra idx tồn tại ko// is Exist?
//			for(int i =0; i< list.length; i++) {
//				if(list[i] != null) {
//					if(i == idx) {
//						//found it đã tìm thấy
//					}
//				}
//			}
		}

		public void update(Article article, int idx) {
			// TODO Auto-generated method stub
			list[idx] = article;
		}

		public Article[] searchArticleByWriter(String writer) {
			// 1. count article which  has writer
			//1. count đếm bài viết có bao nhiêu writer 
			int count = 0;
			//đang sd use Reference type Array
			//check null hay ko
			// use Reference type Array
			//kiểm tra idx tồn tại ko
			// is Exist?
			//Count writer
			for(int i = 0 ; i < list.length; i++) {
				//use Reference type Array
				if(list[i] != null) {
					if(list[i].getName().equals(writer)) {
						count += 1;
					}
				}
			}
			if(count > 0) {
				//has writer
				Article[] result = new Article[count];
				int k = 0; 	//index of result
				for(int i = 0 ; i < list.length ; i++) {
					if(list[i] != null) {
						if(list[i].getName().equals(writer)) {
							//copied instance
							//Cách 1			
							Article rt = new Article(list[i]);	//sao chep art qua rt
							result[k] = rt;
							k++;
//							//Cách 2
//							//origin copied to rt		//is Exits ? // WHYYYYYY?
//							Article rt = new Article();	//origin -> rt
//							rt.setSeq(list[i].getSeq());
//							rt.setTitle(list[i].getTitle());
//							rt.setWriterName(list[i].getWriterName());
//							rt.setContent(list[i].getContent());
//							result[k] = rt;	// copied instance //sao chep art qua rt
//							k++;
						}
					}
				}
				return result;
			}//end if count
			return null;
		}
		
		//void thì ko có kiểu trả về
		public void insert(Article vo) {
	
		}

		@Override
		public void update(Article vo) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Long id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Article> select(Article arg) {
			// TODO Auto-generated method stub
			return null;
		}

}