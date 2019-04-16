package website_news.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import website_news.model.accountadmin;
import website_news.model.categorynews;
import website_news.model.detailnews;
import website_news.service.detailnewsService;

@Controller
public class MainController {

	@Autowired
	private detailnewsService dtnService;

	@GetMapping("/")
	public String Load(HttpServletRequest request) {
		List<detailnews> list = new ArrayList<detailnews>();
		list=dtnService.findAll1();
		int len=list.size();
		List<detailnews> listThoiSuNews = new ArrayList<detailnews>();
		List<detailnews> listGiaoThongNews = new ArrayList<detailnews>();
		List<detailnews> listBongDaNews = new ArrayList<detailnews>();
		List<detailnews> listDuLichNews = new ArrayList<detailnews>();
		for (int i = 0; i < len; i++) {
			if (list.get(i).getIdcategory() == 1) // thoi su
			{
				listThoiSuNews.add(list.get(i));
			}
			if (list.get(i).getIdcategory() == 2) // Giao thong
			{
				listGiaoThongNews.add(list.get(i));
			}
			if (list.get(i).getIdcategory() == 3) // Bong da
			{
				listBongDaNews.add(list.get(i));
			}
			if (list.get(i).getIdcategory() == 4) // Du lich
			{
				listDuLichNews.add(list.get(i));
			}		
		}
		String idcategory;
		int idc=-1;
		idcategory=(request.getParameter("id")) ;
		if(idcategory == null)
		{
			idc=1;
		}
		else
		{
			idc=Integer.parseInt(idcategory);
		}		
		switch (idc) 
		{
		case 1:
			getInfor(listThoiSuNews, request);
			break;
		case 2:
			getInfor(listGiaoThongNews, request);
			break;
		case 3:
			getInfor(listBongDaNews, request);
			break;

		default:
		getInfor(listDuLichNews, request);
			break;
		}
		
		request.setAttribute("list", list);
		 request.setAttribute("ctg", dtnService.getAllListCtg());
		 request.setAttribute("dt", dtnService.findFistList(idc));
		 request.setAttribute("dtnm", dtnService.findMaxSeen(idc));
		 
		return "index_news";
	}
	@GetMapping("/1")
	public String Load1(HttpServletRequest request) {
		List<detailnews> list = new ArrayList<detailnews>();
		list=dtnService.findAll1();
		int len=list.size();
		List<detailnews> listThoiSuNews = new ArrayList<detailnews>();
		List<detailnews> listGiaoThongNews = new ArrayList<detailnews>();
		List<detailnews> listBongDaNews = new ArrayList<detailnews>();
		List<detailnews> listDuLichNews = new ArrayList<detailnews>();
		for (int i = 0; i < len; i++) {
			if (list.get(i).getIdcategory() == 1) // thoi su
			{
				listThoiSuNews.add(list.get(i));
			}
			if (list.get(i).getIdcategory() == 2) // Giao thong
			{
				listGiaoThongNews.add(list.get(i));
			}
			if (list.get(i).getIdcategory() == 3) // Bong da
			{
				listBongDaNews.add(list.get(i));
			}
			if (list.get(i).getIdcategory() == 4) // Du lich
			{
				listDuLichNews.add(list.get(i));
			}		
		}
		String idcategory;
		int idc=-1;
		idcategory=(request.getParameter("id")) ;
		if(idcategory == null)
		{
			idc=1;
		}
		else
		{
			idc=Integer.parseInt(idcategory);
		}		
		switch (idc) 
		{
		case 1:
			getInfor(listThoiSuNews, request);
			break;
		case 2:
			getInfor(listGiaoThongNews, request);
			break;
		case 3:
			getInfor(listBongDaNews, request);
			break;

		default:
		getInfor(listDuLichNews, request);
			break;
		}
		
		request.setAttribute("list", list);
		 request.setAttribute("ctg", dtnService.getAllListCtg());
		 request.setAttribute("dt", dtnService.findFistList(idc));
		 request.setAttribute("dtnm", dtnService.findMaxSeen(idc));
		 
		return "index_news";
	}
	@GetMapping("/.")
	public String LoadIndex(HttpServletRequest request) {
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		List<detailnews> list = new ArrayList<detailnews>();
		  list=dtnService.findAll1();
		  List<detailnews> listLeftNews=new ArrayList<detailnews>();
		  List<detailnews> listheadNews=new ArrayList<detailnews>(); 
		  List<detailnews> listfirstNews=new ArrayList<detailnews>(); 
		  List<detailnews> listlastNews=new ArrayList<detailnews>(); 
		  int len=dtnService.findAll1().size();
		  listfirstNews.add(list.get(len-1));// the first news
		  listheadNews.add(list.get(len-2));// the second news
		  
		  for(int i=len-3;i>=0;i--)
		  { 
			  listLeftNews.add(list.get(i));
			  if(i==len-7)
				  break;
		  } //six news next
		  for(int i=len-9;i>=0;i--) {
		  listlastNews.add(list.get(i)); 
		  	if(i==len-10) break; 
		  } //two news last
		String id = request.getParameter("idfirstnews");
		//String idcategoryNews = request.getParameter("ctgnews");// the thao gigi do...4
		//int idCategoryNews = Integer.parseInt(idcategoryNews);
		int idcategory = 0;
		if (id == null) {
			idcategory = dtnService.getidcategory();
		} else {
			idcategory = Integer.parseInt(id);
		}
		
		 request.setAttribute("leftNews", listLeftNews);
		 request.setAttribute("headNews", listheadNews);
		 request.setAttribute("firstNews", listfirstNews);
		 request.setAttribute("lastNews", listlastNews);
		request.setAttribute("ctg", dtnService.getAllListCtg());
		request.setAttribute("dt", dtnService.findFistList(idcategory));

	
	return "index_news";
	}

