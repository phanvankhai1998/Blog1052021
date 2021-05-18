package coeding.java.blog;

import java.util.Scanner;

/**
 * 
 * blog concepts
 * - have articles
 * - writer
 * blog CRUD
 * - console : keyboard and monitor
 * 
 * @author Administrator
 *
 */
public class Starter {
	static Scanner sc; 
	static ArticleDAO dao;
/**
 *	//	private Article[] list;	// <--- model is data CRUD
 *	//	private int seq;		//không cần thiết nữa, vì chuyển array qua DAO index of array
 *
 * @param args
 */
	
	// Control role
	public static void main(String[] args) {
		// TODO: program entry point ( start )
		sc = new Scanner(System.in);
		// list = new Article[10];
		dao = new ArticleDAO();
		while(true) {
			// show all article list// if get reference, can be changed
			Article[] list = dao.getAll();
			String view = showList(list);
			System.out.println("VIEW >" + view);
			
			//request form keyboard
			System.out.println(" > ");
			String cmd = sc.nextLine();
			
			//CONTROL for request Article
			if(cmd.equals("new")) {			//CREATE
				registArticle();
			}
			if(cmd.equals("showlist")) {	//RETRIEVE
				showList(list);
			}
			if(cmd.equals("edit")) {		//UPDATE
				System.out.print("Select art's Index > ");
				cmd = sc.nextLine();				// "1"
				int idx = Integer.parseInt(cmd);	//	1
//				if(idx < seq) {						//if seq 3, [0][1][2]
				editArticle(idx);				//go to edit [idx]article
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
				System.out.println("Search writer :>");
				cmd = sc.nextLine();
				//check null hay ko
				Article[] rs = dao.searchArticleByWriter(cmd);
/**				if(rs !=null) {
					String s = "search resule\t";
					for(int i = 0; i < rs.length; i++) {
						s += [i].getTitle();
						s += "(" + rs[i].getWriterName() + ")\n";
					}
					s += "------------";
					System.out.println(s);
				}
*/			
				if(rs != null) {
					String s = showList(rs);
					System.out.println(s);
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

	private static String showList(Article[] rs) {
		// TODO Auto-generated method stub
		//check null
		String s = "\nShow list > \t";
		for(int i = 0; i < rs.length; i++) {	//rendering by View role
			if(rs[i] != null) {
				System.out.println(
						" - Title : " + rs[i].getTitle() + " - Write : " + rs[i].getWriterName() + " - Content : " + rs[i].getContent()
				);
			}
		}
		s += "-----------------";
		System.out.println(s);
		return s;
	}

	private static void editArticle(int idx) {
		// TODO Auto-generated method stub
		//Article article = list[idx];	//get reference	// article fields
		Article article = dao.getArticle(idx);
		
		System.out.println("Title >" + article.getTitle());
		String title = sc.nextLine();
		if(title.length() > 0 ) {		// press only <enter> , empty string
			article.setTitle(title);	//over write data
		}
		
		System.out.println("Write > " + article.getWriterName());
		String name = sc.nextLine();
		if(!name.isEmpty()) {			// have input data
			article.setWriterName(name);
		}
		
		System.out.println("Content >" + article.getContent());
		String content = sc.nextLine();
		if(content.length() > 0) {
			article.setContent(content);
		}
		//have to update in DAO
		dao.update(article,idx);
	}

	private static void registArticle() {
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
		article.setWriterName(name);
		article.setContent(content);
//		System.out.println(article);
/**
 * 		// Lưu những giá trị Array // Mà Array tạo ở DAO
		// save to array in DAO
		// delegate <----- call method of DAO
		// XÓA
		// System.out.println(article);
		// if(seq < list.length) {
		// list[seq] = article; //need index of array
		// ++seq;//ArrayIndexOutOfBounds
		// }		
 */			
		if(!dao.save(article)) {
			System.out.println("Failed");
		}

//		//OUT is instance name : article
//		System.out.println(article);	// OUT: Project.Aritcle@7637f22
//		//article fields
//		System.out.println(article.getTitle());	
//		System.out.println(article.getWriterName());	
//		System.out.println(article.getContent());		
	}
}
