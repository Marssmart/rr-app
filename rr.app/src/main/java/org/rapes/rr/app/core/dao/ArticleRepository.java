package org.rapes.rr.app.core.dao;

import org.rapes.rr.app.core.dom.Article;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

}
