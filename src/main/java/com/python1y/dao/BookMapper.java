package com.python1y.dao;

import com.python1y.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    int addBook(Books books);

    int deleteBook(@Param("bookID") int id);

    int updateBook(Books books);

    Books queryBookById(@Param("bookID") int id);

    List<Books> queryAllBooks();

}
