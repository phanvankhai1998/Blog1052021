package coeding.java.blog;

import java.util.List;
import java.util.Scanner;

import coeding.java.blog.impl.ArticleDAO;
import coeding.java.blog.service.BlogService;

/**
 * blog concepts
 * - have articles
 * - writer
 * blog CRUD
 * - console : keyboard and monitor
 * 
 * @author Administrator
 */

/**
 * Role based programming : source files
 * Starter.main() : request, response 
 * 	
 * delegate to(has) //BlogService 
 *  BlogService : business logic : actual processing for request -> trể kq về
 * 	has ArticleDAO : article data management ( CRUD )
*/

public class Starter {
	static Scanner sc; 
	static ArticleDAO dao;
	/**
	 * private Article[] list;	// <--- model is data CRUD
	 * private int seq;		
	 * không cần thiết nữa, vì chuyển array qua DAO index of array
	 * @param args
	 */
	
	// Control role
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		dao = new ArticleDAO();
		
		BlogService service = new BlogService();
		//đầu tiên nhận request -> Starter.main và gửi qua -> Service -> DAO
		//đầu tiên nhận nhận response <--- Starter.main và gửi qua <- Service <- D
		
		while(true) {
			// show all article list// if get reference, can be changed
			//Article[] list = dao.select();
			List<Article> list = service.getList();
			showList(list);
//			String view = showList(list);
//			System.out.println(view);
			
//			if(list.size() == 0) {
//			Article article = new Article();
//			article.setAid(1L);	///Long id
//			article.setContent("AAAA");
//			article.setName("Name");
//			article.setContent("memo ??");
//			list.add(article);
//		}	=> cẩn thận khi thên nào 
			
			//request form keyboard
			System.out.println(" > ");
			String cmd = sc.nextLine();
			
			//CONTROL for request Article
			if(cmd.equals("new")) {			//CREATE
				Article article = registArticle();
				//---->list.add(article); //broken Role concepts
				service.save(article);
			}
			
			if(cmd.equals("showlist")) {	//RETRIEVE
				showList(list);
			}
			
			if(cmd.equals("edit")) {		//UPDATE
				System.out.print("Select art's Index > ");
				String idx = sc.nextLine();
				
//				cmd = sc.nextLine();				// "1"
//				int idx = Integer.parseInt(cmd);	//	1
//				search aid = idx
				Article article = service.getActicle(idx);
				if(article == null) {//have to check null, NPE
					System.out.println("Invalid index");
				}else {
					//current value of aid, title, name
					System.out.println(article);
					editArticle(article);
				}
				
//				if(idx < seq) {		//if seq 3, [0][1][2]
//				editArticle(idx);	//go to edit [idx]article
//				}else {
//					System.out.println("Invaild index");
//				}
			}
			
//			if(cmd.equals("delete")) {		//DELETE
//				System.out.println("Seleact article's index :>");
//				cmd = sc.nextLine();
//				int idx = Integer.parseInt(cmd);
//				
//				if(idx < seq) {
//					deleteArticle(idx);
//					showList();
//				}else {
//					System.out.println("invalid index");
//				}
//			}
			if(cmd.equals("search")) {		//SEARCH
//				cmd = sc.nextLine();
				//check null hay ko
//				Article[] rs = ((ArticleDAOImpl)dao).searchArticleByWriter(cmd);/	
				System.out.println("Search writer :>");
				String name = sc.nextLine();
				Article vo = new Article();
				vo.setName(name);
//				Article[] rs = dao.selectBy(vo);
				List<Article> rs = service.getListByName(vo);
				if(rs != null) {
					showList(rs);
				}else {
					System.out.println("No result");
				}
			}
		}// end while
	}

//	private static void deleteArticle(int idx) {
//		// TODO Auto-generated method stub
//		for(int i=idx; (i+1)<list.length; i++) {
//			list[i] = list[i+1];// [0] <- [] <- [9]
//		}
//		// decrease numbers of save data
//		--seq;
//	}

	private static String showList(List<Article> rs) {
		// TODO Auto-generated method stub	
		// check null
		String s = "Article list - search result\n";
//		for(int i=0; i<rs.length;i++) {//rendering by View role
//			if(rs[i] != null) {
////				System.out.println(
////	" - Title : " + rs[i].getTitle() + " - Write : " + rs[i].getWriterName() + " - Content : " + rs[i].getContent()
////				);
//				s += rs[i].getTitle();
//				s += "(" + rs[i].getWriterName() + ")\n";
//			}
//		}
//		System.out.println(rs.size());
		if(rs != null) {
			for(int i=0; i<rs.size();i++) {
				//current saved elements Article = rs.get(i)
				s += "("+rs.get(i).getAid()+")\n"; //array thì phải check null hay not null
				s += rs.get(i).getTitle();		//list thì check bao nhiêu phần tử ở trong đó thôi, nên ko cần check
				s += "("+rs.get(i).getName()+")\n";
			}
		}
		s += "-----------------";
		System.out.println(s);//output to screen
		return s;
	}

	private static void editArticle(Article article) {
		// TODO Auto-generated method stub
		//Article article = list[idx];	//get reference	// article fields
		//Article article = dao.getArticle(idx);
		//Article article = dao.selectOne(" " + );
		// vì nằm bên DAO nên gửi request cho DAO
		//check Null
//		Article article = dao.selectOne("" + idx);
		
		if(article == null) {
			System.out.println("Indvail Index");
			return;
		}
		
		System.out.println("Title > ");
		String title = sc.nextLine();
		// press only <enter> , empty string
		if( title.length() > 0) {			// have input data
			// in Memory, directly edit
			// dont call dao.update();
			article.setTitle(title);
		}
		
		System.out.println("Write > ");
		String name = sc.nextLine();
		if(!name.isEmpty()) {			// have input data
			article.setName(name);	// over write data
		}
		
		System.out.println("Content > ");
		String content = sc.nextLine();
		if(content.length() > 0) {
			article.setContent(content);//have input data
		}
		
		// done edit data in memory by reference
		
		//have to update in DAO
		//dao.update(article);
	}

	private static Article registArticle() {
		// TODO Auto-generated method stub
		System.out.println("Title > ");
		String title = sc.nextLine();
		System.out.print("Writer > ");
		String name = sc.nextLine();
		System.out.print("Content > ");
		String content = sc.nextLine();
	
		//save data in  Article instance
		Article article = new Article();
		article.setTitle(title);
		article.setName(name);
		article.setContent(content);
		//article.setWdate(wdate);
		// save to array in DAO
		// delegate to dao <-- call method of dao
		//dao.insert(article);
		return article;
	}
}
