package website_news.dao;

import org.springframework.data.repository.CrudRepository;

import website_news.model.detailnews;

public interface detailnewsDAO extends CrudRepository<detailnews, Integer> {
}
