package com.teum.controller.accommodation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.teum.dao.entity.ReviewView;
import com.teum.dao.entity.RoomImageListView;
import com.teum.entity.Acc;
import com.teum.entity.AccImage;
import com.teum.service.AccImageService;
import com.teum.service.AccService;
import com.teum.service.PickService;
import com.teum.service.ReservationService;
import com.teum.service.RoomImageService;
import com.teum.service.RoomService;

@WebServlet("/accommodation/detail")
public class DetailController extends HttpServlet {

	private AccService accService;
	private AccImageService accImageService;
	private RoomService roomService;
	private RoomImageService roomImageService;
	private ReservationService reservationService;
	private PickService pickService;

	public DetailController() {
		accService = new AccService();
		roomService = new RoomService();
		accImageService = new AccImageService();
		roomImageService = new RoomImageService();
		reservationService = new ReservationService();
		pickService = new PickService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();

		String accId_ = request.getParameter("accId");
		int accId = 0;

		String checkinDate_ = "1901-01-01";
		String checkoutDate_ = "1901-01-02";
		
		if (request.getParameter("checkinDate") != null && !request.getParameter("checkinDate").equals(""))
			checkinDate_ = request.getParameter("checkinDate");
		
		if (request.getParameter("checkoutDate") != null && !request.getParameter("checkoutDate").equals(""))
			checkoutDate_ = request.getParameter("checkoutDate");

		if (accId_ != null && !accId_.equals(""))
			accId = Integer.parseInt(accId_);
		System.out.println(accId);
		/* -- acc id에 일치하는 모든 acc 정보 갖고 오기 -- */
		Acc acc = accService.get(accId);


		
		/* -- acc id에 일치하는 accImage 정보들(fileName) 가져오기 -- */
		AccImage accImage = accImageService.get(accId);
		System.out.println(accImage.getFileroute());
		
		/* -- acc id에 일치하는 모든 룸 정보 갖고오고 거기에 딸려오는 룸 사진도 갖고오기 -- */
		List<RoomImageListView> roomList = roomService.getViewList(accId); //회원이 검색한 날짜에 상관없이 모든 방을 넣은 리스트

		
		
		/* -- 개인이 검색한 예약날짜중 예약이 가능한 방만 뽑아내기 -- */
		List<RoomImageListView> showRoomList = new ArrayList<>(); // 개인이 검색한 날짜에 예약이 가능한 방만 넣은 리스트
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Boolean isDate = false;
		Date checkinDate = null;
		Date checkoutDate = null;
		
		if (checkinDate_ != null && !checkinDate_.equals("") && 
				checkoutDate_ != null && !checkoutDate_.equals("")) {
			try {
				isDate = true;
				checkinDate = sdf.parse(checkinDate_);
				checkoutDate = sdf.parse(checkoutDate_);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			// 개인이 검색한 체크인 날짜 ~ 체크아웃 전날 날짜까지 추리기(체크아웃에는 다른 개인이 예약이 가능하므로)
			StringBuilder checkDatesCSV = new StringBuilder();
			
			while (checkinDate.compareTo(checkoutDate) <= 0) {
				checkDatesCSV.append(sdf.format(checkinDate));
				checkDatesCSV.append(",");
				Calendar c = Calendar.getInstance();
				c.setTime(checkinDate);
				c.add(Calendar.DAY_OF_MONTH, 1);
				checkinDate = c.getTime();
			}
			checkDatesCSV.delete(checkDatesCSV.length() - 12, checkDatesCSV.length()); // 퇴실일 ~ 콤마까지 삭제
			
//				System.out.printf("개인이 희망한 체크인날짜: %s\n", checkDatesCSV);
//				System.out.println("roomList: " + roomList.toString());
			
			for (RoomImageListView room : roomList) {
				
				// ex) 만약 개인이 2020-01-01 ~ 2020-01-04 날짜로 검색을 하는 경우에 checkDates는 아래와 같다.
				// checkDates = ["2020-01-01", "2020-01-02", "2020-01-03"];
				String[] checkDates = checkDatesCSV.toString().split(",");
				String bookedDate = room.getBookedDate();
				
//					System.out.println("checkDates: " + Arrays.toString(checkDates));
//					System.out.println("bookedDate: " + bookedDate);
				
				boolean isBook = true;
				
				// 방에 예약이 비어있으므로 보여줄 수 있음
				if (bookedDate == null || bookedDate.equals("")) {
					showRoomList.add(room);
					continue;
				}
				
				// 하루라도 예약날짜가 겹치면 isBook 상태를 false로 변경
				for (String checkDate : checkDates)
					if (bookedDate.contains(checkDate)) {
						isBook = false;
						break;
					}
				
				// 하루도 예약이 겹치지 않았으므로 예약가능
				if (isBook)
					showRoomList.add(room);
			}

			
			// 모든 사람들이 쓴 리뷰가 3개가 넘으면 3개만 보여주고, 아니면 해당 개수만 보여주기
			// 해당 숙소에 등록된 리뷰를 모두 뽑아서 REVIEW_SCORE의 평균을 내기
			// 해당 숙소에 등록된 리뷰를 모두 뽑아서 작성자 이름, 컨텐츠, 등록일 뽑기
			List<ReviewView> review = new ArrayList<ReviewView>();
			review = reservationService.getReviewList(accId);
			
			int avg = reservationService.getAvg(accId);
			int count =reservationService.getReviewCount(accId);


			if (isDate)
				request.setAttribute("showRoomList", showRoomList);
			else
				request.setAttribute("roomList", roomList);
			
			
			
			//찜한숙소인지 검사하는 코드
			int type = 2;
			if(session.getAttribute("type")!=null)
				type = (int)session.getAttribute("type");
			
			int userId = 0;
			if(session.getAttribute("id")!=null && type == 0)
				userId = (int)session.getAttribute("id");
			
			int zzimStatus = 0;
			if(type == 0)
				zzimStatus = pickService.checkZzim(userId,accId);
			
			
			
			request.setAttribute("count", count);
			request.setAttribute("avg", avg);
			request.setAttribute("review", review);
			request.setAttribute("acc", acc);
			request.setAttribute("accImage", accImage);
			request.setAttribute("type", type);
			request.setAttribute("userId", userId);
			request.setAttribute("zzimStatus",zzimStatus);
			request.getRequestDispatcher("detail.jsp").forward(request, response);

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 적용버튼 누르면 해당 acc Id에 일치하는 모든 룸 정보를 갖고오기

		// 체크인, 체크아웃을 배열로 만들어서 ["2020-01-01", "2020-01-02"]로 넣고 마지막날은 빼기.
		// 해당 배열을 돌면서 모든 룸의 BOOKED_DATE를 돌면서 포함되어 있지 않은 것들만 불러오기
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		int accId = Integer.parseInt(request.getParameter("accId"));
		int status = Integer.parseInt(request.getParameter("status"));
		int result = 0;
		if(status == 0) {
			result = pickService.insertZzim(userId,accId);
		}else {
			result = pickService.deleteZzim(userId,accId);
		}
		
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}

}