package coeding.java.blog;

import java.util.List;

//API - Application Programming <<Interface>>>
//be rule and agrement
//Generic
public interface DAO<T> {//ArticleType
	// interface all method be abstract without body {} => method ko có {}
	void insert(T arg);	//Crud
	void update(T arg); //crUd
	void delete(Long id); //cruD
	List<T> select(T arg);//cRud
	//Tạo interface 
}