	public void getInfor(List<detailnews> list, HttpServletRequest request) {
		// list=dtnService.findAll1();
		List<detailnews> listLeftNews = new ArrayList<detailnews>();
		List<detailnews> listheadNews = new ArrayList<detailnews>();
		List<detailnews> listfirstNews = new ArrayList<detailnews>();
		List<detailnews> listlastNews = new ArrayList<detailnews>();
		int len = list.size();
		listfirstNews.add(list.get(len - 1));// the first news
		listheadNews.add(list.get(len - 2));// the second news

		for (int i = len - 3; i >= 0; i--) {
			listLeftNews.add(list.get(i));
			if (i == len - 7)
				break;
		} // six news next
		for (int i = len - 9; i >= 0; i--) {
			listlastNews.add(list.get(i));
			if (i == len - 10)
				break;
		} // two news last
		request.setAttribute("leftNews", listLeftNews);
		request.setAttribute("headNews", listheadNews);
		request.setAttribute("firstNews", listfirstNews);
		request.setAttribute("lastNews", listlastNews);

	}

	@GetMapping("/aaaa")
	public String home(HttpServletRequest request) {
		String id = request.getParameter("id");
		int idcategory = 0;
		if (id == null) {
			idcategory = dtnService.getidcategory();
		} else {
			idcategory = Integer.parseInt(id);
		}
		String name = dtnService.getName(idcategory);
		// gan bai thuoc nhom nao
		request.setAttribute("name", name);
		// load cot ben pai
		request.setAttribute("dtn", dtnService.findAll(idcategory));
		// load ds xem nhieu nhat
		request.setAttribute("dtnm", dtnService.findMaxSeen(idcategory));
		// load bai tren cung
		request.setAttribute("dt", dtnService.findFistList(idcategory));
		// load ctg
		request.setAttribute("ctg", dtnService.getAllListCtg());
		// gan idreadall
		request.setAttribute("idreadall", idcategory);
		return "index_news";
	}

	@GetMapping("/ctgnews")
	public String ctgnews(HttpServletRequest request) {
		return home(request);
	}

