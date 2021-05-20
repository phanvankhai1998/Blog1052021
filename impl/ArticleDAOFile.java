package coeding.java.blog.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import coeding.java.blog.Article;
import coeding.java.blog.DAO;

public class ArticleDAOFile implements DAO<Article>{
	
	private File file;
	
	public ArticleDAOFile() {
		file = new File("data", "blog.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void insert(Article arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Article arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Article> select(Article arg) {
		// TODO File datas -> List<Article>
				if(arg == null) {
					//all data return
					//sử dụng scanner đọc 
					Scanner sc = null;
					try {
						sc = new Scanner(file);
						
						while(sc.hasNext()) {
							String s = sc.nextLine();
							int begin = s.indexOf('[');
							int end = s.indexOf(']');
							String sub = s.substring(begin+1,end);
							System.out.println(sub);
							//mapping(convert) : Article <- String data in file
							String[] csv = sub.split(",");
							
							//JBDC, Mybrtis < DBMS------------------------------------------------------------------------------
							//JPA, String, boot------------------------------------------------------------------------------
							Article article = new Article();
							for(String e: csv) {
								String[] kv = e.trim().split("=");	
								//<---- remove whitespace(' ', '\t', '\n')
								switch(kv[0]) {
									case "aid":
										Long id = null;
										if(!kv[1].equals("null")) {
											id = Long.parseLong(kv[1]);
										}
										article.setAid(id);// = bằng null; giá trị null
										break;
									case "title":
									article.setTitle(kv[1]);break;
									case "name":
									article.setTitle(kv[1]);break;
									case "content":
									article.setContent(kv[1]);break;				
								}
							}
							
							
//							Map<String,Object> map = new HashMap<String,Object>();
//							for(String e: csv) {
//								String[] kv = e.trim().split("=");	
//								map.put(kv[0], kv[1]);
//							}
						}
					}catch(FileNotFoundException e) {
						e.printStackTrace();
					}
					if(sc != null) {
						sc.close();//tại sao ? sc == null
					}
				}
				return null;
	}

}
