package coeding.java.blog;

public class ArticleDAO {
	private Article[] list;	
	private int seq;
	
	//default contructor
	//public dinh ko co kieu tra ve
	public ArticleDAO() {
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
		if(seq< list.length) {
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
			Article rt = new Article();	//origin -> rt
			rt.setSeq(origin.getSeq());
			rt.setTitle(origin.getTitle());
			rt.setWriterName(origin.getWriterName());
			rt.setContent(origin.getContent());
			return rt;	// copied instance //sao chep art qua rt
		}
		return null;
		
//		//cách 1
//		Article origin = list[idx];
//		//kiểm tra idx tồn tại ko// is Exist?
//		for(int i =0; i< list.length; i++) {
//			if(list[i] != null) {
//				if(i == idx) {
//					//found it đã tìm thấy
//				}
//			}
//		}
	}

	public void update(Article article, int idx) {
		// TODO Auto-generated method stub
		list[idx] = article;
	}
}
