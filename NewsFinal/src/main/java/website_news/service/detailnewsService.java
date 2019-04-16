package website_news.service;

import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import website_news.dao.accountadminDAO;
import website_news.dao.categorynewsDAO;
import website_news.dao.detailnewsDAO;
import website_news.model.accountadmin;
import website_news.model.categorynews;
import website_news.model.detailnews;

@Service
@Transactional
public class detailnewsService  {
	private final detailnewsDAO detailnewsdao;
	private final accountadminDAO accountadmindao;
	private final categorynewsDAO categorynewsdao;
	private JdbcTemplate jdbcTemp;
	public detailnewsService(detailnewsDAO detailnewsdao,accountadminDAO ad,categorynewsDAO ct,DataSource dataSource) {
		this.detailnewsdao = detailnewsdao;
		this.accountadmindao=ad;
		this.categorynewsdao=ct;
		jdbcTemp = new JdbcTemplate(dataSource);
	}
	public List<detailnews> findAll1(){
		List<detailnews>news=new ArrayList<detailnews>();
		for(detailnews detail:detailnewsdao.findAll()) {
			news.add(detail);
		}
		return news;
	}
 
	public Optional<detailnews> findDetailnews(int id) {
		return detailnewsdao.findById(id);
	}

	public List<detailnews> findAll(int id){
		List<detailnews>news=new ArrayList<detailnews>();
		news=getList(news,4,id,1);
		return news;
	}

	/*
	 * public detailnews findDetailNewsWithID(int id) { List<detailnews>dts=new
	 * ArrayList<detailnews>(); for(detailnews dt:detailnewsdao.findAll()) {
	 * if(dt.getIddetailnews()==id) { return dt; } } return null; }
	 */
	public categorynews findCategoryNewsWithID(int id)
	{
		List<categorynews>dts=new ArrayList<categorynews>();
		for(categorynews dt:categorynewsdao.findAll()) {
			if(dt.getIdcategory()==id)
			{
				return dt;
			}
		}
		return null;
	}
	public void save(detailnews task) {
		detailnewsdao.save(task);
	}
	public List<detailnews> getList(List<detailnews> list,int count,int id,int check)
	{
		List<detailnews>temp=new ArrayList<detailnews>();
		List<detailnews>listFinal=new ArrayList<detailnews>();
		if(check==1)
		{
			temp=(List<detailnews>) detailnewsdao.findAll();
			for(int i=0;i<temp.size();i++)
			{
				if(listFinal.size()==count)
				{
					break;
				}
				else
				{
					if(temp.get(i).getIdcategory()==id)
					{
						listFinal.add(temp.get(i));
					}
				}
			}
		}
		else
		{
			temp=list;
			for(int i=temp.size()-1;i>=0;i--) {
				if(listFinal.size()==count)
				{
					break;
				}
				else
				{
					if(temp.get(i).getIdcategory()==id)
					{
						listFinal.add(temp.get(i));
					}
				}
			}
		}
		
		return listFinal;
	}
	public List<detailnews> getCtWithID(int id)
	{
		List<detailnews>ads=new ArrayList<detailnews>();
		for(detailnews ad:detailnewsdao.findAll()) {
			if(ad.getIdcategory()==id)
			{
				ads.add(ad);
			}
			
		}
		return ads;
	}
	public List<accountadmin>  findAllad()
	{
		List<accountadmin>ads=new ArrayList<accountadmin>();
		for(accountadmin ad:accountadmindao.findAll()) {
			ads.add(ad);
		}
		return ads;
	}
	public String getName(int id)
	{
		List<categorynews>temp=new ArrayList<categorynews>();
		temp=(List<categorynews>) categorynewsdao.findAll();
		for(int i=0;i<temp.size();i++)
		{
			if(temp.get(i).getIdcategory()==id)
			{
				return temp.get(i).getName();
			}
		}
		return "";
	}
	public int getidcategory()
	{
		List<categorynews>temp=new ArrayList<categorynews>();
		temp=(List<categorynews>) categorynewsdao.findAll();
		return temp.get(0).getIdcategory();
	}
	public List<detailnews> findMaxSeen(int id){
		List<detailnews>temp=new ArrayList<detailnews>();
		for(detailnews dt:detailnewsdao.findAll()) {
			temp.add(dt);
		}
		Collections.sort(temp);
		List<detailnews>news=new ArrayList<detailnews>();
		news=getList(temp,4,id,2);
		return news;
	}
	public detailnews findFistList(int id)
	{
		detailnews dtn=new detailnews();
		List<detailnews>news=new ArrayList<detailnews>();
		dtn=getList(news,4,id,1).get(0);
		return dtn;
	}
	public List<detailnews> getAllListDtn()
	{
		List<detailnews>tasks=new ArrayList<detailnews>();
		for(detailnews task:detailnewsdao.findAll()) {
			tasks.add(task);
		}
		return tasks;
	}
	public List<categorynews> getAllListCtg()
	{
		List<categorynews>tasks=new ArrayList<categorynews>();
		for(categorynews task:categorynewsdao.findAll()) {
				tasks.add(task);
			
		}
		return tasks;
	}
	public detailnews findDetailNewsWithID(int id)
	{
		List<detailnews>dts=new ArrayList<detailnews>();
		for(detailnews dt:detailnewsdao.findAll()) {
			if(dt.getIddetailnews()==id)
			{
				return dt;
			}
		}
		return null;
	}
	public Blob getPhotoById(int id) {

		String query = "select image1 from detailnews where iddetailnews=?";

		Blob photo = jdbcTemp.queryForObject(query, new Object[] { id }, Blob.class);

		return photo;
	}
	public int updateRecords(MultipartFile photo,int id) throws IOException {

		byte[] photoBytes = photo.getBytes();

		String sql = "UPDATE detailnews SET image1 = ? WHERE (iddetailnews = ?)";

		return jdbcTemp.update(sql, new Object[] { photoBytes, id });
	}
}
