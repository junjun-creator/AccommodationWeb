package com.teum.controller.company.reverseoffer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.dao.entity.OfferableRoomListView;
import com.teum.entity.Acc;
import com.teum.entity.Offer;
import com.teum.entity.ReverseOffer;
import com.teum.entity.Room;
import com.teum.service.AccService;
import com.teum.service.OfferService;
import com.teum.service.ReverseOfferService;
import com.teum.service.RoomImageService;
import com.teum.service.RoomService;

@WebServlet("/company/reverseOffer/reg")
public class RegController extends HttpServlet {

	private AccService accService;
	private OfferService offerService;
	private RoomService roomService;
	private RoomImageService roomImageService;
	private ReverseOfferService reverseOfferService;
	
	public RegController() {
		accService = new AccService();
		offerService = new OfferService();
		roomService = new RoomService();
		roomImageService = new RoomImageService();
		reverseOfferService = new ReverseOfferService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email") == null) 		  // 로그인이 안된 경우
			response.sendRedirect("/signin");
		else if(((int)session.getAttribute("type")) != 1) // 기업이 아닌 경우
			response.sendRedirect("/index");
		else {
			int companyId = (int) session.getAttribute("id");
			
			/* -- 개인이 제안한 위치에 매칭되는 모든 숙소 불러오기 -- */
			List<Acc> accList = accService.getList(companyId);
			StringBuilder accIdsCSV = new StringBuilder();
			
			for (Acc acc : accList) {
				accIdsCSV.append(toString().valueOf(acc.getId()));
				accIdsCSV.append(",");
			}
			accIdsCSV.delete(accIdsCSV.length() - 1, accIdsCSV.length()); // 마지막 콤마 삭제
			
			List<Offer> offerList = offerService.getList(accIdsCSV.toString());
			
			int page = 1;
			int offerId = 0;
			String page_ = request.getParameter("page");
			String offerId_ = request.getParameter("offerId");
			
			// 개인회원이 보낸 제안이 최소 1개라도 있는 경우엔 첫 번째 제안을 디폴트 값으로 설정
			if(!offerList.isEmpty())
				offerId = offerList.get(0).getId();
			
			if(page_ != null && !page_.equals(""))
				page = Integer.parseInt(page_);
			
			// 제안목록중 원하는 제안을 클릭한 경우 offerId에 클릭한 offer id를 대입
			if(offerId_ != null && !offerId_.equals(""))
				offerId = Integer.parseInt(offerId_);
			
			List<OfferableRoomListView> offerViewList = roomService.getOfferableRoomList(offerId);
			
			
			/* -- 개인이 제안한 위치에 매칭되는 모든 숙소의 id값을 CSV형식으로 뽑기 -- */
			StringBuilder offeredAccIdsCSV = new StringBuilder();
			for (OfferableRoomListView offer : offerViewList) {
				offeredAccIdsCSV.append(toString().valueOf(offer.getAccId()));
				offeredAccIdsCSV.append(",");
			}
			offeredAccIdsCSV.delete(offeredAccIdsCSV.length() - 1, offeredAccIdsCSV.length()); // 마지막 콤마 삭제
			
			/* -- offeredAccIdsCSV로 모든 방 리스트 불러오기(예약가능 여부는 밑에서 확인) -- */
			List<Room> roomList = roomService.getList(offeredAccIdsCSV.toString());
			
			
			List<Room> showRoomList = new ArrayList<>();
			
			/* -- 예약이 가능한 방 리스트만 뽑기 -- */
			for (OfferableRoomListView offer : offerViewList) {
				Date checkinDate = offer.getCheckinDate();
				Date checkoutDate = offer.getCheckoutDate();
				
				// 개인이 제안한 체크인 날짜 ~ 체크아웃 전날 날짜까지 추리기
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				StringBuilder offerdDatesCSV = new StringBuilder();
				
				while (checkinDate.compareTo(checkoutDate) <= 0) {
					offerdDatesCSV.append(sdf.format(checkinDate));
					offerdDatesCSV.append(",");
					Calendar c = Calendar.getInstance();
					c.setTime(checkinDate);
					c.add(Calendar.DAY_OF_MONTH, 1);
					checkinDate = c.getTime();
				}
				offerdDatesCSV.delete(offerdDatesCSV.length() - 12, offerdDatesCSV.length()); // 퇴실일 ~ 콤마까지 삭제
				
				System.out.printf("개인이 예약한 날짜(체크인~체크아웃-1): %s\n", offerdDatesCSV.toString());
				
//				개인이 원하는 날짜 2020-01-01,2020-01-02 -> String
//				등록된 예약일 2020-01-02,2020-01-03 
//				이렇게 겹치면 해당 방은 제외
				
				int index = 1;
				for (Room room : roomList) {
					// ex) 만약 개인이 2020-01-01 ~ 2020-01-03 날짜로 제안이 오는 경우에는 offeredDates는 아래와 같다.
					// offeredDates = ["2020-01-01", "2020-01-02", "2020-01-03"];
					String[] offeredDates = offerdDatesCSV.toString().split(",");
					String bookedDate = room.getBookedDate();
					
					boolean isBook = true;
					
					System.out.printf("%d번째 for문\n", index++);
					System.out.println("offeredDates: " + Arrays.toString(offeredDates));
					System.out.println("bookedDate: " + bookedDate);
					System.out.println("showRoomList: " + showRoomList);
					System.out.println();
					
					// 방에 예약이 비어있으므로 보여줄 수 있음
					if (bookedDate == null || bookedDate.equals("")) {
						showRoomList.add(room);
						continue;
					}
					
					// 하루라도 예약날짜가 겹치면 isBook 상태를 false로 변경
					for (String offeredDate : offeredDates)
						if (bookedDate.contains(offeredDate)) {
							isBook = false;
							break;
						}
					
					// 하루도 예약이 겹치지 않았으므로 예약가능
					if (isBook)
						showRoomList.add(room);
				}
					
			}
			
			/* -- 데이터 넘기기 -- */
			request.setAttribute("offerList", offerList);
			request.setAttribute("showRoomList", showRoomList);
			request.getRequestDispatcher("reg.jsp").forward(request, response);
			
			//System.out.printf("회원에게 역제안할 수 있는 방의 id들: %s\n\n", offerList.toString());
			//System.out.printf("accId에 일치하는 모든 방의 id들: %s", roomList.toString());
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String roomId_ = request.getParameter("room-id");
		int roomId = 0;
		
		if (roomId_ != null && !roomId_.equals(""))
			roomId = Integer.parseInt(roomId_);
		
		System.out.printf("roomId: %d\n", roomId);
		
		int accId = roomService.getId(roomId);
		System.out.printf("accId: %d\n", accId);
		int offerId = offerService.getId(accId);
		System.out.printf("offerId:%d\n", offerId);
		
		ReverseOffer reverseOffer = new ReverseOffer(offerId, roomId);
		
		reverseOfferService.insert(reverseOffer);
		
		response.sendRedirect("/index");
	}
}