	@GetMapping("/read_all")
	public String readAll(HttpServletRequest request) {
		String idreadall = request.getParameter("idreadall");
		int id = Integer.parseInt(idreadall);
		String name = dtnService.getName(id);
		// gan bai thuoc nhom nao
		request.setAttribute("name", name);
		// load ds ctg
		request.setAttribute("dtn", dtnService.getCtWithID(id));
		return "read_all_category_news";
	}

	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		
//		 String name = request.getParameter("name");
//			String pass = request.getParameter("password");
//			List<accountadmin> list = new ArrayList<accountadmin>();
//			list = dtnService.findAllad();
//			for (int i = 0; i < list.size(); i++) {
//				if (list.get(i).getName().equals(name) && list.get(i).getPassword().equals(pass)) {
//					refreshNameAndPass(request);
//					return Load(request);
//				}
//			}
			refreshNameAndPass(request);
//			request.setAttribute("mode", "MODE_USER");
//			request.setAttribute("users",list);
			request.setAttribute("error","");
			return "login";
	}

	@PostMapping("/loginadmin")
	public String loginadmin(HttpServletRequest request) {
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		
		List<accountadmin> list = new ArrayList<accountadmin>();
		list = dtnService.findAllad();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name) && list.get(i).getPassword().equals(pass)) {
				//refreshNameAndPass(request);
				request.setAttribute("mode", "MODE_USER");
				request.setAttribute("users",list);
				
				return "admin";
			}
		}
		
		request.setAttribute("error","Tên tài khoản hoặc mật khẩu không chính xác");
		return "login";
	}

	public void refreshNameAndPass(HttpServletRequest request) {
		request.setAttribute("name", "");
		request.setAttribute("password", "");
	}
	@GetMapping("/readDetail")

	public String readDetail(HttpServletRequest request) {
		
		 request.setAttribute("ctg", dtnService.getAllListCtg());
		List<detailnews> list = new ArrayList<detailnews>();
		list=dtnService.findAll1();
		int len=list.size();
		String id= request.getParameter("idfirstnews");
		int iddetailnews = Integer.parseInt(id);
		List<detailnews> listThoiSuNews = new ArrayList<detailnews>();
		List<detailnews> listGiaoThongNews = new ArrayList<detailnews>();
		List<detailnews> listBongDaNews = new ArrayList<detailnews>();
		List<detailnews> listDuLichNews = new ArrayList<detailnews>();
		List<detailnews> listTempNews = new ArrayList<detailnews>();
		request.setAttribute("readdetailnews", dtnService.findDetailNewsWithID(iddetailnews));
			
		switch (dtnService.findDetailNewsWithID(iddetailnews).getIdcategory()) {
		case 1:
			request.setAttribute("namecategory", "Thời sự");
			break;
		case 2:
			request.setAttribute("namecategory", "Giao thông");
			break;
		case 3:
			request.setAttribute("namecategory", "Bóng đá");
			break;
		default:
			request.setAttribute("namecategory", "Du lịch");
			break;
		}
		if (dtnService.findDetailNewsWithID(iddetailnews).getIdcategory() == 1) {
			request.setAttribute("name", "");
		}
		int idcategory=dtnService.findDetailNewsWithID(iddetailnews).getIdcategory();
		System.out.print(idcategory);
		for (int i = 0; i < len; i++) {
			if (list.get(i).getIdcategory() == 1) // thoi su
			{
				listThoiSuNews.add(list.get(i));
			}
			if (list.get(i).getIdcategory() == 2) // Giao thong
			{
				listGiaoThongNews.add(list.get(i));
			}
			if (list.get(i).getIdcategory() == 3) // Bong da
			{
				listBongDaNews.add(list.get(i));
			}
			if (list.get(i).getIdcategory() == 4) // Du lich
			{
				listDuLichNews.add(list.get(i));
			}		
		}
		switch (idcategory) {
		case 1:
			for(int i=listThoiSuNews.size()-1;i>=listThoiSuNews.size()-4;i--)
			{
				listTempNews.add(listThoiSuNews.get(i));
			}
			break;
		case 2:
			for(int i=listGiaoThongNews.size()-1;i>=listGiaoThongNews.size()-4;i--)
			{
				listTempNews.add(listGiaoThongNews.get(i));
			}
			break;
		case 3:
			for(int i=listBongDaNews.size()-1;i>=listBongDaNews.size()-4;i--)
			{
				listTempNews.add(listBongDaNews.get(i));
			}
			break;
		default:
			for(int i=listDuLichNews.size()-1;i>=listDuLichNews.size()-4;i--)
			{
				listTempNews.add(listDuLichNews.get(i));
			}
			break;
		}
		request.setAttribute("listTemp", listTempNews);
		return "read_detailnews";
	}
	@GetMapping("/readDetail1")

	public String readDetail1(HttpServletRequest request) {
		 request.setAttribute("ctg", dtnService.getAllListCtg());
		List<detailnews> list = new ArrayList<detailnews>();
		list=dtnService.findAll1();
		int len=list.size();
		String id= request.getParameter("id1");
		int iddetailnews = Integer.parseInt(id);
		List<detailnews> listThoiSuNews = new ArrayList<detailnews>();
		List<detailnews> listGiaoThongNews = new ArrayList<detailnews>();
		List<detailnews> listBongDaNews = new ArrayList<detailnews>();
		List<detailnews> listDuLichNews = new ArrayList<detailnews>();
		List<detailnews> listTempNews = new ArrayList<detailnews>();
		request.setAttribute("readdetailnews", dtnService.findDetailNewsWithID(iddetailnews));
			
		switch (dtnService.findDetailNewsWithID(iddetailnews).getIdcategory()) {
		case 1:
			request.setAttribute("namecategory", "Thời sự");
			break;
		case 2:
			request.setAttribute("namecategory", "Giao thông");
			break;
		case 3:
			request.setAttribute("namecategory", "Bóng đá");
			break;
		default:
			request.setAttribute("namecategory", "Du lịch");
			break;
		}
		if (dtnService.findDetailNewsWithID(iddetailnews).getIdcategory() == 1) {
			request.setAttribute("name", "");
		}
		int idcategory=dtnService.findDetailNewsWithID(iddetailnews).getIdcategory();
		System.out.print(idcategory);
		for (int i = 0; i < len; i++) {
			if (list.get(i).getIdcategory() == 1) // thoi su
			{
				listThoiSuNews.add(list.get(i));
			}
			if (list.get(i).getIdcategory() == 2) // Giao thong
			{
				listGiaoThongNews.add(list.get(i));
			}
			if (list.get(i).getIdcategory() == 3) // Bong da
			{
				listBongDaNews.add(list.get(i));
			}
			if (list.get(i).getIdcategory() == 4) // Du lich
			{
				listDuLichNews.add(list.get(i));
			}		
		}
		switch (idcategory) {
		case 1:
			for(int i=listThoiSuNews.size()-1;i>=listThoiSuNews.size()-4;i--)
			{
				listTempNews.add(listThoiSuNews.get(i));
			}
			break;
		case 2:
			for(int i=listGiaoThongNews.size()-1;i>=listGiaoThongNews.size()-4;i--)
			{
				listTempNews.add(listGiaoThongNews.get(i));
			}
			break;
		case 3:
			for(int i=listBongDaNews.size()-1;i>=listBongDaNews.size()-4;i--)
			{
				listTempNews.add(listBongDaNews.get(i));
			}
			break;
		default:
			for(int i=listDuLichNews.size()-1;i>=listDuLichNews.size()-4;i--)
			{
				listTempNews.add(listDuLichNews.get(i));
			}
			break;
		}
		request.setAttribute("listTemp", listTempNews);
		return "read_detailnews";
	}

	@GetMapping("/loadct")
	public String loadct(HttpServletRequest request) {
		String id = request.getParameter("id");
		int idct = Integer.parseInt(id);
		request.setAttribute("ctg", dtnService.findCategoryNewsWithID(idct));
		return "index_news";
	}

	@GetMapping("/hello")
	public String readDed(HttpServletRequest request) {
		return "cc";
	}

	@PostMapping("/save-tasks")
	public String saveTasks(@ModelAttribute detailnews task, BindingResult bindingResult,
			@RequestParam("image1") MultipartFile photo, HttpServletRequest request) throws IOException {

		task.setCreate_time(new Date());
		dtnService.save(task);
		dtnService.updateRecords(photo, task.getIddetailnews());
		return home(request);
	}

	@RequestMapping(value = "/getPhoto/{iddetailnews}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("iddetailnews") int id) throws Exception {
		response.setContentType("image/jpeg");
		Blob ph = dtnService.getPhotoById(id);
		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	}
	@GetMapping("/userManagement") 
	public String user(HttpServletRequest request) {
		List<accountadmin> list = new ArrayList<accountadmin>();
		list = dtnService.findAllad();
		request.setAttribute("mode", "MODE_USER");
		request.setAttribute("users",list);
		return "admin";
	}
	@GetMapping("/groupNews") 
	public String groupNews(HttpServletRequest request) {
		List<categorynews> list = new ArrayList<categorynews>();
		list = dtnService.getAllListCtg();
		request.setAttribute("mode", "MODE_GROUPNEWS");
		request.setAttribute("groupNews",list);
		return "admin";
	}
	@GetMapping("/newManagement") 
	public String newManagement(HttpServletRequest request) {
		List<detailnews> list = new ArrayList<detailnews>();
		list = dtnService.findAll1();
		request.setAttribute("mode", "MODE_NEWS");
		request.setAttribute("newManagement",list);
		return "admin";
	}
	@GetMapping("/logout") 
	public String logOut(HttpServletRequest request) {
		Load(request);
		return "index_news";
	}
}
