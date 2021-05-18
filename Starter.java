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
	static Article[] list;
	static int seq;
	
	public static void main(String[] args) {
		// TODO: program entry point ( start )
		sc = new Scanner(System.in);
		list = new Article[10];
		seq = 0;
		while(true) {
			System.out.println(" > ");
			String cmd = sc.nextLine();
			if(cmd.equals("new")) {			//CREATE
				registArticle();
			}
			if(cmd.equals("showlist")) {	//RETRIEVE
				showList();
			}
			if(cmd.equals("edit")) {		//UPDATE
				System.out.print("Select art's Index > ");
				cmd = sc.nextLine();				// "1"
				int idx = Integer.parseInt(cmd);	//	1
				if(idx < seq) {						//if seq 3, [0][1][2]
					editArticle(idx);				//go to edit [idx]article
				}else {
					System.out.println("Invaild index");
				}
			}
			if(cmd.equals("delete")) {		//DELETE
				System.out.println("Seleact article's index :>");
				cmd = sc.nextLine();
				int idx = Integer.parseInt(cmd);
				
				if(idx < seq) {
					deleteArticle(idx);
					showList();
				}else {
					System.out.println("invalid index");
				}
			}
			if(cmd.equals("search")) {		//SEARCH
				System.out.println("Search writer :>");
				cmd = sc.nextLine();
				Article rs = searchArticleByWriter("Jang");
			}
		}// end while
	}

	private static Article searchArticleByWriter(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void deleteArticle(int idx) {
		// TODO Auto-generated method stub
		for(int i=idx; (i+1)<list.length; i++) {
			list[i] = list[i+1];// [0] <- [] <- [9]
		}
		// decrease numbers of save data
		--seq;
	}

	private static void showList() {
		// TODO Auto-generated method stub
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				System.out.println(
						"Title : " + list[i].getTitle() + " Write : " + list[i].getWriterName() + " Contetn : " + list[i].getContent()
				);
			}
		}
	}

	private static void editArticle(int idx) {
		// TODO Auto-generated method stub
		Article article = list[idx];		//get reference
		
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
		// quiz ? tai sao khong co code below
		//	list[idx] = article;	already set via setter
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
		System.out.println(article);
		if(seq < list.length) {
			list[seq] = article;	//need index of array
			seq++;
			//ArrayIndexOutOfBounds
		}
		//OUT is instance name : article
		System.out.println(article);	// OUT: Project.Aritcle@7637f22
		//article fields
		System.out.println(article.getTitle());	
		System.out.println(article.getWriterName());	
		System.out.println(article.getContent());		
	}
}
