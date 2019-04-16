package website_news.dao;

import org.springframework.data.repository.CrudRepository;

import website_news.model.categorynews;

public interface categorynewsDAO extends CrudRepository<categorynews, Integer> {

}
