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
}
