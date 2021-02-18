package com.python1y.service;

import com.python1y.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    int addBook(Books books);

    int deleteBook(int id);

    int updateBook(Books books);

    Books queryBookById(int id);

    List<Books> queryAllBooks();
}
